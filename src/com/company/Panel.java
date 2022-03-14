package com.company;

import Tiles.Tile;
import Tiles.TileManager;
import entity.Player;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable{
    final int originalTileSize = 16;
    final int characterSize = 16;
    final int characterScaling = 3;
    public final int tileSize = characterSize*characterScaling;
    final int maxScreenCol = 24; // how big actual window is
    final int maxScreenRow = 16;
    final int screenWidth = maxScreenCol * tileSize;
    final int screenHeight = maxScreenRow * tileSize;

    public final int maxWorldCol = 50; // how big map is
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;




    public Panel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(listener);
        this.setFocusable(true);

    }
    TileManager tileManager = new TileManager(this);
    Input listener = new Input();
    public Player player = new Player(this,listener);
    Thread gameThread;
    public collisionTest cTest = new collisionTest(this);

    public void StartThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval = 1000000000/60;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer =0;
        int drawCount = 0;

        while (gameThread!= null){

            currentTime = System.nanoTime();
            timer += (currentTime - lastTime);
            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {

                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000){
                //System.out.println("FPS:"+ drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g2){
            super.paintComponent(g2);
            Graphics2D g2D = (Graphics2D) g2;
            tileManager.draw(g2D);
            player.draw((Graphics2D) g2);
            g2D.dispose();

    }
}
