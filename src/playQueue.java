
public class playQueue implements Runnable {
    sync q;
    playQueue(sync q){
      this.q = q;
      new Thread(this, "Producer").start();
    }
    public void run(){
        if(!App.queue.isEmpty()){  
            System.out.println(App.queue);
            for(String url: App.queue){
              for(String s:VideoPlaylist.videoformats){
                if(url.contains(s)){
                    System.out.println("tyjkjhkhjkhtryty");
                    q.setit(url,"v");
                }
              }
              for(String s:AudioPlaylist.audioformats){
                if(url.contains(s)){
                  q.setit(url,"a");
                }
              }
            }
          }
        }
        
}


