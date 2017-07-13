package Sound;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Created by acer on 11/4/2560.
 */
public class Sound {
    private Clip clip;
    public Sound (String s){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource(s));
            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels()*2,
                    baseFormat.getSampleRate(),
                    false
                );
            AudioInputStream dais =
                    AudioSystem.getAudioInputStream(
                            decodeFormat,ais);
            clip = AudioSystem.getClip();
            clip.open(dais);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
    public void play(){
        if(clip==null)
            return;
        stop();
        clip.setFramePosition(0);
        clip.start();
    }
    public void loop(){
        if(clip==null)
            return;
        stop();
        clip.setFramePosition(0);
        clip.loop(100);
        clip.start();
    }
    public void stop(){
        if(clip.isRunning())
            clip.stop();
    }
    public void close(){
        stop();
        clip.close();
    }
}
