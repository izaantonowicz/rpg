import item.ItemType;
import org.junit.Assert;
import org.junit.Test;
import places.PlaceEventInput;
import places.PlaceEventOutput;
import places.ShopWithPartsForTheTimeMachine;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ShopWithPartsForTheTimeMachineTest {
    private ShopWithPartsForTheTimeMachine shopWithPartsForTheTimeMachine = new ShopWithPartsForTheTimeMachine();
    private PlaceEventInput input = new PlaceEventInput(null, 0,0,0);

    @Test
    public void noMoneyTest(){
        PlaceEventOutput output = shopWithPartsForTheTimeMachine.doSomething(input);
        Assert.assertFalse(output.win);
    }

    @Test
    public void enoughMoneyTestForTurboEncabulator(){
        input.money = 2000;
        String simulateScannerValue = "1";
        InputStream in = new ByteArrayInputStream(simulateScannerValue.getBytes());
        System.setIn(in);
        PlaceEventOutput output = shopWithPartsForTheTimeMachine.doSomething(input);
        Assert.assertTrue(output.addItem!=null);
        Assert.assertEquals(ItemType.TURBO_ENCABULATOR, output.addItem);
    }
}
