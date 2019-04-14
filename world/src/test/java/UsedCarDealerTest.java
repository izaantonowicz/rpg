import org.junit.Assert;
import org.junit.Test;
import places.PlaceEventInput;
import places.PlaceEventOutput;
import places.UsedCarDealer;

public class UsedCarDealerTest {
    private UsedCarDealer usedCarDealer = new UsedCarDealer();
    private PlaceEventInput input = new PlaceEventInput(null, 0,0,0);

    @Test
    public void testNoItems() {
        PlaceEventOutput output = usedCarDealer.doSomething(input);
        Assert.assertTrue(output.addItem == null);
        Assert.assertTrue(output.removeItem == null);
    }
}
