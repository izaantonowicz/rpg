import org.junit.Assert;
import org.junit.Test;
import places.PlaceEventInput;
import places.PlaceEventOutput;
import places.ScrapHeap;

public class ScrapHeapTest {

    private ScrapHeap scrapHeap = new ScrapHeap();
    private PlaceEventInput input = new PlaceEventInput(null, 0,0,0);

    @Test
    public void test(){
        PlaceEventOutput output = scrapHeap.doSomething(input);
        Assert.assertTrue(output.addItem!=null);
    }
}
