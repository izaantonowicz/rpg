package game;

import places.*;
import player.Player;
import skill.EcoDriver;
import utils.*;

import java.io.Serializable;

public class Game implements Serializable {

    private Player player;
    private Place currentPlace;
    private int defaultFuelCost = 5;

    public Game(Player player) {
        this.player = player;
    }

    public void play() {
        boolean gameStatus = true;
        if(isEcoDriver()){
            setSpecialPrice();
        }

        while (gameStatus) {
            String additional = MessageValues.ADDITIONAL_OPTIONS;
            Integer choosedPlace = ScannerUtils.getValidateIntegerWithMessage(MessageValues.CHOOSE_DESTINATION + MessageValues.NEW_LINE + PlaceType.getStringValues() + additional, 1, 8);
            if (choosedPlace >= 1 && choosedPlace <= 6) {
                Place place = PlaceProvider.pickPlace(choosedPlace);
                CommunicationUtils.printMessage(place.getEventDescription());
                gameStatus = move(place);
                player.printStatistics();
            } else if (choosedPlace.equals(Integer.valueOf(7))) {
                CommunicationUtils.printMessage(MessageValues.EXIT);
                gameStatus = false;
            } else if (choosedPlace.equals(Integer.valueOf(8))) {
                String filename = ScannerUtils.getValidateStringWithMessage(MessageValues.SAVE_GAME_NAME);
                GameWriter.write(this, filename);
            }
        }
    }

    public boolean move(Place place) {

        if ((firstMove() || isInDifferentPlace(place))) {
            if (hasEnoughFuel()) {
                player.changeFuel(-defaultFuelCost);
                this.currentPlace = place;
            } else {
                CommunicationUtils.printMessage(MessageValues.NOT_ENOUGH_FUEL);
                return false;
            }
        }

        PlaceEventInput input = new PlaceEventInput(player.getItems(), player.getMoneyPoints(), player.getFuelPoints(), player.getLevel());
        PlaceEventOutput output = place.doSomething(input);

        if (output.gameOver || output.win) {
            return false;
        }

        player.changeFuel(output.changeFuel);
        player.changeMoney(output.changeMoney);
        if (output.levelUp) {
            player.levelUp();
        }
        if (output.addItem != null) {
            player.addItem(output.addItem);
        }
        if (output.removeItem != null) {
            player.removeItem(output.removeItem);
        }

        return true;
    }

    private boolean isInDifferentPlace(Place place) {
        return !this.currentPlace.getType().equals(place.getType());
    }

    private boolean firstMove() {
        return currentPlace == null;
    }

    private boolean hasEnoughFuel() {
        return player.getFuelPoints() > defaultFuelCost;
    }

    private void setSpecialPrice() {
        this.defaultFuelCost -= 2;
    }

    private boolean isEcoDriver(){
        return player.getSkills().stream().anyMatch(skill -> skill instanceof EcoDriver);
    }
}
