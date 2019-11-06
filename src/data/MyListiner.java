/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import app.Settings;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author student
 */
public class MyListiner implements KeyListener {

    private Move move;
    private boolean arrowUpTyped;

    public MyListiner(Move move) {
        this.move = move;
        arrowUpTyped = false;
    }

    public MyListiner() {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case 39:
                move.moveRight();
                break;
            case 37:
                move.moveLeft();
                break;
            case 38:
                if (!arrowUpTyped) {
                    move.getGameInfo().setSpeed(move.increaseSpeed(move.getGameInfo().getSpeed()));
                    arrowUpTyped = true;     
                    move.getGameInfo().setLabelText(move.getGameInfo().getSpeedLabel(), 
                            String.valueOf(move.getGameInfo().getSpeed()));
                }
                break;
            case 40:
                if (arrowUpTyped == true) {
                    move.getGameInfo().setSpeed(Settings.START_SPEED - Integer.parseInt(move.getGameInfo().getScore().getText()) / 10 * 10);
                    arrowUpTyped = false;
                    move.getGameInfo().setLabelText(move.getGameInfo().getSpeedLabel(), 
                            String.valueOf(move.getGameInfo().getSpeed()));
                }
                break;
        }
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
