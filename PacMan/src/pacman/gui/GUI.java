/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
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
    
    public GUI(){
        init();
        this.setTitle("PacMan v0.0.1");
    };
    
    public void updateGrid(Player player, Enemy[] enemies, Life[] lives){
        offScreenImg = createImage(grid.getWidth(),grid.getHeight());
        offScreenGraph = offScreenImg.getGraphics();
        drawGrid(player, enemies, lives);
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
    
    private void drawGrid(Player player, Enemy[] enemies, Life[] lives){
        offScreenGraph.setColor(Color.BLUE);
        offScreenGraph.fillRect(0, 0, grid.getWidth(), grid.getHeight());
        for(int i = 0; i < 20; i++){
            offScreenGraph.setColor(Color.BLACK);
            int X = i * grid.getWidth()/20;
            offScreenGraph.fillRect(X, 0, grid.getWidth()/20, grid.getHeight()/20); 
        }
        for(int i = 0; i < player.getLivesLeft(); i++){
            offScreenGraph.setColor(Color.RED);
            int X = ((i + 15) * grid.getWidth()/20);
            offScreenGraph.fillRect(X, 0, grid.getWidth()/20, grid.getHeight()/20); 
        }
        offScreenGraph.setColor(player.COLOR);
        int pX = player.getPositionX() * grid.getWidth()/20;
        int pY = player.getPositionY() * grid.getHeight()/20;
        offScreenGraph.fillRect(pX, pY, grid.getWidth()/20, grid.getHeight()/20);
        
        if(enemies[0] != null){
            for(int i = 0; i < enemies.length; i++){
                offScreenGraph.setColor(enemies[i].COLOR);
                int eX = enemies[i].getPositionX() * grid.getWidth() /20;
                int eY = enemies[i].getPositionY() * grid.getHeight() /20;
                offScreenGraph.fillRect(eX, eY, grid.getWidth()/20, grid.getHeight()/20);
            }
        }
        
        if(lives[0] != null){
            for(int i = 0; i < lives.length; i++){
                offScreenGraph.setColor(lives[i].COLOR);
                int eX = lives[i].getPositionX() * grid.getWidth() /20;
                int eY = lives[i].getPositionY() * grid.getHeight() /20;
                offScreenGraph.fillRect(eX, eY, grid.getWidth()/20, grid.getHeight()/20);
            }
        }
        offScreenGraph.setColor(Color.BLACK);
        for (int i = 1; i <= 20; i++){
            int y = i * grid.getHeight() /20;
            offScreenGraph.drawLine(0 , y ,grid.getWidth(), y);
        }
        for (int j = 1; j <= 20; j++){
            int x = j * grid.getWidth() / 20;
            offScreenGraph.drawLine(x, 0, x, grid.getHeight());
        }
        grid.getGraphics().drawImage(offScreenImg, 0, 0, grid);
    }
    
}
