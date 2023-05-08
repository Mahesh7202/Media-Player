import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.shape.SVGPath;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.geometry.*;
import javafx.scene.media.*;
import javafx.scene.paint.Color;

public class AudioPlaylist{

   static BorderPane bp,fp,m,lp;
   static LinkedList<Node> videoList = new LinkedList<Node>();
   static String ile,lin,value,tmps;
   static String[] valr  = new String[100];
   static Button toremove;
   static Button[] bb = new Button[100];
   static HBox fpd,listOfViddeos;
   static int i = 0,j = 0,k = 0,vali;
   static Set<String> val;
   static Button plus,mainScreen,leftb,rightb;
   static ScrollPane ss;
   static Boolean flag,init = true;
   static int next;
   static BufferedWriter bw,bw2;
   static HashMap<String,String> links = new HashMap<String,String>(); 
   static HashMap<String,String> tmp = new HashMap<String,String>();
   static EventHandler<ActionEvent> acev;
   static EventHandler<MouseEvent> me;
   static ContextMenu cm;
   static ObservableList<Button> as;
   static FlowPane p;
   static HBox hj;
   static String[] audioformats = new String[]{".WMA",".MP3",".MP2", ".MPA",".WAV",".M4A",
   ".CDA",".FLAC",".AAC", ".ADT", ".ADTS"};



AudioPlaylist(Stage st,Boolean finit,int n){
        init = finit;
        next = n;
        fp = new BorderPane();
        lp = new BorderPane();
        MenuItem play =  new MenuItem("Play");
        MenuItem remove = new MenuItem("Remove");
        MenuItem addtoq = new MenuItem("Add to Queue");
        MenuItem remfrq = new MenuItem("Remove from Queue");
        MenuItem plyq = new MenuItem("Play Queue");

        cm = new ContextMenu(play,remove,addtoq,remfrq,plyq);

        for(int i=0;i<100;i++){
            bb[i] = new Button();
            as= FXCollections.observableArrayList(bb[i]);
        }

      
        final FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Audio Files","*.WMA","*.MP3","*.MP2", "*.MPA","*.WAV","*.M4A",
        "*.CDA","*.FLAC","*.AAC", "*.ADT", "*.ADTS");

        fileChooser.getExtensionFilters().add(extFilter);


      FlowPane fp = new FlowPane();
      FlowPane labelflp = new FlowPane();
      mainScreen = new Button();
      mainScreen.setContextMenu(cm);
      bp = new BorderPane();
      VBox vb = new VBox();
      fpd = new HBox();
     

fpd.setPrefSize(1000,500);

fpd.getChildren().add(mainScreen);
fpd.setStyle("-fx-background-color:transparent;");



        SVGPath b = new SVGPath();
        b.setContent("M2.5 0c-.166 0-.33.016-.487.048l.194.98A1.51 1.51 0 0 1 2.5 1h.458V0H2.5zm2.292 0h-.917v1h.917V0zm1.833 0h-.917v1h.917V0zm1.833 0h-.916v1h.916V0zm1.834 0h-.917v1h.917V0zm1.833 0h-.917v1h.917V0zM13.5 0h-.458v1h.458c.1 0 .199.01.293.029l.194-.981A2.51 2.51 0 0 0 13.5 0zm2.079 1.11a2.511 2.511 0 0 0-.69-.689l-.556.831c.164.11.305.251.415.415l.83-.556zM1.11.421a2.511 2.511 0 0 0-.689.69l.831.556c.11-.164.251-.305.415-.415L1.11.422zM16 2.5c0-.166-.016-.33-.048-.487l-.98.194c.018.094.028.192.028.293v.458h1V2.5zM.048 2.013A2.51 2.51 0 0 0 0 2.5v.458h1V2.5c0-.1.01-.199.029-.293l-.981-.194zM0 3.875v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zM0 5.708v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zM0 7.542v.916h1v-.916H0zm15 .916h1v-.916h-1v.916zM0 9.375v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zm-16 .916v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zm-16 .917v.458c0 .166.016.33.048.487l.98-.194A1.51 1.51 0 0 1 1 13.5v-.458H0zm16 .458v-.458h-1v.458c0 .1-.01.199-.029.293l.981.194c.032-.158.048-.32.048-.487zM.421 14.89c.183.272.417.506.69.689l.556-.831a1.51 1.51 0 0 1-.415-.415l-.83.556zm14.469.689c.272-.183.506-.417.689-.69l-.831-.556c-.11.164-.251.305-.415.415l.556.83zm-12.877.373c.158.032.32.048.487.048h.458v-1H2.5c-.1 0-.199-.01-.293-.029l-.194.981zM13.5 16c.166 0 .33-.016.487-.048l-.194-.98A1.51 1.51 0 0 1 13.5 15h-.458v1h.458zm-9.625 0h.917v-1h-.917v1zm1.833 0h.917v-1h-.917v1zm1.834-1v1h.916v-1h-.916zm1.833 1h.917v-1h-.917v1zm1.833 0h.917v-1h-.917v1zM8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3v-3z");
        b.setId("plus");

        plus = new Button("",b);
        plus.setPrefSize(150,110);




        ss = new ScrollPane();
        ss.setVbarPolicy(ScrollBarPolicy.NEVER);
        ss.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        ss.setFitToHeight(true);
        

        fp.setPadding(new Insets(10));
        fp.setVgap(25);
        fp.setHgap(25);
       
        fp.setId("flow");
        fp.getStylesheets().add("Styles/Script.css");



fpd.setSpacing(80);

fpd.setId("flow");
fpd.getStylesheets().add("Styles/Script.css");

fpd.setAlignment(Pos.CENTER);
vb.setAlignment(Pos.CENTER);

// Label label = new Label("Select From System");
// label.setAlignment(Pos.CENTER);
// labelflp.getChildren().add(label);
// labelflp.setAlignment(Pos.CENTER);

vb.getChildren().addAll(fpd);


FlowPane right = new FlowPane();
right.setPrefSize(50,500);
SVGPath righti =  new SVGPath();

righti.setContent("M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z");
righti.setId("righti");

right.setAlignment(Pos.CENTER);


rightb = new Button("",righti);
rightb.setPrefSize(70, 70);
right.getChildren().add(rightb);


FlowPane left = new FlowPane();
left.setPrefSize(50,500);
SVGPath lefti =  new SVGPath();

lefti.setContent("M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z");
lefti.setId("lefti");
left.setAlignment(Pos.CENTER);



leftb = new Button("",lefti);
leftb.setPrefSize(70, 70);
left.getChildren().add(leftb);


reset(videoList);




plus.setOnAction(ae->{
    ile = "";
    File file = fileChooser.showOpenDialog(st);
    if(file!=null){
        ile = file.toURI().toString();
    }
    setbutton(i,ile,videoList);
    storelinks(bb[i],ile);
    i++;
});



acev = new EventHandler<ActionEvent>(){
    public void handle(ActionEvent ae){

     value = ae.getSource().toString();
     val = links.keySet();
     
    for(String s: val){
        valr[j++] = s;
        if(s.equals(value)){
            vali = j; 
            System.out.println(i);
        }
    }

     if(vali>=0 || vali< val.size()-1){
        leftb.setDisable(false);
        rightb.setDisable(false);
     }

    System.out.println(links.get(""+ae.getSource()));
    Media m = new Media(links.get(""+ae.getSource()));
    MediaPlayer player = new MediaPlayer(m);
    MediaView mediaView = new MediaView(player);

    mediaView.setFitHeight(750);
    mediaView.setFitWidth(700);
    
    mainScreen.setGraphic(mediaView);

}
};

 me = new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
        MouseButton button = event.getButton();
       if(button==MouseButton.SECONDARY){
        toremove = ((Button)event.getSource());
       if(App.queue.isEmpty()){
           plyq.setDisable(true);
       }
       else{
           plyq.setDisable(false);
       }
       if(App.queue.contains(toremove)){
        remfrq.setDisable(false);
        addtoq.setDisable(true);
       }
       else{
        remfrq.setDisable(true);
        addtoq.setDisable(false);
       }
    }
    }
};


leftb.setOnAction(ae->{
   
    System.out.println(val);
    if(vali<= 0){
        leftb.setDisable(true);
    }
    else{
        rightb.setDisable(false);
    Media m = new Media(links.get(valr[vali--]));
    MediaPlayer player = new MediaPlayer(m);
    MediaView mediaView = new MediaView(player);

    mediaView.setFitHeight(750);
    mediaView.setFitWidth(700);
    
    mainScreen.setGraphic(mediaView);
    }
});

rightb.setOnAction(ae->{

    if(vali>= val.size()-1){
        rightb.setDisable(true);
    }

    else{
        
    leftb.setDisable(false);
    Media m = new Media(links.get(valr[vali++]));
    MediaPlayer player = new MediaPlayer(m);
    MediaView mediaView = new MediaView(player);

    mediaView.setFitHeight(750);
    mediaView.setFitWidth(700);
    
    mainScreen.setGraphic(mediaView);
    }
});

remove.setOnAction(ae->{

    // int n = Integer.parseInt(toremove);

    try{
    FileReader fr=new FileReader("mlinkk.txt"); 
    BufferedReader br=new BufferedReader(fr); 

    FileWriter ffw2  = new FileWriter("temp.txt",true);
    bw2 = new BufferedWriter(ffw2);

    removing(br,bw2);
    delete("mlinkk");
    reupdate("temp","mlinkk");
    delete("temp");

    FileReader fr2=new FileReader("mmain.txt"); 
    BufferedReader br2=new BufferedReader(fr2); 

    FileWriter ffw  = new FileWriter("temp.txt",true);
    bw2 = new BufferedWriter(ffw);

    removing(br2,bw2);
    delete("mmain");
    reupdate("temp","mmain");
    delete("temp");
    }
    catch(Exception e){}

   
    links.remove(toremove);
    setList(links);
    videoList.remove(toremove);
    reset(videoList);
 
 });
 play.setOnAction(ae->{
      //  sync q = new sync();
    //  q.se();
    setList(links);
    //  App.queue.add();
    videoPlay.setst(links.get(""+toremove));
    new App(st,true);
     //playQueue.setit(links.get(""+toremove));
     App.st2.hide();
     App.show();
 });

 addtoq.setOnAction(ae->{
    App.queue.add(links.get(""+toremove));
 });

 remfrq.setOnAction(ae->{
    App.queue.remove(links.get(""+toremove));
 });

 plyq.setOnAction(ae->{
    App.inist();
    App.st2.hide();
    App.show();
 });
 

// HBox top= new HBox();

// Label title = new Label();

// SVGPath Viewi = new SVGPath();
// Viewi.setContent("M1 2a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H7a1 1 0 0 1-1-1V2zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1V2zM1 7a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V7zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H7a1 1 0 0 1-1-1V7zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1V7zM1 12a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1v-2zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H7a1 1 0 0 1-1-1v-2zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-2z");
// Viewi.setScaleX(2.5);
// Viewi.setScaleY(2.5);
// Button View = new Button("");
// View.setPrefSize(70,70);

// View.setGraphic(Viewi);


// top.setAlignment(Pos.CENTER);
// top.setPrefHeight(40);
// top.getChildren().addAll(title,Viewi);


if(init){
    videoList.add(0,plus);
    initialise();
    }
// bp.setTop(top);
bp.setBottom(listOfViddeos);
bp.setCenter(vb);
bp.setLeft(left);
bp.setRight(right);

bp.getStylesheets().add("Styles/Script.css");
bp.setId("first");
left.setId("left");
right.setId("right");



        // Scene s = new Scene(fp,500,500);
        // st.setScene(s);
        // st.show();


}
public static void setbutton(int i,String ile,LinkedList<Node> videolList){
              
  AudioClip m= new AudioClip(ile);
  SVGPath sss = new SVGPath();
  sss.setContent("M6 13c0 1.105-1.12 2-2.5 2S1 14.105 1 13c0-1.104 1.12-2 2.5-2s2.5.896 2.5 2zm9-2c0 1.105-1.12 2-2.5 2s-2.5-.895-2.5-2 1.12-2 2.5-2 2.5.895 2.5 2z M14 11V2h1v9h-1zM6 3v10H5V3h1z M5 2.905a1 1 0 0 1 .9-.995l8-.8a1 1 0 0 1 1.1.995V3L5 4V2.905z");
  sss.setScaleX(2);
  sss.setScaleY(2);
  sss.setFill(Color.web("#dad870"));

  bb[i].setGraphic(sss);
  bb[i].setPrefSize(185,110);
  bb[i].setAlignment(Pos.CENTER);
  bb[i].setTooltip(new Tooltip(""+ile));
  bb[i].setOnAction(acev);
  bb[i].setOnMouseClicked(me);
  bb[i].setContextMenu(cm);
  listOfViddeos.setMargin(bb[i],new Insets(16,2,16,2));
  videoList.add(0,bb[i]);
  reset(videoList);
  
}

public static void reset(LinkedList<Node> videoList) {

    if(next == 0){
        p = new FlowPane();
        p.setHgap(50);
        p.setVgap(50);
        p.setPadding(new Insets(15));
        p.getChildren().addAll(videoList);       
        fp.setCenter(p);
        settPane(fp);
    }
   
else if(next == 1){
         listOfViddeos = new HBox();
         listOfViddeos.setAlignment(Pos.BOTTOM_LEFT);
         listOfViddeos.getChildren().addAll(videoList);
         listOfViddeos.setStyle("-fx-background-color:transparent;");
   
         ss.setContent(listOfViddeos);
       
         ss.getStylesheets().add("Styles/Script.css");
         bp.setBottom(ss);
         listOfViddeos.setMargin(plus,new Insets(16,2,16,2));
         settPane(bp);
    }
    else{
        ListView<Node> list = new ListView<Node>();
        ObservableList<Node> oll = FXCollections.observableArrayList();
        int h = 0;
        setList(links);
        for(String ss: getList().values()){
            System.out.println(getList().values());
            hj = new HBox();    
            VBox jj = new VBox();
            VBox vb = new VBox();
            vb.setAlignment(Pos.BOTTOM_LEFT);
            vb.getChildren().addAll(new Label(App.name(ss)),new Label(ss));
            vb.getStylesheets().add("Styles/main.css");
            jj.getChildren().addAll(vb);
        if(h<videoList.size()-1){
                hj.getChildren().addAll(videoList.get(h++),jj);
            }
            oll.addAll(hj);
         }
         if(!oll.isEmpty()){
            list.setItems(oll);
         }
          lp.setCenter(list);
            
         settPane(lp);
    }

    
}
public void disable(int val){
   
}

public static void storelinks(Button key,String valu){
    try{
        FileWriter ffw  = new FileWriter("mmain.txt",true);
        bw = new BufferedWriter(ffw);

        FileWriter ffw2  = new FileWriter("mlinkk.txt",true);
        bw2 = new BufferedWriter(ffw2);

        bw.write(key+","+valu);
        bw.newLine();
        bw.close();

        bw2.write(key+","+valu);
        bw2.newLine();
        bw2.close();

        setList(links);
    }
    catch(Exception e){}
}

public static void setList(HashMap<String,String> links){
    try{
        FileReader fr=new FileReader("mmain.txt"); 
        BufferedReader br=new BufferedReader(fr); 
    if(!flag){
       while((lin = br.readLine())!=null){
                tmps = lin;
       }
       String[] ss = tmps.split(","); 
       
       links.put(ss[0],ss[1]);
       
    }
    else{
        while((lin = br.readLine())!=null){
            String[] ss = lin.split(","); 
            links.put(ss[0],ss[1]);
       }
    }
        System.out.println(links);
        br.close();
       
    }
        catch(Exception e){}
}

    public static void initialise(){
        flag = true;
        update(bb);
       delete("mlinkk");
        reupdate("mmain","mlinkk"); 
        setList(links);
        tmp = getList();   
        if(tmp.size()!=0){
           Collection<String> tt = tmp.values();
           for(String s: tt){
               setbutton(i++,s,videoList);
            }
            flag = false;
        }
    }


public static void update(Button[] bb){  
    try{

        File f = new File("mmain.txt");
        f.delete();
       

        FileReader fr=new FileReader("mlinkk.txt"); 
        BufferedReader br=new BufferedReader(fr);

        FileWriter ffw  = new FileWriter("mmain.txt",true);
        bw = new BufferedWriter(ffw); 

        while((lin = br.readLine())!=null){
            String[] ss = lin.split(",");
            System.out.println(ss[0]);
            ss[0]=""+bb[k++];
            System.out.println(ss[0]);
            bw.write(ss[0]+","+ss[1]);
            bw.newLine();
        }
        bw.close();
        br.close();
    }

        catch(Exception e){}
       
}


public static void reupdate(String s1,String s2){
    try{ 
  //  delete(s2);
    FileReader fr2=new FileReader(s1+".txt"); 
    BufferedReader br2=new BufferedReader(fr2);

    FileWriter ffw2  = new FileWriter(s2+".txt",true);
    bw2 = new BufferedWriter(ffw2);

    while((lin = br2.readLine())!=null){
        bw2.write(lin);
        bw2.newLine();
    }
    bw2.close();
    br2.close();
   
}catch(Exception e){}
  }




public static HashMap<String,String> getList(){
    return links;
}

public static void removing(BufferedReader br,BufferedWriter bw) throws IOException{

    while((lin = br.readLine())!=null){ 
        String[] ss = lin.split(",");
        if(!ss[0].equals(""+toremove)){
            System.out.println(lin);
            System.out.println(""+toremove);
            bw.write(lin);
            bw.newLine();
        }
    }
    br.close();
    bw.close();
    
}
static BorderPane getPane(){
    return m;
}
static void settPane(BorderPane p){
    m = p;
}

public static void delete(String t){
    File ff = new File(t+".txt");
    ff.delete();
}
   
}