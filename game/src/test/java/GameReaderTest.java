import exception.PlayerNotFoundException;
import game.Game;
import org.junit.Assert;
import org.junit.Test;
import player.Player;
import utils.GameReader;
import utils.GameWriter;

public class GameReaderTest {

    @Test
    public void testWrongFilename() {
        Assert.assertThrows(PlayerNotFoundException.class, () -> GameReader.read("textNotFound"));

    }

    @Test
    public void testExistingFilename() throws PlayerNotFoundException {
        String testFilename = "test";
        Player player = Player.builder().setName("test").build();
        Game game = new Game(player);
        GameWriter.write(game, testFilename);
        Assert.assertNotNull(GameReader.read(testFilename));
    }
}
