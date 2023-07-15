/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionsav;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author ACER
 */
public class FXMLDocumentController implements Initializable {

    //Récupération des nom des variables (interface)
    @FXML
    private AnchorPane pnlconnexion;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtmdp;

    @FXML
    private Button btnconnexion;

    @FXML
    private Button btnforgot;

    @FXML
    private Button btnfermer;

    //Outil de la base de donnée
    private PreparedStatement pst;
    private ResultSet rs;

    //Variable
    private double x = 0;
    private double y = 0;
    //Connexion à la base de donnée

    public void connexionAdmin() {
        try {
            if (txtemail.getText().isEmpty() || txtmdp.getText().isEmpty()) {
                showAlert("Champs invalides", "Veuillez remplir tous les champs.");
            } else {
                // Connexion à la base de données
                connect con = new connect();
                pst = con.con.prepareStatement("select * from responsable where Email_Res = ? and Mdp_Res = ?");
                pst.setString(1, txtemail.getText());
                pst.setString(2, txtmdp.getText());
                rs = pst.executeQuery();

                if (!rs.isBeforeFirst()) { // Donnée qui n'existe pas
                    showAlert("Compte invalide", "Email ou mot de passe incorrect.");
                    txtemail.setText("");
                    txtmdp.setText("");
                } else { // Les données existent
                    while (rs.next()) {

                        //Fermeture du fenetre connexion
                        btnconnexion.getScene().getWindow().hide();
                        // Redirection vers la page principale
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
                        Parent root = loader.load();
                        menuController menu = loader.getController();

                        // Affichage du nom et prénom dans le menu
                        menu.lblNomDashboard.setText(rs.getString("Nom_Res"));
                        menu.lblPrenomDashboard.setText(rs.getString("Prenom_Res"));
                        String imagePath = rs.getString("Photo_Res");
                        File file = new File(imagePath);
                        String imageUrl = file.toURI().toURL().toString();
                        Image image = new Image(imageUrl);
                        menu.ImageAdminDashboard.setImage(image);

                        Stage stage = new Stage();
                        Scene scene = new Scene(root);

                        //Utilisation des variabeles
                        root.setOnMousePressed((MouseEvent event) -> {
                            x = event.getSceneX();
                            y = event.getSceneY();
                        });

                        root.setOnMouseDragged((MouseEvent event) -> {
                            stage.setX(event.getScreenX() - x);
                            stage.setY(event.getScreenY() - y);

                            stage.setOpacity(.8);
                        });

                        stage.initStyle(StageStyle.TRANSPARENT);
                        stage.setScene(scene);
                        stage.show();
                        // Ici, vous pouvez appeler une méthode ou charger une nouvelle vue FXML
                        // pour afficher la page principale de l'application
                        // Assurez-vous d'adapter cela à votre propre logique
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Fonction alert
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //
    //Fonction de fermeture
    public void fermer() {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Email Password Sender");

        txtemail = new TextField();
        txtemail.setPromptText("Enter your email");

        btnforgot = new Button("Send Password");
        btnforgot.setOnAction(e -> sendPassword());

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(txtemail, btnforgot);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void sendPassword() {
        String recipientEmail = txtemail.getText();

        // Configure the email server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Set your email account credentials
        String senderEmail = "rakotomalalasoloheryalain@gmail.com";
        String password = "leknbrslyhwplcal";

        // Create the session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, password);
            }
        });

        try {
            // Retrieve the password from the database
            String passwordFromDatabase = getPasswordFromDatabase(recipientEmail);

            if (passwordFromDatabase != null) {
                // Create a new message
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(senderEmail));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
                message.setSubject("Mot de passe récupérer");
                message.setText("Votre mot de passe est: " + passwordFromDatabase);

                // Send the message
                Transport.send(message);

                // Show a success alert
                showAlert("Email envoyé", "Votre mot de passe a été envoyé avec succès.");

                // Clear the email field
                txtemail.setText("");
            } else {
                showAlert("Erreur", "Votre mot de passe n'a pas été récupérer, veuiller contacter l'administrateur principale.");
            }
        } catch (MessagingException ex) {
            ex.printStackTrace();
            showAlert("Erreur", "Erreur d'envoi. Veuillez réessayer plutard.");
        }
    }

    private String getPasswordFromDatabase(String email) {
        // Configure database connection properties
        try {
            // Establish database connection
            connect con = new connect();
            // Prepare the SQL statement
            pst = con.con.prepareStatement("select * from responsable where Email_Res = ?");
            pst.setString(1, email);

            // Execute the query
            rs = pst.executeQuery();

            // Check if a result is found
            if (rs.next()) {
                // Retrieve the password from the result set
                String passwordFromDatabase = rs.getString("Mdp_Res");

                // Close the database resources
                rs.close();
                pst.close();

                return passwordFromDatabase;
            } else {
                // Close the database resources
                rs.close();
                pst.close();

                return null; // No password found for the given email
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle the database error
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
