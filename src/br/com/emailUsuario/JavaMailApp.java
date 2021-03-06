package br.com.emailUsuario;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class JavaMailApp {
	
	public void emailUsuario() {
		enviarEmail();
	}
	
	private void enviarEmail() {
	
	
    Properties props = new Properties();
    props.put("mail.smtp.Host", "smtp-mail.Outlook.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");
    
    JOptionPane.showMessageDialog(null, "Ja temos um email do mercado mini");

    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
        	   return new PasswordAuthentication("seuemail@gmail.com", "suasenha123");
           }
      });

    session.setDebug(true);

    try {

      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("seuemail@gmail.com"));

      String emailColega = JOptionPane.showInputDialog("Digite o email do destinatario.");
      
      Address[] toUser = InternetAddress.parse(emailColega);

      String titulo = JOptionPane.showInputDialog("Digite um titulo");
      message.setRecipients(Message.RecipientType.TO, toUser);
      message.setSubject(titulo);
      
      String menssagem = JOptionPane.showInputDialog("Digite uma menssagem");
      
      message.setText(menssagem);
      Transport.send(message);

      System.out.println("Feito!!!");

     } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
  }
}