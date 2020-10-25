package Domain.db;

import Domain.Model.Items;

import java.util.ArrayList;

public class ItemsDB {
    ArrayList<Items> itemList;

    public ItemsDB() {
        itemList = new ArrayList<>();
    }

    public void addItem(Items items) {
        if (items == null)
            throw new IllegalArgumentException("item is not valid");

        itemList.add(items);
    }

    public ArrayList<Items> getItemList() {
        return this.itemList;
    }

    public Items Find(String name, String type) {
        for (Items items : itemList) {
            if (items.hasName(name, type)) {
                return items;
            }
        }
        return null;
    }

    public int calculateTotal() {
        int sum = 0;
        for (Items items : itemList) {
            sum = sum + items.getAmount();
        }
        return sum;
    }

    public void delete(Items items){
        itemList.remove(items);
    }


}




