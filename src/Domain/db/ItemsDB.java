package Domain.db;

import Domain.Model.Items;

import java.util.ArrayList;

public class ItemsDB {
    ArrayList<Items> itemList;

    public ItemsDB() {
        itemList = new ArrayList<>();

        Items item1 = new Items("Abracadabrus", "WonderousItem", 1, "Utility");
        Items item2 = new Items("Adamantine Armor", "Armor", 5, "Heavy defence");
        Items item3 = new Items("Runic Armor", "Armor", 5, "Heavy defence");
        Items item4 = new Items("Health Potion", "Potions", 50, "Restores health");
        Items item5 = new Items("Defence Potion", "Potions", 20, "Increases health");
        Items item6 = new Items("Rusted blade", "Weapon", 10, "Old rusty blade");
        addItem(item1);
        addItem(item2);
        addItem(item3);
        addItem(item4);
        addItem(item5);
        addItem(item6);

    }

        public void addItem(Items items) {
        if (items == null)
            throw new IllegalArgumentException("item is not valid");

        itemList.add(items);
    }

    public ArrayList<Items> getItemList() {
        return this.itemList;
    }

   public int calculateTotal(){
        int sum = 0;
        for (Items items: itemList) {
            sum = sum + items.getAmount();
        }
        return sum;
    }




}

