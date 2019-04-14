package places;

import utils.CommunicationUtils;
import utils.MessageValues;
import utils.ScannerUtils;


public class GasStation extends AbstractPlace implements Place {

    public PlaceEventOutput doSomething(PlaceEventInput input) {

        PlaceEventOutput output = new PlaceEventOutput();
        int minFuelAmount = 0;
        int maxFuelAmount = 100;
        Integer wantedFuel = ScannerUtils.getValidateIntegerWithMessage(MessageValues.FUEL_AMOUNT(3), minFuelAmount, maxFuelAmount);
        int fuelCost = 3;
        int fuelPrice = wantedFuel * fuelCost;
        if (hasEnoughMoney(input, fuelPrice)) {
            output.changeMoney = -fuelPrice;
            output.changeFuel = wantedFuel;
        } else {
            CommunicationUtils.printMessage(MessageValues.NOT_ENOUGH_MONEY);
        }
        return output;
    }

    private boolean hasEnoughMoney(PlaceEventInput input, int fuelPrice) {
        return input.money > fuelPrice;
    }

    public String getEventDescription() {
        return MessageValues.GAS_STATION_DESCRIPTION;
    }

    public PlaceType getType() {
        return PlaceType.GAS_STATION;
    }


}
