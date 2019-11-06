/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import app.Settings;
import java.util.Random;

/**
 *
 * @author qqs
 */
public class Block extends RaceArray{

   
    public void createBlock(TypeOfBlock type, int colorIndex) {
        switch (type) {
            case I:
                array = new int[3][1];
                for (int i = 0; i < 3; i++) {
                    array[i][0] = colorIndex;
                }
                break;
            case Car:
                array = new int[4][3];
                array[0][0]= -1;
                array[0][1] = colorIndex;
                array[0][2]= -1;
                
                array[1][0] = colorIndex;
                array[1][1] = colorIndex;
                array[1][2] = colorIndex;
                
                array[2][0] = -1;
                array[2][1] = colorIndex;
                array[2][2] = -1;
                
                array[3][0] = colorIndex;
                array[3][1] = -1;
                array[3][2] = colorIndex;
                break;
            case RotatedCar:
                array = new int[4][3];
                array[3][0] = -1;
                array[3][1] = colorIndex;
                array[3][2] = -1;
                
                array[2][0] = colorIndex;
                array[2][1] = colorIndex;
                array[2][2] = colorIndex;
                
                array[1][0] = -1;
                array[1][1] = colorIndex;
                array[1][2] = -1;
                
                array[0][0] = colorIndex;
                array[0][1] = -1;
                array[0][2] = colorIndex;
                break;
            default:
                throw new AssertionError();
        }
    }

    public Block(TypeOfBlock type, int idxColor) {
        createBlock(type, idxColor);
    }  
}
