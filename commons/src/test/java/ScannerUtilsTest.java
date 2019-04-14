import org.junit.Assert;
import org.junit.Test;
import utils.ScannerUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScannerUtilsTest {

    private String testMessage = "TEST MESSAGE";

    @Test
    public void getValidateStringWithMessage() {
        String simulateScannerValue = "string";
        InputStream in = new ByteArrayInputStream(simulateScannerValue.getBytes());
        System.setIn(in);
        Assert.assertEquals(simulateScannerValue, ScannerUtils.getValidateStringWithMessage(testMessage));
    }

    @Test
    public void getValidateIntegerWithMessageMinMax() {
        String simulateScannerValue = "1";
        InputStream in = new ByteArrayInputStream(simulateScannerValue.getBytes());
        System.setIn(in);
        Assert.assertEquals(Integer.valueOf(simulateScannerValue), ScannerUtils.getValidateIntegerWithMessage(testMessage, 1, 2));
    }

    @Test
    public void getValidateIntegerWithMessageRange() {
        String simulateScannerValue = "1";
        InputStream in = new ByteArrayInputStream(simulateScannerValue.getBytes());
        System.setIn(in);
        List<Integer> range = IntStream.rangeClosed(1, 2)
                .boxed().collect(Collectors.toList());
        Assert.assertEquals(Integer.valueOf(simulateScannerValue), ScannerUtils.getValidateIntegerWithMessage(testMessage, range));
    }
}
