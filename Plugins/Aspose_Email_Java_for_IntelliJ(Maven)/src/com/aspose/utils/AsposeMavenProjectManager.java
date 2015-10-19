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

import com.aspose.maven.apis.artifacts.Metadata;
import com.aspose.utils.execution.RunnableHelper;
import com.aspose.wizards.maven.AsposeMavenModuleBuilderHelper;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.*;
import java.io.*;
import java.net.*;
import java.util.ResourceBundle;

/*
* @author Adeel Ilyas <adeel.ilyas@aspose.com>
*
*/

public class AsposeMavenProjectManager {
    private boolean examplesNotAvailable;

    private boolean examplesDefinitionAvailable;

    public Project getProjectHandle() {
        return projectHandle;
    }

    private Project projectHandle;

    public String readURLContents(String Url) throws IOException {
        URL url = new URL(Url);
        URLConnection con = url.openConnection();
        InputStream in = con.getInputStream();
        String encoding = con.getContentEncoding();
        encoding = encoding == null ? "UTF-8" : encoding;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[8192];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            baos.write(buf, 0, len);
        }
        String body = new String(baos.toByteArray(), encoding);
        return body;
    }


    public Metadata getProductMavenDependency(String productMavenRepositoryUrl) {
        final String mavenMetaDataFileName = "maven-metadata.xml";
        Metadata data = null;

        try {
            String productMavenInfo;
            productMavenInfo = readURLContents(productMavenRepositoryUrl + mavenMetaDataFileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(com.aspose.maven.apis.artifacts.ObjectFactory.class);
            Unmarshaller unmarshaller;
            unmarshaller = jaxbContext.createUnmarshaller();
            AsposeConstants.println(productMavenInfo);
            data = (Metadata) unmarshaller.unmarshal(new StreamSource(new StringReader(productMavenInfo)));

            String remoteArtifactFile = productMavenRepositoryUrl + data.getVersioning().getLatest() + "/" + data.getArtifactId() + "-" + data.getVersioning().getLatest();

            AsposeConstants.println(remoteArtifactFile);
            if (!remoteFileExists(remoteArtifactFile + ".jar")) {
                AsposeConstants.println("Not Exists");
                data.setClassifier(getResolveSupportedJDK(remoteArtifactFile));
            } else {
                AsposeConstants.println("Exists");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            data = null;
        }
        return data;
    }

    public String getResolveSupportedJDK(String ProductURL) {
        String supportedJDKs[] = {"jdk17", "jdk16", "jdk15", "jdk14", "jdk18"};
        String classifier = null;
        for (String jdkCheck : supportedJDKs) {
            AsposeConstants.println(ProductURL + "-" + jdkCheck + ".jar");
            if (remoteFileExists(ProductURL + "-" + jdkCheck + ".jar")) {
                AsposeConstants.println("Exists");
                classifier = jdkCheck;
                break;
            } else {
                AsposeConstants.println("Not Exists");
            }
        }
        return classifier;
    }

    public boolean remoteFileExists(String URLName) {
        try {
            HttpURLConnection.setFollowRedirects(false);
            // note : you may also need
            //        HttpURLConnection.setInstanceFollowRedirects(false)
            HttpURLConnection con =
                    (HttpURLConnection) new URL(URLName).openConnection();
            con.setRequestMethod("HEAD");
            return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addMavenDependenciesInProject(NodeList addTheseDependencies) {
        String mavenPomXmlfile = AsposeMavenUtil.getPOMXmlFile(projectHandle);

        VirtualFile vf_mavenPomXmlfilel = LocalFileSystem.getInstance().findFileByPath(mavenPomXmlfile);


        try {
            Document pomDocument = getXmlDocument(mavenPomXmlfile);

            Node dependenciesNode = pomDocument.getElementsByTagName("dependencies").item(0);


            if (addTheseDependencies != null && addTheseDependencies.getLength() > 0) {
                for (int n = 0; n < addTheseDependencies.getLength(); n++) {
                    String artifactId = addTheseDependencies.item(n).getFirstChild().getNextSibling().getNextSibling().getNextSibling().getFirstChild().getNodeValue();

                    XPathFactory xPathfactory = XPathFactory.newInstance();
                    XPath xpath = xPathfactory.newXPath();
                    String expression = "//artifactId[text()='" + artifactId + "']";

                    XPathExpression xPathExpr = xpath.compile(expression);

                    Node dependencyAlreadyExist = (Node) xPathExpr.evaluate(pomDocument, XPathConstants.NODE);

                    if (dependencyAlreadyExist != null) {
                        Node dependencies = pomDocument.getElementsByTagName("dependencies").item(0);
                        dependencies.removeChild(dependencyAlreadyExist.getParentNode());
                    }

                    Node importedNode = pomDocument.importNode(addTheseDependencies.item(n), true);
                    dependenciesNode.appendChild(importedNode);


                }
            }
            removeEmptyLinesfromDOM(pomDocument);
            writeXmlDocumentToVirtualFile(vf_mavenPomXmlfilel, pomDocument);

        } catch (IOException io) {
            io.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addMavenRepositoriesInProject(NodeList addTheseRepositories) {
        String mavenPomXmlfile = AsposeMavenUtil.getPOMXmlFile(projectHandle);

        VirtualFile vf_mavenPomXmlfilel = LocalFileSystem.getInstance().findFileByPath(mavenPomXmlfile);


        try {
            Document pomDocument = getXmlDocument(mavenPomXmlfile);

            Node repositoriesNode = pomDocument.getElementsByTagName("repositories").item(0);


            if (addTheseRepositories != null && addTheseRepositories.getLength() > 0) {
                for (int n = 0; n < addTheseRepositories.getLength(); n++) {
                    String repositoryId = addTheseRepositories.item(n).getFirstChild().getNextSibling().getFirstChild().getNodeValue();

                    XPathFactory xPathfactory = XPathFactory.newInstance();
                    XPath xpath = xPathfactory.newXPath();
                    String expression = "//id[text()='" + repositoryId + "']";

                    XPathExpression xPathExpr = xpath.compile(expression);

                    Boolean repositoryAlreadyExist = (Boolean) xPathExpr.evaluate(pomDocument, XPathConstants.BOOLEAN);

                    if (!repositoryAlreadyExist) {
                        Node importedNode = pomDocument.importNode(addTheseRepositories.item(n), true);
                        repositoriesNode.appendChild(importedNode);
                    }

                }
            }
            removeEmptyLinesfromDOM(pomDocument);
            writeXmlDocumentToVirtualFile(vf_mavenPomXmlfilel, pomDocument);

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }


    private void removeEmptyLinesfromDOM(Document doc) throws XPathExpressionException {
        XPath xp = XPathFactory.newInstance().newXPath();
        NodeList nl = (NodeList) xp.evaluate("//text()[normalize-space(.)='']", doc, XPathConstants.NODESET);

        for (int i = 0; i < nl.getLength(); ++i) {
            Node node = nl.item(i);
            node.getParentNode().removeChild(node);
        }
    }

    public void writeXmlDocumentToVirtualFile(VirtualFile pom, Document pomDocument) {

        RunnableHelper.runWriteCommand(projectHandle, new Runnable() {
            @Override
            public void run() {
                try {
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                    DOMSource source = new DOMSource(pomDocument);

                    ByteOutputStream bytes = new ByteOutputStream();

                    StreamResult result = new StreamResult(bytes);
                    transformer.transform(source, result);

                    VfsUtil.saveText(pom, bytes.toString());

                } catch (TransformerException tfe) {
                    tfe.printStackTrace();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public boolean retrieveAsposeMavenDependencies(@NotNull ProgressIndicator progressIndicator) {
        try {
            AsposeMavenModuleBuilderHelper.getAsposeProjectMavenDependencies().clear();
            progressIndicator.setText(ResourceBundle.getBundle("Bundle").getString("AsposeManager.progressMessage"));

            AsposeJavaAPI component = AsposeEmailJavaAPI.getInstance();

            Metadata productMavenDependency = getProductMavenDependency(component.get_mavenRepositoryURL());

            if (productMavenDependency != null) {
                AsposeMavenModuleBuilderHelper.getAsposeProjectMavenDependencies().add(productMavenDependency);
            }

        } catch (Exception rex) {
            return false;
        }
        if (!AsposeMavenModuleBuilderHelper.getAsposeProjectMavenDependencies().isEmpty()) {

            return true;
        } else {
            return false;
        }
    }

    /**
     * @return
     */
    public static boolean isInternetConnected() {
        try {
            InetAddress address = InetAddress.getByName(AsposeConstants.INTERNET_CONNNECTIVITY_PING_URL);
            if (address == null) {
                return false;
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static int showMessage(String title, String message, int buttons, int icon) {
        int result = JOptionPane.showConfirmDialog(null, message, title, buttons, icon);
        return result;
    }

    private Document getXmlDocument(String mavenPomXmlfile) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document pomDocument = docBuilder.parse(mavenPomXmlfile);

        return pomDocument;
    }

    public String getDependencyVersionFromPOM(String dependencyName) {
        try {
            String mavenPomXmlfile = AsposeMavenUtil.getPOMXmlFile(projectHandle);

            Document pomDocument = getXmlDocument(mavenPomXmlfile);

            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            String expression = "//version[ancestor::dependency/artifactId[text()='" + dependencyName + "']]";
            XPathExpression xPathExpr = xpath.compile(expression);
            NodeList nl = (NodeList) xPathExpr.evaluate(pomDocument, XPathConstants.NODESET);
            if (nl != null && nl.getLength() > 0) {
                return nl.item(0).getTextContent();
            }
        } catch (IOException io) {
            io.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public NodeList getDependenciesFromPOM(String mavenPomXmlfile, String excludeGroup) {

        try {

            Document pomDocument = getXmlDocument(mavenPomXmlfile);

            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            String expression = "//dependency[child::groupId[text()!='" + excludeGroup + "']]";
            XPathExpression xPathExpr = xpath.compile(expression);
            NodeList nl = (NodeList) xPathExpr.evaluate(pomDocument, XPathConstants.NODESET);
            if (nl != null && nl.getLength() > 0) {
                return nl;
            }
        } catch (IOException io) {
            io.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public NodeList getRepositoriesFromPOM(String mavenPomXmlfile, String excludeURL) {

        try {

            Document pomDocument = getXmlDocument(mavenPomXmlfile);

            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            String expression = "//repository[child::url[not(starts-with(.,'" + excludeURL + "'))]]";
            XPathExpression xPathExpr = xpath.compile(expression);
            NodeList nl = (NodeList) xPathExpr.evaluate(pomDocument, XPathConstants.NODESET);
            if (nl != null && nl.getLength() > 0) {
                return nl;
            }
        } catch (IOException io) {
            io.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getAsposeHomePath() {

        String path = "";
        path = System.getProperty("user.home");
        path = path + File.separator + "aspose" + File.separator;
        return path;
    }

    public static void copyDirectory(String sourceLocation, String targetLocation) throws IOException {

        checkAndCreateFolder(targetLocation);
        copyDirectory(new File(sourceLocation + File.separator), new File(targetLocation + File.separator));
    }

    public static void copyDirectory(File sourceLocation, File targetLocation) throws IOException {
        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children = sourceLocation.list();
            for (int i = 0; i < children.length; i++) {
                copyDirectory(new File(sourceLocation, children[i]),
                        new File(targetLocation, children[i]));
            }
        } else {

            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);

            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }

    /**
     * @param folderPath
     */
    public static void checkAndCreateFolder(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    // Singleton instance
    private static AsposeMavenProjectManager asposeMavenProjectManager = new AsposeMavenProjectManager();

    public static AsposeMavenProjectManager getInstance() {
        return asposeMavenProjectManager;
    }

    public static AsposeMavenProjectManager initialize(Project projectId) {
        asposeMavenProjectManager = new AsposeMavenProjectManager();
        asposeMavenProjectManager.projectHandle = projectId;
        return asposeMavenProjectManager;
    }

    private AsposeMavenProjectManager() {
    }

}
