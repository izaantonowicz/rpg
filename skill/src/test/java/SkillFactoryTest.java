import org.junit.Assert;
import org.junit.Test;
import skill.EcoDriver;
import skill.SkillFactory;
import skill.TalkativeDriver;

public class SkillFactoryTest {

    @Test
    public void testEcoDriver(){
        Assert.assertTrue(SkillFactory.createSkill(1) instanceof EcoDriver);
    }

    @Test
    public void testTalkativeDriver(){
        Assert.assertTrue(SkillFactory.createSkill(2) instanceof TalkativeDriver);

    }
}
