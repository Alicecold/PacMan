/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import javax.swing.GroupLayout;
import pacman.game.*;

/**
 *
 * @author alicecold
 */
public class GUI extends javax.swing.JFrame{
    private javax.swing.JPanel grid;
    private Graphics offScreenGraph;
    private Image offScreenImg;
    private static int LEVEL_WIDTH = 20, LEVEL_HEIGHT = 20;
    public GUI(){
        init();
        this.setTitle("PacMan v0.0.1");
    };
    
    public void updateGrid(Player player, Enemy[] enemies, List<Life> lives, Wall[] walls){
        offScreenImg = createImage(grid.getWidth(),grid.getHeight());
        offScreenGraph = offScreenImg.getGraphics();
        drawGrid(player, enemies, lives, walls);
    };

    private void init(){
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        grid = new javax.swing.JPanel();
        grid.setBackground(Color.BLUE);
        
        javax.swing.GroupLayout gridLayout = new javax.swing.GroupLayout(grid);
        grid.setLayout(gridLayout);
        gridLayout.setHorizontalGroup(gridLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 426, Short.MAX_VALUE));
        
        gridLayout.setVerticalGroup(gridLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 426, Short.MAX_VALUE));
      
        
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                            .addComponent(grid, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                            .addContainerGap()));
        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addContainerGap()
                            .addComponent(grid, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                            .addContainerGap()));
        pack();
    }
    
    private void drawGrid(Player player, Enemy[] enemies, List<Life> lives, Wall[] walls){
        offScreenGraph.setColor(Color.BLUE);
        offScreenGraph.fillRect(0, 0, grid.getWidth(), grid.getHeight());
        
        for(int i = 0; i < LEVEL_WIDTH; i++){
            offScreenGraph.setColor(Color.BLACK);
            int X = i * grid.getWidth()/LEVEL_WIDTH;
            offScreenGraph.fillRect(X, 0,
                    grid.getWidth()/LEVEL_WIDTH,
                    grid.getHeight()/LEVEL_HEIGHT); 
        }
        
        for(Wall wall : walls){
            offScreenGraph.setColor(wall.COLOR);
            int eX = wall.getPositionX() * grid.getWidth() /LEVEL_WIDTH;
            int eY = wall.getPositionY() * grid.getHeight() /LEVEL_HEIGHT;
            offScreenGraph.fillRect(eX, eY,
                    grid.getWidth()/LEVEL_WIDTH,
                    grid.getHeight()/LEVEL_HEIGHT);
        }
        
        for(int i = 0; i < player.getLivesLeft(); i++){
            offScreenGraph.setColor(Color.RED);
            int X = ((i + (LEVEL_WIDTH - Player.MAX_LIVES)) * grid.getWidth()/LEVEL_WIDTH);
            offScreenGraph.fillRect(X, 0,
                    grid.getWidth()/LEVEL_WIDTH,
                    grid.getHeight()/LEVEL_HEIGHT); 
        }
        offScreenGraph.setColor(player.COLOR);
        int pX = player.getPositionX() * grid.getWidth()/LEVEL_WIDTH;
        int pY = player.getPositionY() * grid.getHeight()/LEVEL_HEIGHT;
        offScreenGraph.fillRect(pX, pY,
                grid.getWidth()/LEVEL_WIDTH,
                grid.getHeight()/LEVEL_HEIGHT);
        
        if(enemies[0] != null){
            for(int i = 0; i < enemies.length; i++){
                offScreenGraph.setColor(enemies[i].COLOR);
                int eX = enemies[i].getPositionX() * grid.getWidth() /LEVEL_WIDTH;
                int eY = enemies[i].getPositionY() * grid.getHeight() /LEVEL_HEIGHT;
                offScreenGraph.fillRect(eX, eY,
                        grid.getWidth()/LEVEL_WIDTH,
                        grid.getHeight()/LEVEL_HEIGHT);
            }
        }
        
        for(Life life : lives){
            offScreenGraph.setColor(life.COLOR);
            int eX = life.getPositionX() * grid.getWidth() /LEVEL_WIDTH;
            int eY = life.getPositionY() * grid.getHeight() /LEVEL_HEIGHT;
            offScreenGraph.fillRect(eX, eY,
                    grid.getWidth()/LEVEL_WIDTH,
                    grid.getHeight()/LEVEL_HEIGHT);
        }
        
        offScreenGraph.setColor(Color.BLACK);
        for (int i = 1; i <= LEVEL_HEIGHT; i++){
            int y = i * grid.getHeight() /LEVEL_HEIGHT;
            offScreenGraph.drawLine(0 , y ,grid.getWidth(), y);
        }
        for (int j = 1; j <= LEVEL_WIDTH; j++){
            int x = j * grid.getWidth() / LEVEL_WIDTH;
            offScreenGraph.drawLine(x, 0, x, grid.getHeight());
        }
        grid.getGraphics().drawImage(offScreenImg, 0, 0, grid);
    }
    
}
