public class sync{
    String link;
    Boolean f = false;
    String fl,li;

    synchronized void setit(String str,String flag){
        System.out.println("djjfdhjhgjhdhghd");
        while(f)
            try {
               wait();
            } catch(InterruptedException e) {}
        li = str;
        System.out.println("tytryty");
        fl = flag;
        f = true;
        notify();
    }

    synchronized String[] getit(){
        while(!f)
        try {
           wait();
        } catch(InterruptedException e) {}
        System.out.println("dssjfhjdhfj"+li);
        String[] ss = new String[]{li,fl};
        System.out.println(ss[1]);
        return ss;
      }

    synchronized void se(){
        f = false;
        notify();
    }
}
   