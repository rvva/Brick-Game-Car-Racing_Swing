/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import app.Settings;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author qqs
 */
public class RacePanel extends JPanel {

    private int[][] tab;

    public void setTab(int[][] tab) {
        this.tab = tab;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (tab == null) {
            return;
        }

        for (int i = 4; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {

                if (tab[i][j] != -1) {
                    g.setColor(Settings.colors[tab[i][j]]);
                    
                    g.fillRect(j * Settings.DEFAULT_FIELD_SIZE,
                            i * Settings.DEFAULT_FIELD_SIZE,
                            Settings.DEFAULT_FIELD_SIZE, Settings.DEFAULT_FIELD_SIZE);

                    g.setColor(Color.GRAY);

                    g.drawRect(j * Settings.DEFAULT_FIELD_SIZE,
                            i * Settings.DEFAULT_FIELD_SIZE,
                            Settings.DEFAULT_FIELD_SIZE, Settings.DEFAULT_FIELD_SIZE);
                }
            }
        }
    }
}
