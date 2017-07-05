# OST2PST

Needed something to convert a 5GB Outlook OST file to PST format. Turned out Aspose has a good (commercial) API/library for Java to do exactly that. I had not touched Java for 10 years but got things sorted within a few hours thanks to clear instructions and good examples and docs. I just used the example and made minimal changes, nothing more.

## Download

### Jar and wrappers:

* Main executable: [ost2pst.jar](ost2pst.jar) 
* Windows batch file: [ost2pst.bat](ost2pst.bat) 
* Linux shell script: [ost2pst.bat](ost2pst.sh) 
* [SHA512SUMS](SHA512SUMS)
* [JRE8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)

### Usage:

```ost2pst.bat <input.ost> <output.pst>```
* same for .sh, or run the jar directly with ```java -jar ost2pst.jar```
* currently the jar needs JRE8 but I might try to lower that requirement.

## Source

[LoadAndConvertOSTFileCLI.java](Examples/ost2pst/LoadAndConvertOSTFileCLI.java)

## Notes

* To create runnable jar in eclipse: Export > Runnable JAR file
* What lead me to Aspose: http://wiki.opf-labs.org/pages/viewpage.action?pageId=25887031
* Possible  alternative https://github.com/rjohnsondev/java-libpst

---

# Aspose.Email for Java

This repository contains [Examples](Examples), [Plugins](Plugins) and projects that will help you to write your own application using [Aspose.Email for Java](https://www.aspose.com/products/email/java).

<p align="center">
  <a title="Download complete Aspose.Email for Java source code" href="https://github.com/asposeemail/Aspose_Email_Java/archive/master.zip">
    <img src="http://i.imgur.com/hwNhrGZ.png" />
  </a>
</p>

Following is short description of contents of the repository: 

Directory  | Description
---------- | -----------
[Examples](Examples)  | A collection of Java examples that help you learn how to use product features
[Plugins](Plugins)  | Plugins that will demonstrate one or more features of Aspose.Email for Java

## Resources

+ **Website:** [www.aspose.com](http://www.aspose.com)
+ **Product Home:** [Aspose.Email for Java](https://www.aspose.com/products/email/java)
+ **Download:** [Download Aspose.Email for Java](https://downloads.aspose.com/email/java)
+ **Documentation:** [Aspose.Email for Java Documentation](https://docs.aspose.com/display/emailjava/Home)
+ **Forum:** [Aspose.Email for Java Forum](http://www.aspose.com/community/forums/aspose.email-product-family/188/showforum.aspx)
+ **Blog:** [Aspose.Email for Java Blog](http://www.aspose.com/blogs/aspose-products/aspose-email-product-family.html)
