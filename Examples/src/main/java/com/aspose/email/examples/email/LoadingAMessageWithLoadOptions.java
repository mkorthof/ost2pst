package com.aspose.email.examples.email;

import com.aspose.email.EmlLoadOptions;
import com.aspose.email.HtmlLoadOptions;
import com.aspose.email.MailMessage;
import com.aspose.email.MhtmlLoadOptions;
import com.aspose.email.MsgLoadOptions;
import com.aspose.email.TnefLoadOptions;

/*
 * Not an example. Is just for Gist Creation
 */

public class LoadingAMessageWithLoadOptions {

	public static void main(String[] args) {
		// Loading with default options
		// Load from eml
		MailMessage eml = MailMessage.load("test.eml", new EmlLoadOptions());

		// Load from html
		MailMessage html = MailMessage.load("test.html", new HtmlLoadOptions());

		// load from mhtml
		MailMessage mhtml = MailMessage.load("test.mhtml", new MhtmlLoadOptions());

		// load from msg
		MailMessage msg = MailMessage.load("test.msg", new MsgLoadOptions());

		// load from thef fomat
		MailMessage thef = MailMessage.load("winmail.dat", new TnefLoadOptions());

		// Loading with custom options
		EmlLoadOptions opt = new EmlLoadOptions();
		opt.setPreserveTnefAttachments(true);
		MailMessage emlMailMessage = MailMessage.load("test.html", opt);

		HtmlLoadOptions htmlOpt = new HtmlLoadOptions();
		htmlOpt.shouldAddPlainTextView(true);
		MailMessage htmlMailMessage = MailMessage.load("test.html", htmlOpt);

	}

}
