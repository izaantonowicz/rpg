package item;

import java.io.Serializable;

public class Item implements Serializable {
    ItemType type;
    Integer count;

    public Item(ItemType type) {
        this.type = type;
        this.count = 1;
    }

    public ItemType getType() {
        return type;
    }

    public Integer getCount() {
        return count;
    }

    public void increaseAmount() {
        this.count++;
    }

    public void decreaseAmount() {
        this.count--;
    }
}
