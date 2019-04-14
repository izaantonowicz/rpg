import item.Item;
import item.ItemType;
import org.junit.Assert;
import org.junit.Test;
import places.CarRepairShop;
import places.PlaceEventInput;
import places.PlaceEventOutput;

import java.util.ArrayList;


public class CarRepairShopTest {
    CarRepairShop carRepairShop = new CarRepairShop();
    PlaceEventInput input = new PlaceEventInput(null, 0,0,0);

    @Test
    public void testWithNoParts(){
        PlaceEventOutput output = carRepairShop.doSomething(input);
        Assert.assertEquals(output.changeFuel,0);
        Assert.assertEquals(output.changeMoney,0);
        Assert.assertEquals(output.addItem, null);
        Assert.assertEquals(output.gameOver, false);
        Assert.assertEquals(output.levelUp,false);
        Assert.assertEquals(output.win, false);
    }

    @Test
    public void testWin(){
        input.itemList = new ArrayList<>();
        input.itemList.add(new Item(ItemType.ACCELERANT_OF_MODERATOR));
        input.itemList.add(new Item(ItemType.BULBULATOR));
        input.itemList.add(new Item(ItemType.HEADLIGHT_FLUID));
        input.itemList.add(new Item(ItemType.TRI_SHAFT_EXHAUST_FLANGE));
        input.itemList.add(new Item(ItemType.TURBO_ENCABULATOR));
        PlaceEventOutput output = carRepairShop.doSomething(input);
        Assert.assertTrue(output.win);
    }


}
