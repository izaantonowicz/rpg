package places;

import item.ItemType;
import utils.CommunicationUtils;
import utils.MessageValues;
import utils.ScannerUtils;

public class ShopWithPartsForTheTimeMachine extends AbstractPlace implements Place {

    private int priceForOnePart = 1000;

    public PlaceEventOutput doSomething(PlaceEventInput input) {
        PlaceEventOutput output = new PlaceEventOutput();
        if(hasEnoughMoney(input)){
            CommunicationUtils.printMessage(MessageValues.NOT_ENOUGH_MONEY);
            return output;
        }
        Integer choosedItem = ScannerUtils.getValidateIntegerWithMessage(MessageValues.ITEM_PRICE(priceForOnePart, ItemType.stringValues()),1,6);
        output.addItem = ItemType.values()[choosedItem];
        output.changeMoney = -priceForOnePart;

        return output;
    }

    private boolean hasEnoughMoney(PlaceEventInput input) {
        return input.money<priceForOnePart;
    }

    public String getEventDescription() {
        return MessageValues.SHOP_WITH_PARTS_FOR_TIME_MACHINE_DESCRIPTION;
    }

    public PlaceType getType() {
        return PlaceType.SHOP_WITH_PARTS_FOR_THE_TIME_MACHINE;
    }


}
