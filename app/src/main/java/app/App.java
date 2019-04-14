package app;

import exception.PlayerNotFoundException;
import game.Game;
import item.Item;
import item.ItemType;
import player.Player;
import skill.DriverSkill;
import skill.SkillFactory;
import utils.*;

import java.util.EnumSet;

public class App {

    public static void main(String args[]) {

        CommunicationUtils.printMessage(MessageValues.INTRO());

        Integer option = ScannerUtils.getValidateIntegerWithMessage(MessageValues.START_GAME_OPTION, 1, 2);

        Player player;
        Game game;

        if (option.equals(1)) {
            greetWithNewPlayer();
            String playerName = getPlayerName();
            DriverSkill skill = getPlayerMainSkill();
            Integer moneyOrFuel = chooseMoneyOrFuel();
            ItemType luckyPart = giveFirstGift();

            player = Player
                    .builder()
                    .addSkill(skill)
                    .addItem(new Item(luckyPart))
                    .setName(playerName)
                    .setFuelPoints(moneyOrFuel.equals(1))
                    .setMoneyPoints(moneyOrFuel.equals(2))
                    .build();

            game = new Game(player);
        } else {
            while (true) {
                try {
                    String filename = ScannerUtils.getValidateStringWithMessage(MessageValues.RESUME_GAME_NAME);
                    game = GameReader.read(filename);
                    break;
                } catch (PlayerNotFoundException e) {
                    CommunicationUtils.printMessage(MessageValues.INVALIDATE_VALUE_EXCEPTION);
                }
            }
        }


        game.play();
    }

    private static ItemType giveFirstGift() {
        CommunicationUtils.printMessage(MessageValues.FIRST_GIFT);
        ItemType luckyPart = ItemType.randomType();
        CommunicationUtils.printMessage(MessageValues.LUCKY_PART(luckyPart.name()));
        return luckyPart;
    }

    private static Integer chooseMoneyOrFuel() {
        return ScannerUtils.getValidateIntegerWithMessage(MessageValues.PLAYER_DECISION, 1, 2);
    }

    private static DriverSkill getPlayerMainSkill() {
        Integer mainSkill = ScannerUtils.getValidateIntegerWithMessage(MessageValues.PLAYER_MAIN_SKILL, 1, 2);
        return SkillFactory.createSkill(mainSkill);
    }

    private static String getPlayerName() {
        CommunicationUtils.printMessage(MessageValues.PLAYER_INFO);
        return ScannerUtils.getValidateStringWithMessage(MessageValues.PLAYER_NAME);
    }

    private static void greetWithNewPlayer() {
        CommunicationUtils.printMessage(MessageValues.INTRODUCTION);
        EnumSet<ItemType> allTypes = EnumSet.allOf(ItemType.class);
        CommunicationUtils.printMessage(MessageValues.OBJECTIVE_INFO(allTypes.toString()));
    }




}
