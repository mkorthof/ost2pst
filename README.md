# OST2PST

Needed something to convert a 5GB Outlook OST file to PST format. Turned out Aspose has a good (commercial) API/library for Java to do exactly that. I had not touched Java for 10 years but got things sorted within a few hours thanks to clear instructions and good examples and docs. I just used the example and made minimal changes, nothing more.

## Download

### Jar and wrappers:

* Main executable: [ost2pst.jar](ost2pst.jar), verify: [SHA512SUMS](SHA512SUMS)
* Windows batch file: [ost2pst.bat](ost2pst.bat) 
* Linux shell script: [ost2pst.sh](ost2pst.sh) 
* Download Java: [JRE8](https://java.com/en/download/manual.jsp) or alternative: [JavaSE RE 8 ](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)

### Usage:

```ost2pst.bat <input.ost> <output.pst>```
* same for .sh, or run the jar directly with ```java -jar ost2pst.jar```
* the jar needs JRE8 
* Outlook 2013/2016 OST files are not supported

### Example:

```
C:\src\ost2pst>ost2pst.bat input.ost output.pst

OST2PST (180915)

INFO: Loading OST file input.ost (5GB)
INFO: Folder 0 Root - Public
INFO: Folder 1 Root - Mailbox
INFO: Converting input.ost to output.pst - 1225MB/4731MB (26%)
```

## Changelog:

20180915: improved progress indicator, updated aspose-email lib to 18.8

## Source:

* Import into [Eclipse](https://www.eclipse.org):
    * [pom.xml](pom.xml)
    * [Loast2pstLoadAndConvertOSTFileCLI.java](src/main/java/com/ost2pst/LoadAndConvertOSTFileCLI.java)

* Required: Aspose.Email for Java API (lib)
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
