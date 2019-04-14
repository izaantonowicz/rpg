package places;

import utils.CommunicationUtils;
import utils.MessageValues;
import utils.RandomBooleanValue;

public class RallyCar extends AbstractPlace implements Place {

    public int competitionFuelCost = 5;
    public int competitionMoney = 20;

    public PlaceEventOutput doSomething(PlaceEventInput input) {
        PlaceEventOutput output = new PlaceEventOutput();

        if(input.fuel < competitionFuelCost){
            CommunicationUtils.printMessage(MessageValues.NOT_ENOUGH_FUEL);
            return output;
        }

        if(input.fuel == competitionFuelCost){
            CommunicationUtils.printMessage(MessageValues.GAME_OVER_FUEL);
            output.gameOver = true;
            return output;
        }

        boolean competition = RandomBooleanValue.getValue();

        if(competition){
            CommunicationUtils.printMessage(MessageValues.COMPETITION_WON);
            output.levelUp = true;
            output.changeMoney = competitionMoney;
        }else{
            CommunicationUtils.printMessage(MessageValues.COMPETITION_LOSE);
        }

        output.changeFuel = -competitionFuelCost;

        return output;
    }

    public String getEventDescription() {
        return MessageValues.RALLY_CAR_DESCRIPTION;
    }

    public PlaceType getType() {
        return PlaceType.RALLY_CAR;
    }


}
