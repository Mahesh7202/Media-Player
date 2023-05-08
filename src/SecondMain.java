
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Side;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.*;
import javafx.scene.shape.SVGPath;

public class SecondMain{
    Boolean flagr= true;
    int  flag = 0,flagm = 0;
    String str;
    static BorderPane bp,bpl,bps,bpsl,m;
    static Button View;
    SVGPath Viewi,Viewi1,Viewi2;
   
    SecondMain(Stage st){

      new VideoPlaylist(st,true,0);
      bp=  VideoPlaylist.getPane();

      new AudioPlaylist(st,true,0);
       bps = AudioPlaylist.getPane();

     

        SVGPath music =  new SVGPath();
        music.setContent("M14.5.5a.5.5 0 0 0-1 0V2H1a1 1 0 0 0-1 1v2h16V3a1 1 0 0 0-1-1h-.5V.5ZM2.5 4a.5.5 0 1 1 0-1 .5.5 0 0 1 0 1Zm2 0a.5.5 0 1 1 0-1 .5.5 0 0 1 0 1Zm7.5-.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0Zm1.5.5a.5.5 0 1 1 0-1 .5.5 0 0 1 0 1Zm-7-1h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1Zm-2 9a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3Zm.5-1.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0Zm6.5 1.5a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3Zm0-1a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1Z M16 6H0v8a1 1 0 0 0 1 1h14a1 1 0 0 0 1-1V6ZM4.5 13a2.5 2.5 0 1 1 0-5 2.5 2.5 0 0 1 0 5Zm7 0a2.5 2.5 0 1 1 0-5 2.5 2.5 0 0 1 0 5Z");
        music.setScaleX(2);
        music.setScaleY(2);
        music.setId("music");

        SVGPath video =  new SVGPath();
        video.setContent("M0 1a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1V1zm4 0v6h8V1H4zm8 8H4v6h8V9zM1 1v2h2V1H1zm2 3H1v2h2V4zM1 7v2h2V7H1zm2 3H1v2h2v-2zm-2 3v2h2v-2H1zM15 1h-2v2h2V1zm-2 3v2h2V4h-2zm2 3h-2v2h2V7zm-2 3v2h2v-2h-2zm2 3h-2v2h2v-2z");
        video.setScaleX(2);
        video.setScaleY(2);
        video.setId("video");


        Viewi = new SVGPath();
        Viewi.setContent("M1 2a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H7a1 1 0 0 1-1-1V2zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1V2zM1 7a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V7zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H7a1 1 0 0 1-1-1V7zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1V7zM1 12a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1v-2zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H7a1 1 0 0 1-1-1v-2zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-2z");
        Viewi.setScaleX(2.5);
        Viewi.setScaleY(2.5);
        Viewi.setId("view");

        Viewi1 = new SVGPath();
        Viewi1.setContent("M11 0H3a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2 2 2 0 0 0 2-2V4a2 2 0 0 0-2-2 2 2 0 0 0-2-2zm2 3a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1V3zM2 2a1 1 0 0 1 1-1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V2z");
        Viewi1.setScaleX(2.5);
        Viewi1.setScaleY(2.5);
        Viewi1.setId("view1");

        Viewi2 = new SVGPath();
        Viewi2.setContent("M2 2.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5V3a.5.5 0 0 0-.5-.5H2zM3 3H2v1h1V3z M5 3.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zM5.5 7a.5.5 0 0 0 0 1h9a.5.5 0 0 0 0-1h-9zm0 4a.5.5 0 0 0 0 1h9a.5.5 0 0 0 0-1h-9z M1.5 7a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5V7zM2 7h1v1H2V7zm0 3.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5H2zm1 .5H2v1h1v-1z");
        Viewi2.setScaleX(2.5);
        Viewi2.setScaleY(2.5);
        Viewi2.setId("view2");

        SVGPath lines = new SVGPath();
        lines.setContent("M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z");
        lines.setScaleY(2.5);
        lines.setScaleX(2.5);
        lines.setId("threelines"); 

        
        SVGPath lines2 =  new SVGPath();
        lines2.setContent("M3.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L9.293 8 3.646 2.354a.5.5 0 0 1 0-.708z M7.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L13.293 8 7.646 2.354a.5.5 0 0 1 0-.708z");
        lines2.setScaleX(2);
        lines2.setScaleY(2);
        lines2.setId("lin");

        Button threelines = new Button("",lines);
        threelines.setPrefSize(60,60);
        
        View = new Button("");
        View.setPrefSize(60,60);
        View.setGraphic(Viewi);
        View.setLayoutX(Screen.getPrimary().getVisualBounds().getWidth()-45);
        View.setLayoutY(10);


        TabPane tp = new TabPane();
        tp.setPrefHeight(Screen.getPrimary().getVisualBounds().getHeight());
        tp.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
        tp.setTabMinWidth(70);
        tp.setTabMinHeight(90);
        tp.setSide(Side.LEFT);

        Tab vtab = new Tab();
        vtab.setTooltip(new Tooltip("Videos"));

        Tab mtab = new Tab();
        mtab.setTooltip(new Tooltip("Music"));

        vtab.setGraphic(video);

        mtab.setGraphic(music);

        
        tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        tp.getTabs().addAll(vtab,mtab);

        HBox change = new HBox();
    
        change.setSpacing(Screen.getPrimary().getVisualBounds().getWidth()-100);
        change.getChildren().addAll(threelines,View);
        change.setId("topbar");
        change.getStylesheets().add("Styles/tabstyle.css");
        
        
        BorderPane hp = new BorderPane();
        hp.setTop(change);
        hp.setCenter(tp);

        tp.getStylesheets().add("Styles/tabstyle.css");
      


        tp.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable,
                                Tab oldSelectedTab, Tab newSelectedTab) {
                if (newSelectedTab == vtab) {
                    hp.setTop(change);
                    hp.setCenter(tp);
                    flag =  0;

                }
                if (newSelectedTab == mtab) {
                    hp.setTop(change);
                    hp.setCenter(tp);
                    flagm = 0;
                    System.out.println(str);
                    
                   
                    
                }
            }
        });

View.setOnAction(ae->{
if(vtab.isSelected()){
  if(flag == 0){
    flag = 1;
    new VideoPlaylist(st,false,1);
    bp = VideoPlaylist.getPane();
    vtab.setContent(new StackPane(bp,change));
    View.setGraphic(Viewi1);
    hp.setTop(change);
    hp.setCenter(tp);
  }
  else if(flag == 1){
    flag = 2;
    new VideoPlaylist(st,false,0);
    bpl =  VideoPlaylist.getPane();
    vtab.setContent(new StackPane(bpl,change));
    hp.setTop(change);
    View.setGraphic(Viewi);
    hp.setCenter(tp);
  }else{
    flag = 0;
    new VideoPlaylist(st,false,2);
    bpl =  VideoPlaylist.getPane();
    vtab.setContent(new StackPane(bpl,change));
    hp.setTop(change);
    View.setGraphic(Viewi2);
    hp.setCenter(tp);


  }

}
else if(mtab.isSelected()){
  if(flagm == 0){
        flagm = 1;
        View.setGraphic(Viewi1);
        new AudioPlaylist(st,false,1);
        bps = AudioPlaylist.getPane();
        mtab.setContent(new StackPane(bps,change));
        hp.setTop(change);
        hp.setCenter(tp);
      }
      else if(flagm == 1){
        flagm = 2;
        View.setGraphic(Viewi);
        new AudioPlaylist(st,false,0);
         bpsl = AudioPlaylist.getPane();
        mtab.setContent(new StackPane(bpsl,change));
        hp.setTop(change);
        hp.setCenter(tp);
      }
      else{
        flagm = 0;
        View.setGraphic(Viewi2);
        new AudioPlaylist(st,false,2);
        bpl =  AudioPlaylist.getPane();
        mtab.setContent(new StackPane(bpl,change));
        hp.setTop(change);
        hp.setCenter(tp);
      }
      

      
    
    
    }

});

threelines.setOnAction(ae->{
  if(flagr){
    threelines.setGraphic(lines2);
     tp.setTabMinWidth(0);
     tp.setTabMinHeight(0);
     vtab.setGraphic(null);
     mtab.setGraphic(null);
     hp.setCenter(tp);
     flagr = false;
  }else{
    threelines.setGraphic(lines);
     tp.setTabMinWidth(70);
     tp.setTabMinHeight(90);
     vtab.setGraphic(video);
     mtab.setGraphic(music);
     hp.setCenter(tp);
     flagr = true;
  }
}); 


settomain(hp);

} 

static BorderPane getfrommain(){
  return m;
}

static void settomain(BorderPane p){
  m = p;
}

//
////fb9221

}
