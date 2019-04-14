package player;

import item.Item;
import item.ItemType;
import skill.DriverSkill;
import utils.CommunicationUtils;
import utils.MessageValues;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable{
    private List<DriverSkill> skills;
    private List<Item> items;
    private String name;
    private Integer fuelPoints;
    private Integer moneyPoints;
    private Integer level = 0;

    public String getName() {
        return this.name;
    }

    public List<DriverSkill> getSkills() {
        return skills;
    }

    public List<Item> getItems() {
        return items;
    }

    public Integer getFuelPoints() {
        return fuelPoints;
    }

    public Integer getMoneyPoints() {
        return moneyPoints;
    }

    public Integer getLevel() {
        return level;
    }

    public Player(List<DriverSkill> skills, List<Item> items, String name, Integer fuealPoints, Integer moneyPoints) {
        this.skills = skills;
        this.items = items;
        this.name = name;
        this.fuelPoints = fuealPoints;
        this.moneyPoints = moneyPoints;
    }

    public static PlayerBuilder builder() {
        return new PlayerBuilder();
    }

    public static class PlayerBuilder {
        private List<DriverSkill> skills;
        private List<Item> items;
        private String name;
        private Integer fuealPoints;
        private Integer moneyPoints;

        private PlayerBuilder() {
            this.skills = new ArrayList<>();
            items = new ArrayList<>();
        }

        public PlayerBuilder addSkill(DriverSkill skill) {
            this.skills.add(skill);
            return this;
        }

        public PlayerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder setFuelPoints(boolean fuel) {
            if (fuel)
                this.fuealPoints = 100;
            else
                this.fuealPoints = 50;
            return this;
        }

        public PlayerBuilder setMoneyPoints(boolean money) {
            if (money)
                this.moneyPoints = 100;
            else
                this.moneyPoints = 50;
            return this;
        }

        public PlayerBuilder addItem(Item item) {
            this.items.add(item);
            return this;
        }

        public Player build() {
            return new Player(skills, items, name, fuealPoints, moneyPoints);
        }
    }

    public void addItem(final ItemType itemType) {
        if (items.stream().anyMatch(i -> i.getType().equals(itemType))) {
            for (Item item : items) {
                if (item.getType().equals(itemType)) {
                    item.increaseAmount();
                }
            }
        } else {
            this.items.add(new Item(itemType));
        }
    }

    public void removeItem(ItemType itemType) {
        Item itemToRemove = null;
        if (items.stream().anyMatch(i -> i.getType().equals(itemType))) {
            for (Item item : items) {
                if (item.getType().equals(itemType)) {
                    if (item.getCount().equals(1)) {
                        itemToRemove = item;
                    } else {
                        item.decreaseAmount();
                    }
                }
            }
        }

        if (itemToRemove != null) {
            items.remove(itemToRemove);
        }
    }

    public void printStatistics() {
        StringBuilder sb = new StringBuilder("");
        sb.append(MessageValues.LEVEL)
                .append(level)
                .append(MessageValues.NEW_LINE)
                .append(MessageValues.FUEL)
                .append(fuelPoints)
                .append(MessageValues.NEW_LINE)
                .append(MessageValues.MONEY)
                .append(moneyPoints)
                .append(MessageValues.NEW_LINE);
        items.forEach(i -> sb.append(i.getType()).append(MessageValues.SEPARATOR).append(i.getCount()).append(MessageValues.NEW_LINE));
        CommunicationUtils.printMessage(sb.toString());

    }

    public void changeFuel(int change){
        this.fuelPoints+=change;
    }

    public void changeMoney(int money){
        this.moneyPoints+=money;
    }

    public void levelUp(){
        this.level+=1;
    }



}
