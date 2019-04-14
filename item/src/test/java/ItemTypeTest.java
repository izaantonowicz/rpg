import item.ItemType;
import org.junit.Assert;
import org.junit.Test;

public class ItemTypeTest {

    @Test
    public void randomTypeTest(){
        Assert.assertNotNull(ItemType.randomType());
    }

    @Test
    public void testStringValues(){
        Assert.assertNotNull(ItemType.stringValues());
    }
}
