# Aspose_Email_Java_for_Ruby
Aspose.Email Java for Ruby is a gem that demonstrates / provides the Aspose.Email for Java API usage examples in Ruby by using Rjb - Ruby Java Bridge.

## Installation

Execute following command.

    $ gem install asposeemailjava

To download Aspose.Email for Java API to be used with these examples through RJB, Please navigate to:

http://www.aspose.com/community/files/72/java-components/aspose.email-for-java/default.aspx

Note: Create jars folder at root of the gem folder and copy downloaded Aspose.Email for java component into it.

For most complete documentation of the project, check Aspose.Email Java for Ruby confluence wiki link:

http://www.aspose.com/docs/display/emailjava/2.+Aspose.Email+Java+For+Ruby

## Usage

```ruby
require File.dirname(File.dirname(File.dirname(__FILE__))) + '/lib/asposeemailjava'
include Asposeemailjava
include Asposeemailjava::CreateNewEmail

initialize_aspose_email
```
Lets understand the above code
* The first line makes sure that the Aspose.Email is loaded and available 
* Include the files that are required to access the Aspose.Email
* Initialize the libraries. The aspose JAVA classes are loaded from the path provided in the aspose.yml file