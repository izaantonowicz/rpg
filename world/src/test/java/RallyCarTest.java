
import org.junit.Assert;
import org.junit.Test;
import places.PlaceEventInput;
import places.PlaceEventOutput;
import places.RallyCar;

public class RallyCarTest {

    private RallyCar rallyCar = new RallyCar();
    private PlaceEventInput input = new PlaceEventInput(null, 0,0,0);

    @Test
    public void notEnoughFuel() {
        input.fuel = 0;
        PlaceEventOutput output = rallyCar.doSomething(input);
        Assert.assertFalse(output.levelUp);
        Assert.assertEquals(0, output.changeMoney);
        Assert.assertFalse(output.levelUp);
    }

    @Test
    public void testGameOver() {
        input.fuel = 5;
        PlaceEventOutput output = rallyCar.doSomething(input);
        Assert.assertTrue(output.gameOver);
    }

    @Test
    public void testEnoughFuel() {
        input.fuel = 50;
        PlaceEventOutput output = rallyCar.doSomething(input);
        Assert.assertFalse(output.gameOver);
    }
}
