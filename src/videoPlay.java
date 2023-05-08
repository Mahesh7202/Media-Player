
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

import javafx.application.*;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.geometry.*;


public class videoPlay extends Application{
    static FlowPane kk;
    static String  stlink;
    static Scene se;

    @Override
    public void start(Stage st){
        final FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Audio Files","*.WMA","*.MP3","*.MP2", "*.MPA","*.WAV","*.M4A",
        "*.CDA","*.FLAC","*.AAC", "*.ADT", "*.ADTS");
        FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter("Video Files", "*.mp4",
          "*.WEBM","*.MPG", "*.MP2", "*.MPEG", "*.MPE", "*.MPV",
          "*.OGG","*.M4P", "*.M4V",
          "*.AVI", "*.WMV",
         "*.MOV", "*.QT",
         "*.FLV", "*.SWF","*.AVCHD","*.MKV");
         fileChooser.getExtensionFilters().addAll(extFilter,extFilter1);
        kk = new FlowPane();

        Button music = new Button("MUSIC",new ImageView(new Image("Images/a.jpg",400,400,true,true)));
        music.setPrefSize(400,400);
        music.setContentDisplay(ContentDisplay.TOP);
        music.setId("music");
        
        Button video = new Button("VIDEO", new ImageView(new Image("Images/v.jpg",400,400,true,true)));
        video.setPrefSize(400,400);
        video.setContentDisplay(ContentDisplay.TOP);
        video.setId("video");
        
        kk.setAlignment(Pos.CENTER);
        kk.setHgap(20);
        kk.setId("kk");
        kk.getChildren().addAll(video,music);
        kk.getStylesheets().add("Styles/sumain.css");

        music.setOnAction(ae->{
            fileChooser.getExtensionFilters().remove(extFilter1);
             File file = fileChooser.showOpenDialog(st);
             if(file!=null){
                 stlink = file.toURI().toString(); 
                 new App(st,true);                
             }
             fileChooser.getExtensionFilters().add(extFilter1);
           });
           
           video.setOnAction(ae->{
             fileChooser.getExtensionFilters().remove(extFilter);
               File file = fileChooser.showOpenDialog(st);
               if(file!=null){
                   stlink = file.toURI().toString();
                   new App(st,true);    
               }
               fileChooser.getExtensionFilters().add(extFilter);
           });
           SecondMain sm = new SecondMain(st);
           se = new Scene(sm.getfrommain(),Screen.getPrimary().getVisualBounds().getWidth(),Screen.getPrimary().getVisualBounds().getHeight());

           
           Scene s =  new Scene(kk,Screen.getPrimary().getVisualBounds().getWidth()-50,Screen.getPrimary().getVisualBounds().getHeight()-50);
           st.setScene(s);
           st.show();
       }
public static void setst(String str){
    stlink = str;
}
public static String getstr(){
    return stlink;
}
       public static void main(String[] args){
        launch();
      }
}