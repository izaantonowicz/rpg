package utils;

import exception.PlayerNotFoundException;
import game.Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GameReader {
    public static Game read(String filename) throws PlayerNotFoundException {
        Game game;

        try {
            FileInputStream fi = new FileInputStream(new File(filename));
            ObjectInputStream oi = new ObjectInputStream(fi);
            game = (Game) oi.readObject();
            oi.close();
            fi.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new PlayerNotFoundException();
        }

        return game;
    }
}
