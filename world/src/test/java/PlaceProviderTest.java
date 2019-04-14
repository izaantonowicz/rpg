import org.junit.Assert;
import org.junit.Test;
import places.PlaceProvider;
import places.PlaceType;

public class PlaceProviderTest {

    @Test
    public void testOption1(){
        Assert.assertEquals(PlaceType.USED_CAR_DEALER, PlaceProvider.pickPlace(1).getType());
    }

    @Test
    public void testOption2(){
        Assert.assertEquals(PlaceType.SCRAP_HEAP, PlaceProvider.pickPlace(2).getType());
    }

    @Test
    public void testOption3(){
        Assert.assertEquals(PlaceType.SHOP_WITH_PARTS_FOR_THE_TIME_MACHINE, PlaceProvider.pickPlace(3).getType());
    }

    @Test
    public void testOption4(){
        Assert.assertEquals(PlaceType.GAS_STATION, PlaceProvider.pickPlace(4).getType());
    }

    @Test
    public void testOption5(){
        Assert.assertEquals(PlaceType.CAR_REPAIR_SHOP, PlaceProvider.pickPlace(5).getType());
    }

    @Test
    public void testOption6(){
        Assert.assertEquals(PlaceType.RALLY_CAR, PlaceProvider.pickPlace(6).getType());
    }


}
