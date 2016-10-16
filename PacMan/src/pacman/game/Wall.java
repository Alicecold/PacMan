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
public class Wall {
    private int x, y;
    public final Color COLOR = Color.BLACK;
    
    public Wall(int posX, int posY){
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
