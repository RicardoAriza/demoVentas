
package hilo;

import com.sun.webkit.CursorManager;
import java.applet.AudioClip;

public class AudioConHilos extends Thread{
    String url;
    AudioClip sonido;
    public AudioConHilos(String url) {
        this.url=url;
    }
    
    @Override
    public void run(){
        try {
             urlAudio(url);
        } catch (Exception e) {
        }
    }

    public  void  urlAudio(String cursor){
        sonido = java.applet.Applet.newAudioClip(getClass().getResource(url));
        sonido.play();
    }    
}
