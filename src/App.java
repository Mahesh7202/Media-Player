
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.geometry.*;


public class App{

   static sync q;
   static Boolean flag = false,flagm = false,flagt = true,flagv = true,flagg = false,ff = true,uflag = true;
   //static Boolean sure = false;
   MediaView mv;

   static Label title;
   static Media m;
   static MediaPlayer player;
   static MediaView mediaView;

   static String videostring = "f:/Browser.mp4",sti;
   static Scene s;
   static Stage st2 = new Stage();
   static Stage st;
   static Queue<String> queue = new LinkedList<String>();

   static Slider prg;
   static StackPane bp,spp;
   static BorderPane bsp;
   static Button unl; 
   EventHandler<ActionEvent> playpa;
 
  public static void inist(){
        videostring = videoPlay.getstr();
        q = new sync();
        new playQueue(q);
        System.out.println("sdfjhdjfhjshdjfhshdhfhsdhf");
        String[] s = q.getit();
        System.out.println(s[0]);
        if(s[1].equals("v")){
            videostring = s[0];
        }
        if(s[1].equals("a")){
            videostring = s[0];
        }
        m = new Media(videostring);

        player = new MediaPlayer(m);
        mediaView = new MediaView(player);
        playit();
  }

  
  public static void inist(String str){
        videostring = str;

        System.out.println(videostring);
        m = new Media(videostring);
        player = new MediaPlayer(m);
        mediaView = new MediaView(player);
       
  }

  App(Stage str,Boolean flf){
     if(flf){
       inist(videoPlay.getstr());
     }
     else{
       inist();
     }
     st = str;
     FlowPane one = new FlowPane();
     FlowPane two = new FlowPane();
     FlowPane three = new FlowPane();

     HBox maa = new HBox();

     bp = new StackPane();
     prg = new Slider();
     Slider audio = new Slider();
   
     audio.setId("audio");
     prg.setId("prg");
     HBox hvol=new HBox();
     
     //music();

  
     //  setit("file:/C:/Users/ASUS/Videos/Browser.mp4");
     
      //String path="";
      //Media ap=new Media(new File(path).toURI().toString());
      //MediaPlayer p=new MediaPlayer(ap);
      //p.setCycleCount(MediaPlayer.INDEFINITE);
      //p.play();
      //}
      //for(String s:AudioPlaylist.audioformats){
      //     if(url.contains(s)){
      //         setit(url);}
      //}
      //Media m= new Media("file:/D:/Download/demon%20slayer%20episode%201.mp4");
       
      DoubleProperty width = mediaView.fitWidthProperty();
      DoubleProperty height = mediaView.fitHeightProperty();
  
      width.bind(Bindings.selectDouble(mediaView.sceneProperty(),"Width"));
      height.bind(Bindings.selectDouble(mediaView.sceneProperty(),"Height"));
    

      player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
        public void changed(ObservableValue<? extends Duration> observable, Duration oldValue,Duration newValue){
           prg.setValue(newValue.toSeconds());
        }
      });

      prg.setOnMousePressed(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event){
           player.seek(Duration.seconds(prg.getValue()));
         }
         
       });

      prg.setOnMouseDragged(new EventHandler<MouseEvent>() {
       public void handle(MouseEvent event){
          player.seek(Duration.seconds(prg.getValue()));
        }  
      });

      player.setOnReady(new Runnable() {
        public void run(){
          Duration total=m.getDuration();
          prg.setMax(total.toSeconds());
        }
      });

      player.setOnEndOfMedia(() -> {
        q.se();
      });

      //audio.setValue(player.getVolume()*100);
      //audio.valueProperty().addListener(new InvalidationListener() {
      //  public void invalidated(Observable observable){
       //   player.setVolume(audio.getValue()/100);
       // }
      //});

    
 
      SVGPath exiti = new SVGPath();
      exiti.setContent("M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z");
      exiti.setFill(Color.web("#ff6939"));
      exiti.setId("exit");
      
      Button b = new Button("",exiti);
      b.setPrefSize(60, 60);
      b.setTooltip(new Tooltip("Exit"));


      b.setOnAction(ae->{
        Platform.exit();
      });
      // b.hoverProperty().addListener((observable) -> {
      //  exiti.setFill(Color.web("#e31c25"));
      //  exiti.setScaleY(1.1);

      // });



      HBox top = new HBox();
      top.setAlignment(Pos.TOP_LEFT);
      title =new Label(".");
      title.setId("title");
      top.setId("top");
      top.getChildren().addAll(b);
        
    
     
      //the bottom stackpane

     bsp = new BorderPane(null,null,null,null,null);

      HBox h = new HBox();
      VBox v = new VBox();
    
      h.setPrefHeight(100);

      SVGPath pausei = new SVGPath();
      pausei.setContent("M5.5 3.5A1.5 1.5 0 0 1 7 5v6a1.5 1.5 0 0 1-3 0V5a1.5 1.5 0 0 1 1.5-1.5zm5 0A1.5 1.5 0 0 1 12 5v6a1.5 1.5 0 0 1-3 0V5a1.5 1.5 0 0 1 1.5-1.5z");
      pausei.setFill(Color.web("#ff6939"));

      SVGPath playi =  new SVGPath();
      playi.setContent("m11.596 8.697-6.363 3.692c-.54.313-1.233-.066-1.233-.697V4.308c0-.63.692-1.01 1.233-.696l6.363 3.692a.802.802 0 0 1 0 1.393z");
      playi.setFill(Color.web("#ff6939"));

      SVGPath forwardi = new SVGPath();
      forwardi.setContent("M4 4a.5.5 0 0 1 1 0v3.248l6.267-3.636c.54-.313 1.232.066 1.232.696v7.384c0 .63-.692 1.01-1.232.697L5 8.753V12a.5.5 0 0 1-1 0V4z");
      forwardi.setFill(Color.web("#ff6939"));

      SVGPath backwardi = new SVGPath();
      backwardi.setContent("M12.5 4a.5.5 0 0 0-1 0v3.248L5.233 3.612C4.693 3.3 4 3.678 4 4.308v7.384c0 .63.692 1.01 1.233.697L11.5 8.753V12a.5.5 0 0 0 1 0V4z");
      backwardi.setFill(Color.web("#ff6939"));

      SVGPath volumei =  new SVGPath();
      volumei.setContent("M9 4a.5.5 0 0 0-.812-.39L5.825 5.5H3.5A.5.5 0 0 0 3 6v4a.5.5 0 0 0 .5.5h2.325l2.363 1.89A.5.5 0 0 0 9 12V4zm3.025 4a4.486 4.486 0 0 1-1.318 3.182L10 10.475A3.489 3.489 0 0 0 11.025 8 3.49 3.49 0 0 0 10 5.525l.707-.707A4.486 4.486 0 0 1 12.025 8z");
      volumei.setFill(Color.web("#ff6939"));

      SVGPath playlisti = new SVGPath();
      playlisti.setContent("M2.5 3.5a.5.5 0 0 1 0-1h11a.5.5 0 0 1 0 1h-11zm2-2a.5.5 0 0 1 0-1h7a.5.5 0 0 1 0 1h-7zM0 13a1.5 1.5 0 0 0 1.5 1.5h13A1.5 1.5 0 0 0 16 13V6a1.5 1.5 0 0 0-1.5-1.5h-13A1.5 1.5 0 0 0 0 6v7zm6.258-6.437a.5.5 0 0 1 .507.013l4 2.5a.5.5 0 0 1 0 .848l-4 2.5A.5.5 0 0 1 6 12V7a.5.5 0 0 1 .258-.437z");
      playlisti.setFill(Color.web("#ff6939"));

      SVGPath windowi = new SVGPath();
      windowi.setContent("M.172 15.828a.5.5 0 0 0 .707 0l4.096-4.096V14.5a.5.5 0 1 0 1 0v-3.975a.5.5 0 0 0-.5-.5H1.5a.5.5 0 0 0 0 1h2.768L.172 15.121a.5.5 0 0 0 0 .707zM15.828.172a.5.5 0 0 0-.707 0l-4.096 4.096V1.5a.5.5 0 1 0-1 0v3.975a.5.5 0 0 0 .5.5H14.5a.5.5 0 0 0 0-1h-2.768L15.828.879a.5.5 0 0 0 0-.707z");
      windowi.setFill(Color.web("#ff6939"));

      SVGPath optioni = new SVGPath();
      optioni.setContent("M3 9.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3z");
      optioni.setFill(Color.web("#ff6939"));
      optioni.setId("option");
    

      SVGPath mute = new SVGPath();
      mute.setContent("M6.717 3.55A.5.5 0 0 1 7 4v8a.5.5 0 0 1-.812.39L3.825 10.5H1.5A.5.5 0 0 1 1 10V6a.5.5 0 0 1 .5-.5h2.325l2.363-1.89a.5.5 0 0 1 .529-.06zm7.137 2.096a.5.5 0 0 1 0 .708L12.207 8l1.647 1.646a.5.5 0 0 1-.708.708L11.5 8.707l-1.646 1.647a.5.5 0 0 1-.708-.708L10.793 8 9.146 6.354a.5.5 0 1 1 .708-.708L11.5 7.293l1.646-1.647a.5.5 0 0 1 .708 0z");
      mute.setFill(Color.web("#ff6939"));
      
      SVGPath lockk = new SVGPath();
      lockk.setContent("M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z");
      lockk.setFill(Color.web("#ff6939"));
      lockk.setId("lock");

      SVGPath ulock = new SVGPath();
      ulock.setContent("M11 1a2 2 0 0 0-2 2v4a2 2 0 0 1 2 2v5a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V9a2 2 0 0 1 2-2h5V3a3 3 0 0 1 6 0v4a.5.5 0 0 1-1 0V3a2 2 0 0 0-2-2z");
      ulock.setFill(Color.web("#e31c25"));
      ulock.setId("ulock");

HBox h1 = new HBox();
HBox h2 = new HBox();
HBox h3 = new HBox();

      Button play = new Button("",pausei);
      play.setPrefSize(60,60);

      Button forward = new Button("",forwardi);
      forward.setTooltip(new Tooltip("forward 30 sec"));
      forward.setPrefSize(60,60);

      Button backward = new Button("",backwardi);
      backward.setTooltip(new Tooltip("back 10 sec"));
      backward.setPrefSize(60,60);
     
      Menu speed = new Menu("Speed");

      MenuItem i = new MenuItem("0.5");
      MenuItem i1 = new MenuItem("0.25");
      MenuItem i2 = new MenuItem("1");
      MenuItem i3 = new MenuItem("1.25");
      MenuItem i4 = new MenuItem("1.5");
      MenuItem Exit = new MenuItem("Exit");

      MenuItem playpau = new MenuItem("Play/Pause");

      playpau.setOnAction(playpa);


      Exit.setOnAction(ae->{
       Platform.exit();
      });

      speed.getItems().addAll(i,i1,i2,i3,i4);

      Button playlist = new Button("",playlisti);
      playlist.setPrefSize(60,60);
      playlist.setTooltip(new Tooltip("Playlist"));
      
      Button volume = new Button("",volumei);
      volume.setPrefSize(60,60);
      volume.setTooltip(new Tooltip("Volume"));

      Button lock = new Button("",lockk);
      lock.setPrefSize(60,60);
      lock.setTooltip(new Tooltip("lock"));
   
      Button window = new Button("",windowi);
      window.setPrefSize(60,60);
      window.setTooltip(new Tooltip("Full Screen"));

      MenuButton option = new MenuButton();
      option.setId("menubutton");
      option.setTooltip(new Tooltip("option"));
      option.setGraphic(optioni);
      option.getItems().addAll(playpau,speed,Exit);
      
      option.setAlignment(Pos.BOTTOM_LEFT);
      
      hvol.getChildren().add(volume);
     
      h1.getChildren().addAll(playlist);
      h2.getChildren().addAll(forward,play,backward,hvol);
      one.setAlignment(Pos.BOTTOM_LEFT);
      
      h3.getChildren().addAll(lock,window,option);
      h3.setSpacing(15);
      h2.setSpacing(15);
     
      two.setAlignment(Pos.BOTTOM_CENTER);

      three.setAlignment(Pos.BOTTOM_RIGHT);


one.getChildren().add(h1);
two.getChildren().add(h2);
three.getChildren().add(h3);

maa.getChildren().addAll(one,new FlowPane(10,10),two,new FlowPane(20,20),three);

v.getChildren().addAll(title,prg,maa);
v.setId("bottom");



bp.getChildren().addAll(bsp);

bsp.setBottom(v);
bsp.setTop(top);
    
//bsp.setStyle("-fx-background-color:blue;");
v.setSpacing(20);
h1.getStylesheets().add("Styles/main.css");
h2.getStylesheets().add("Styles/main.css");
h3.getStylesheets().add("Styles/main.css");
v.getStylesheets().add("Styles/main.css");
top.getStylesheets().add("Styles/main.css");

//compress
//"M.172 15.828a.5.5 0 0 0 .707 0l4.096-4.096V14.5a.5.5 0 1 0 1 0v-3.975a.5.5 0 0 0-.5-.5H1.5a.5.5 0 0 0 0 1h2.768L.172 15.121a.5.5 0 0 0 0 .707zM15.828.172a.5.5 0 0 0-.707 0l-4.096 4.096V1.5a.5.5 0 1 0-1 0v3.975a.5.5 0 0 0 .5.5H14.5a.5.5 0 0 0 0-1h-2.768L15.828.879a.5.5 0 0 0 0-.707z"
//expand
//"M5.828 10.172a.5.5 0 0 0-.707 0l-4.096 4.096V11.5a.5.5 0 0 0-1 0v3.975a.5.5 0 0 0 .5.5H4.5a.5.5 0 0 0 0-1H1.732l4.096-4.096a.5.5 0 0 0 0-.707zm4.344-4.344a.5.5 0 0 0 .707 0l4.096-4.096V4.5a.5.5 0 1 0 1 0V.525a.5.5 0 0 0-.5-.5H11.5a.5.5 0 0 0 0 1h2.768l-4.096 4.096a.5.5 0 0 0 0 .707z"
//options
//"M3 9.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3z"




playpa = new EventHandler<ActionEvent>(){
  @Override
  public void handle(ActionEvent ae){
  mediaView.setMediaPlayer(player);
  player.play();
  if(flag){
    flag = false;
    play.setGraphic(pausei);
    player.play();
    player.setRate(1);
  }
  else{
    flag = true;
    play.setGraphic(playi);
    player.pause();
  }
}
};

play.setOnAction(playpa);


forward.setOnAction(ae->{
  player.seek(player.getCurrentTime().add(Duration.seconds(30)));
});

backward.setOnAction(ae->{
  player.seek(player.getCurrentTime().add(Duration.seconds(-30)));
});

window.setOnAction(ae-> {
  st.setFullScreen(true);
});

i.setOnAction(ae->{
  player.setRate(0.5);
});

i1.setOnAction(ae->{
  player.setRate(0.25);
});

i2.setOnAction(ae->{
  player.setRate(1.0);
});

i3.setOnAction(ae->{
  player.setRate(1.25);
});

i4.setOnAction(ae->{
  player.setRate(1.5);
});

playlist.setOnAction(ae->{
    st2.setScene(videoPlay.se);
    st2.show();
    st.hide();
});

spp = new StackPane();
unl = new Button();
unl.setPrefSize(60, 60);
unl.setGraphic(ulock);
spp.getChildren().add(unl);
spp.getStylesheets().add("Styles/main.css");
spp.setAlignment(Pos.CENTER_LEFT);


lock.setOnAction(ae->{
   bp.getChildren().remove(bsp);
   bp.getChildren().add(spp);
});


unl.setOnAction(ae->{
    bp.getChildren().remove(spp);
    bp.getChildren().add(bsp);
});


bsp.setOnMouseClicked(mouseevent->{
    if(mouseevent.getButton().equals(MouseButton.PRIMARY)){
        if(mouseevent.getX()>(Screen.getPrimary().getVisualBounds().getWidth()/2) && mouseevent.getY()<(Screen.getPrimary().getVisualBounds().getHeight()-200)){
          if(mouseevent.getClickCount() == 2){
             player.seek(player.getCurrentTime().add(Duration.seconds(30)));
          }
        }
        else if(mouseevent.getX()<(Screen.getPrimary().getVisualBounds().getWidth()/2) && mouseevent.getY()<(Screen.getPrimary().getVisualBounds().getHeight()-200)){
          if(mouseevent.getClickCount() == 2){
            player.seek(player.getCurrentTime().add(Duration.seconds(-30)));
        }
      }
    }
});

bp.setOnMouseClicked(mouseevent->{
  if(mouseevent.getButton().equals(MouseButton.PRIMARY)){
    if((mouseevent.getX()>(Screen.getPrimary().getVisualBounds().getWidth()/2) && mouseevent.getY()<(Screen.getPrimary().getVisualBounds().getHeight()-200))||(mouseevent.getX()<(Screen.getPrimary().getVisualBounds().getWidth()/2) && mouseevent.getY()<(Screen.getPrimary().getVisualBounds().getHeight()-200))){
      if(mouseevent.getClickCount() == 1){
        if(flagg){
            flagg = false;
            bp.getChildren().add(bsp);
        }
        else{
          flagg = true;
          bp.getChildren().remove(bsp);
        }
      }
    }
  }
});

volume.setOnMouseClicked(mouseevent->{
  if(mouseevent.getButton().equals(MouseButton.PRIMARY)){
      if(mouseevent.getClickCount() == 2){
        if(flagt){
          flagt = false;
          mute.setFill(Color.web("#e31c25"));
          volume.setGraphic(mute);
          player.setMute(true);
        }
        else{
          flagt = true;
          player.setMute(false);
          volume.setGraphic(volumei);
        }
      } 
    }
      
  if(mouseevent.getButton().equals(MouseButton.SECONDARY)){
      if(mouseevent.getClickCount() == 1){
        volume.setGraphic(volumei);
        
      if(flagm){
        flagm = false;
      hvol.getChildren().add(audio);
      prg.lookup(".track").setStyle("-fx-background-color:blue;");
      hvol.getStylesheets().add("Styles/sumain.css");
    
      }
      else{
        flagm = true;
        hvol.getChildren().remove(audio);

      }
      audio.setValue(player.getVolume()*100);
      audio.valueProperty().addListener(observable->{
          player.setVolume(audio.getValue()/100);
      });
    }
  }
});


playit();
  hvol.setAlignment(Pos.CENTER);
    s =  new Scene(bp,Screen.getPrimary().getVisualBounds().getWidth()-50,Screen.getPrimary().getVisualBounds().getHeight()-50);
    st.setScene(s);
    st.show();
}


public static String name(String url){
  String s =url;
  String[] sa = s.split("/");
  if(sa.length == 0){
     sa = s.split("\\");
    }
  int count=0;
  for (String s1 : sa){  
   count=count+1;
  }
  String last = sa[count-1];
  return last;
}   


public static void show(){
  st.show();
}


public static void playit(){
  if(ff){
    bp.getChildren().remove(bsp);
    ff = false;
  }else{
    bp.getChildren().remove(bsp);
    bp.getChildren().remove(mediaView);
  }
  bp.getChildren().add(mediaView);
  bp.getChildren().add(bsp);
  flagg = false;
  title.setText(name(videostring));
  player.play();
}

}