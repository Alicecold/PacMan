/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.game;

import java.awt.Color;

/**
 *
 * @author alicecold
 */
public class Life {
    int x, y;
    public final Color COLOR = Color.RED;
    
    public Life(int posX, int posY){
        x = posX;
        y = posY;
    }
    
    public int getPosX(){
        return x;
    }
    
    public int getPosY(){
        return y;
    }
    
}
