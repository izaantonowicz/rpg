package places;

import item.ItemType;
import utils.CommunicationUtils;
import utils.MessageValues;

public class ScrapHeap extends AbstractPlace implements Place {

    public PlaceEventOutput doSomething(PlaceEventInput input) {
        PlaceEventOutput output = new PlaceEventOutput();
        output.addItem = ItemType.randomType();
        CommunicationUtils.printMessage(MessageValues.SCRAP_HEAP_ITEM(output.addItem.name()));
        return output;
    }

    public String getEventDescription() {
        return MessageValues.SCRAP_HEAP_DESCRIPTION;
    }

    public PlaceType getType() {
        return PlaceType.SCRAP_HEAP;
    }


}
