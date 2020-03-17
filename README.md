# OST2PST

A while ago I needed something to convert a 5GB Outlook OST file to PST format. Turned out Aspose has a good (commercial) API/library for Java to do exactly that. I had not touched Java for 10 years but got things sorted within a few hours thanks to clear instructions and good examples and docs. I just used the example and made minimal changes, nothing more.

## Download

Get files below or from [Releases page](../../releases/latest)

### Jar and wrappers

* Main executable: [ost2pst.jar](ost2pst.jar) verify: [SHA512SUMS](SHA512SUMS)
* Windows batch file: [ost2pst.bat](ost2pst.bat)
* Linux/BSD shell script: [ost2pst.sh](ost2pst.sh)
* Download Java: [JRE8](https://java.com/en/download/manual.jsp) or alternative: [JavaSE-RE-8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)

### Usage

Windows: `ost2pst.bat <input.ost> <output.pst>` _(same for .sh)_

* you can also run the jar directly: `java -jar ost2pst.jar`
* the jar needs JRE8
* [**Saving to Outlook 2013/2016 PST files is not supported**](https://docs.aspose.com/display/emailjava/Read+and+Convert+Outlook+OST+File#ReadandConvertOutlookOSTFile-ConvertingOSTtoPST)

### Example

``` batch
C:\src\ost2pst>ost2pst.bat input.ost output.pst

OST2PST (200316)

INFO: Loading OST file "input.pst" (5GB)
      Folder [00] "Public"
      Folder [01] "Inbox"
      Folder [02] "Outbox"
      Folder [03] "Sent Items"

INFO: File format is "64-bit Unicode" (23)
INFO: Converting "input.pst" to "output.ost" 511MB/4751MB (11%) |
```

## Changelog

### 20200317

* show file format info
* exits instead of trying to save outlook 2013+ files
* jar also builds in maven now

### 20200313

* error handling, added notice about outlook '13/16 files
* updated aspose-email lib to 20.2

### 20200119

* fixed (visual) error before convertion
* improved messages and progress indicator
* updated aspose-email lib to 19.12  

### 20180915

* improved progress indicator
* updated aspose-email lib to 18.8

## Source

### Import into [Eclipse](https://www.eclipse.org):

* [pom.xml](pom.xml)
* [Loast2pstLoadAndConvertOSTFileCLI.java](src/main/java/com/ost2pst/LoadAndConvertOSTFileCLI.java)

### Aspose.Email for Java API/lib (*required*)

* [GitHub Aspose Email-for-Java](https://github.com/aspose-email/Aspose.Email-for-Java)
* [docs.aspose.com Installation (Maven)](https://docs.aspose.com/display/emailjava/Installation)
* [docs.aspose.com Aspose.Email java for Eclipse  (Maven)](https://docs.aspose.com/display/emailjava/Aspose.Email+Java+for+Eclipse+-+Maven)
  
### Create runnable Jar in Eclipse

* use Ant to 'Export', 'Java', 'Runnable JAR file' (used for [ost2pst.jar](ost2pst.jar))
* or alternatively use Maven to build project
  
## More info

Aspose.Email for Java: https://products.aspose.com/email/java  
What lead me to Aspose: http://wiki.opf-labs.org/pages/viewpage.action?pageId=25887031  
Possible alternative https://github.com/rjohnsondev/java-libpst  

---
> moved from old repo mkorthof/Aspose.Email-for-Java
---
