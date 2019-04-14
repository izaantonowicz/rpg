package places;

public class PlaceProvider {
    private static UsedCarDealer usedCarDealer = new UsedCarDealer();
    private static CarRepairShop carRepairShop = new CarRepairShop();
    private static GasStation gasStation = new GasStation();
    private static RallyCar rallyCar = new RallyCar();
    private static ScrapHeap scrapHeap = new ScrapHeap();
    private static ShopWithPartsForTheTimeMachine shopWithPartsForTheTimeMachine = new ShopWithPartsForTheTimeMachine();

    public static Place pickPlace(Integer value){
        if (Integer.valueOf(1).equals(value)) {
            return usedCarDealer;
        } else if (Integer.valueOf(2).equals(value)) {
            return scrapHeap;
        } else if (Integer.valueOf(3).equals(value)) {
            return shopWithPartsForTheTimeMachine;
        } else if (Integer.valueOf(4).equals(value)) {
            return gasStation;
        } else if (Integer.valueOf(5).equals(value)) {
            return carRepairShop;
        } else if (Integer.valueOf(6).equals(value)) {
            return rallyCar;
        }else{
            return null;
        }
    }

}
