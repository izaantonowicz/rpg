package places;

import item.Item;

import java.util.List;

public class PlaceEventInput {
    public List<Item> itemList;
    public int money;
    public int fuel;
    public int level;

    public PlaceEventInput(List<Item> itemList, int money, int fuel, int level) {
        this.itemList = itemList;
        this.money = money;
        this.fuel = fuel;
        this.level = level;
    }
}
