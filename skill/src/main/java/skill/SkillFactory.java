package skill;

public class SkillFactory {

    public static DriverSkill createSkill(Integer value) {
        DriverSkill driverSkill;
        if (value.equals(1)) {
            driverSkill = new EcoDriver();
        } else {
            driverSkill = new TalkativeDriver();
        }
        return driverSkill;
    }

}
