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
public class Player {
    protected int x, y;
    public final Color COLOR = Color.YELLOW;
    private int livesLeft;
    public static final int MAX_LIVES = 5;
    
    public Player(int posX, int posY){
        x = posX;
        y = posY;
        reset();
    }
    
    public void setPosition(int posX, int posY){
        x = posX;
        y = posY;
    }
    
    public int getPositionX(){
        return x;
    }
    
    public int getPositionY(){
        return y;
    }
    
    public int getLivesLeft(){
        return livesLeft;
    }
    
    public void lostLife(){
        livesLeft--;
    }
    
    public void addLife(){
        if(livesLeft < MAX_LIVES)
        livesLeft++;
    }
    
    public void reset(){
        livesLeft = 3;
    }
}
