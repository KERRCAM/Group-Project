package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class mapCreating {
    private static File RandomGameMap = new File("RandomGameMap.txt");

    public static void CreateMap(){
        try{
            FileWriter myWriter = new FileWriter(RandomGameMap.getName(),true);
        }catch(Exception e){
            System.out.println("error:"+e);
        }

    }



}
