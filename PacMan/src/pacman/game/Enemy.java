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
public class Enemy extends Player{
    public final Color COLOR;
    private int x, y;
    
    public Enemy(int posX, int posY, Color color){
        super(posX,posY);
        x = posX;
        y = posY;
        COLOR = color;
    }
    
    public int[] wantToMove(){
        int[] direction = new int[2];
        double one = Math.random(), two = Math.random();
        if( one > 0.75){
            direction[0] = 1;
        }else if (one < 0.25){
            direction[0] = -1;
        }
        
        if(two > 0.75){
            direction[1] = 1;
        }else if (two < 0.25){
            direction[1] = -1;
        }
        return direction;
    }
}
