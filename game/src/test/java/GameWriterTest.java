import game.Game;
import org.junit.Assert;
import org.junit.Test;
import player.Player;
import utils.GameWriter;

public class GameWriterTest {
    @Test
    public void test(){
        Player player = Player.builder().setName("test").build();
        Game game = new Game(player);
        boolean checkValue = GameWriter.write(game, "test");
        Assert.assertTrue(checkValue);
    }
}
