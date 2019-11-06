/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import app.Settings;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author qqs
 */
public class Move extends Thread {

    private JPanel panel;
    private RaceArray array;
    private Block myCar;
    private GameInfo gameInfo;

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public Move(JPanel panel, RaceArray array, Block myCar, GameInfo game) {
        this.panel = panel;
        this.array = array;
        this.myCar = myCar;
        gameInfo = game;
    }

    public void moveLeft() {
        if (array.getArray()[Settings.DEFAULT_HEIGHT][Settings.DEFAULT_WIDTH - 4] == 0 // pobierana i sprawdzana jest jedna komórka w celu sprawdzenia czy nasz samachód tam się znajduję
                && !gameInfo.isCollision()) {

            if (array.isEnemyCarOnLeft()) {// kolizja po zmianie strony
                gameInfo.setCollision(true);
            }

            array.clear(Settings.DEFAULT_HEIGHT, Settings.DEFAULT_WIDTH - 5, myCar.getArray());
            array.draw(Settings.DEFAULT_HEIGHT, 2, myCar.getArray());
            panel.repaint();
        }
    }

    public void moveRight() {
        if (array.getArray()[Settings.DEFAULT_HEIGHT][3] == 0
                && !gameInfo.isCollision()) {  // pobierana i sprawdzana jest jedna komórka w celu sprawdzenia czy nasz samachód tam się znajduję

            if (array.isEnemyCarOnRight()) {// kolizja po zmianie strony
                gameInfo.setCollision(true);
            }

            array.clear(Settings.DEFAULT_HEIGHT, 2, myCar.getArray());
            array.draw(Settings.DEFAULT_HEIGHT, Settings.DEFAULT_WIDTH - 5, myCar.getArray());
            panel.repaint();
        }
    }
    
     public int increaseSpeed (int speed)
    {   
        return (int) (speed*0.5);
    }

    public void run(TypeOfBlock typeOfCar) {
        super.run();

        Block edge = new Block(TypeOfBlock.I, 1);
        Block enemyCar = new Block(typeOfCar, 1);

        int score = 0;
        int spaceCounter = 0;
        int randomSpace = array.generateSpacesBetweenCars();
        int edgeCounter = edge.getRowCount() + Settings.SPCACE_BETWEEN_EDGES;
        Random randomSide = new Random();

        while (!gameInfo.isCollision()) {
            if (edgeCounter == 0) { // dopisywanie krawędzi
                array.draw(0, 0, edge.getArray());
                array.draw(0, array.getColCount() - 1, edge.getArray());
                edgeCounter = edge.getRowCount() + Settings.SPCACE_BETWEEN_EDGES;
            }
            edgeCounter--;
            spaceCounter++;

            if (array.isScoreSpot(typeOfCar)) { //sprawdzanie czy nasz samochód zrównał się z autem przeciwnika
                ++score;
                gameInfo.setLabelText(gameInfo.getScore(), String.valueOf(score));

                if ((score + 1) % 11 == 0 && getGameInfo().getSpeed() > Settings.SPEED_INCREMENT) {
                    gameInfo.setSpeed(getGameInfo().getSpeed()-Settings.SPEED_INCREMENT);
                    gameInfo.setLabelText(gameInfo.getSpeedLabel(), String.valueOf(gameInfo.getSpeed()));
                }
            }

            if (spaceCounter == randomSpace) {
                if (randomSide.nextBoolean() == true) {
                    array.draw(0, 2, enemyCar.getArray());
                } else {
                    array.draw(0, array.getColCount() - 2 - enemyCar.getColCount(), enemyCar.getArray());
                }

                randomSpace = array.generateSpacesBetweenCars();
                spaceCounter = 0;
            }

            array.shiftDown();

            try {
                Thread.sleep(getGameInfo().getSpeed());
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

            if (array.isStraightLineCollision()) //kolizja
            {
                gameInfo.setCollision(true);
            }

            panel.repaint();

        }
        array.endGame(panel);
    }
}
