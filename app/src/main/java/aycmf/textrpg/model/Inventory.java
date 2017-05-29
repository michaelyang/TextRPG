package aycmf.textrpg.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by myang on 5/22/17.
 */

public class Inventory {
    HashMap<Item, Integer> inventory;

    public Inventory() {
        this.inventory = new HashMap<>();
    }

    public void put(Item item) {
        int count = inventory.containsKey(item) ? inventory.get(item) : 0;
        inventory.put(item, count + 1);
    }

    public void remove(Item item) {
        if (inventory.containsKey(item)) {
            int count = inventory.get(item);
            if (count == 1) {
                inventory.remove(item);
            } else {
                inventory.put(item, count - 1);
            }
        }
    }

    public int size() {
        return inventory.size();
    }

    public HashMap<Item, Integer> getHashMap() {
        return inventory;
    }
}
