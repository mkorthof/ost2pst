# OST2PST

A while ago I needed something to convert a 5GB Outlook OST file to PST format. Turned out [Aspose](https://products.aspose.com/email) has a good (commercial) API/library for Java to do exactly that. I had not touched Java for 10 years but got things sorted within a few hours thanks to clear instructions and good examples and docs. I just used the example and made minimal changes, nothing more.

[**Saving to Outlook 2013/2016 PST files is not supported**](https://docs.aspose.com/email/java/read-and-convert-outlook-ost-file/#converting-ost-to-pst)

## Download

Get files below or from [Releases page](../../releases/latest)

**Jar and wrappers:**

* Main executable: [ost2pst.jar](ost2pst.jar) (verify [SHA512SUMS](SHA512SUMS))
* Windows batch file: [ost2pst.bat](ost2pst.bat)
* Linux/BSD shell script: [ost2pst.sh](ost2pst.sh)


If you need to install Java use your OS package manager or download it here: [JRE8](https://java.com/en/download/manual.jsp) or alternatively [JavaSE-RE-8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html).

### Usage

* Windows: `ost2pst.bat <input.ost> <output.pst>`
* Linux: `ost2pst.sh <input.ost> <output.pst>`

Or run the jar directly: `java -jar ost2pst.jar <input.ost> <output.pst>`

_Remember you need to have at least JRE8 installed, OpenJDK is untested but should work_

### Example

``` batch

C:\src\ost2pst>ost2pst.bat input.ost output.pst

OST2PST (210619)

INFO: File format is "64-bit Unicode" (23)
INFO: Loading file "input.pst" (5GB)
      Folder [00] "Public"
      Folder [01] "Inbox"
      Folder [02] "Outbox"
      Folder [03] "Sent Items"

INFO: Converting "input.pst" to "output.ost" 511MB/4751MB (11%) |

```

## Building from source

### Import into [Eclipse](https://www.eclipse.org):

* [pom.xml](pom.xml)
* [Loast2pstLoadAndConvertOSTFileCLI.java](src/main/java/com/ost2pst/LoadAndConvertOSTFileCLI.java)

### Get Aspose.Email for Java API/lib (*required*)

* [GitHub Aspose Email-for-Java](https://github.com/aspose-email/Aspose.Email-for-Java)
* [docs.aspose.com Installation (Maven)](https://docs.aspose.com/display/emailjava/Installation)
* [docs.aspose.com Aspose.Email java for Eclipse  (Maven)](https://docs.aspose.com/display/emailjava/Aspose.Email+Java+for+Eclipse+-+Maven)

### Create runnable Jar in Eclipse

* use Ant to 'Export', 'Java', 'Runnable JAR file' (used for [ost2pst.jar](ost2pst.jar))
* or alternatively use Maven to build project

## TODO

Add new option that tries to read corrupted ost/pst files. See [here](https://docs.aspose.com/email/java/aspose-email-for-java-20-10-release-notes/#reading-corrupted-pstost-files) for more info.

``` batch
C:\src\ost2pst>ost2pst.bat -c broken.ost
```

## Changelog

### 20210702

* fixed file size formatting: [programming.guide](https://programming.guide/java/formatting-byte-size-to-human-readable-format.html) :)
* updated aspose-email lib to 21.5
* removed aspose-email submodule from git repo

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

## More info

* Aspose.Email for Java: <https://products.aspose.com/email/java>
* What lead me to Aspose: <http://wiki.opf-labs.org/pages/viewpage.action?pageId=25887031>
* Possible alternative <https://github.com/rjohnsondev/java-libpst>

---
> moved from old repo mkorthof/Aspose.Email-for-Java
---
