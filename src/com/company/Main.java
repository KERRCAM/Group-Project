package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.leaderBoardFile.CreateLeaderboardFile;
import static com.company.mapCreating.CreateMap;

public class Main {

    public static void main(String[] args) {
        CreateLeaderboardFile();
        CreateMap();;
        Screen gameScreen= new Screen();
        Panel gamePanel=new Panel();
        gameScreen.add(gamePanel);
        gameScreen.pack();
        gameScreen.setLocationRelativeTo(null);
        gameScreen.setVisible(true);
    }
}
