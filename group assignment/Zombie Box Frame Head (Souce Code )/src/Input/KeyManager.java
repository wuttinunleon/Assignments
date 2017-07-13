package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener {

    boolean [] key;
    public boolean up,left,right,down;
    public boolean up2,left2,right2,down2;
    public boolean atk,atk2,spawn,enter,r;
    public boolean weapon_p1_back , weapon_p1_next ;
    public boolean weapon_p2_back , weapon_p2_next ;
    public static boolean release;
    public KeyManager(){
        key = new boolean[600];
    }

    public void tick(){

        up = key[KeyEvent.VK_W];
        left = key[KeyEvent.VK_A];
        right = key[KeyEvent.VK_D];


        down = key[KeyEvent.VK_S];
        up2 = key[KeyEvent.VK_UP];
        left2 = key[KeyEvent.VK_LEFT];
        right2 = key[KeyEvent.VK_RIGHT];
        down2 = key[KeyEvent.VK_DOWN];
        atk = key[KeyEvent.VK_SPACE];
        atk2 = key[KeyEvent.VK_SLASH];
        spawn = key[KeyEvent.VK_Z];
        weapon_p1_back = key[KeyEvent.VK_Q];
        weapon_p1_next = key[KeyEvent.VK_E];
        weapon_p2_back = key[KeyEvent.VK_COMMA];
        weapon_p2_next = key[KeyEvent.VK_PERIOD];
        enter = key[KeyEvent.VK_ENTER];
        r = key[KeyEvent.VK_R];



    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        key[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key[e.getKeyCode()]=false;
    }


}
