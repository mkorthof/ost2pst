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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.utils;

//import com.aspose.examples.otherexamples.OtherExamplesManager;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;

import java.io.File;

/**
 * @author Adeel Ilyas
 * 
 */
public class GitHelper {
    public static void updateRepository(String localPath, String remotePath) throws Exception {
        Repository localRepo;
        try {
            localRepo = new FileRepository(localPath + "/.git");

            Git git = new Git(localRepo);
            {
                AsposeConstants.println("Cloning Repository [" + remotePath + "]....");
            }

            // First try to clone the repository
            try {
                Git.cloneRepository().setURI(remotePath).setDirectory(new File(localPath)).call();
            } catch (Exception ex) {
                // If clone fails, try to pull the changes
                try {
                    git.pull().call();
                } catch (Exception exPull) {
                    // Pull also failed. Throw this exception to caller
                    {
                        AsposeConstants.println("Pull also failed.");
                    }
                    throw exPull; // throw it
                }
            }
        } catch (Exception ex) {
            throw new Exception("Could not download Repository from Github. Error: " + ex.getMessage());
        }
    }

    public static void syncRepository(String localPath, String remotePath) throws Exception {
        Repository localRepo;
        try {
            localRepo = new FileRepository(localPath + "/.git");

            Git git = new Git(localRepo);

                AsposeConstants.println("Syncronizing Repository [" + remotePath + "]....");
               // Pull the changes
            try {
                git.pull().call();
            } catch (Exception exPull) {
                // If pull failed. Throw this exception to caller
                {
                    AsposeConstants.println("Pull failed.");
                }
                throw exPull; // throw it
            }

        } catch (Exception ex) {
            throw new Exception("Could not update Repository from Github. Error: " + ex.getMessage());
        }
    }


}
