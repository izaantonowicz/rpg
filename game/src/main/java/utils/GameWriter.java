package utils;

import game.Game;
import player.Player;

import java.io.*;

public class GameWriter {
    public static boolean write(Game game, String filename){
        FileOutputStream f = null;
        try {
            f = new FileOutputStream(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream o = null;
        try {
            o = new ObjectOutputStream(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write objects to file
        try {
            o.writeObject(game);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            o.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
