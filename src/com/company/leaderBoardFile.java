package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class leaderBoardFile {
    public static File leaderBoards = new File("leaderBoards.txt");

    ////////////////setting temp variables for points and username
    public static String userName;
    public static int pointsScored;
    ///////////////


    public static void CreateLeaderboardFile() {
        try {
            if (leaderBoards.createNewFile()) {
                System.out.println("File created: " + leaderBoards.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void WriteToLeaderboardFile(){
        try {
            FileWriter myWriter = new FileWriter(leaderBoards.getName(), true);

            myWriter.write(userName+" " );
            myWriter.write(pointsScored+" \n");
            myWriter.close();
        }catch(Exception e){
            System.out.println("An error occurred "+e);
        }
    }

}
