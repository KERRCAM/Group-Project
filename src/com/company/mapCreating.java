package com.company;

import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class mapCreating {
    private static File RandomGameMap = new File("RandomGameMap.txt");
    public static void CreateMap(){
        try{
        if (RandomGameMap.createNewFile()) {
            System.out.println("File created: " + RandomGameMap.getName());
        } else {
            System.out.println("File already exists.");
        }
        Random random = new Random();
        int mapX = random.nextInt(20)+24;
        int mapY = random.nextInt(50)+100;

            FileWriter myWriter = new FileWriter(RandomGameMap.getName(),false);
            for (int i = 0; i < mapY; i++) {
                myWriter.write("5 ");
                for (int j = 0; j < mapX; j++) {
                    int platformChance = random.nextInt(20);
                    if (platformChance == 1 && j < mapX-3){
                        myWriter.write("1 0 2 ");
                        j++;
                        j++;

                    }else{
                        myWriter.write("4 ");
                    }
                }
                myWriter.write("5 \n");

            }
            myWriter.close();
        }catch(Exception e){
            System.out.println("error:"+e);
        }

    }
    public static void DeleteRandomMapFile(){
        if (RandomGameMap.delete()) {
            System.out.println("Deleted the file: " + RandomGameMap.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }



}
