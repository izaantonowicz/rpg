package item;

import java.util.Random;

public enum ItemType {
    BULBULATOR, TURBO_ENCABULATOR, ACCELERANT_OF_MODERATOR, TRI_SHAFT_EXHAUST_FLANGE, HEADLIGHT_FLUID;

    public static ItemType randomType(){
        int pick = new Random().nextInt(ItemType.values().length);
        return ItemType.values()[pick];
    }

    public static String stringValues(){
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<ItemType.values().length; i++){
            sb.append("Press "+ItemType.values()[i].ordinal()+" - "+ItemType.values()[i].name()+"\n");
        }
        return sb.toString();
    };
}
