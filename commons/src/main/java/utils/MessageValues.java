package utils;

public class MessageValues {
    public static final String START_GAME_OPTION = "Welcome to the TIME MACHINE CHALLENGE RPG! Press 1 if you would like to play a new game or press 2 if you would like to resume your old game.";
    public static final String INTRODUCTION = "OK!!\nYou are stuck in the year 3005 with an ordinary car. Your mission is to build a time machine to get back to the present. Remember that your every move costs fuel points, be careful not to lose all of it! To achieve your challenge you need to collect all necessary parts (at least one of each)! Let's see what you need to collect...";
    public static final String PLAYER_INFO = "Now, you know everything so it's time for me to get to know something about you...";
    public static final String PLAYER_NAME = "What's your name?";
    public static final String PLAYER_MAIN_SKILL = "You need to choose your main skill: \nPress 1 if you would like to be an eco driver or press 2 if you would like to be a super fast driver!";
    public static final String PLAYER_DECISION = "What would you like to start with: more fuel or money? Press 1 for fuel or press 2 for money!";
    public static final String FIRST_GIFT = "Oh, I almost forgot! I have the first part for you! Let me check... ";
    public static final String CHOOSE_DESTINATION = "Where would you like to go?";
    public static final String EXCHANGE_IN = "Which part would you like to give us for exchange?";
    public static final String EXCHANGE_OUT = "Which part would you like to get from us?";
    public static final String EXCHANGE_WRONG = "Sorry, you don't have that part. Pick another one.";
    public static final String USED_CAR_DEALER_DESCRIPTION = "You can exchange your parts here! For free!";
    public static final String SHOP_WITH_PARTS_FOR_TIME_MACHINE_DESCRIPTION = "You can buy some parts for your time machine here! But... it's not cheap...";
    public static final String NOT_ENOUGH_MONEY = "I told you! You don't have enough money! Come here later!";
    public static final String GAS_STATION_DESCRIPTION = "You can fuel up your car here!";
    public static final String NOT_ENOUGH_FUEL = "You don't have enough fuel. GAME OVER :(((";
    public static final String LEVEL = "Your level: ";
    public static final String FUEL = "Your fuel points: ";
    public static final String MONEY = "Your money points: ";
    public static final String NEW_LINE = "\n";
    public static final String SEPARATOR = " --- ";
    public static final String LINE_SEPARATOR = "*********************************";
    public static final String PRESS = "(Enter something here): ";
    public static final String INVALIDATE_VALUE_EXCEPTION = "Invalid value, bro! Try again!";
    public static final String CONGRATULATIONS = "CONGRATZZZZZ!!!!! YOU WIN!";
    public static final String WRONG_DECISION = "Not this time, sorry bro.";
    public static final String CAR_REPAIR_SHOP_DESCRIPTION = "You can build your time machine here! Of course if you have all of necessary parts!";
    public static final String GAME_OVER_FUEL = "You lost all of your fuel! GAME OVER! :(((";
    public static final String COMPETITION_WON = "Congrats! You won the competition!";
    public static final String COMPETITION_LOSE = "You lose. Try again later.";
    public static final String RALLY_CAR_DESCRIPTION = "Improve your skills and earn more money by taking part in a competition!";
    public static final String SCRAP_HEAP_DESCRIPTION = "Try to find some parts for free!";
    public static final String RESUME_GAME_NAME = "Enter the name of your saved game.";
    public static final String SAVE_GAME_NAME = "(Enter name here): ";
    public static final String ADDITIONAL_OPTIONS = "Press 7 - CLOSE GAME\nPress 8 - SAVE GAME";
    public static final String EXIT = "BYE!!!!!";

    public static final String USED_CAR_DEAL_EXCHANGE(String name, int ordinal) {
        return "To change " + name + " press " + ordinal + "\n";
    }

    public static final String SCRAP_HEAP_ITEM(String item) {
        return "You found " + item + "!";
    }

    public static final String FUEL_AMOUNT(int fuelCost) {
        return "How much fuel would you like to buy? 1 fuel point costs " + fuelCost + " money points.";
    }

    public static String OBJECTIVE_INFO(String objective) {
        return "There is a list of parts which you need: " + objective;
    }

    public static String LUCKY_PART(String luckyPart) {
        return "It's a " + luckyPart + "! Good luck!";
    }

    public static String ITEM_PRICE(int price, String additionalInfo) {
        return "You can buy an item for " + price + " money points, which one would you like?\n" + additionalInfo + "\n";
    }
}
