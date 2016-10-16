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
public class Enemy {
    public final Color COLOR;
    private int x, y;
    
    public Enemy(int posX, int posY, Color color){
        COLOR = color;
        x = posX;
        y = posY;
    }
    
    public int getPositionX(){
        return x;
    }
    
    public int getPositionY(){
        return y;
    }
}
