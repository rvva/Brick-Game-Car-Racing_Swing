/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import app.Settings;
import javax.swing.JLabel;
/**
 *
 * @author qqs
 */
public class GameInfo {
    
    private JLabel score;
    private int speed; 
    private JLabel speedLabel;
    private boolean collision; 

    public GameInfo() {
    }

    public GameInfo(JLabel score, JLabel speedLabel) {
        collision = false;
        speed = Settings.START_SPEED;
        this.score = score;
        this.speedLabel = speedLabel;
        speedLabel.setText(String.valueOf(speed));
    }

    public JLabel getSpeedLabel() {
        return speedLabel;
    }

    public void setLabelText(JLabel speedLabel, String string) {
        speedLabel.setText(String.valueOf(string));
    }
    
    
    
   

    

    public JLabel getScore() {
        return score;
    }

    public void setScore(JLabel score) {
        this.score = score;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    
    

   

   
    
    
    
}
