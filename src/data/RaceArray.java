/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import app.Settings;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author student
 */
public class RaceArray extends MyArray {

    public RaceArray() {
        // +4 ukryte wiersze na nowy samochód 
        // +4 ukryte wiersze na ukrycie samochodu przeciwnika po minięciu naszego auta
        super(Settings.DEFAULT_HEIGHT + 4, Settings.DEFAULT_WIDTH);
        clear();
        generateEdges();
    }

    private void clear() {
        for (int i = 0, limitRow = getRowCount(); i < limitRow; i++) {
            for (int j = 0, limitCol = getColCount(); j < limitCol; j++) {
                array[i][j] = -1;
            }
        }
    }

    private void generateEdges() {
        for (int i = 0, limitRow = getRowCount(), limitCol = getColCount() - 1;
                i < limitRow; i += Settings.SPCACE_BETWEEN_EDGES + 3) {
            for (int j = 0; j < 3; j++) {
                if (isRowIdxValid(i + j)) {
                    array[i + j][0] = 1;
                    array[i + j][limitCol] = 1;
                }
            }
        }
    }

    public void draw(int row, int col, int[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (tab[i][j] != -1) {
                    array[row + i][col + j] = tab[i][j];
                }
            }
        }
    }

    public void deleteRow(int row) {
        for (int i = 0; i < array[0].length; i++) {
            if (array[row][i] != -1) {
                array[row][i] = -1;
            }
        }
    }

    public void shiftDown() {
        for (int i = getRowCount() - 1; i > 0; i--) {
            for (int j = 0; j < getColCount(); j++) {
                if (array[i][j] != 0 && array[i - 1][j] != 0) {
                    array[i][j] = array[i - 1][j];
                }
            }
        }
        deleteRow(0);
    }

    public void clear(int row, int col, int[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (array[row + i][col + j] != -1 && tab[i][j] != -1) {
                    array[row + i][col + j] = -1;
                }
            }
        }
    }

    public boolean isValueInRow(int value, int row) {
        for (int i = 2; i < array[0].length - 2; i++) {
            if (array[row][i] == value) {
                return true;
            }
        }
        return false;
    }

    public boolean isScoreSpot(TypeOfBlock type) {
        if (type == TypeOfBlock.Car) {
            if ((array[getRowCount() - 1][2] > 0 && array[getRowCount() - 3][2] > 0)
                    || (array[getRowCount() - 1][getColCount() - 3] > 0 && array[getRowCount() - 3][getColCount() - 3] > 0)) {
                return true;
            }
        } else if (type == TypeOfBlock.RotatedCar) {
            if ((array[getRowCount() - 2][2] > 0 && array[getRowCount() - 4][2] > 0)
                    || (array[getRowCount() - 2][getColCount() - 4] > 0 && array[getRowCount() - 4][getColCount() - 3] > 0)) {
                return true;
            }
        }
        return false;
    }

    public boolean isStraightLineCollision() {
        if ((array[getRowCount() - 4][3] == 0 && array[getRowCount() - 5][3] > 0)
                || (array[getRowCount() - 4][getColCount() - 4] == 0 && array[getRowCount() - 5][getColCount() - 4] > 0)) {
            return true;
        }
        return false;
    }

    public boolean isEnemyCarOnRight() {
        if (array[getRowCount() - 5][getColCount() - 4] > 0
                || array[getRowCount() - 4][getColCount() - 4] > 0
                || array[getRowCount() - 1][getColCount() - 4] > 0
                || array[getRowCount() - 1][getColCount() - 5] > 0) // ost. warunek  dla RotatedCar
        {
            return true;
        }

        return false;
    }

    public boolean isEnemyCarOnLeft() {
        if (array[getRowCount() - 5][3] > 0
                || array[getRowCount() - 4][3] > 0
                || array[getRowCount() - 1][3] > 0
                || array[getRowCount() - 1][2] > 0) // ost. warunek  dla RotatedCar
        {
            return true;
        }
        return false;
    }
    
    public int generateSpacesBetweenCars ()
    {
       return new Random().nextInt(6)+ 12;
}
    
    public void endGame (JPanel panel)
    {
        for (int i = 4; i< getRowCount(); i++) {
            for (int j = 0; j< getColCount(); j++) {
                array[i][j] = 0;
                panel.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RaceArray.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
