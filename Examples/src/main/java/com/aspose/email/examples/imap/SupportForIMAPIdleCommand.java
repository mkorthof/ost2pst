package com.aspose.email.examples.imap;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapMonitoringEventArgs;
import com.aspose.email.ImapMonitoringEventHandler;
import com.aspose.email.MailMessage;
import com.aspose.email.SmtpClient;

public class SupportForIMAPIdleCommand {

	public static void main(String[] args) throws InterruptedException {
		final ImapClient imapClient = new ImapClient("exchange.aspose.com", "username", "password");
		try {
			final SmtpClient smtpClient = new SmtpClient("exchange.aspose.com", "username", "password");
			try {
				final Semaphore semaphore = new Semaphore(1);
				final ImapMonitoringEventArgs[] eventArgs = { null };
				imapClient.startMonitoring(new ImapMonitoringEventHandler() {
					public void invoke(Object sender, ImapMonitoringEventArgs e) {
						eventArgs[0] = e;
						semaphore.release();
					}
				});

				semaphore.acquire();
				Thread.sleep(5000);

				smtpClient.send(new MailMessage("from@domain.com", "to@domain.com", "EMAILNET-34875", "EMAILNET-34875 Support for IMAP idle command"));
				semaphore.tryAcquire(10000, TimeUnit.MILLISECONDS);
				if (eventArgs[0].getNewMessages().length == 1)
					System.out.println("Message received.");
				if (eventArgs[0].getNewMessages().length == 0)
					System.out.println("Message received.");

				smtpClient.send(new MailMessage("from@domain.com", "to@domain.com", "EMAILNET-34875 - ", "EMAILNET-34875 Support for IMAP idle command"));
				semaphore.tryAcquire(10000, TimeUnit.MILLISECONDS);
				if (eventArgs[0].getNewMessages().length == 1)
					System.out.println("Message received.");
				if (eventArgs[0].getNewMessages().length == 0)
					System.out.println("Message received.");
				imapClient.stopMonitoring("Inbox");
				smtpClient.send(new MailMessage("from@domain.com", "to@domain.com", "EMAILNET-34875 - ", "EMAILNET-34875 Support for IMAP idle command"));
				semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS);
			} finally {
				if (smtpClient != null)
					(smtpClient).dispose();
			}
		} finally {
			if (imapClient != null)
				(imapClient).dispose();
		}
	}
}