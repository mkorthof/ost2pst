package com.aspose.email.examples.email;

import com.aspose.email.DataRow;
import com.aspose.email.DataTable;
import com.aspose.email.MailAddress;
import com.aspose.email.MailException;
import com.aspose.email.MailMessage;
import com.aspose.email.MailMessageCollection;
import com.aspose.email.TemplateEngine;
import com.aspose.email.TemplateRoutine;
import com.aspose.email.system.DateTime;

public class PerformMailMerge {

	public static void main(String[] args) {
		//create a new MailMessage instance as a template
		MailMessage template = new MailMessage();

		//add template field to subject
		template.setSubject("Hello, #FirstName#");
		template.setFrom(MailAddress.to_MailAddress("sale@aspose.com"));

		//add template field to receipt
		template.getTo().addMailAddress(new MailAddress("#Receipt#", true));

		//add template field to html body 
		//use GetSignment as the template routine, which will provide the same signment.
		template.setHtmlBody("Dear #FirstName# #LastName#, &lt;br&gt;&lt;br&gt;Thank you for your interest in &lt;STRONG&gt;Aspose.Network&lt;/STRONG&gt;.&lt;br&gt;&lt;br&gt;Have fun with it.&lt;br&gt;&lt;br&gt;#GetSignature()#");

		//create a new TemplateEngine with the template message.
		TemplateEngine engine = new TemplateEngine(template);

		//register the GetSignment as a template routine, for we use it in the template.
		engine.registerRoutine("GetSignature", new TemplateRoutine() {
			public Object invoke(Object[] args) {
				return getSignature(args);
			}
		});
		
		//fill a DataTable as data source
		DataTable dt = new DataTable();
		dt.getColumns().add("Receipt");
		dt.getColumns().add("FirstName");
		dt.getColumns().add("LastName");
		DataRow dr;
		dr = dt.newRow();
		dr.set("Receipt", "Nancy.Davolio&lt;Nancy@somedomain.com&gt;");
		dr.set("FirstName", "Nancy");
		dr.set("LastName", "Davolio");
		dt.getRows().add(dr);
		dr = dt.newRow();
		dr.set("Receipt", "Andrew.Fuller&lt;Andrew@somedomain.com&gt;");
		dr.set("FirstName", "Andrew");
		dr.set("LastName", "Fuller");
		dt.getRows().add(dr);
		dr = dt.newRow();
		dr.set("Receipt", "Janet.Leverling&lt;Janet@somedomain.com&gt;");
		dr.set("FirstName", "Janet");
		dr.set("LastName", "Leverling");
		dt.getRows().add(dr);

		MailMessageCollection messages;
		try
		{
			//create the messages from the template and datasource.
			messages = engine.instantiate(dt);
		}
		catch (MailException ex)
		{
			System.out.println(ex.toString());
		}
	}
	
	static Object getSignature(Object[] args)
	{
	    return "John Smith&lt;br&gt;Product Lead&lt;br&gt;Aspose Ltd.&lt;br&gt;".concat(DateTime.getNow().toShortDateString());
	}

}
