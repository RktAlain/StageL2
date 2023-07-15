/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionsav;

import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.concurrent.Worker;
import javafx.embed.swing.SwingFXUtils;
import javafx.embed.swing.SwingNode;
import javafx.geometry.Insets;
import javafx.print.PageLayout;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Scale;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import netscape.javascript.JSObject;
import javafx.scene.chart.XYChart;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;

/**
 *
 * @author ACER
 */
public class menuController implements Initializable {

    @FXML
    private PieChart pieChart;

    @FXML
    private BarChart barChart;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button close;

    @FXML
    private Button modebtn;

    @FXML
    private Button minimize;

    @FXML
    private Button btn_dashboard;

    @FXML
    private Button btnShowPara;

    @FXML
    private Button btnNouveau;

    @FXML
    private Button btnCloseMdpPrinc;

    @FXML
    private Button btn_admin;

    @FXML
    private Button btn_client;

    @FXML
    private Button btn_Tech;

    @FXML
    private Button btn_demande;

    @FXML
    private Button btn_intervention;

    @FXML
    private Button btn_remise;

    @FXML
    private Button btn_mail;

    @FXML
    private Button logout;

    @FXML
    private Button btnPrintCardAdmin;

    @FXML
    private Button btnCloseDialog;

    @FXML
    private Button btnCloseDialogTech;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private AnchorPane anchorCard1;

    @FXML
    private AnchorPane anchorCard2;

    @FXML
    private AnchorPane anchorCard3;

    @FXML
    private AnchorPane anchorCard4;

    @FXML
    private AnchorPane admin_form;

    @FXML
    private AnchorPane demande_form;

    @FXML
    private AnchorPane cardAdmin;

    @FXML
    private AnchorPane cardTech;

    @FXML
    private Button btnInsert_Res;

    @FXML
    private Label lblidRes;
    
    @FXML
    public Label lblNomDashboard;
    
    @FXML
    public Label lblPrenomDashboard;

    @FXML
    private ImageView ImageAdmin;

    @FXML
    private TextField txtNomRes;

    @FXML
    private PasswordField txtmdpAdminPrinc;

    @FXML
    private TextField txtPrenomRes;

    @FXML
    private TextField txtAdrsRes;

    @FXML
    private TextField txtEmailRes;

    @FXML
    private TextField txtTelRes;

    @FXML
    private TextField txtTypeRes;

    @FXML
    private TextField txtMdpRes;

    @FXML
    private TextField txtCodeRes;

    @FXML
    private TextField txtdestinataire;

    @FXML
    private TextArea txtMessage;

    @FXML
    private TextField txtObjet;

    //Recherche
    @FXML
    private TextField txtRechAdmin;

    @FXML
    private TextField txtRechClient;

    @FXML
    private TextField txtRechTech;

    @FXML
    private TextField txtRechSAV;

    // Label Card
    @FXML
    private Label lblNomRes;

    @FXML
    private Label lblTitre;

    @FXML
    private Label lblPrenomRes;

    @FXML
    private Label lblAdrsRes;

    @FXML
    private Label lblEmailRes;

    @FXML
    private Label lblTelRes;

    @FXML
    private Label lblNomTech;

    @FXML
    private Label lblTotDmd;

    @FXML
    private Label lblPrenomTech;

    @FXML
    private Label lblAdrsTech;

    @FXML
    private Label lblEmailTech;

    @FXML
    private Label lblTelTech;

    @FXML
    private Label lbldmdSMS;

    @FXML
    private Label lblDateMail;

    @FXML
    private Label lblStatutMail;

    @FXML
    private ImageView ImgQrAdmin;

    @FXML
    private ImageView ImgQrTech;

    @FXML
    private ImageView ImgViewCardAdmin;

    @FXML
    private ImageView ImgViewCardTech;

    @FXML
    private ImageView qrCodeImageViewAdmin;

    @FXML
    private ImageView qrCodeImageViewTech;

    @FXML
    private ImageView qrCodeImageViewTechRecu;
    
    @FXML
    public ImageView ImageAdminDashboard;

    @FXML
    private Button generateQRCodeBtn;

    @FXML
    private Button btnQrAdmin;

    @FXML
    private Button btnQrTech;

    @FXML
    private Button btnScan;

    @FXML
    private Button showDialog;

    @FXML
    private Button btnShowRecu;

    @FXML
    private Button btnCloseRecu;

    @FXML
    private Button showDialogTech;

    @FXML
    private Button btnShowDmd;

    @FXML
    private Button btnCloseDmd;

    @FXML
    private Button btnShowPro;

    @FXML
    private Button btnClosePro;

    @FXML
    private Button btnShowMail;

    @FXML
    private Button btnCloseMail;

    @FXML
    private Button btnAjout_Res;

    @FXML
    private Button btnModif_Res;

    @FXML
    private Button btnSup_Res;

    @FXML
    private Button btnEffacer_Res;

    @FXML
    private TextField txtNomCli;

    @FXML
    private TextField txtPrenomCli;

    @FXML
    private TextField txtEmailCli;

    @FXML
    private TextField txtTelCli;

    @FXML
    private TextField txtFactCli;

    @FXML
    private Label lblidCli;

    @FXML
    private TextField txtAdrsCli;

    @FXML
    private Button btnAjout_Cli;

    @FXML
    private Button btnModif_Cli;

    @FXML
    private Button btnSup_Cli;

    @FXML
    private Button btnEfface_Cli;

    @FXML
    private ImageView ImageTech;

    @FXML
    private ImageView ImagePro;

    @FXML
    private Button btnInsert_Teh;

    @FXML
    private Button btnAjout_Dmd;

    @FXML
    private Label lblidTech;

    @FXML
    private TextField txtNomTech;

    @FXML
    private TextField txtPrenomTech;

    @FXML
    private TextField txtAdrsTech;

    @FXML
    private TextField txtEmailTech;

    @FXML
    private TextField txtTelTech;

    //Demande
    @FXML
    private TextField txtNumDmd;

    @FXML
    private TextField txtCauseDmd;

    @FXML
    private TextField txtidCliDmd;

    @FXML
    private TextField txtDateDmd;

    @FXML
    private TextField txtDelaisDmd;

    @FXML
    private TextField txtStatutDmd;

    //Produit
    @FXML
    private TextField txtNumDmdPro;

    @FXML
    private TextField txtNomPro;

    @FXML
    private TextField txtDescPro;

    @FXML
    private TextField txtGarPro;

    @FXML
    private TextField txtPrixPro;

    @FXML
    private TextField txtRefPro;

    //Intervvention
    @FXML
    private TextField txtRefProInter;

    @FXML
    private Label lblidinter;

    @FXML
    private TextField txtIdTechInter;

    @FXML
    private TextField txtDateInter;

    @FXML
    private TextField txtDateFinInter;

    @FXML
    private TextField txtTypeInter;

    @FXML
    private TextField txtCoutInter;

    @FXML
    private TextField txtStatutInter;

    //Remise
    @FXML
    private Label lblidRem;

    @FXML
    private Label lblidMail;

    @FXML
    private TextField txtNumDmdRem;

    @FXML
    private TextField txtIdResRem;

    @FXML
    private TextField txtDateRem;

    @FXML
    private TextArea txtDescRem;

    @FXML
    private TextField txtProRem;

    @FXML
    private TextField txtRefRem;

    //Recu
    @FXML
    private Label lblidRemRecu;

    @FXML
    private Label lblDateRemRecu;

    @FXML
    private Label lblNomCliRemRecu;

    @FXML
    private Label lblNumDmdRemRecu;

    @FXML
    private Label lblCauseRemRecu;

    @FXML
    private Label lblDateInterRecu;

    @FXML
    private Label lblNomTechRemRecu;

    @FXML
    private Label lblNomResRemRecu;

    //Colone Responsabe
    @FXML
    private TableColumn<ObservableList<String>, Integer> columnIDRes;

    @FXML
    private TableColumn<ObservableList<String>, String> columnNomRes;

    @FXML
    private TableColumn<ObservableList<String>, String> columnPrenomRes;

    @FXML
    private TableColumn<ObservableList<String>, String> columnAdrsRes;

    @FXML
    private TableColumn<ObservableList<String>, String> columnEmailRes;

    @FXML
    private TableColumn<ObservableList<String>, String> columnTelRes;

    @FXML
    private TableColumn<ObservableList<String>, String> columnTypeRes;

    //Colone Client
    @FXML
    private TableColumn<ObservableList<String>, Integer> columnIdCli;

    @FXML
    private TableColumn<ObservableList<String>, String> columnNomCli;

    @FXML
    private TableColumn<ObservableList<String>, String> columnPrenomCli;

    @FXML
    private TableColumn<ObservableList<String>, String> columnAdrsCli;

    @FXML
    private TableColumn<ObservableList<String>, String> columnEmailCli;

    @FXML
    private TableColumn<ObservableList<String>, String> columnTelCli;

    @FXML
    private TableColumn<ObservableList<String>, String> columnFactCli;

    //Colone Technicien
    @FXML
    private TableColumn<ObservableList<String>, Integer> columnIdTech;

    @FXML
    private TableColumn<ObservableList<String>, String> columnNomTech;

    @FXML
    private TableColumn<ObservableList<String>, String> columnPrenomTech;

    @FXML
    private TableColumn<ObservableList<String>, String> columnAdrsTech;

    @FXML
    private TableColumn<ObservableList<String>, String> columnEmailTech;

    @FXML
    private TableColumn<ObservableList<String>, String> columnTelTech;

    //Colonne Demande
    @FXML
    private TableColumn<ObservableList<String>, String> columnNumDmd;

    @FXML
    private TableColumn<ObservableList<String>, Integer> columnIdCliDmd;

    @FXML
    private TableColumn<ObservableList<String>, String> columnCauseDmd;

    @FXML
    private TableColumn<ObservableList<String>, String> columnDateDmd;

    @FXML
    private TableColumn<ObservableList<String>, String> columnDelaisDmd;

    @FXML
    private TableColumn<ObservableList<String>, String> columnStatutDmd;

    //Colonne Produit
    @FXML
    private TableColumn<ObservableList<String>, String> columnRefPro;

    @FXML
    private TableColumn<ObservableList<String>, String> columnNumDmdPro;

    @FXML
    private TableColumn<ObservableList<String>, String> columnNomPro;

    @FXML
    private TableColumn<ObservableList<String>, String> columnDescPro;

    @FXML
    private TableColumn<ObservableList<String>, String> columnGarPro;

    @FXML
    private TableColumn<ObservableList<String>, String> columnPrixPro;

    //Colonne SAV
    @FXML
    private TableColumn<ObservableList<String>, String> columnNumDmdSAV;

    @FXML
    private TableColumn<ObservableList<String>, Integer> columnIdCliSAV;

    @FXML
    private TableColumn<ObservableList<String>, String> columnCauseSAV;

    @FXML
    private TableColumn<ObservableList<String>, String> columnDateSAV;

    @FXML
    private TableColumn<ObservableList<String>, String> columnDelaiSAV;

    @FXML
    private TableColumn<ObservableList<String>, String> columnRefSAV;

    @FXML
    private TableColumn<ObservableList<String>, String> columnNomProSAV;

    @FXML
    private TableColumn<ObservableList<String>, String> columnDescSAV;

    @FXML
    private TableColumn<ObservableList<String>, String> columnGarSAV;

    @FXML
    private TableColumn<ObservableList<String>, String> columnPrixSAV;

    @FXML
    private TableColumn<ObservableList<String>, String> columnStatutSAV;

    //Colonne Intervention
    @FXML
    private TableColumn<ObservableList<String>, Integer> columnIdInter;

    @FXML
    private TableColumn<ObservableList<String>, String> columnRefProInter;

    @FXML
    private TableColumn<ObservableList<String>, Integer> columnIdTechInter;

    @FXML
    private TableColumn<ObservableList<String>, String> columnDateInter;

    @FXML
    private TableColumn<ObservableList<String>, String> columnDateFinInter;

    @FXML
    private TableColumn<ObservableList<String>, String> columnTypeInter;

    @FXML
    private TableColumn<ObservableList<String>, String> columnCoutInter;

    @FXML
    private TableColumn<ObservableList<String>, String> columnStatutInter;

    //Colonne Intervention
    @FXML
    private TableColumn<ObservableList<String>, Integer> columnIdRem;

    @FXML
    private TableColumn<ObservableList<String>, String> columnNumDmdRem;

    @FXML
    private TableColumn<ObservableList<String>, String> columnDateRem;

    @FXML
    private TableColumn<ObservableList<String>, String> columnDescRem;

    @FXML
    private TableColumn<ObservableList<String>, String> columnProRem;

    @FXML
    private TableColumn<ObservableList<String>, String> columnRefRem;

    @FXML
    private TableColumn<ObservableList<String>, String> columnIdResRem;

    //Colonne Ancien Produit et nouveau Produit
    @FXML
    private TableColumn<ObservableList<String>, String> columnRefProA;

    @FXML
    private TableColumn<ObservableList<String>, String> columnRefProB;

    @FXML
    private TableColumn<ObservableList<String>, String> columnNomProA;

    @FXML
    private TableColumn<ObservableList<String>, String> columnNomProB;

    @FXML
    private TableColumn<ObservableList<String>, String> columnDescProA;

    @FXML
    private TableColumn<ObservableList<String>, String> columnDescProB;

    //Colonne Tous
    @FXML
    private TableColumn<ObservableList<String>, String> columnMailTous;

    @FXML
    private TableColumn<ObservableList<String>, String> columnObjetTous;

    @FXML
    private TableColumn<ObservableList<String>, String> columnMessageTous;

    @FXML
    private TableColumn<ObservableList<String>, String> columnDateTous;

    @FXML
    private TableColumn<ObservableList<String>, String> columnStatutTous;

    //Colonne Envoye
    @FXML
    private TableColumn<ObservableList<String>, String> columnMailEnvoye;

    @FXML
    private TableColumn<ObservableList<String>, String> columnObjetEnvoye;

    @FXML
    private TableColumn<ObservableList<String>, String> columnMessageEnvoye;

    @FXML
    private TableColumn<ObservableList<String>, String> columnDateEnvoye;

    //Colonne Echoue
    @FXML
    private TableColumn<ObservableList<String>, String> columnMailEchec;

    @FXML
    private TableColumn<ObservableList<String>, String> columnObjetEchec;

    @FXML
    private TableColumn<ObservableList<String>, String> columnMessageEchec;

    @FXML
    private TableColumn<ObservableList<String>, String> columnDateEchec;

    //Forme
    @FXML
    private AnchorPane client_form;

    @FXML
    private AnchorPane Tech_form;

    @FXML
    private AnchorPane dialog_form;

    @FXML
    private AnchorPane dialog_formTech;

    @FXML
    private AnchorPane dmdSAV_form;

    @FXML
    private AnchorPane proSAV_form;

    @FXML
    private AnchorPane sidebar_form;

    @FXML
    private AnchorPane navbar_form;

    @FXML
    private AnchorPane mdp_form;

    @FXML
    private AnchorPane recu_form;

    @FXML
    private AnchorPane mail_form;

    @FXML
    private AnchorPane Inter_form;

    @FXML
    private AnchorPane Remise_form;

    @FXML
    private AnchorPane historique_form;

    //QR Code Admin
    @FXML
    private TableView<ObservableList<String>> tblAdmin; // TableView pour afficher les données
    @FXML
    private TableView<ObservableList<String>> tblClient; // TableView pour afficher les données
    @FXML
    private TableView<ObservableList<String>> tblTech; // TableView pour afficher les données
    @FXML
    private TableView<ObservableList<String>> tblDemande; // TableView pour afficher les données
    @FXML
    private TableView<ObservableList<String>> tblProduit; // TableView pour afficher les données
    @FXML
    private TableView<ObservableList<String>> tblSAV; // TableView pour afficher les données
    @FXML
    private TableView<ObservableList<String>> tblAncienPro; // TableView pour afficher les données
    @FXML
    private TableView<ObservableList<String>> tblNouveauPro; // TableView pour afficher les données
    @FXML
    private TableView<ObservableList<String>> tblintervention; // TableView pour afficher les données
    @FXML
    private TableView<ObservableList<String>> tblRemise; // TableView pour afficher les données
    @FXML
    private TableView<ObservableList<String>> tblTous; // TableView pour afficher les données
    @FXML
    private TableView<ObservableList<String>> tblEnvoye; // TableView pour afficher les données
    @FXML
    private TableView<ObservableList<String>> tblEchec; // TableView pour afficher les données

    //Outils photo
    public File fileAdmin = null;
    public String pathM;
    private boolean isMoved = false;
    private Background originalBackground;

    //Mode dark
    @FXML
    void mode(ActionEvent event) {
        if (event.getSource() == modebtn) {
            Button button = (Button) event.getSource(); // Récupérer la référence du bouton cliqué

            TranslateTransition transition = new TranslateTransition(Duration.seconds(1), button);

            if (isMoved) {
                // Si le bouton est déjà déplacé, le ramener à sa position initiale
                transition.setToX(0);
                isMoved = false;

                // Restaurer la couleur de fond d'origine de l'AnchorPane
//                sidebar_form.setBackground(originalBackground);
                //SideBar
                Stop[] stops = new Stop[]{new Stop(0, Color.web("#9631c4")), new Stop(1, Color.web("#48349a"))};
                LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
                sidebar_form.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));
                //Carte
                Stop[] stops1 = new Stop[]{new Stop(0, Color.web("#9631c4")), new Stop(1, Color.web("#48349a"))};
                LinearGradient gradient1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops1);
                anchorCard1.setBackground(new Background(new BackgroundFill(gradient1, CornerRadii.EMPTY, Insets.EMPTY)));
                anchorCard2.setBackground(new Background(new BackgroundFill(gradient1, CornerRadii.EMPTY, Insets.EMPTY)));
                anchorCard1.setBackground(new Background(new BackgroundFill(gradient1, CornerRadii.EMPTY, Insets.EMPTY)));
                anchorCard3.setBackground(new Background(new BackgroundFill(gradient1, CornerRadii.EMPTY, Insets.EMPTY)));
                anchorCard4.setBackground(new Background(new BackgroundFill(gradient1, CornerRadii.EMPTY, Insets.EMPTY)));
                //Déconnexion
                logout.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));
                //Barre de navigation
                navbar_form.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                navbar_form.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                dashboard_form.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
                //Titre
                lblTitre.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            } else {
                // Sinon, déplacer le bouton de 50 pixels vers la droite
                transition.setByX(50);
                isMoved = true;

                // Changer la couleur de fond de l'AnchorPane en gris
                Stop[] stops = new Stop[]{new Stop(0, Color.BLACK), new Stop(1, Color.web("#808080"))};
                LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
                sidebar_form.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));
                navbar_form.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
                dashboard_form.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

                //Titre
                lblTitre.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
                //Déconnexion
                logout.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));
                //Carte
                anchorCard1.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));
                anchorCard2.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));
                anchorCard3.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));
                anchorCard4.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));
            }

            transition.play();
        }
    }

    //Ajout de l'administrateur
    @FXML
    void Ajout_Res(ActionEvent event) {
        if (!txtNomRes.getText().isEmpty() && !txtPrenomRes.getText().isEmpty() && !txtTelRes.getText().isEmpty()
                && !txtAdrsRes.getText().isEmpty() && !txtEmailRes.getText().isEmpty() && !txtMdpRes.getText().isEmpty()
                && !txtCodeRes.getText().isEmpty()) {
            try {
                connect con = new connect(); //Connexion à la bd
                pst = con.con.prepareStatement("insert into responsable (Nom_Res, Prenom_Res, Adrs_Res, Email_Res, Tel_Res, Type_Res, Mdp_Res, Code_Res, Photo_Res) values (?,?,?,?,?,?,?,?,?)");
                pst.setString(1, txtNomRes.getText());
                pst.setString(2, txtPrenomRes.getText());
                pst.setString(3, txtAdrsRes.getText());
                pst.setString(4, txtEmailRes.getText());
                pst.setString(5, txtTelRes.getText());
                pst.setString(6, txtTypeRes.getText());
                pst.setString(7, txtMdpRes.getText());
                pst.setString(8, txtCodeRes.getText());
                pst.setString(9, pathM);
                pst.executeUpdate();

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Succès");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Responsable ajouté avec succès");
                successAlert.showAndWait();

                tableAdmin();
                pst.close();
            } catch (Exception e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erreur");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Échec d'ajout : " + e.getMessage());
                errorAlert.showAndWait();
            }
        } else {
            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
            infoAlert.setTitle("Information");
            infoAlert.setHeaderText(null);
            infoAlert.setContentText("Veuillez compléter tous les champs");
            infoAlert.showAndWait();
        }

    }

    //Effacer les données Admin Input
    @FXML
    void Effacer_Res(ActionEvent event) {
        lblidRes.setText("");
        txtNomRes.setText("");
        txtPrenomRes.setText("");
        txtAdrsRes.setText("");
        txtEmailRes.setText("");
        txtTelRes.setText("");
        txtMdpRes.setText("");
        txtCodeRes.setText("");
    }

    //Upluad Image Admin
    private Image image;

    @FXML
    void Insert_Res(ActionEvent event) {
        FileChooser photo = new FileChooser();
        photo.setTitle("Importer une photo");
        photo.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));
        File fileAdmin = photo.showOpenDialog(main_form.getScene().getWindow());

        if (fileAdmin != null) {
            pathM = fileAdmin.getAbsolutePath();
            image = new Image(fileAdmin.toURI().toString(), 130, 120, false, true);
            ImageAdmin.setImage(image);
        }
    }
    
    @FXML
    void Insert_Admin(ActionEvent event) {
        FileChooser photo = new FileChooser();
        photo.setTitle("Importer une photo");
        photo.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));
        File fileAdmin = photo.showOpenDialog(main_form.getScene().getWindow());

        if (fileAdmin != null) {
            pathM = fileAdmin.getAbsolutePath();
            image = new Image(fileAdmin.toURI().toString(), 130, 120, false, true);
            ImageRes.setImage(image);
        }
    }

    //Upluad Image Tech
    @FXML
    void Insert_Tech(ActionEvent event) {
        FileChooser photo = new FileChooser();
        photo.setTitle("Importer une photo");
        photo.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));
        File fileAdmin = photo.showOpenDialog(main_form.getScene().getWindow());

        if (fileAdmin != null) {
            pathM = fileAdmin.getAbsolutePath();
            image = new Image(fileAdmin.toURI().toString(), 130, 120, false, true);
            ImageTech.setImage(image);
        }
    }

//    Upluad Image Produit
    @FXML
    void Insert_Pro(ActionEvent event) {
        FileChooser photo = new FileChooser();
        photo.setTitle("Importer une photo");
        photo.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));
        File fileAdmin = photo.showOpenDialog(main_form.getScene().getWindow());

        if (fileAdmin != null) {
            pathM = fileAdmin.getAbsolutePath();
            image = new Image(fileAdmin.toURI().toString(), 130, 120, false, true);
            ImagePro.setImage(image);
        }
    }

    //Modification de l'administrateur
    @FXML
    void Modif_Res(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("UPDATE responsable SET Nom_Res = ?, Prenom_Res = ?, Adrs_Res = ?, Email_Res = ?, Tel_Res = ?, Type_Res = ?, Mdp_Res = ?, Code_Res = ?, Photo_Res = ? WHERE Id_Res = '" + lblidRes.getText() + "'");
            pst.setString(1, txtNomRes.getText());
            pst.setString(2, txtPrenomRes.getText());
            pst.setString(3, txtAdrsRes.getText());
            pst.setString(4, txtEmailRes.getText());
            pst.setString(5, txtTelRes.getText());
            pst.setString(6, txtTypeRes.getText());
            pst.setString(7, txtMdpRes.getText());
            pst.setString(8, txtCodeRes.getText());
            pst.setString(9, pathM);
            pst.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Administrateur mis à jour avec succès");
            successAlert.showAndWait();
            tableAdmin();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la mise à jour : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Suppression de l'administrateur
    @FXML
    void Sup_Res(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("DELETE FROM responsable WHERE Id_Res = ?");
            pst.setString(1, lblidRes.getText());
            pst.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Administrateur supprimé avec succès");
            successAlert.showAndWait();
            tableAdmin();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la suppression : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Ajout Client
    @FXML
    void Ajout_Cli(ActionEvent event) {
        if (!txtNomCli.getText().isEmpty() && !txtPrenomCli.getText().isEmpty() && !txtEmailCli.getText().isEmpty()
                && !txtTelCli.getText().isEmpty() && !txtAdrsCli.getText().isEmpty() && !txtFactCli.getText().isEmpty()) {
            try {
                connect con = new connect(); //Connexion à la bd
                pst = con.con.prepareStatement("insert into client (Nom_Cli, Prenom_Cli, Email_Cli, Tel_Cli, Adrs_Cli, NumFact_Cli) values (?,?,?,?,?,?)");
                pst.setString(1, txtNomCli.getText());
                pst.setString(2, txtPrenomCli.getText());
                pst.setString(3, txtEmailCli.getText());
                pst.setString(4, txtTelCli.getText());
                pst.setString(5, txtAdrsCli.getText());
                pst.setString(6, txtFactCli.getText());
                pst.executeUpdate();

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Succès");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Client ajouté avec succès");
                successAlert.showAndWait();

                tableClient();
                pst.close();
            } catch (Exception e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erreur");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Échec d'ajout : " + e.getMessage());
                errorAlert.showAndWait();
            }
        } else {
            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
            infoAlert.setTitle("Information");
            infoAlert.setHeaderText(null);
            infoAlert.setContentText("Veuillez compléter tous les champs");
            infoAlert.showAndWait();
        }
    }

    //Modification du client
    @FXML
    void Modif_Cli(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("UPDATE client SET Nom_Cli = ?, Prenom_Cli = ?, Email_Cli = ?, Tel_Cli = ?, Adrs_Cli = ?, NumFact_Cli = ? WHERE Id_Cli = '" + lblidCli.getText() + "'");
            pst.setString(1, txtNomCli.getText());
            pst.setString(2, txtPrenomCli.getText());
            pst.setString(3, txtEmailCli.getText());
            pst.setString(4, txtTelCli.getText());
            pst.setString(5, txtAdrsCli.getText());
            pst.setString(6, txtFactCli.getText());
            pst.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Client mis à jour avec succès");
            successAlert.showAndWait();
            tableClient();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la mise à jour : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Suppresion du client
    @FXML
    void Sup_Cli(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("DELETE FROM client WHERE Id_Cli = ?");
            pst.setString(1, lblidCli.getText());
            pst.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Client supprimé avec succès");
            successAlert.showAndWait();
            tableClient();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la suppression : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Effacer le client
    @FXML
    void Efface_Cli(ActionEvent event) {
        lblidCli.setText("");
        txtNomCli.setText("");
        txtPrenomCli.setText("");
        txtAdrsCli.setText("");
        txtEmailCli.setText("");
        txtTelCli.setText("");
        txtFactCli.setText("");
    }

    //Ajout de Technicien
    @FXML
    void Ajout_Tech(ActionEvent event) {
        if (!txtNomTech.getText().isEmpty() && !txtPrenomTech.getText().isEmpty() && !txtTelTech.getText().isEmpty()
                && !txtAdrsTech.getText().isEmpty() && !txtEmailTech.getText().isEmpty()) {
            try {
                connect con = new connect(); //Connexion à la bd
                pst = con.con.prepareStatement("insert into technicien (Nom_Tech, Prenom_Tech, Adrs_Tech, Email_Tech, Tel_Tech, Photo_Tech) values (?,?,?,?,?,?)");
                pst.setString(1, txtNomTech.getText());
                pst.setString(2, txtPrenomTech.getText());
                pst.setString(3, txtAdrsTech.getText());
                pst.setString(4, txtEmailTech.getText());
                pst.setString(5, txtTelTech.getText());
                pst.setString(6, pathM);
                pst.executeUpdate();

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Succès");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Technicien ajouté avec succès");
                successAlert.showAndWait();

                tableTech();
                pst.close();
            } catch (Exception e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erreur");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Échec d'ajout : " + e.getMessage());
                errorAlert.showAndWait();
            }
        } else {
            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
            infoAlert.setTitle("Information");
            infoAlert.setHeaderText(null);
            infoAlert.setContentText("Veuillez compléter tous les champs");
            infoAlert.showAndWait();
        }

    }

    //Modification du technicien
    @FXML
    void Modif_Tech(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("UPDATE technicien SET Nom_Tech = ?, Prenom_Tech = ?, Adrs_Tech = ?, Email_Tech = ?, Tel_Tech = ?, Photo_Tech = ? WHERE Id_Tech = '" + lblidTech.getText() + "'");
            pst.setString(1, txtNomTech.getText());
            pst.setString(2, txtPrenomTech.getText());
            pst.setString(3, txtAdrsTech.getText());
            pst.setString(4, txtEmailTech.getText());
            pst.setString(5, txtTelTech.getText());
            pst.setString(6, pathM);
            pst.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Technicien mis à jour avec succès");
            successAlert.showAndWait();
            tableTech();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la mise à jour : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Suppression de l'administrateur
    @FXML
    void Sup_Tech(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("DELETE FROM technicien WHERE Id_Tech = ?");
            pst.setString(1, lblidTech.getText());
            pst.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Technicien supprimé avec succès");
            successAlert.showAndWait();
            tableTech();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la suppression : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Suppression de l'intervention
    @FXML
    void Sup_Inter(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("DELETE FROM intervention WHERE Id_Inter = ?");
            pst.setString(1, lblidinter.getText());
            pst.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("intervention supprimé avec succès");
            successAlert.showAndWait();
            tableTech();
            String StatutDmd = "En attente";
            pst = con.con.prepareStatement("Update demande, produit, intervention set Statut_Dmd = '" + StatutDmd + "' where demande.Num_Dmd = produit.Num_Dmd and produit.Ref_Pro = intervention.Ref_Pro and intervention.Ref_Pro = '" + txtRefProInter.getText() + "'");
            pst.executeUpdate();

            Alert successAlert1 = new Alert(Alert.AlertType.INFORMATION);
            successAlert1.setTitle("Succès");
            successAlert1.setHeaderText(null);
            successAlert1.setContentText("Demande mise en attente");
            successAlert1.showAndWait();

            tableDemande();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la suppression : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Effacer Technicien
    @FXML
    void Efface_Tech(ActionEvent event) {
        lblidTech.setText("");
        txtNomTech.setText("");
        txtPrenomTech.setText("");
        txtAdrsTech.setText("");
        txtEmailTech.setText("");
        txtTelTech.setText("");
    }

    //Ajout de Demande et produit
    @FXML
    void Ajout_SAV(ActionEvent event) {
        if (!txtNumDmd.getText().isEmpty() && !txtCauseDmd.getText().isEmpty() && !txtidCliDmd.getText().isEmpty() && !txtDateDmd.getText().isEmpty() && !txtDelaisDmd.getText().isEmpty() && !txtStatutDmd.getText().isEmpty()) {
            try {
                connect con = new connect(); //Connexion à la bd
                pst = con.con.prepareStatement("insert into demande (Num_Dmd, Id_Cli, Cause_Dmd, Date_Dmd, Delais_Dmd, Statut_Dmd) values (?,?,?,?,?,?)");
                pst.setString(1, txtNumDmd.getText());
                pst.setString(2, txtidCliDmd.getText());
                pst.setString(3, txtCauseDmd.getText());
                pst.setString(4, txtDateDmd.getText());
                pst.setString(5, txtDelaisDmd.getText());
                pst.setString(6, txtStatutDmd.getText());
                pst.executeUpdate();
                tableDemande();
                pst = con.con.prepareStatement("insert into produit (Ref_Pro, Num_Dmd, Nom_Pro, Desc_Pro, Gar_Pro, Prix_Pro, Photo_Pro) values (?,?,?,?,?,?,?)");
                pst.setString(1, txtRefPro.getText());
                pst.setString(2, txtNumDmdPro.getText());
                pst.setString(3, txtNomPro.getText());
                pst.setString(4, txtDescPro.getText());
                pst.setString(5, txtGarPro.getText());
                pst.setString(6, txtPrixPro.getText());
                pst.setString(7, pathM);
                pst.executeUpdate();
                tableProduit();
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Succès");
                successAlert.setHeaderText(null);
                successAlert.setContentText("demande ajouté avec succès");
                successAlert.showAndWait();

                pst.close();
            } catch (Exception e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erreur");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Échec d'ajout : " + e.getMessage());
                errorAlert.showAndWait();
            }
        } else {
            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
            infoAlert.setTitle("Information");
            infoAlert.setHeaderText(null);
            infoAlert.setContentText("Veuillez compléter tous les champs");
            infoAlert.showAndWait();
        }
    }

    //Modification de la demande
    @FXML
    void Modif_Dmd(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("UPDATE demande SET Num_Dmd = ?, Id_Cli = ?, Cause_Dmd = ?, Date_Dmd = ?, Delais_Dmd = ?, Statut_Dmd = ? WHERE Num_Dmd = '" + txtNumDmd.getText() + "'");
            pst.setString(1, txtNumDmd.getText());
            pst.setString(2, txtidCliDmd.getText());
            pst.setString(3, txtCauseDmd.getText());
            pst.setString(4, txtDateDmd.getText());
            pst.setString(5, txtDelaisDmd.getText());
            pst.setString(6, txtStatutDmd.getText());
            pst.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Demande mis à jour avec succès");
            successAlert.showAndWait();
            tableDemande();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la mise à jour : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Suppression de Demande et produit
    @FXML
    void Sup_SAV(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("DELETE FROM produit WHERE Num_Dmd = ?");
            pst.setString(2, txtNumDmdPro.getText());
            pst.executeUpdate();

            pst = con.con.prepareStatement("DELETE FROM demande WHERE Num_Dmd = ?");
            pst.setString(1, txtNumDmd.getText());

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Opération supprimé avec succès");
            successAlert.showAndWait();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la suppression : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Effacer Demande
    @FXML
    void Efface_Dmd(ActionEvent event) {
        txtNumDmd.setText("");
        txtidCliDmd.setText("");
        txtCauseDmd.setText("");
        txtDateDmd.setText("");
        txtDelaisDmd.setText("");
        txtStatutDmd.setText("");
    }

    //Effacer Produit
    @FXML
    void Efface_Pro(ActionEvent event) {
        txtRefPro.setText("");
        txtNumDmdPro.setText("");
        txtNomPro.setText("");
        txtDescPro.setText("");
        txtGarPro.setText("");
        txtPrixPro.setText("");
        ImagePro.setImage(null);
    }

    //Effacer remise
    @FXML
    void Efface_Remise(ActionEvent event) {
        lblidRem.setText("");
        txtNumDmdRem.setText("");
        txtDateRem.setText("");
        txtDescRem.setText("");
        txtProRem.setText("");
        txtRefRem.setText("");
    }

    //Effacer Intervention
    @FXML
    void Efface_Inter(ActionEvent event) {
        lblidinter.setText("");
        txtRefProInter.setText("");
        txtIdTechInter.setText("");
        txtDateInter.setText("");
        txtDateFinInter.setText("");
        txtCoutInter.setText("");
    }

    //Ajout Produit
    @FXML
    void Ajout_Pro(ActionEvent event) {
        if (!txtRefPro.getText().isEmpty() && !txtNumDmdPro.getText().isEmpty() && !txtNomPro.getText().isEmpty() && !txtDescPro.getText().isEmpty() && !txtGarPro.getText().isEmpty() && !txtPrixPro.getText().isEmpty()) {
            try {
                connect con = new connect(); //Connexion à la bd
                pst = con.con.prepareStatement("insert into produit (Ref_Pro, Num_Dmd, Nom_Pro, Desc_Pro, Gar_Pro, Prix_Pro, Photo_Pro) values (?,?,?,?,?,?,?)");
                pst.setString(1, txtRefPro.getText());
                pst.setString(2, txtNumDmdPro.getText());
                pst.setString(3, txtNomPro.getText());
                pst.setString(4, txtDescPro.getText());
                pst.setString(5, txtGarPro.getText());
                pst.setString(6, txtPrixPro.getText());
                pst.setString(7, pathM);
                pst.executeUpdate();
                tableProduit();
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Succès");
                successAlert.setHeaderText(null);
                successAlert.setContentText("produit ajouté avec succès");
                successAlert.showAndWait();

                pst.close();
            } catch (Exception e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erreur");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Échec d'ajout : " + e.getMessage());
                errorAlert.showAndWait();
            }
        } else {
            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
            infoAlert.setTitle("Information");
            infoAlert.setHeaderText(null);
            infoAlert.setContentText("Veuillez compléter tous les champs");
            infoAlert.showAndWait();
        }
    }

    //Modification de la demande
    @FXML
    void Modif_Pro(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("UPDATE produit SET Ref_Pro = ?, Num_Dmd = ?, Nom_Pro = ?, Desc_Pro = ?, Gar_Pro = ?, Prix_Pro = ?, Photo_Pro = ? WHERE Ref_Pro = '" + txtRefPro.getText() + "'");
            pst.setString(1, txtRefPro.getText());
            pst.setString(2, txtNumDmdPro.getText());
            pst.setString(3, txtNomPro.getText());
            pst.setString(4, txtDescPro.getText());
            pst.setString(5, txtGarPro.getText());
            pst.setString(6, txtPrixPro.getText());
            pst.setString(7, pathM);
            pst.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Produit mis à jour avec succès");
            successAlert.showAndWait();
            tableProduit();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la mise à jour : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Ajout Intervention
    @FXML
    void Ajout_Inter(ActionEvent event) {
        if (!txtRefProInter.getText().isEmpty() && !txtIdTechInter.getText().isEmpty() && !txtDateInter.getText().isEmpty()
                && !txtDateFinInter.getText().isEmpty() && !txtTypeInter.getText().isEmpty() && !txtCoutInter.getText().isEmpty()) {
            try {
                connect con = new connect(); //Connexion à la bd
                pst = con.con.prepareStatement("insert into intervention (Ref_Pro, Id_Tech, Date_Inter, DateFin_Inter, Type_Inter, Cout_Inter, Statut_Inter) values (?,?,?,?,?,?,?)");
                pst.setString(1, txtRefProInter.getText());
                pst.setString(2, txtIdTechInter.getText());
                pst.setString(3, txtDateInter.getText());
                pst.setString(4, txtDateFinInter.getText());
                pst.setString(5, txtTypeInter.getText());
                pst.setString(6, txtCoutInter.getText());
                pst.setString(7, txtStatutInter.getText());
                pst.executeUpdate();

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Succès");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Intervention ajouté avec succès");
                successAlert.showAndWait();

                tableInter();

                String StatutDmd = "En cours";
                pst = con.con.prepareStatement("Update demande, produit, intervention set Statut_Dmd = '" + StatutDmd + "' where demande.Num_Dmd = produit.Num_Dmd and produit.Ref_Pro = intervention.Ref_Pro and intervention.Ref_Pro = '" + txtRefProInter.getText() + "'");
                pst.executeUpdate();

                Alert successAlert1 = new Alert(Alert.AlertType.INFORMATION);
                successAlert1.setTitle("Succès");
                successAlert1.setHeaderText(null);
                successAlert1.setContentText("Demande en cours");
                successAlert1.showAndWait();

                tableDemande();
                pst.close();
            } catch (Exception e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erreur");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Échec d'ajout : " + e.getMessage());
                errorAlert.showAndWait();
            }
        } else {
            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
            infoAlert.setTitle("Information");
            infoAlert.setHeaderText(null);
            infoAlert.setContentText("Veuillez compléter tous les champs");
            infoAlert.showAndWait();
        }
    }

    //Update Demande et Intervention
    @FXML
    void Maj_DmdInter(ActionEvent event) {
        if (!txtRefProInter.getText().isEmpty() && !txtIdTechInter.getText().isEmpty() && !txtDateInter.getText().isEmpty()
                && !txtDateFinInter.getText().isEmpty() && !txtTypeInter.getText().isEmpty() && !txtCoutInter.getText().isEmpty()) {
            try {
                connect con = new connect(); //Connexion à la bd

                String StatutInter = "Terminé";
                pst = con.con.prepareStatement("Update intervention set Statut_Inter = '" + StatutInter + "' where Id_Inter = '" + lblidinter.getText() + "'");
                pst.executeUpdate();

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Succès");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Intervention terminé");
                successAlert.showAndWait();
                tableInter();
                String StatutDmd = "Résolue";
                pst = con.con.prepareStatement("Update demande, produit, intervention set Statut_Dmd = '" + StatutDmd + "' where demande.Num_Dmd = produit.Num_Dmd and produit.Ref_Pro = intervention.Ref_Pro and intervention.Ref_Pro = '" + txtRefProInter.getText() + "'");
                pst.executeUpdate();

                Alert successAlert1 = new Alert(Alert.AlertType.INFORMATION);
                successAlert1.setTitle("Succès");
                successAlert1.setHeaderText(null);
                successAlert1.setContentText("Demande résolue");
                successAlert1.showAndWait();

                tableDemande();
                transfertSMS();
                pst.close();

                mail_form.setVisible(true);
                navbar_form.setMouseTransparent(true);
                sidebar_form.setMouseTransparent(true);
                dashboard_form.setMouseTransparent(true);
                Inter_form.setMouseTransparent(true);

            } catch (Exception e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erreur");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Échec d'ajout : " + e.getMessage());
                errorAlert.showAndWait();
            }
        } else {
            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
            infoAlert.setTitle("Information");
            infoAlert.setHeaderText(null);
            infoAlert.setContentText("Veuillez compléter tous les champs");
            infoAlert.showAndWait();
        }
    }

    @FXML
    void Modif_Inter(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("UPDATE intervention SET Ref_Pro = ?, Id_Tech = ?, Date_Inter = ?, DateFin_Inter = ?, Type_Inter = ?,  = ?, Cout_Inter = ? WHERE Id_Inter = '" + lblidinter.getText() + "'");
            pst.setString(1, txtRefPro.getText());
            pst.setString(2, txtIdTechInter.getText());
            pst.setString(3, txtDateInter.getText());
            pst.setString(4, txtDateFinInter.getText());
            pst.setString(5, txtTypeInter.getText());
            pst.setString(6, txtCoutInter.getText());
            pst.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Intervention modifié avec succès");
            successAlert.showAndWait();
            tableInter();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la modification : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Ajout Remise
    @FXML
    void Ajout_Remise(ActionEvent event) {
        if (!txtNumDmdRem.getText().isEmpty() && !txtDateRem.getText().isEmpty()
                && !txtDescRem.getText().isEmpty() && !txtProRem.getText().isEmpty() && !txtRefRem.getText().isEmpty()) {
            try {
                connect con = new connect(); //Connexion à la bd
                pst = con.con.prepareStatement("insert into remise (Num_Dmd, Id_Res, Date_Rem, Desc_Rem, Pro_Rem, Ref_Rem) values (?,?,?,?,?)");
                pst.setString(1, txtNumDmdRem.getText());
                pst.setString(2, txtIdResRem.getText());
                pst.setString(3, txtDateRem.getText());
                pst.setString(4, txtDescRem.getText());
                pst.setString(5, txtProRem.getText());
                pst.setString(6, txtRefRem.getText());
                pst.executeUpdate();

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Succès");
                successAlert.setHeaderText(null);
                successAlert.setContentText("remise ajouté avec succès");
                successAlert.showAndWait();

                tableRemise();
                pst.close();
            } catch (Exception e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erreur");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Échec d'ajout : " + e.getMessage());
                errorAlert.showAndWait();
            }
        } else {
            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
            infoAlert.setTitle("Information");
            infoAlert.setHeaderText(null);
            infoAlert.setContentText("Veuillez compléter tous les champs");
            infoAlert.showAndWait();
        }
    }

    //Modification remise
    @FXML
    void Modif_Remise(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("UPDATE remise SET Num_Dmd = ?, Id_Res = ?, Date_Rem = ?, Desc_Rem = ?, Pro_Rem = ?, Ref_Rem = ? WHERE Id_Rem = '" + lblidRem.getText() + "'");
            pst.setString(1, txtNumDmdRem.getText());
            pst.setString(2, txtIdResRem.getText());
            pst.setString(3, txtDateRem.getText());
            pst.setString(4, txtDescRem.getText());
            pst.setString(5, txtProRem.getText());
            pst.setString(6, txtRefRem.getText());
            pst.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("remise modifié avec succès");
            successAlert.showAndWait();
            tableRemise();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la modification : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Suppresion du remise
    @FXML
    void Sup_Remise(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("DELETE FROM remise WHERE Id_Rem = ?");
            pst.setString(1, lblidCli.getText());
            pst.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Remise supprimé avec succès");
            successAlert.showAndWait();
            tableRemise();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la suppression : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Suppresion Mail Tous
    @FXML
    void Sup_Tous(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("DELETE FROM mail WHERE Id_Mail = ?");
            pst.setString(1, lblidMail.getText());
            pst.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Remise supprimé avec succès");
            successAlert.showAndWait();
            tableTous();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la suppression : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Suppresion Mail Tous
    @FXML
    void Sup_Envoye(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("DELETE FROM mail WHERE Id_Mail= ?");
            pst.setString(1, lblidMail.getText());
            pst.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Remise supprimé avec succès");
            successAlert.showAndWait();
            tableEnvoye();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la suppression : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Suppresion Mail Echoue
    @FXML
    void Sup_Echoue(ActionEvent event) {
        try {
            connect con = new connect();
            pst = con.con.prepareStatement("DELETE FROM mail WHERE Id_Mail= ?");
            pst.setString(1, lblidMail.getText());
            pst.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Remise supprimé avec succès");
            successAlert.showAndWait();
            tableEchoue();
            pst.close();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de la suppression : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Envoie Message
    @FXML
    void envoyerEmail(ActionEvent event) {
        String destinataire = txtdestinataire.getText();
        String message = txtMessage.getText();
        String objet = txtObjet.getText();

        if (!destinataire.isEmpty() && !message.isEmpty()) {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            // Remplacez les valeurs ci-dessous par votre propre adresse e-mail et mot de passe
            String monAdresseEmail = "rakotomalalasoloheryalain@gmail.com";
            String monMotDePasse = "leknbrslyhwplcal";

            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(monAdresseEmail, monMotDePasse);
                }
            });

            try {
                Message email = new MimeMessage(session);
                email.setFrom(new InternetAddress(monAdresseEmail));
                email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
                email.setSubject(objet);
                email.setText(message);
                Transport.send(email);

                // Effacer les champs de texte après l'envoi de l'e-mail
                txtdestinataire.clear();
                txtObjet.clear();
                txtMessage.clear();

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Succès");
                successAlert.setHeaderText(null);
                successAlert.setContentText("E-mail envoyé avec succès");
                successAlert.showAndWait();

                HistoriqueEnvoye();

            } catch (MessagingException e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erreur");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Échec de l'envoi de l'e-mail : " + e.getMessage());
                errorAlert.showAndWait();

                HistoriqueEchoue();
            }
        } else {
            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
            infoAlert.setTitle("Information");
            infoAlert.setHeaderText(null);
            infoAlert.setContentText("Veuillez remplir tous les champs");
            infoAlert.showAndWait();
        }
    }

    //Historique Envoyé
    public void HistoriqueEnvoye() {
        try {
            //Ajout historique
            connect con = new connect(); //Connexion à la bd
            pst = con.con.prepareStatement("insert into message (Num_Dmd, Dest_Mail, Objet_Mail, mess_Mail, Date_Mail, Statut_Mail) values (?,?,?,?,?,?)");
            pst.setString(1, lbldmdSMS.getText());
            pst.setString(2, txtdestinataire.getText());
            pst.setString(3, txtObjet.getText());
            pst.setString(4, txtMessage.getText());
            pst.setString(5, lblDateMail.getText());
            pst.setString(6, lblStatutMail.getText());
            pst.executeUpdate();
            pst.close();
            tableTous();
            tableEnvoye();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Historique Echoué
    public void HistoriqueEchoue() {
        try {
            //Ajout historique
            connect con = new connect(); //Connexion à la bd
            pst = con.con.prepareStatement("insert into message (Num_Dmd, Dest_Mail, Objet_Mail, mess_Mail, Date_Mail, Statut_Mail) values (?,?,?,?,?,?)");
            pst.setString(1, lbldmdSMS.getText());
            pst.setString(2, txtdestinataire.getText());
            pst.setString(3, txtObjet.getText());
            pst.setString(4, txtMessage.getText());
            pst.setString(5, lblDateMail.getText());
            pst.setString(6, lblStatutMail.getText());
            pst.executeUpdate();
            pst.close();
            //Modification
            String Echec = "Echoué";
            pst = con.con.prepareStatement("UPDATE message SET Statut_Mail = '" + Echec + "' WHERE Num_Dmd = '" + lbldmdSMS.getText() + "'");
            pst.setString(1, lbldmdSMS.getText());
            pst.setString(2, txtdestinataire.getText());
            pst.setString(3, txtObjet.getText());
            pst.setString(4, txtMessage.getText());
            pst.setString(5, lblDateMail.getText());
            pst.setString(6, lblStatutMail.getText());
            pst.executeUpdate();
            pst.close();
            tableTous();
            tableEchoue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Tableau Tous (Affichage des données ajouter dans le tableau)
    public void tableTous() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList(); // Liste observable pour les données

        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("select * from mail");

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(rs.getString("Dest_Mail"));
                row.add(rs.getString("Objet_Mail"));
                row.add(rs.getString("mess_Mail"));
                row.add(rs.getString("Date_Mail"));
                row.add(rs.getString("Statut_Mail"));

                data.add(row);
            }

            tblTous.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
        // Associer les colonnes aux données correspondantes
        columnMailTous.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        columnObjetTous.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        columnMessageTous.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        columnDateTous.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        columnStatutTous.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));
    }

    //Tableau Envoye (Affichage des données ajouter dans le tableau)
    public void tableEnvoye() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList(); // Liste observable pour les données

        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("select * from mail");

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(rs.getString("Dest_Mail"));
                row.add(rs.getString("Objet_Mail"));
                row.add(rs.getString("mess_Mail"));
                row.add(rs.getString("Date_Mail"));

                data.add(row);
            }

            tblEnvoye.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
        // Associer les colonnes aux données correspondantes
        columnMailEnvoye.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        columnObjetEnvoye.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        columnMessageEnvoye.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        columnDateEnvoye.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
    }

    //Tableau Envoye (Affichage des données ajouter dans le tableau)
    public void tableEchoue() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList(); // Liste observable pour les données

        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("select * from mail");

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(rs.getString("Dest_Mail"));
                row.add(rs.getString("Objet_Mail"));
                row.add(rs.getString("mess_Mail"));
                row.add(rs.getString("Date_Mail"));

                data.add(row);
            }

            tblEchec.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
        // Associer les colonnes aux données correspondantes
        columnMailEchec.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        columnObjetEchec.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        columnMessageEchec.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        columnDateEchec.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
    }

    // Transférer les données du tableau Tous vers les inputs afin de les modifier
    public void tblTransfertTous() {
        ObservableList<String> selectedItem = tblTous.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            try {
                connect con = new connect();
                st = con.con.createStatement();
                rs = st.executeQuery("SELECT * FROM mail WHERE Dest_Mail = '" + selectedItem.get(0) + "'");
                while (rs.next()) {
                    lblidMail.setText(rs.getString("Id_Mail"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Transférer les données du tableau Envoye vers les inputs afin de les modifier
    public void tblTransfertEnvoye() {
        ObservableList<String> selectedItem = tblEnvoye.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            try {
                connect con = new connect();
                st = con.con.createStatement();
                rs = st.executeQuery("SELECT * FROM mail WHERE Dest_Mail = '" + selectedItem.get(0) + "'");
                while (rs.next()) {
                    lblidMail.setText(rs.getString("Id_Mail"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Transférer les données du tableau Evhoue vers les inputs afin de les modifier
    public void tblTransfertEchoue() {
        ObservableList<String> selectedItem = tblEchec.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            try {
                connect con = new connect();
                st = con.con.createStatement();
                rs = st.executeQuery("SELECT * FROM mail WHERE Dest_Mail = '" + selectedItem.get(0) + "'");
                while (rs.next()) {
                    lblidMail.setText(rs.getString("Id_Mail"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private double x = 0;
    private double y = 0;

    //Outil de la base de donnée
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement st;

    //Form vers un form
    public void switchForm(ActionEvent event) {
        //Condidition des évenements
        if (event.getSource() == btn_dashboard) {
            dashboard_form.setVisible(true);
            graphPie();
            graphBar();
            admin_form.setVisible(false);
            client_form.setVisible(false);
            Tech_form.setVisible(false);
            demande_form.setVisible(false);
            Inter_form.setVisible(false);
            Remise_form.setVisible(false);
            historique_form.setVisible(false);

            //Couleur du bouton
            btn_dashboard.setStyle("-fx-background-color: linear-gradient(to bottom right, #48349a, #89892b);");
            btn_admin.setStyle("-fx-background-color: transparent;");
            btn_client.setStyle("-fx-background-color: transparent;");
            btn_Tech.setStyle("-fx-background-color: transparent;");
            btn_demande.setStyle("-fx-background-color: transparent;");
            btn_intervention.setStyle("-fx-background-color: transparent;");
            btn_remise.setStyle("-fx-background-color: transparent;");
            btn_mail.setStyle("-fx-background-color: transparent;");

        } else if (event.getSource() == btnShowPara) {
            try {
                connect con = new connect();
                st = con.con.createStatement();
                String TypePrinc = "Principale";
                rs = st.executeQuery("SELECT * from responsable where Type_Res = '" + TypePrinc + "'");
                if (rs.next() && txtmdpAdminPrinc.getText().equals(rs.getString("Mdp_Res"))) {
                    dashboard_form.setVisible(false);
                    admin_form.setVisible(true);
                    client_form.setVisible(false);
                    Tech_form.setVisible(false);
                    demande_form.setVisible(false);
                    Inter_form.setVisible(false);
                    Remise_form.setVisible(false);
                    historique_form.setVisible(false);
                    mdp_form.setVisible(false);
                    navbar_form.setMouseTransparent(false);
                    sidebar_form.setMouseTransparent(false);
                    dashboard_form.setMouseTransparent(false);
                    client_form.setMouseTransparent(false);

                    // Couleur du bouton
                    btn_dashboard.setStyle("-fx-background-color: transparent;");
                    btn_client.setStyle("-fx-background-color: transparent;");
                    btn_admin.setStyle("-fx-background-color: linear-gradient(to bottom right, #48349a, #89892b);");
                    btn_Tech.setStyle("-fx-background-color: transparent;");
                    btn_demande.setStyle("-fx-background-color: transparent;");
                    btn_intervention.setStyle("-fx-background-color: transparent;");
                    btn_remise.setStyle("-fx-background-color: transparent;");
                    btn_mail.setStyle("-fx-background-color: transparent;");
                } else {
                    // Mot de passe incorrect
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Mot de passe incorrect");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (event.getSource() == btn_client) {
            dashboard_form.setVisible(false);
            admin_form.setVisible(false);
            client_form.setVisible(true);
            Tech_form.setVisible(false);
            demande_form.setVisible(false);
            Inter_form.setVisible(false);
            Remise_form.setVisible(false);
            historique_form.setVisible(false);

            //Couleur du bouton
            btn_dashboard.setStyle("-fx-background-color: transparent;");
            btn_admin.setStyle("-fx-background-color: transparent;");
            btn_client.setStyle("-fx-background-color: linear-gradient(to bottom right, #48349a, #89892b);");
            btn_Tech.setStyle("-fx-background-color: transparent;");
            btn_demande.setStyle("-fx-background-color: transparent;");
            btn_intervention.setStyle("-fx-background-color: transparent;");
            btn_remise.setStyle("-fx-background-color: transparent;");
            btn_mail.setStyle("-fx-background-color: transparent;");

        } else if (event.getSource() == btn_Tech) {
            dashboard_form.setVisible(false);
            admin_form.setVisible(false);
            client_form.setVisible(false);
            Tech_form.setVisible(true);
            demande_form.setVisible(false);
            Inter_form.setVisible(false);
            Remise_form.setVisible(false);
            historique_form.setVisible(false);

            //Couleur du bouton
            btn_dashboard.setStyle("-fx-background-color: transparent;");
            btn_admin.setStyle("-fx-background-color: transparent;");
            btn_client.setStyle("-fx-background-color: transparent;");
            btn_Tech.setStyle("-fx-background-color: linear-gradient(to bottom right, #48349a, #89892b);");
            btn_demande.setStyle("-fx-background-color: transparent;");
            btn_intervention.setStyle("-fx-background-color: transparent;");
            btn_remise.setStyle("-fx-background-color: transparent;");
            btn_mail.setStyle("-fx-background-color: transparent;");

        } else if (event.getSource() == btn_demande) {
            dashboard_form.setVisible(false);
            admin_form.setVisible(false);
            client_form.setVisible(false);
            Tech_form.setVisible(false);
            demande_form.setVisible(true);
            Inter_form.setVisible(false);
            Remise_form.setVisible(false);
            historique_form.setVisible(false);

            //Couleur du bouton
            btn_dashboard.setStyle("-fx-background-color: transparent;");
            btn_admin.setStyle("-fx-background-color: transparent;");
            btn_client.setStyle("-fx-background-color: transparent;");
            btn_Tech.setStyle("-fx-background-color: transparent;");
            btn_demande.setStyle("-fx-background-color: linear-gradient(to bottom right, #48349a, #89892b);");
            btn_intervention.setStyle("-fx-background-color: transparent;");
            btn_remise.setStyle("-fx-background-color: transparent;");
            btn_mail.setStyle("-fx-background-color: transparent;");

        } else if (event.getSource() == btn_intervention) {
            dashboard_form.setVisible(false);
            admin_form.setVisible(false);
            client_form.setVisible(false);
            Tech_form.setVisible(false);
            demande_form.setVisible(false);
            Inter_form.setVisible(true);
            Remise_form.setVisible(false);
            historique_form.setVisible(false);

            //Couleur du bouton
            btn_dashboard.setStyle("-fx-background-color: transparent;");
            btn_admin.setStyle("-fx-background-color: transparent;");
            btn_client.setStyle("-fx-background-color: transparent;");
            btn_Tech.setStyle("-fx-background-color: transparent;");
            btn_demande.setStyle("-fx-background-color: transparent;");
            btn_intervention.setStyle("-fx-background-color: linear-gradient(to bottom right, #48349a, #89892b);");
            btn_remise.setStyle("-fx-background-color: transparent;");
            btn_mail.setStyle("-fx-background-color: transparent;");

        } else if (event.getSource() == btn_remise) {
            dashboard_form.setVisible(false);
            admin_form.setVisible(false);
            client_form.setVisible(false);
            Tech_form.setVisible(false);
            demande_form.setVisible(false);
            Inter_form.setVisible(false);
            Remise_form.setVisible(true);
            historique_form.setVisible(false);

            //Couleur du bouton
            btn_dashboard.setStyle("-fx-background-color: transparent;");
            btn_admin.setStyle("-fx-background-color: transparent;");
            btn_client.setStyle("-fx-background-color: transparent;");
            btn_Tech.setStyle("-fx-background-color: transparent;");
            btn_demande.setStyle("-fx-background-color: transparent;");
            btn_intervention.setStyle("-fx-background-color: transparent;");
            btn_remise.setStyle("-fx-background-color: linear-gradient(to bottom right, #48349a, #89892b);");
            btn_mail.setStyle("-fx-background-color: transparent;");

        } else if (event.getSource() == btn_mail) {
            dashboard_form.setVisible(false);
            admin_form.setVisible(false);
            client_form.setVisible(false);
            Tech_form.setVisible(false);
            demande_form.setVisible(false);
            Inter_form.setVisible(false);
            Remise_form.setVisible(false);
            historique_form.setVisible(true);
            tableTous();
            tableEnvoye();
            tableEchoue();

            //Couleur du bouton
            btn_dashboard.setStyle("-fx-background-color: transparent;");
            btn_admin.setStyle("-fx-background-color: transparent;");
            btn_client.setStyle("-fx-background-color: transparent;");
            btn_Tech.setStyle("-fx-background-color: transparent;");
            btn_demande.setStyle("-fx-background-color: transparent;");
            btn_intervention.setStyle("-fx-background-color: transparent;");
            btn_remise.setStyle("-fx-background-color: transparent;");
            btn_mail.setStyle("-fx-background-color: linear-gradient(to bottom right, #48349a, #89892b);");
        }

    }

    //Affichage du dialog AdminMdp
    public void formDialogMdpPrinc(ActionEvent event) {
        if (event.getSource() == btnNouveau) {
            mdp_form.setVisible(true);
            navbar_form.setMouseTransparent(true);
            sidebar_form.setMouseTransparent(true);
            dashboard_form.setMouseTransparent(true);
            client_form.setMouseTransparent(true);

        } else if (event.getSource() == btnCloseMdpPrinc) {
            mdp_form.setVisible(false);
            navbar_form.setMouseTransparent(false);
            sidebar_form.setMouseTransparent(false);
            dashboard_form.setMouseTransparent(false);
            client_form.setMouseTransparent(false);
        }

    }

    //Affichage du dialog Admin
    public void formDialog(ActionEvent event) {
        if (event.getSource() == showDialog) {
            dialog_form.setVisible(true);
            navbar_form.setMouseTransparent(true);
            sidebar_form.setMouseTransparent(true);
            dashboard_form.setMouseTransparent(true);
            admin_form.setMouseTransparent(true);
            client_form.setMouseTransparent(true);

            // Affichage des données
            Image img = ImageAdmin.getImage();
            ImgViewCardAdmin.setImage(img);ll
            lblNomRes.setText(txtNomRes.getText());
            lblPrenomRes.setText(txtPrenomRes.getText());
            lblAdrsRes.setText(txtAdrsRes.getText());
            lblEmailRes.setText(txtEmailRes.getText());
            lblTelRes.setText(txtTelRes.getText());

            Image img2 = qrCodeImageViewAdmin.getImage();
            ImgQrAdmin.setImage(img2);

        } else if (event.getSource() == btnCloseDialog) {
            dialog_form.setVisible(false);
            navbar_form.setMouseTransparent(false);
            sidebar_form.setMouseTransparent(false);
            dashboard_form.setMouseTransparent(false);
            admin_form.setMouseTransparent(false);
            client_form.setMouseTransparent(false);
        }

    }

    //Affichage du dialog Technicien
    public void formDialogTech(ActionEvent event) {
        if (event.getSource() == showDialogTech) {
            applyZoomEffect(dialog_formTech, 0.8, 1.0);
            dialog_formTech.setVisible(true);
            navbar_form.setMouseTransparent(true);
            sidebar_form.setMouseTransparent(true);
            dashboard_form.setMouseTransparent(true);
            admin_form.setMouseTransparent(true);
            client_form.setMouseTransparent(true);
            Tech_form.setMouseTransparent(true);

            // Affichage des données
            Image img = ImageTech.getImage();
            ImgViewCardTech.setImage(img);
            lblNomTech.setText(txtNomTech.getText());
            lblPrenomTech.setText(txtPrenomTech.getText());
            lblAdrsTech.setText(txtAdrsTech.getText());
            lblEmailTech.setText(txtEmailTech.getText());
            lblTelTech.setText(txtTelTech.getText());

            Image img2 = qrCodeImageViewTech.getImage();
            ImgQrTech.setImage(img2);

        } else if (event.getSource() == btnCloseDialogTech) {
            applyZoomEffect(dialog_formTech, 1.0, 0.8);
            dialog_formTech.setVisible(false);
            navbar_form.setMouseTransparent(false);
            sidebar_form.setMouseTransparent(false);
            dashboard_form.setMouseTransparent(false);
            admin_form.setMouseTransparent(false);
            client_form.setMouseTransparent(false);
            Tech_form.setMouseTransparent(false);
        }

    }

    private void applyZoomEffect(AnchorPane container, double fromScale, double toScale) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5), container);
        scaleTransition.setFromX(fromScale);
        scaleTransition.setFromY(fromScale);
        scaleTransition.setToX(toScale);
        scaleTransition.setToY(toScale);

        // Inverser les valeurs de fromScale et toScale pour la fermeture
        if (toScale < fromScale) {
            scaleTransition.setFromX(toScale);
            scaleTransition.setFromY(toScale);
            scaleTransition.setToX(fromScale);
            scaleTransition.setToY(fromScale);
        }

        scaleTransition.play();
    }

    //Affichage du dialog Demande
    public void formDialogDmd(ActionEvent event) {
        if (event.getSource() == btnShowDmd) {
            dmdSAV_form.setVisible(true);
            navbar_form.setMouseTransparent(true);
            sidebar_form.setMouseTransparent(true);
            dashboard_form.setMouseTransparent(true);
            demande_form.setMouseTransparent(true);
            // Affichage des données

        } else if (event.getSource() == btnCloseDmd) {
            dmdSAV_form.setVisible(false);
            navbar_form.setMouseTransparent(false);
            sidebar_form.setMouseTransparent(false);
            dashboard_form.setMouseTransparent(false);
            demande_form.setMouseTransparent(false);
        }

    }

    //Affichage du dialog Produit
    public void formDialogPro(ActionEvent event) {
        if (event.getSource() == btnShowPro) {
            proSAV_form.setVisible(true);
            navbar_form.setMouseTransparent(true);
            sidebar_form.setMouseTransparent(true);
            dashboard_form.setMouseTransparent(true);
            demande_form.setMouseTransparent(true);
            // Affichage des données

        } else if (event.getSource() == btnClosePro) {
            proSAV_form.setVisible(false);
            navbar_form.setMouseTransparent(false);
            sidebar_form.setMouseTransparent(false);
            dashboard_form.setMouseTransparent(false);
            demande_form.setMouseTransparent(false);
        }

    }

    //Affichage du dialog Message
    public void formDialogMail(ActionEvent event) {
        if (event.getSource() == btnShowMail) {
            mail_form.setVisible(true);
            navbar_form.setMouseTransparent(true);
            sidebar_form.setMouseTransparent(true);
            dashboard_form.setMouseTransparent(true);
            Inter_form.setMouseTransparent(true);
            // Affichage des données

        } else if (event.getSource() == btnCloseMail) {
            mail_form.setVisible(false);
            navbar_form.setMouseTransparent(false);
            sidebar_form.setMouseTransparent(false);
            dashboard_form.setMouseTransparent(false);
            Inter_form.setMouseTransparent(false);
        }

    }

    //Affichage du dialog Recu
    public void formDialogRecu(ActionEvent event) {
        if (event.getSource() == btnShowRecu) {
            recu_form.setVisible(true);
            transfertRecu();
            tableProduitA();
            tableProduitB();
            generateQrTechRecu();
            navbar_form.setMouseTransparent(true);
            sidebar_form.setMouseTransparent(true);
            dashboard_form.setMouseTransparent(true);
            Remise_form.setMouseTransparent(true);
            // Affichage des données

        } else if (event.getSource() == btnCloseRecu) {
            recu_form.setVisible(false);
            navbar_form.setMouseTransparent(false);
            sidebar_form.setMouseTransparent(false);
            dashboard_form.setMouseTransparent(false);
            Remise_form.setMouseTransparent(false);
        }

    }

    //Boutton déconnexion
    public void logout() {
        try {

            //Message de confirmation
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Message de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sur de vouloir déconnecter");
            Optional<ButtonType> option = alert.showAndWait();

            //Condition de déconnection
            if (option.get().equals(ButtonType.OK)) {
                //Fermeture du menu
                logout.getScene().getWindow().hide();
                //Lien du login
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                //Déplacement de la fenêtre (evenement du curseur)
                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Bouton réduire
    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    //Bouton fermer
    public void close() {
        System.exit(0);
    }

    //Tableau Administrateur (Affichage des données ajouter dans le tableau)
    public void tableAdmin() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList(); // Liste observable pour les données

        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("select * from responsable");

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(String.valueOf(rs.getInt("Id_Res")));
                row.add(rs.getString("Nom_Res"));
                row.add(rs.getString("Prenom_Res"));
                row.add(rs.getString("Adrs_Res"));
                row.add(rs.getString("Email_Res"));
                row.add(rs.getString("Tel_Res"));
                row.add(rs.getString("Type_Res"));

                data.add(row);
            }

            tblAdmin.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
        // Associer les colonnes aux données correspondantes
        columnIDRes.setCellValueFactory(cellData -> new SimpleIntegerProperty(Integer.parseInt(cellData.getValue().get(0))).asObject());
        columnNomRes.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        columnPrenomRes.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        columnAdrsRes.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        columnEmailRes.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));
        columnTelRes.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));
        columnTypeRes.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(6)));
    }

    // Transférer les données du tableau Admin vers les inputs afin de les modifier
    public void tblTransfertAdmin() {
        ObservableList<String> selectedItem = tblAdmin.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            lblidRes.setText(selectedItem.get(0));
            txtNomRes.setText(selectedItem.get(1));
            txtPrenomRes.setText(selectedItem.get(2));
            txtAdrsRes.setText(selectedItem.get(3));
            txtEmailRes.setText(selectedItem.get(4));
            txtTelRes.setText(selectedItem.get(5));
            txtTypeRes.setText(selectedItem.get(6));
            try {
                connect con = new connect();
                st = con.con.createStatement();
                rs = st.executeQuery("SELECT * FROM responsable WHERE Id_Res = '" + selectedItem.get(0) + "'");
                rs.next();
                String photoF = rs.getString("Photo_Res");
                if (photoF != null) {
                    Image image = new Image(new FileInputStream(photoF), 130, 120, false, true);
                    ImageAdmin.setImage(image);
                } else {
                    ImageAdmin.setImage(null);
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    //Tableau Client (Affichage des données ajouter dans le tableau)
    public void tableClient() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList(); // Liste observable pour les données

        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("select * from client");

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(String.valueOf(rs.getInt("Id_Cli")));
                row.add(rs.getString("Nom_Cli"));
                row.add(rs.getString("Prenom_Cli"));
                row.add(rs.getString("Email_Cli"));
                row.add(rs.getString("Tel_Cli"));
                row.add(rs.getString("Adrs_Cli"));
                row.add(rs.getString("NumFact_Cli"));

                data.add(row);
            }

            tblClient.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
        // Associer les colonnes aux données correspondantes
        columnIdCli.setCellValueFactory(cellData -> new SimpleIntegerProperty(Integer.parseInt(cellData.getValue().get(0))).asObject());
        columnNomCli.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        columnPrenomCli.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        columnEmailCli.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        columnTelCli.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));
        columnAdrsCli.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));
        columnFactCli.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(6)));
    }

    // Transférer les données du tableau Client vers les inputs afin de les modifier
    public void tblTransfertClient() {
        ObservableList<String> selectedItem = tblClient.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            lblidCli.setText(selectedItem.get(0));
            txtNomCli.setText(selectedItem.get(1));
            txtPrenomCli.setText(selectedItem.get(2));
            txtEmailCli.setText(selectedItem.get(3));
            txtTelCli.setText(selectedItem.get(4));
            txtAdrsCli.setText(selectedItem.get(5));
            txtFactCli.setText(selectedItem.get(6));
        }
    }

    //Tableau Technicien (Affichage des données ajouter dans le tableau)
    public void tableTech() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList(); // Liste observable pour les données

        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("select * from technicien");

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(String.valueOf(rs.getInt("Id_Tech")));
                row.add(rs.getString("Nom_Tech"));
                row.add(rs.getString("Prenom_Tech"));
                row.add(rs.getString("Adrs_Tech"));
                row.add(rs.getString("Email_Tech"));
                row.add(rs.getString("Tel_Tech"));

                data.add(row);
            }

            tblTech.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
        // Associer les colonnes aux données correspondantes
        columnIdTech.setCellValueFactory(cellData -> new SimpleIntegerProperty(Integer.parseInt(cellData.getValue().get(0))).asObject());
        columnNomTech.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        columnPrenomTech.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        columnAdrsTech.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        columnEmailTech.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));
        columnTelTech.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));
    }

    // Transférer les données du tableau Tech vers les inputs afin de les modifier
    public void tblTransfertTech() {
        ObservableList<String> selectedItem = tblTech.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            lblidTech.setText(selectedItem.get(0));
            txtNomTech.setText(selectedItem.get(1));
            txtPrenomTech.setText(selectedItem.get(2));
            txtAdrsTech.setText(selectedItem.get(3));
            txtEmailTech.setText(selectedItem.get(4));
            txtTelTech.setText(selectedItem.get(5));
            try {
                connect con = new connect();
                st = con.con.createStatement();
                rs = st.executeQuery("SELECT * FROM technicien WHERE Id_Tech = '" + selectedItem.get(0) + "'");
                rs.next();
                String photoF = rs.getString("Photo_Tech");
                if (photoF != null) {
                    Image image = new Image(new FileInputStream(photoF), 130, 120, false, true);
                    ImageTech.setImage(image);
                } else {
                    ImageTech.setImage(null);
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    //Tableau Demande (Affichage des données ajouter dans le tableau)
    public void tableDemande() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList(); // Liste observable pour les données

        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("select * from demande");

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(rs.getString("Num_Dmd"));
                row.add(String.valueOf(rs.getInt("Id_Cli")));
                row.add(rs.getString("Cause_Dmd"));
                row.add(rs.getString("Date_Dmd"));
                row.add(rs.getString("Delais_Dmd"));
                row.add(rs.getString("Statut_Dmd"));

                data.add(row);
            }

            tblDemande.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
        // Associer les colonnes aux données correspondantes
        columnNumDmd.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        columnIdCliDmd.setCellValueFactory(cellData -> new SimpleIntegerProperty(Integer.parseInt(cellData.getValue().get(1))).asObject());
        columnCauseDmd.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        columnDateDmd.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        columnDelaisDmd.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));
        columnStatutDmd.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));
    }

    //Tableau SAV (Affichage des données ajouter dans le tableau)
    public void tableSAV() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList(); // Liste observable pour les données

        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("select demande.Num_Dmd, demande.Id_Cli, Cause_Dmd, Date_Dmd, Delais_Dmd, produit.Ref_Pro, "
                    + "Nom_Pro, Desc_Pro, Gar_Pro, Prix_Pro, Statut_Dmd from demande, produit where demande.Num_Dmd = produit.Num_Dmd");

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(rs.getString("demande.Num_Dmd"));
                row.add(String.valueOf(rs.getInt("demande.Id_Cli")));
                row.add(rs.getString("Cause_Dmd"));
                row.add(rs.getString("Date_Dmd"));
                row.add(rs.getString("Delais_Dmd"));
                row.add(rs.getString("produit.Ref_Pro"));
                row.add(rs.getString("Nom_Pro"));
                row.add(rs.getString("Desc_Pro"));
                row.add(rs.getString("Gar_Pro"));
                row.add(rs.getString("Prix_Pro"));
                row.add(rs.getString("Statut_Dmd"));

                data.add(row);
            }

            tblSAV.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
        // Associer les colonnes aux données correspondantes
        columnNumDmdSAV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        columnIdCliSAV.setCellValueFactory(cellData -> new SimpleIntegerProperty(Integer.parseInt(cellData.getValue().get(1))).asObject());
        columnCauseSAV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        columnDateSAV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        columnDelaiSAV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));
        columnRefSAV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));
        columnNomProSAV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(6)));
        columnDescSAV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(7)));
        columnGarSAV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(8)));
        columnPrixSAV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(9)));
        columnStatutSAV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(10)));
    }

    // Transférer les données du tableau Demande vers les inputs afin de les modifier
    public void tblTransfertSAV() {
        ObservableList<String> selectedItem = tblSAV.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            txtNumDmd.setText(selectedItem.get(0));
            txtidCliDmd.setText(selectedItem.get(1));
            txtCauseDmd.setText(selectedItem.get(2));
            txtDateDmd.setText(selectedItem.get(3));
            txtDelaisDmd.setText(selectedItem.get(4));
            txtRefPro.setText(selectedItem.get(5));
            txtNumDmdPro.setText(selectedItem.get(1));
            txtNomPro.setText(selectedItem.get(6));
            txtDescPro.setText(selectedItem.get(7));
            txtGarPro.setText(selectedItem.get(8));
            txtPrixPro.setText(selectedItem.get(9));
            txtStatutDmd.setText(selectedItem.get(10));
            try {
                connect con = new connect();
                st = con.con.createStatement();
                rs = st.executeQuery("SELECT * FROM produit WHERE Ref_Pro = '" + selectedItem.get(5) + "'");
                rs.next();
                String photoF = rs.getString("Photo_Pro");
                if (photoF != null) {
                    Image image = new Image(new FileInputStream(photoF), 130, 120, false, true);
                    ImagePro.setImage(image);
                } else {
                    ImagePro.setImage(null);
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    // Transférer les données du tableau Demande vers les inputs afin de les modifier
    public void tblTransfertDemande() {
        ObservableList<String> selectedItem = tblDemande.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            txtNumDmd.setText(selectedItem.get(0));
            txtidCliDmd.setText(selectedItem.get(1));
            txtCauseDmd.setText(selectedItem.get(2));
            txtDateDmd.setText(selectedItem.get(3));
            txtDelaisDmd.setText(selectedItem.get(4));
            txtStatutDmd.setText(selectedItem.get(5));
        }
    }

    // Transférer les données SMS
    public void transfertSMS() {
        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("SELECT Email_Cli, demande.Num_Dmd FROM client, demande, produit, intervention WHERE intervention.Ref_Pro = produit.Ref_Pro AND produit.Num_Dmd = demande.Num_Dmd AND demande.Id_Cli = client.Id_Cli AND intervention.Ref_Pro = '" + txtRefProInter.getText() + "'");
            while (rs.next()) {
                lbldmdSMS.setText(rs.getString("demande.Num_Dmd"));
                txtdestinataire.setText(rs.getString("Email_Cli"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Transférer les données Remise vers recu
    public void transfertRecu() {
        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("SELECT remise.Id_Rem, Date_Rem, Nom_Cli, Prenom_Cli, demande.Num_Dmd, Cause_Dmd, produit.Ref_Pro, Nom_Pro, Desc_Pro, Ref_Rem, Pro_Rem, Desc_Rem, Nom_Tech, Prenom_Tech, Date_Inter, Nom_Res, Prenom_Res "
                    + "FROM remise, client, demande, produit, intervention, responsable, technicien "
                    + "WHERE responsable.Id_Res = remise.Id_Res AND remise.Num_Dmd = demande.Num_Dmd AND demande.Id_Cli = client.Id_Cli "
                    + "AND demande.Num_Dmd = produit.Num_Dmd AND produit.Ref_Pro = intervention.Ref_Pro AND intervention.Id_Tech = technicien.Id_Tech AND remise.Id_Rem = '" + lblidRem.getText() + "'");
            while (rs.next()) {
                lblidRemRecu.setText(rs.getString("remise.Id_Rem"));
                lblDateRemRecu.setText(rs.getString("Date_Rem"));
                lblNomCliRemRecu.setText(rs.getString("Nom_Cli") + " " + rs.getString("Prenom_Cli"));
                lblNumDmdRemRecu.setText(rs.getString("demande.Num_Dmd"));
                lblCauseRemRecu.setText(rs.getString("Cause_Dmd"));
                lblNomTechRemRecu.setText(rs.getString("Nom_Tech") + " " + rs.getString("Prenom_Tech"));
                lblDateInterRecu.setText(rs.getString("Date_Inter"));
                lblNomResRemRecu.setText(rs.getString("Nom_Res") + " " + rs.getString("Prenom_Res"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Ancien produit
    public void tableProduitA() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("SELECT remise.Id_Rem, Date_Rem, Nom_Cli, Prenom_Cli, demande.Num_Dmd, Cause_Dmd, produit.Ref_Pro, Nom_Pro, Desc_Pro, Ref_Rem, Pro_Rem, Desc_Rem, Nom_Tech, Prenom_Tech, Date_Inter, Nom_Res, Prenom_Res "
                    + "FROM remise, client, demande, produit, intervention, responsable, technicien "
                    + "WHERE responsable.Id_Res = remise.Id_Res AND remise.Num_Dmd = demande.Num_Dmd AND demande.Id_Cli = client.Id_Cli "
                    + "AND demande.Num_Dmd = produit.Num_Dmd AND produit.Ref_Pro = intervention.Ref_Pro AND intervention.Id_Tech = technicien.Id_Tech AND remise.Id_Rem = '" + lblidRem.getText() + "'");

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(rs.getString("produit.Ref_Pro"));
                row.add(rs.getString("Nom_Pro"));
                row.add(rs.getString("Desc_Pro"));

                data.add(row);
            }
            tblAncienPro.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
        // Associer les colonnes aux données correspondantes
        columnRefProA.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        columnNomProA.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        columnDescProA.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
    }

    //Ancien produit
    public void tableProduitB() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("SELECT remise.Id_Rem, Date_Rem, Nom_Cli, Prenom_Cli, demande.Num_Dmd, Cause_Dmd, produit.Ref_Pro, Nom_Pro, Desc_Pro, Ref_Rem, Pro_Rem, Desc_Rem, Nom_Tech, Prenom_Tech, Date_Inter, Nom_Res, Prenom_Res "
                    + "FROM remise, client, demande, produit, intervention, responsable, technicien "
                    + "WHERE responsable.Id_Res = remise.Id_Res AND remise.Num_Dmd = demande.Num_Dmd AND demande.Id_Cli = client.Id_Cli "
                    + "AND demande.Num_Dmd = produit.Num_Dmd AND produit.Ref_Pro = intervention.Ref_Pro AND intervention.Id_Tech = technicien.Id_Tech AND remise.Id_Rem = '" + lblidRem.getText() + "'");

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(rs.getString("Ref_Rem"));
                row.add(rs.getString("Pro_Rem"));
                row.add(rs.getString("Desc_Rem"));

                data.add(row);
            }
            tblNouveauPro.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
        // Associer les colonnes aux données correspondantes
        columnRefProB.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        columnNomProB.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        columnDescProB.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
    }

    //Tableau Produit (Affichage des données ajouter dans le tableau)
    public void tableProduit() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList(); // Liste observable pour les données

        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("select * from produit");

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(rs.getString("Ref_Pro"));
                row.add(rs.getString("Num_Dmd"));
                row.add(rs.getString("Nom_Pro"));
                row.add(rs.getString("Desc_Pro"));
                row.add(rs.getString("Gar_Pro"));
                row.add(rs.getString("Prix_Pro"));

                data.add(row);
            }

            tblProduit.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
        // Associer les colonnes aux données correspondantes
        columnRefPro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        columnNumDmdPro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        columnNomPro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        columnDescPro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        columnGarPro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));
        columnPrixPro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));
    }

    // Transférer les données du tableau Tech vers les inputs afin de les modifier
    public void tblTransfertPro() {
        ObservableList<String> selectedItem = tblProduit.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            txtRefPro.setText(selectedItem.get(0));
            txtNumDmdPro.setText(selectedItem.get(1));
            txtNomPro.setText(selectedItem.get(2));
            txtDescPro.setText(selectedItem.get(3));
            txtGarPro.setText(selectedItem.get(4));
            txtPrixPro.setText(selectedItem.get(5));
            try {
                connect con = new connect();
                st = con.con.createStatement();
                rs = st.executeQuery("SELECT * FROM produit WHERE Ref_Pro = '" + selectedItem.get(0) + "'");
                rs.next();
                String photoF = rs.getString("Photo_Pro");
                if (photoF != null) {
                    Image image = new Image(new FileInputStream(photoF), 130, 120, false, true);
                    ImagePro.setImage(image);
                } else {
                    ImagePro.setImage(null);
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    //Tableau Intervention (Affichage des données ajouter dans le tableau)
    public void tableInter() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList(); // Liste observable pour les données

        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("select * from intervention");

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(String.valueOf(rs.getInt("Id_Inter")));
                row.add(rs.getString("Ref_Pro"));
                row.add(String.valueOf(rs.getInt("Id_Tech")));
                row.add(rs.getString("Date_Inter"));
                row.add(rs.getString("DateFin_Inter"));
                row.add(rs.getString("Type_Inter"));
                row.add(rs.getString("Cout_Inter"));
                row.add(rs.getString("Statut_Inter"));
                data.add(row);
            }
            tblintervention.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
        // Associer les colonnes aux données correspondantes
        columnIdInter.setCellValueFactory(cellData -> new SimpleIntegerProperty(Integer.parseInt(cellData.getValue().get(0))).asObject());
        columnRefProInter.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        columnIdTechInter.setCellValueFactory(cellData -> new SimpleIntegerProperty(Integer.parseInt(cellData.getValue().get(2))).asObject());
        columnDateInter.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        columnDateFinInter.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));
        columnTypeInter.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));
        columnCoutInter.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(6)));
        columnStatutInter.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(7)));
    }

    // Transférer les données du tableau Intervention vers les inputs afin de les modifier
    public void tblTransfertInter() {
        ObservableList<String> selectedItem = tblintervention.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            lblidinter.setText(selectedItem.get(0));
            txtRefProInter.setText(selectedItem.get(1));
            txtIdTechInter.setText(selectedItem.get(2));
            txtDateInter.setText(selectedItem.get(3));
            txtDateFinInter.setText(selectedItem.get(4));
            txtTypeInter.setText(selectedItem.get(5));
            txtCoutInter.setText(selectedItem.get(6));
            txtStatutInter.setText(selectedItem.get(7));
        }
    }

    //Tableau remise (Affichage des données ajouter dans le tableau)
    public void tableRemise() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList(); // Liste observable pour les données

        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("select * from remise");

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(String.valueOf(rs.getInt("Id_Rem")));
                row.add(rs.getString("Num_Dmd"));
                row.add(rs.getString("Date_Rem"));
                row.add(rs.getString("Desc_Rem"));
                row.add(rs.getString("Pro_Rem"));
                row.add(rs.getString("Ref_Rem"));
                row.add(rs.getString("Id_Res"));

                data.add(row);
            }

            tblRemise.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
        // Associer les colonnes aux données correspondantes
        columnIdRem.setCellValueFactory(cellData -> new SimpleIntegerProperty(Integer.parseInt(cellData.getValue().get(0))).asObject());
        columnNumDmdRem.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        columnDateRem.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        columnDescRem.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        columnProRem.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));
        columnRefRem.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));
        columnIdResRem.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(6)));
    }

    // Transférer les données du tableau Client vers les inputs afin de les modifier
    public void tblTransfertRemise() {
        ObservableList<String> selectedItem = tblRemise.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            lblidRem.setText(selectedItem.get(0));
            txtNumDmdRem.setText(selectedItem.get(1));
            txtDateRem.setText(selectedItem.get(2));
            txtDescRem.setText(selectedItem.get(3));
            txtProRem.setText(selectedItem.get(4));
            txtRefRem.setText(selectedItem.get(5));
            txtIdResRem.setText(selectedItem.get(6));
        }
    }

    //Recherche Administrateur
    public void rechercheAdmin() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList(); // Liste observable pour les données
        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery(("select * from responsable where Nom_Res like '%" + txtRechAdmin.getText().trim() + "%' or Prenom_Res like '%" + txtRechAdmin.getText().trim() + "%' or "
                    + "Email_Res like '%" + txtRechAdmin.getText().trim() + "%' or Tel_Res like '%" + txtRechAdmin.getText().trim() + "%'"));
            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(String.valueOf(rs.getInt("Id_Res")));
                row.add(rs.getString("Nom_Res"));
                row.add(rs.getString("Prenom_Res"));
                row.add(rs.getString("Adrs_Res"));
                row.add(rs.getString("Email_Res"));
                row.add(rs.getString("Tel_Res"));
                row.add(rs.getString("Mdp_Res"));
                row.add(rs.getString("Code_Res"));

                data.add(row);
            }
            tblAdmin.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Recherche Administrateur
    public void rechercheClient() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList(); // Liste observable pour les données
        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery(("select * from client where Nom_Client like '%" + txtRechClient.getText().trim() + "%' or Prenom_Client like '%" + txtRechClient.getText().trim() + "%' or "
                    + "Email_Client like '%" + txtRechClient.getText().trim() + "%' or Tel_Client like '%" + txtRechClient.getText().trim() + "%'"));
            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(String.valueOf(rs.getInt("Id_Cli")));
                row.add(rs.getString("Nom_Cli"));
                row.add(rs.getString("Prenom_Cli"));
                row.add(rs.getString("Email_Cli"));
                row.add(rs.getString("Tel_Cli"));
                row.add(rs.getString("Adrs_Cli"));
                row.add(rs.getString("NumFact_Cli"));

                data.add(row);
            }
            tblAdmin.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    public void rechercheTech() {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList(); // Liste observable pour les données
        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery(("select * from technicien where Nom_Tech like '%" + txtRechTech.getText().trim() + "%' or Prenom_Tech like '%" + txtRechTech.getText().trim() + "%' or "
                    + "Email_Tech like '%" + txtRechTech.getText().trim() + "%' or Tel_Tech like '%" + txtRechTech.getText().trim() + "%'"));
            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(String.valueOf(rs.getInt("Id_Tech")));
                row.add(rs.getString("Nom_Tech"));
                row.add(rs.getString("Prenom_Tech"));
                row.add(rs.getString("Adrs_Tech"));
                row.add(rs.getString("Email_Tech"));
                row.add(rs.getString("Tel_Tech"));

                data.add(row);
            }
            tblTech.setItems(data);
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Échec de l'exportation : " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //Recherche SAV
    public void rechSAV(String rec) {
        if (!rec.isEmpty()) {
            try {

                connect con = new connect();
                st = con.con.createStatement();
                rs = st.executeQuery("select * from demande where Id_Cli like '" + rec + "'");
                while (rs.next()) {
                    txtNumDmd.setText(rs.getString("Num_Dmd"));
                    txtidCliDmd.setText(String.valueOf(rs.getInt("Id_Cli")));
                    txtCauseDmd.setText(rs.getString("Cause_Dmd"));
                    txtDateDmd.setText(rs.getString("Date_Dmd"));
                    txtDelaisDmd.setText(rs.getString("Delais_Dmd"));
                    txtStatutDmd.setText(rs.getString("Statut_Dmd"));
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Affichage échoué");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }

        }
    }

    // Appel du rech SAV
    public void rechercheSAV() {
        rechSAV(txtRechSAV.getText().trim());
    }

    //Générateur et affichage de Qr code Admin
    public void generateQrAdmin() {
        String idRes = lblidRes.getText();
        String nomRes = txtNomRes.getText();
        String prenomRes = txtPrenomRes.getText();
        // ... récupérer les autres données nécessaires

        String qrCodeContent = "Id: " + idRes + "\n"
                + "Nom: " + nomRes + "\n"
                + "Prénom: " + prenomRes;
        // ... ajouter les autres données au contenu du code QR

        Image qrCodeImage = generateQRCodeImage(qrCodeContent, 200, 200);
        qrCodeImageViewAdmin.setImage(qrCodeImage);
    }

    //Générateur et affichage de Qr code Technicien
    public void generateQrTech() {
        String idTech = lblidTech.getText();
        String nomTech = txtNomTech.getText();
        String prenomTech = txtPrenomRes.getText();
        // ... récupérer les autres données nécessaires

        String qrCodeContent = "Id: " + idTech + "\n"
                + "Nom: " + nomTech + "\n"
                + "Prénom: " + prenomTech;
        // ... ajouter les autres données au contenu du code QR

        Image qrCodeImage = generateQRCodeImage(qrCodeContent, 200, 200);
        qrCodeImageViewTech.setImage(qrCodeImage);
    }

    //Générateur et affichage de Qr code Technicien BD
    public void generateQrTechRecu() {
        try {
            connect con = new connect();
            st = con.con.createStatement();
            rs = st.executeQuery("SELECT remise.Id_Rem, Date_Rem, Nom_Cli, Prenom_Cli, demande.Num_Dmd, Cause_Dmd, produit.Ref_Pro, Nom_Pro, Desc_Pro, Ref_Rem, Pro_Rem, Desc_Rem, Nom_Tech, Prenom_Tech, Tel_Tech, Adrs_Tech, Email_Tech, Photo_Tech, Date_Inter, Nom_Res, Prenom_Res "
                    + "FROM remise, client, demande, produit, intervention, responsable, technicien "
                    + "WHERE responsable.Id_Res = remise.Id_Res AND remise.Num_Dmd = demande.Num_Dmd AND demande.Id_Cli = client.Id_Cli "
                    + "AND demande.Num_Dmd = produit.Num_Dmd AND produit.Ref_Pro = intervention.Ref_Pro AND intervention.Id_Tech = technicien.Id_Tech AND remise.Id_Rem = '" + lblidRem.getText() + "'");

            if (rs.next()) {
                String nomTech = rs.getString("Nom_Tech");
                String prenomTech = rs.getString("Prenom_Tech");
                String AdrsTech = rs.getString("Adrs_Tech");
                String EmailTech = rs.getString("Email_Tech");
                String TelTech = rs.getString("Tel_Tech");
                byte[] photoTech = rs.getBytes("Photo_Tech");

                // Convertir les données binaires de l'image en Base64
                String encodedPhoto = Base64.getEncoder().encodeToString(photoTech);

                String qrCodeContent = "Nom : " + nomTech + "\n"
                        + "Prénom : " + prenomTech + "\n"
                        + "Adresse : " + AdrsTech + "\n"
                        + "Email: " + EmailTech + "\n"
                        + "Telephone: " + TelTech + "\n"
                        + "Photo: " + encodedPhoto;

                Image qrCodeImage = generateQRCodeImage(qrCodeContent, 200, 200);
                qrCodeImageViewTechRecu.setImage(qrCodeImage);
            }

            rs.close();
            st.close();
            con.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Image generateQRCodeImage(String content, int width, int height) {
        try {
            // Configure les paramètres du code QR
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            // Génère le code QR
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

            // Convertit le code QR en image
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int rgb = bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF;
                    bufferedImage.setRGB(x, y, rgb);
                }
            }

            // Convertit l'image en format JavaFX
            return SwingFXUtils.toFXImage(bufferedImage, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Enregisrer le code
    public void saveQrAdmin() {
        // Enregistrer le QR code
        Image qrCodeImage = qrCodeImageViewAdmin.getImage();
        if (qrCodeImage != null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Enregistrer le QR code");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image PNG", "*.png"));
            File file = fileChooser.showSaveDialog(btnQrAdmin.getScene().getWindow());
            if (file != null) {
                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(qrCodeImage, null), "png", file);
                    showSuccessAlert("QR code enregistré avec succès !");
                    openFolder(file.getParentFile());
                } catch (IOException e) {
                    e.printStackTrace();
                    showErrorAlert("Erreur lors de l'enregistrement du QR code.");
                }
            }
        } else {
            showErrorAlert("Aucun QR code à enregistrer.");
        }
    }

    //Enregistrer qrCode Technicien
    public void saveQrTech() {
        // Enregistrer le QR code
        Image qrCodeImage = qrCodeImageViewTech.getImage();
        if (qrCodeImage != null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Enregistrer le QR code");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image PNG", "*.png"));
            File file = fileChooser.showSaveDialog(btnQrTech.getScene().getWindow());
            if (file != null) {
                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(qrCodeImage, null), "png", file);
                    showSuccessAlert("QR code enregistré avec succès !");
                    openFolder(file.getParentFile());
                } catch (IOException e) {
                    e.printStackTrace();
                    showErrorAlert("Erreur lors de l'enregistrement du QR code.");
                }
            }
        } else {
            showErrorAlert("Aucun QR code à enregistrer.");
        }
    }

    private void openFolder(File folder) {
        try {
            Desktop.getDesktop().open(folder);
        } catch (IOException e) {
            e.printStackTrace();
            showErrorAlert("Erreur lors de l'ouverture du répertoire.");
        }
    }

    private void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //Imprimer carte Admin
    public void printCardAdmin() {
        // Obtenir la référence au Node que vous souhaitez imprimer
        Node node = cardAdmin; // Remplacez "cardAdmin" par la référence appropriée à votre AnchorPane

        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            Window window = node.getScene().getWindow();
            boolean proceed = job.showPrintDialog(window);
            if (proceed) {
                PageLayout pageLayout = job.getPrinter().getDefaultPageLayout();

                Scale scale = new Scale(0.7, 0.7);
                node.getTransforms().add(scale);

                boolean printed = job.printPage(node);
                if (printed) {
                    job.endJob();
                } else {
                    job.cancelJob();
                }

                node.getTransforms().remove(scale);
            } else {
                // L'utilisateur a annulé la sélection de l'imprimante
                job.cancelJob();
            }
        }
    }

    public void printCardTech() {
        // Obtenir la référence au Node que vous souhaitez imprimer
        Node node = cardTech; // Remplacez "cardAdmin" par la référence appropriée à votre AnchorPane

        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            Window window = node.getScene().getWindow();
            boolean proceed = job.showPrintDialog(window);
            if (proceed) {
                PageLayout pageLayout = job.getPrinter().getDefaultPageLayout();

                Scale scale = new Scale(0.7, 0.7);
                node.getTransforms().add(scale);

                boolean printed = job.printPage(node);
                if (printed) {
                    job.endJob();
                } else {
                    job.cancelJob();
                }

                node.getTransforms().remove(scale);
            } else {
                // L'utilisateur a annulé la sélection de l'imprimante
                job.cancelJob();
            }
        }
    }

//    //Scanneur de Qr Code
//    public void scanQR() {
//        Webcam webcam = Webcam.getDefault();
//        if (webcam != null) {
//            webcam.open();
//
//            // Create a SwingNode container for the webcam panel
//            SwingNode swingNode = new SwingNode();
//            SwingUtilities.invokeLater(() -> {
//                WebcamPanel webcamPanel = new WebcamPanel(webcam);
//                webcamPanel.setFPSDisplayed(true);
//                webcamPanel.setDisplayDebugInfo(true);
//                webcamPanel.setImageSizeDisplayed(true);
//
//                swingNode.setContent(webcamPanel);
//            });
//
//            // Create a JavaFX popup window to display the webcam panel
//            Platform.runLater(() -> {
//                StackPane root = new StackPane(swingNode);
//                Stage stage = new Stage();
//                stage.initModality(Modality.APPLICATION_MODAL);
//                stage.initStyle(StageStyle.UNDECORATED);
//                stage.setScene(new javafx.scene.Scene(root));
//                stage.showAndWait();
//
//                // After the popup window is closed, capture the webcam image and read the QR Code
//                javafx.scene.image.Image imgScan = swingNode.snapshot(null, null);
//                webcam.close();
//
//                BufferedImage bufferedImage = SwingFXUtils.fromFXImage(imgScan, null);
//                Result result = readQRCode(bufferedImage);
//                if (result != null) {
//                    String qrCodeText = result.getText();
//                    showAlert("QR Code Scanned", qrCodeText, JOptionPane.INFORMATION_MESSAGE);
//                } else {
//                    showAlert("No QR Code found!", "", JOptionPane.ERROR_MESSAGE);
//                }
//            });
//        } else {
//            showAlert("Webcam not found!", "", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private Result readQRCode(BufferedImage image) {
//        try {
//            int width = image.getWidth();
//            int height = image.getHeight();
//            int[] pixels = image.getRGB(0, 0, width, height, null, 0, width);
//
//            RGBLuminanceSource source = new RGBLuminanceSource(width, height, pixels);
//            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
//            Reader reader = new MultiFormatReader();
//            try {
//                Result result = reader.decode(bitmap);
//                return result;
//            } catch (NotFoundException e) {
//                e.printStackTrace();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private void showAlert(String title, String message, int messageType) {
//        SwingUtilities.invokeLater(() -> {
//            JOptionPane.showMessageDialog(null, message, title, messageType);
//        });
//    }
    public void scanQR() {
        Platform.runLater(() -> {
            try {
                String softwarePath = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";
                String websiteURL = "https://webqr.com/"; // Remplacer par l'URL du site que vous souhaitez ouvrir

                File file = new File(softwarePath);
                if (file.exists()) {
                    Desktop.getDesktop().browse(new URI(websiteURL));
                } else {
                    System.out.println("Le fichier spécifié n'existe pas.");
                }
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }

    public void graphPie() {
        // Effacer les données existantes
        pieChart.getData().clear();
        // Données pour le graphique en secteurs
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Partie 1", 30),
                new PieChart.Data("Partie 2", 20),
                new PieChart.Data("Partie 3", 10),
                new PieChart.Data("Partie 4", 40)
        );

        // Création des étiquettes
        pieChartData.forEach(data -> {
            Label label = new Label();
            label.setTextFill(javafx.scene.paint.Color.WHITE);
            label.setText(String.format("%.1f%%", data.getPieValue()));
            pieChart.getData().add(data);
            pieChart.getData().forEach(d -> {
                d.getNode().setVisible(true);
            });
        });

    }

    public void graphBar() {
        // Effacer les données existantes
        barChart.getData().clear();

        // Données pour le graphique en barres
        ObservableList<XYChart.Data<String, Number>> barChartData = FXCollections.observableArrayList(
                new XYChart.Data<>("Partie 1", 30),
                new XYChart.Data<>("Partie 2", 20),
                new XYChart.Data<>("Partie 3", 10),
                new XYChart.Data<>("Partie 4", 40)
        );

        // Création des séries
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        barChartData.forEach(data -> {
            Label label = new Label();
            label.setTextFill(javafx.scene.paint.Color.WHITE);
            label.setText(String.valueOf(data.getYValue()));
            series.getData().add(data);
        });

        // Ajout des séries au graphique en barres
        barChart.getData().add(series);
    }

    private Map<Label, String> labelTranslations = new HashMap<>();

    @FXML
    void voidLang(ActionEvent event) {
        // Obtenez le texte actuel du label
        String currentText = lblTotDmd.getText();

        // Ajoutez les traductions au Map si le Map ne les contient pas déjà
        if (!labelTranslations.containsKey(new Label(currentText))) {
            labelTranslations.put(new Label(currentText), "Hello"); // Ajoutez la traduction pour le texte actuel du label "lblTotDmd" ici
        }

        // Effectuez la traduction si une traduction existe pour le texte actuel
        if (labelTranslations.containsKey(new Label(currentText))) {
            String translation = labelTranslations.get(new Label(currentText));
            lblTotDmd.setText(translation);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle rb) {
        tableAdmin();
        tableClient();
        tableTech();
        tableDemande();
        tableProduit();
        tableSAV();
        tableInter();
        tableRemise();
        transfertRecu();
        tableProduitA();
        tableProduitB();
        generateQrTechRecu();
        tableTous();
        tableEnvoye();
        tableEchoue();
        graphPie();
        graphBar();
    }

}
