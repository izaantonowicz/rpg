package places;

import item.ItemType;
import utils.CommunicationUtils;
import utils.MessageValues;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class CarRepairShop extends AbstractPlace implements Place {

    public PlaceEventOutput doSomething(PlaceEventInput input) {
        PlaceEventOutput output = new PlaceEventOutput();
        if (input.itemList==null || input.itemList.isEmpty()) {
            return output;
        }

        AtomicBoolean check = new AtomicBoolean(true);

        Arrays.asList(ItemType.values()).forEach(t -> {
            if (input.itemList.stream().noneMatch(i -> i.getType().equals(t))) {
                check.set(false);
            }
        });

        if (check.get()) {
            CommunicationUtils.printMessage(MessageValues.CONGRATULATIONS);
            output.win = true;
        } else {
            CommunicationUtils.printMessage(MessageValues.WRONG_DECISION);
        }

        return output;
    }

    public String getEventDescription() {
        return MessageValues.CAR_REPAIR_SHOP_DESCRIPTION;
    }

    public PlaceType getType() {
        return PlaceType.CAR_REPAIR_SHOP;
    }
}
