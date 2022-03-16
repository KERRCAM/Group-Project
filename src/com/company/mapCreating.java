package com.company;

import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class mapCreating {
    private static File RandomGameMap = new File("RandomGameMap.txt");

    public static void CreateMap(){
        Random random = new Random();
        int mapX = random.nextInt(30)+20;
        int mapY = random.nextInt(30)+20;
        try{
            FileWriter myWriter = new FileWriter(RandomGameMap.getName(),true);
            for (int i = 0; i < mapY; i++) {
                myWriter.write("5 ");
                for (int j = 0; j < mapX; j++) {
                    int platformChance = random.nextInt(5);
                    if (platformChance == 1){
                        myWriter.write("1 0 2 ");
                        i++;
                        i++;
                    }else{
                        myWriter.write("4 ");
                    }
                }
                myWriter.write("5 ");

            }

        }catch(Exception e){
            System.out.println("error:"+e);
        }

    }



}
