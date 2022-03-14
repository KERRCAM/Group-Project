
package Tiles;

import com.company.Panel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    int tileTypes=5;
    Panel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(Panel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/map1.txt");


    }
    public void getTileImage(){
        try{
            tile[0]=new Tile();
            tile[0].image=ImageIO.read(getClass().getResourceAsStream("/TerrainTiles/terrain_platform_center.png"));
            tile[0].collision = true;

            tile[1]=new Tile();
            tile[1].image=ImageIO.read(getClass().getResourceAsStream("/TerrainTiles/terrain_platform_left.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/TerrainTiles/terrain_platform_right.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/TerrainTiles/terrain_top_center.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/TerrainTiles/sky2.png"));
            tile[4].collision = true;




        }catch(IOException e){
            System.out.println("Error: "+e);
        }
    }

    public void loadMap(String filePath){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();

                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;

                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        }catch(Exception e) {

        }
    }

    public void draw(Graphics2D g2D){
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
                    && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
                    && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
                    && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)

            g2D.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow ++;
            }
        }








        //int screenCenterX = gp.getWidth()/2- gp.tileSize/2;
        //int screenCenterY = gp.getHeight()/2-gp.tileSize/2;

        //g2D.drawImage(tile[0].image,screenCenterX,screenCenterY,gp.tileSize, gp.tileSize,null);
        //g2D.drawImage(tile[1].image,screenCenterX- gp.tileSize,screenCenterY,gp.tileSize, gp.tileSize,null);
        //g2D.drawImage(tile[2].image,screenCenterX + gp.tileSize,screenCenterY,gp.tileSize, gp.tileSize,null);
        //for (int i = 0; i < gp.getWidth(); i = i+ gp.tileSize) {
        //    g2D.drawImage(tile[3].image,i,gp.getHeight()-30,gp.tileSize,gp.tileSize,null);

        }

    }

