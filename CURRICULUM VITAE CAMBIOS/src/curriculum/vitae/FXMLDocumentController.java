package curriculum.vitae;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;



public class FXMLDocumentController implements Initializable {
    String rootto;
    final FileChooser fc = new FileChooser();
    @FXML private TextField tfNombre;
    @FXML private TextField tfApellido;
    @FXML private TextField tfIdentidad;
    @FXML private TextField tfEdad;
    @FXML private TextField tfTelefono;
    @FXML private TextField tfEmail;
    @FXML private TextField tfInstitucion;
    @FXML private TextField tfInstitucion2;
    @FXML private TextField tfInstitucion3;
    @FXML private TextField tfEmpresa;
    @FXML private TextField tfEmpresa2;
    @FXML private TextField tfCargo;
    @FXML private TextField tfCargo2;
    @FXML private TextArea tfLogros;
    @FXML private TextArea tfLogros2;
    //FECHAS
    @FXML private DatePicker fechaIni1;
    @FXML private DatePicker FechaFin1;
    @FXML private DatePicker fechaIni2;
    @FXML private DatePicker FechaFin2;
    @FXML private DatePicker fechaIni3;
    @FXML private DatePicker FechaFin3;
    @FXML private DatePicker fechaIni4;
    @FXML private DatePicker FechaFin4;
    @FXML private DatePicker fechaIni5;
    @FXML private DatePicker FechaFin5;
    @FXML private CheckBox chLeer;
    @FXML private CheckBox chMusica;
    @FXML private CheckBox chViajar;
    @FXML private CheckBox chvideojuegos;
    @FXML private TextArea tfSobremi;
    @FXML private Button btnOpenImgFile;
    @FXML private ImageView ivFile;
    @FXML private Button btGuardar;
    @FXML private Button btLimpiar;
    @FXML private Button exitbtn;
    @FXML private GridPane panel;
    
    private ArrayList<String> errores;
    
    @FXML private void handleOpenImgFile(ActionEvent event) {
        //Imagen
        //Lector de Archivos
        //Damos titulo al Lector de archivos
        fc.setTitle("Foto de Perfil");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        //Aplicamos un filtro solo para imagenes
        fc.getExtensionFilters().clear();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png","*.jpg","*.gif"));
        File file=fc.showOpenDialog(null);
        if (file != null){
            ivFile.setImage(new Image(file.toURI().toString()));
            rootto = file.getPath();
        }
        else{
            rootto= "https://us.123rf.com/450wm/mialima/mialima1603/mialima160300025/55096766-hombre-icono-de-usuario-aislado-en-un-fondo-blanco-avatar-cuenta-para-la-web-foto-de-perfil-de-usuar.jpg";
        }
        
    }
    @FXML private void handleButtonAction (ActionEvent event){
        
        String sobreMi = tfSobremi.getText();
        String nombre = tfNombre.getText();
        String apellido = tfApellido.getText();
        String identidad = tfIdentidad.getText();
        String edad = tfEdad.getText();
        String telefono = tfTelefono.getText();
        String email = tfEmail.getText();
        //Instituciones
        String institucion = tfInstitucion.getText();
        String institucion2 = tfInstitucion2.getText();
        String institucion3 = tfInstitucion3.getText();
        //Empresas
        String empresa = tfEmpresa.getText();
        String empresa2 = tfEmpresa2.getText();
        String cargo = tfCargo.getText();
        String cargo2 = tfCargo2.getText();
        String logros = tfLogros.getText();
        String logros2 = tfLogros2.getText();
        //Obtenemos las fechas
        LocalDate fechaIN1= fechaIni1.getValue();
        LocalDate fechaFI1= FechaFin1.getValue();
        LocalDate fechaIN2= fechaIni2.getValue();
        LocalDate fechaFI2= FechaFin2.getValue();
        LocalDate fechaIN3= fechaIni3.getValue();
        LocalDate fechaFI3= FechaFin3.getValue();
        LocalDate fechaIN4= fechaIni4.getValue();
        LocalDate fechaFI4= FechaFin4.getValue();
        LocalDate fechaIN5= fechaIni5.getValue();
        LocalDate fechaFI5= FechaFin5.getValue();
        
        
        //Se le da un formato correcto a la fecha
        if (rootto==null){
            rootto= "https://us.123rf.com/450wm/mialima/mialima1603/mialima160300025/55096766-hombre-icono-de-usuario-aislado-en-un-fondo-blanco-avatar-cuenta-para-la-web-foto-de-perfil-de-usuar.jpg";
        }
       
        
        //Escritura
        
        FileWriter fichero =null;
        PrintWriter escr = null;
        
        try{
            fichero = new FileWriter(""+nombre+" "+apellido+" Curriculum.html");
            escr = new PrintWriter(fichero);
            
            escr.println("!DOCTTYPE html");
            escr.println("<html lang=\"en\">");
            escr.println("<head>");
            escr.println("<meta charset=\"UTF-8\">");
            escr.println("<title>"+nombre+"</title>");
            escr.println("<link rel=\"stylesheet\" href=\"styles.css\">");
            escr.println("<script src=\"https://kit.fontawesome.com/b99e675b6e.js\">"); //toma los iconos para el curriculum
            escr.println("</script>");
            escr.println("</head>");
            escr.println("<body>");
           
            escr.println("<div class=\"resume\">");
            escr.println("<div class=\"resume_left\">");
            escr.println("<div class=\"resume_profile\">");
            escr.println("<img src="+rootto+">"); ///imagen ruta colocar compañeros
            escr.println("</div>");
            escr.println("<div class=\"resume_content\">");
            escr.println("<div class=\"resume_item resume_info\">");
            escr.println("<div class=\"title\">");
            escr.println("<p class=\"bold\">"+nombre+"</p>");
            escr.println("<p class=\"bold\">"+apellido+"</p>");
            escr.println("</div>");
           escr.println("<ul>");
           escr.println("<li>");
             escr.println("<div class=\"icon\">");
               escr.println("<i class=\"fas fa-map-signs\"></i>");
             escr.println("</div>");
             escr.println("<div class=\"data\">");
              escr.println(" Tegucigalpa, <br /> HONDURAS");
             escr.println("</div>");
           escr.println("</li>");
           escr.println("<li>");
             escr.println("<div class=\"icon\">");
               escr.println("<i class=\"fas fa-solid fa-address-card\"></i>");
             escr.println("</div>");
             escr.println("<div class=\"data\">"+identidad);
             escr.println("</div>");
             escr.println("</li>");
             escr.println("<li>");
             escr.println("<div class=\"icon\">");
               escr.println("<i class=\"fa-solid fa-user-tie\"></i>");
             escr.println("</div>");
             escr.println("<div class=\"data\">"+edad+" años");
             escr.println("</div>");
             escr.println("</li>");
           escr.println("<li>");
             escr.println("<div class=\"icon\">");
               escr.println("<i class=\"fas fa-mobile-alt\"></i>");
             escr.println("</div>");
             escr.println("<div class=\"data\">"+telefono);
             escr.println("</div>");
             escr.println("</li>");
           escr.println("<li>");
             escr.println("<div class=\"icon\">");
               escr.println("<i class=\"fas fa-envelope\"></i>");
             escr.println("</div>");
             escr.println("<div class=\"data\">"+email);
             escr.println("</div>");
           escr.println("</li>");
         escr.println("</ul>");
       escr.println("</div>");
            escr.println("</div>");
            escr.println("</div>");
            escr.println("<div class=\"resume_right\">");
    escr.println("<div class=\"resume_item resume_about\">");
        escr.println("<div class=\"title\">");
           escr.println("<p class=\"bold\"> PERFIL </p>");
         escr.println("</div>");
        escr.println("<p>Sobre mi:"+sobreMi+" </p>");
    escr.println("</div>");
    escr.println("<div class=\"resume_item resume_work\">");
        escr.println("<div class=\"title\">");
           escr.println("<p class=\"bold\"> EXPERIENCIA LABORAL </p>");
         escr.println("</div>");
        escr.println("<ul>");
            escr.println("<li>");
                escr.println("<div class=\"date\">" +fechaIN4+"//"+fechaFI4+"</div>"); 
                escr.println("<div class=\"info\">");
                     escr.println("<p class=\"semi-bold\">" +empresa+ "</p>"); 
                     escr.println("<p>"+cargo+"</p>");
                  escr.println("<p>"+logros+"</p>");
                escr.println("</div>");
            escr.println("</li>");
            escr.println("<li>");
              escr.println("<div class=\"date\">" +fechaIN5+"//"+fechaFI5+"</div>");
              escr.println("<div class=\"info\">");
                     escr.println("<p class=\"semi-bold\">" +empresa2+"</p>"); 
                  escr.println("<p>"+cargo2+"</p>");
                  escr.println("<p>"+logros2+"</p>");
                escr.println("</div>");
                escr.println("</li>");
        escr.println("</ul>");
    escr.println("</div>");
    escr.println("<div class=\"resume_item resume_education\">");
      escr.println("<div class=\"title\">");
           escr.println("<p class=\"bold\">ESTUDIOS REALIZADOS</p>");
         escr.println("</div>");
      escr.println("<ul>");
             escr.println("<li>");
                escr.println("<div class=\"date\">"+fechaIN1+"//"+fechaFI1+" </div>"); 
                escr.println("<div class=\"info\">");
                     escr.println("<p class=\"semi-bold\">"+institucion+"</p>"); 
                  escr.println("<p>UNIVERSIDAD</p>");
               escr.println("</div>");
            escr.println("</li>");
            escr.println("<li>");
              escr.println("<div class=\"date\">"+fechaIN2+"//"+fechaFI2+" </div>");
              escr.println("<div class=\"info\">");
                    escr.println("<p class=\"semi-bold\">"+institucion2+"</p>"); 
                    escr.println("<p>SECUNDARIA</p>");
               escr.println("</div>");
            escr.println("</li>");
            escr.println("<li>");
              escr.println("<div class=\"date\">"+fechaIN3+"//"+fechaFI3+" </div>");
              escr.println("<div class=\"info\">");
              escr.println("<p class=\"semi-bold\">"+institucion3+"</p>");  
                  escr.println("<p>PRIMARIA</p>");
                escr.println("</div>");
            escr.println("</li>");
       escr.println("</ul>");
    escr.println("</div>");
    escr.println("<div class=\"resume_item resume_hobby\">");
      escr.println("<div class=\"title\">");
           escr.println("<p class=\"bold\"> PASATIEMPOS </p>");
         escr.println("</div>");
       escr.println("<ul>");
    
       if (chLeer.isSelected()){
           escr.println("<li><i class=\"fas fa-book\"></i></li>");
       }
       if (chvideojuegos.isSelected()){
           escr.println("<li><i class=\"fas fa-gamepad\"></i></li>");
       }
       if (chMusica.isSelected()){
           escr.println("<li><i class=\"fas fa-music\"></i></li>");
       }
       if (chViajar.isSelected()){
           escr.println("<li><i class=\"fab fa-pagelines\"></i></li>");
       } 
      escr.println("</ul>");
    escr.println("</div>");
  escr.println("</div>");
escr.println("</div>");
         escr.println("</body>");
escr.println("</html>");     
              
            
        }catch (Exception e){
        }finally{
            try{
                if(null != fichero){
                    fichero.close();
                }
            }catch (Exception e){
            }
        }
        
        //------AQUI VALIDAMOS ALGUNOS CAMPOS-----------
        validar();
        if ( errores.size() > 0 ){
            String cadenaErrores = "";
            
            for (int i=0; i<errores.size(); i++){
                cadenaErrores += errores.get(i) + "\n";
            }
            
            Alert mensaje = new Alert(AlertType.ERROR); //ESTO LO QUE HACE ES MOSTRAR UN CUADRO DE DIALOGO PORQUE HAY ERRORES
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Se encontraron los siguientes errores");
            mensaje.setContentText(cadenaErrores);
            mensaje.show();
            return;
        }
        
        //VENTA PARA DECIR QUE SE GUARDÓ CORRECTAMENTE
        Alert mensajeG = new Alert(AlertType.CONFIRMATION);
        String Guardado = "Se guardó correctamente";
        mensajeG.setContentText("Se guardaron correctamente los datos");
        mensajeG.show();
        
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       errores = new ArrayList<String>();
    }    

    @FXML
    private void clear(ActionEvent event) {
        tfEdad.clear();
        tfIdentidad.clear();
        tfNombre.clear();
        tfApellido.clear();
        tfTelefono.clear();
        tfEmail.clear();
        tfInstitucion.clear();
        tfInstitucion2.clear();
        tfInstitucion3.clear();
        tfEmpresa.clear();
        tfEmpresa2.clear();
        tfCargo.clear();
        tfCargo2.clear();
        tfLogros.clear();
        tfLogros2.clear();
        //FECHAS
        fechaIni1.setValue(null);
        FechaFin1.setValue(null);
        fechaIni2.setValue(null);
        FechaFin2.setValue(null);
        fechaIni3.setValue(null);
        FechaFin3.setValue(null);
        fechaIni4.setValue(null);
        FechaFin4.setValue(null);
        fechaIni5.setValue(null);
        FechaFin5.setValue(null);
        rootto=null;
        ivFile.setImage(null);
        tfSobremi.clear();
        chLeer.setSelected(false);
        chMusica.setSelected(false);
        chvideojuegos.setSelected(false);
        chViajar.setSelected(false);
    }
    
    
    
    private void validar(){
        //----ESTAS SON EXPRESIONES REGULARES PARA VALIDACIONES
        String patronName = "^([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+)(\\s+([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+))*$";
        String patronEmail = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$";
        //String patronTel = "/(^$|^[3789][0-9]*)$/";
        
        errores.clear(); //HACE QUE EL ARREGLO ESTE VACÍO EN CADA LLAMADO
        if ( tfNombre.getText().isEmpty() ){
            errores.add("El campo nombre es obligatorio");
        }else if ( !Pattern.matches(patronName, tfNombre.getText())){
            errores.add("No se permiten numeros ni caracteres especiales en el nombre");
        }
        if ( tfApellido.getText().isEmpty() ){
            errores.add("El campo Apellido es obligatorio");
        }else if(!Pattern.matches(patronName, tfApellido.getText())){
            errores.add("No se permiten numeros ni caracteres especiales en el apellido");
        }
        if(tfEdad.getText().isEmpty()){
            errores.add("El campo telefono es obligatorio");
        }
        
        if ( tfTelefono.getText().isEmpty() ){
            errores.add("El campo telefono es obligatorio");
        }
        if ( tfEmail.getText().isEmpty() ){
            errores.add("El campo email es obligatorio");
        } else if(!Pattern.matches(patronEmail, tfEmail.getText())){
            errores.add("Por favor ingrese un correo electronico valido");
            }
        
        if ( tfInstitucion.getText().isEmpty() ){
            errores.add("El campo institución universidad es obligatorio");
        }
        if ( tfInstitucion2.getText().isEmpty() ){
            errores.add("El campo institución secundaria es obligatorio");
        }
        if ( tfInstitucion3.getText().isEmpty() ){
            errores.add("El campo institución primaria es obligatorio");
        }
        if (tfSobremi.getText().isEmpty()){
            errores.add(("El campo sobre mi es obligatorio"));
        }
        if ( tfEmpresa.getText().isEmpty() ){
            errores.add("El campo empresa es obligatorio");
        }
        if ( tfEmpresa2.getText().isEmpty() ){
            errores.add("El campo empresa 2 es obligatorio");
        }
        if ( tfCargo.getText().isEmpty() ){
            errores.add("El campo Cargo es obligatorio");
        }
        if ( tfCargo2.getText().isEmpty() ){
            errores.add("El campo Cargo 2 es obligatorio");
        }
        if ( tfLogros.getText().isEmpty() ){
            errores.add("El campo logros es obligatorio");
        }

        /*
        if(!Pattern.matches(patronTel, tfTelefono.getText())){
            errores.add("Telefono invalido");
        }
        */    
    }

    @FXML
    private void exitnow(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }

    @FXML
    private void eventKey(KeyEvent event) {
        Object evt = event.getSource();
        if(evt.equals(tfEdad)){
            if ( !Character.isDigit(event.getCharacter().charAt(0)) ){
            event.consume();
        }
        }
    }
    

}
