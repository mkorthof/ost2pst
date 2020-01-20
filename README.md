# OST2PST

A while ago I needed something to convert a 5GB Outlook OST file to PST format. Turned out Aspose has a good (commercial) API/library for Java to do exactly that. I had not touched Java for 10 years but got things sorted within a few hours thanks to clear instructions and good examples and docs. I just used the example and made minimal changes, nothing more.

## Download

### Jar and wrappers

* Main executable: [ost2pst.jar](ost2pst.jar) verify: [SHA512SUMS](SHA512SUMS)
* Windows batch file: [ost2pst.bat](ost2pst.bat)
* Linux shell script: [ost2pst.sh](ost2pst.sh)
* Download Java: [JRE8](https://java.com/en/download/manual.jsp) or alternative: [JavaSE-RE-8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)

### Usage

`ost2pst.bat <input.ost> <output.pst>`

* same for .sh, or run the jar directly with `java -jar ost2pst.jar`
* the jar needs JRE8
* [**Outlook 2013/2016 OST files are not supported**](https://docs.aspose.com/display/emailjava/Read+and+Convert+Outlook+OST+File#ReadandConvertOutlookOSTFile-ConvertingOSTtoPST)

### Example

``` batch
C:\src\ost2pst>ost2pst.bat input.ost output.pst

OST2PST (200119)

INFO: Loading OST file "input.pst" (5GB)
      Folder [00] "Public"
      Folder [01] "Inbox"
      Folder [02] "Outbox"
      Folder [03] "Sent Items"

INFO: Converting "input.pst" to "output.ost" 511MB/4751MB (11%) /
```

## Changelog

### 20200119

* fixed (visual) error before convertion
* improved messages and progress indicator
* updated aspose-email lib to 19.12  

### 20180915

* improved progress indicator
* updated aspose-email lib to 18.8

## Source

Import into [Eclipse](https://www.eclipse.org):

* [pom.xml](pom.xml)
* [Loast2pstLoadAndConvertOSTFileCLI.java](src/main/java/com/ost2pst/LoadAndConvertOSTFileCLI.java)

Required: Aspose.Email for Java API (lib)

* [GitHub Aspose_Email_Java](https://github.com/aspose-email/Aspose_Email_Java)
* [docs.aspose.com Installation (Maven)](https://docs.aspose.com/display/emailjava/Installation)
* [docs.aspose.com Aspose.Email java for Eclipse  (Maven)](https://docs.aspose.com/display/emailjava/Aspose.Email+Java+for+Eclipse+-+Maven)
  
To create runnable jar in Eclipse: 'Export > Runnable JAR file'
  
## More info

Aspose.Email for Java: https://products.aspose.com/email/java  
What lead me to Aspose: http://wiki.opf-labs.org/pages/viewpage.action?pageId=25887031  
Possible alternative https://github.com/rjohnsondev/java-libpst  

---
> moved from old repo mkorthof/Aspose.Email-for-Java
