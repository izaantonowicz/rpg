package places;

import item.Item;
import item.ItemType;
import utils.CommunicationUtils;
import utils.MessageValues;
import utils.ScannerUtils;

import java.util.List;
import java.util.stream.Collectors;

public class UsedCarDealer extends AbstractPlace implements Place {

    public PlaceEventOutput doSomething(PlaceEventInput input) {
        PlaceEventOutput output = new PlaceEventOutput();
        if(input.itemList!=null&&!input.itemList.isEmpty()) {
            Integer partForExchange = ScannerUtils.getValidateIntegerWithMessage(MessageValues.EXCHANGE_IN + MessageValues.NEW_LINE + getEquipmentInfo(input), getAvailableValues(input));
            if (partAvailable(input, partForExchange)) {
                CommunicationUtils.printMessage(MessageValues.EXCHANGE_WRONG);
                return output;
            }
            int minItemValue = 0;
            int maxItemValue = 4;
            Integer wantedPart = ScannerUtils.getValidateIntegerWithMessage(MessageValues.EXCHANGE_OUT + MessageValues.NEW_LINE + ItemType.stringValues(), minItemValue, maxItemValue);
            output.addItem = ItemType.values()[wantedPart];
            output.removeItem = ItemType.values()[partForExchange];
        }
        return output;
    }

    private boolean partAvailable(PlaceEventInput input, Integer partForExchange) {
        return input.itemList.stream().noneMatch(i -> i.getType().ordinal() == partForExchange);
    }

    public String getEventDescription() {
        return MessageValues.USED_CAR_DEALER_DESCRIPTION;
    }

    public PlaceType getType() {
        return PlaceType.USED_CAR_DEALER;
    }

    private String getEquipmentInfo(PlaceEventInput input) {
        if (input.itemList != null && !input.itemList.isEmpty()) {
            List<ItemType> availableItems = input.itemList.stream().map(Item::getType).collect(Collectors.toList());
            StringBuilder sb = new StringBuilder("");
            availableItems.forEach(i -> sb.append(MessageValues.USED_CAR_DEAL_EXCHANGE(i.name(), i.ordinal())));
            return sb.toString();
        }
        return null;
    }

    private List<Integer> getAvailableValues(PlaceEventInput input) {
        if (input.itemList != null && !input.itemList.isEmpty())
            return input.itemList.stream().map(i -> i.getType().ordinal()).collect(Collectors.toList());
        else
            return null;
    }


}
