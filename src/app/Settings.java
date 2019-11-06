/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Color;

/**
 *
 * @author student
 */
public class Settings {
    /**
     * Default col count
     */
    public static final int DEFAULT_WIDTH = 14;
    /**
     * Default row count.
     */
    public static final int DEFAULT_HEIGHT = 22;
   
    public static Color [] colors = {
        Color.RED, // kolor naszego auta
        Color.BLACK, // kolor bloków przeciwnika i krawędzi;
    };
    public static int DEFAULT_FIELD_SIZE = 20;    
    
    public static int SPCACE_BETWEEN_EDGES = 2;
    
    public static int START_SPEED = 180; 
    
    public static int SPEED_INCREMENT = 10;
    
}
