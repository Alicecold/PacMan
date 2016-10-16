/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.game;

/**
 *
 * @author alicecold
 */
public class Vec2 {
    public int x, y;
    
    public Vec2(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public boolean compare(Vec2 vec){
        if(this.x == vec.x){
            if(this.y == vec.y){
                return true;
            }
        }
        return false;
    }
}
