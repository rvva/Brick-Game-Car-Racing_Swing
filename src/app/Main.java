/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import data.Block;
import data.GameInfo;
import data.Move;
import data.MyListiner;
import data.RaceArray;
import data.TypeOfBlock;
import view.MainFrame;

/**
 *
 * @author qqs
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        
        RaceArray race = new RaceArray();
        Block b = new Block(TypeOfBlock.Car,0);
        
        race.draw(Settings.DEFAULT_HEIGHT, 2, b.getArray());
              
//        System.out.println(race.toString());
        
        GameInfo gameInfo = new GameInfo(mf.getjLabelScore(), mf.getjLabelSpeed());
        
        Move move = new Move(mf.getjPanelRace(), race, b, gameInfo);

                
        mf.setTab(race.getArray(), mf.getjPanelRace());
            
        MyListiner listiner = new MyListiner(move);
        mf.addKeyListener(listiner);
        
        move.run(TypeOfBlock.Car);
               
    }
    
}
