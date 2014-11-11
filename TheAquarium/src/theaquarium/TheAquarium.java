package theaquarium;

import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JFrame;

public class TheAquarium {
    public static JFrame frame1 ,frame2;
    public static AudioClip a;
    
    public static void main(String[] args) {
        try{
            a=JApplet.newAudioClip(new URL("file:sounds/backMusic.wav"));
        }catch(MalformedURLException ex){
            Logger.getLogger(TheAquarium.class.getName()).log(Level.SEVERE, null,ex);
        }
        Thread snd=new Thread(new ThredSound());
        snd.start();
        frame1=new frontPage();
    }
}
