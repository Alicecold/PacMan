/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author alicecold
 */
public class Input implements KeyListener{
    char key;
    
    @Override
    public void keyReleased(KeyEvent e){
        key = ' ';
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        key = e.getKeyChar();
    }
    
    @Override
    public void keyTyped(KeyEvent e){
        //System.out.println(e.getKeyChar());
    }
    
    public char getKey(){
        return key;
    }
    
    public int[] getDirection(){
        int[] out = new int[2];
        if (key == 'w'){
            out[0] = -1;
        }else if(key == 's'){
            out[0] = 1;
        }else if(key == 'a'){
            out[1] = -1;
        }else if(key == 'd'){
            out[1] = 1;
        }
        return out;
    }
}
