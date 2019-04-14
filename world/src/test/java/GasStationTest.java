import org.junit.Assert;
import org.junit.Test;
import places.GasStation;
import places.PlaceEventInput;
import places.PlaceEventOutput;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GasStationTest {

    GasStation gasStation = new GasStation();
    PlaceEventInput input = new PlaceEventInput(null, 0,0,0);

    @Test
    public void notEnoughMoney(){
        input.money=0;
        String simulateScannerValue = "1";
        InputStream in = new ByteArrayInputStream(simulateScannerValue.getBytes());
        System.setIn(in);
        PlaceEventOutput output = gasStation.doSomething(input);
        Assert.assertEquals(0, output.changeFuel);
    }

    @Test
    public void enoughMoney(){
        input.money=100;
        String simulateScannerValue = "3";
        InputStream in = new ByteArrayInputStream(simulateScannerValue.getBytes());
        System.setIn(in);
        PlaceEventOutput output = gasStation.doSomething(input);
        Assert.assertEquals(3, output.changeFuel);
    }
}
