package com.example.ruben.mascotas;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailAPI extends AsyncTask<Void,Void,Void>  {

    //Variables
    private Context mContext;
    private Session mSession;

    private String mEmail;
    private String mSubject;
    private String mMessage;

    private ProgressDialog mProgressDialog;
    // Este es tu email
    private static final String EMAIL= "AQUI VA TU CORREO";
    //este es para tu contraseña
    private static final String PASSWORD= "AQUI VA TU CONTRASEÑA DEL CORREO";

    //Constructor
    public JavaMailAPI(Context mContext, String mEmail, String mSubject, String mMessage) {
        this.mContext = mContext;
        this.mEmail = mEmail;
        this.mSubject = mSubject;
        this.mMessage = mMessage;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Mostrar diálogo de progreso al enviar correo electrónico
        mProgressDialog = ProgressDialog.show(mContext,"Enviando mensaje", "Por favor espera...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        // Descartar el diálogo de progreso cuando el mensaje se envía correctamente
        mProgressDialog.dismiss();

        // Muestra el envio exitoso
        Toast.makeText(mContext,"Mensaje enviado",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        // Creando propiedades(properties)
        Properties props = new Properties();

        // Configurando propiedades para gmail
        // Si no está utilizando gmail, es posible que deba cambiar los valores
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        // Creando una nueva sesión
        mSession = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    // Autenticar la contraseña
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EMAIL,PASSWORD);
                    }
                });

        try {
            // Creando objeto MimeMessage
            MimeMessage mm = new MimeMessage(mSession);

            // Configuración de la dirección del remitente
            mm.setFrom(new InternetAddress(EMAIL));
            // Añadiendo receptor
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(mEmail));
            // Añadiendo asunto
            mm.setSubject(mSubject);
            // Añadiendo mensaje
            mm.setText(mMessage);
            // Envío de correo electrónico
            Transport.send(mm);

//            BodyPart messageBodyPart = new MimeBodyPart();
//
//            messageBodyPart.setText(message);
//
//            Multipart multipart = new MimeMultipart();
//
//            multipart.addBodyPart(messageBodyPart);
//
//            messageBodyPart = new MimeBodyPart();
//
//            DataSource source = new FileDataSource(filePath);
//
//            messageBodyPart.setDataHandler(new DataHandler(source));
//
//            messageBodyPart.setFileName(filePath);
//
//            multipart.addBodyPart(messageBodyPart);

//            mm.setContent(multipart);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}