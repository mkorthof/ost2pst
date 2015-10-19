/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2001-2015 Aspose Pty Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.aspose.utils;

import com.aspose.wizards.maven.MavenId;
import com.intellij.codeInsight.actions.ReformatCodeProcessor;
import com.intellij.codeInsight.template.TemplateManager;
import com.intellij.codeInsight.template.impl.TemplateImpl;
import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.util.DisposeAwareRunnable;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AsposeMavenUtil {
    public static final String MAVEN_NOTIFICATION_GROUP = "Maven";
    public static final String MAVEN_PROJECT_XML_TEMPLATE = "Maven Project.xml";

    public static void invokeLater(final Project p, final ModalityState state, final Runnable r) {
        if (isNoBackgroundMode()) {
            r.run();
        } else {
            ApplicationManager.getApplication().invokeLater(DisposeAwareRunnable.create(r, p), state);
        }
    }

    public static boolean isNoBackgroundMode() {
        return (ApplicationManager.getApplication().isUnitTestMode()
                || ApplicationManager.getApplication().isHeadlessEnvironment());
    }


    public static void showError(Project project, String title, Throwable e) {
        Notifications.Bus.notify(new Notification(MAVEN_NOTIFICATION_GROUP, title, e.getMessage(), NotificationType.ERROR), project);
    }

    public static void runOrApplyMavenProjectFileTemplate(Project project,
                                                          VirtualFile file,
                                                          @NotNull MavenId projectId) throws IOException {
        runOrApplyMavenProjectFileTemplate(project, file, projectId, null, null);
    }

    public static void runOrApplyMavenProjectFileTemplate(Project project,
                                                          VirtualFile file,
                                                          @NotNull MavenId projectId,
                                                          MavenId parentId,
                                                          VirtualFile parentFile) throws IOException {
        Properties properties = new Properties();

        properties.setProperty("GROUP_ID", projectId.getGroupId());
        properties.setProperty("ARTIFACT_ID", projectId.getArtifactId());
        properties.setProperty("VERSION", projectId.getVersion());

        runOrApplyFileTemplate(project, file, MAVEN_PROJECT_XML_TEMPLATE, properties);
    }


    private static void runOrApplyFileTemplate(Project project,
                                               VirtualFile file,
                                               String templateName,
                                               Properties properties) throws IOException {
        FileTemplateManager manager = FileTemplateManager.getInstance();
        FileTemplate fileTemplate = manager.getJ2eeTemplate(templateName);
        Properties allProperties = manager.getDefaultProperties(project);
        allProperties.putAll(properties);
        String text = fileTemplate.getText(allProperties);
        Pattern pattern = Pattern.compile("\\$\\{(.*)\\}");
        Matcher matcher = pattern.matcher(text);
        StringBuffer builder = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(builder, "\\$" + matcher.group(1).toUpperCase() + "\\$");
        }
        matcher.appendTail(builder);
        text = builder.toString();

        TemplateImpl template = (TemplateImpl) TemplateManager.getInstance(project).createTemplate("", "", text);
        for (int i = 0; i < template.getSegmentsCount(); i++) {
            if (i == template.getEndSegmentNumber()) continue;
            String name = template.getSegmentName(i);
            String value = "\"" + properties.getProperty(name, "") + "\"";
            template.addVariable(name, value, value, true);
        }

        VfsUtil.saveText(file, template.getTemplateText());

        PsiFile psiFile = PsiManager.getInstance(project).findFile(file);
        if (psiFile != null) {
            new ReformatCodeProcessor(project, psiFile, null, false).run();
        }

    }

    public static File getPluginSystemDir(String folder) {
        // PathManager.getSystemPath() may return relative path
        return new File(PathManager.getSystemPath(), "Maven" + "/" + folder).getAbsoluteFile();
    }

    public static String getPOMXmlFile(VirtualFile pomFile) {
        return pomFile.getParent().getPath() + File.separator + AsposeConstants.MAVEN_POM_XML;
    }

    public static String getPOMXmlFile(Project project) {
        String projectPath = project.getBasePath();
        String projectPOM = projectPath + File.separator + AsposeConstants.MAVEN_POM_XML;
        return projectPOM;
    }

}
