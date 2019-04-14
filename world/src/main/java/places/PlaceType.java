package places;

public enum PlaceType {
    USED_CAR_DEALER(1),
    SCRAP_HEAP(2),
    SHOP_WITH_PARTS_FOR_THE_TIME_MACHINE(3),
    GAS_STATION(4),
    CAR_REPAIR_SHOP(5),
    RALLY_CAR(6);

    private final int value;

    PlaceType(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }

    public static String getStringValues(){
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<PlaceType.values().length; i++){
            sb.append("Press "+PlaceType.values()[i].getValue()+" - "+PlaceType.values()[i].name()+"\n");
        }
        return sb.toString();
    };
}
