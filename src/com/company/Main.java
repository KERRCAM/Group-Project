package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.leaderBoardFile.CreateLeaderboardFile;

public class Main {

    public static void main(String[] args) {
        CreateLeaderboardFile();
        Screen gameScreen= new Screen();
        Panel gamePanel=new Panel();
        ImageIcon button=new ImageIcon("button.png");
        JButton b1 = new JButton(button);
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.CENTER);
        gameScreen.add(gamePanel);
        gameScreen.add(new JLabel("GameTitle"), BorderLayout.NORTH);
        gameScreen.pack();
        gameScreen.setLocationRelativeTo(null);
        gameScreen.setVisible(true);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                gamePanel.StartThread();
            }
        });
    }
}
