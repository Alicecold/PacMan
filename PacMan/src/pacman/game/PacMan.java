/*
 * Something that I begun to write for fun on a trip from Malmö to Stockholm 16/10-2016
 * I hope you'll enjoy it!
 */
package pacman.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import pacman.gui.*;
/**
 *
 * @author alicecold
 */
public class PacMan{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        GUI ui = new GUI();
        ui.setVisible(true);
        Input in = new Input();
        ui.addKeyListener(in);
        loop(ui, in);
    }
    
    public static void loop(GUI ui, Input in){
        Player player = new Player(5,5);
        Enemy[] enemies = {new Enemy(2,6, Color.PINK), new Enemy(6,2, Color.ORANGE)};
        List<Life> lives = new ArrayList();
        lives.add(new Life(15,15));
        Timer timer = new javax.swing.Timer(120, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (player.getLivesLeft() == 0){
                    int cont = JOptionPane.showConfirmDialog(null, "You are dead! Continue?","Oh noes!", JOptionPane.YES_NO_OPTION);
                    if (cont == 0){
                        player.reset();
                        player.setPosition(6, 6);
                    }else{
                        System.exit(0);
                    }
                }else{
                    ui.updateGrid(player, enemies, lives);

                    player.setPosition(
                            player.getPositionX() + in.getDirection()[1],
                            player.getPositionY() + in.getDirection()[0]);

                    for (Enemy enemy : enemies) {
                        if (player.getPositionX() == enemy.getPositionX()
                                && player.getPositionY() == enemy.getPositionY()) {
                            player.lostLife();
                            player.setPosition(5, 5);
                        }
                    }
                    
                    for (int i = 0; i < lives.size(); i++){
                        if (player.getPositionX() == lives.get(i).getPositionX()
                                && player.getPositionY() == lives.get(i).getPositionY()) {
                            player.addLife();
                            lives.remove(i);
                        }
                    }
                }
            }
        });
        timer.start();
    }

    
}
