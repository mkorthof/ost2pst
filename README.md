# OST2PST

Needed something to convert a 5GB Outlook OST file to PST format. Turned out Aspose has a good (commercial) API/library for Java to do exactly that. I had not touched Java for 10 years but got things sorted within a few hours thanks to clear instructions and good examples and docs. I just used the example and made minimal changes, nothing more.

## Download

### Jar and wrappers:

* Main executable: [ost2pst.jar](ost2pst.jar) 
* Windows batch file: [ost2pst.bat](ost2pst.bat) 
* Linux shell script: [ost2pst.sh](ost2pst.sh) 
* [SHA512SUMS](SHA512SUMS)
* [JRE8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)

### Usage:

```ost2pst.bat <input.ost> <output.pst>```
* same for .sh, or run the jar directly with ```java -jar ost2pst.jar```
* currently the jar needs JRE8 but I might try to lower that requirement.

## Source:

* [LoadAndConvertOSTFileCLI.java](LoadAndConvertOSTFileCLI.java)

* Required: Aspose.Email for Java API (lib):

  * [Aspose Email-for-Java/README.md](Aspose.Email-for-Java/README.md)
  * [GitHub Aspose_Email_Java](https://github.com/asposeemail/Aspose_Email_Java)
  * [docs.aspose.com Installation (Maven)](https://docs.aspose.com/display/emailjava/Installation)
  * [docs.aspose.com Aspose.Email java for Eclipse  (Maven)](https://docs.aspose.com/display/emailjava/Aspose.Email+Java+for+Eclipse+-+Maven)
  
* To create runnable jar in Eclipse: Export > Runnable JAR file
  
## More info

* Aspose.Email for Java: https://products.aspose.com/email/java 
* What lead me to Aspose: http://wiki.opf-labs.org/pages/viewpage.action?pageId=25887031
* Possible alternative https://github.com/rjohnsondev/java-libpst

---
> moved from old repo mkorthof/Aspose.Email-for-Java

