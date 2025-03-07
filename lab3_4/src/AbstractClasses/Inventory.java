package AbstractClasses;

import java.util.ArrayList;

public abstract class Inventory {
        private ArrayList<Item> items;
        private String name;

        public Inventory(String name) {
            this.name = name;
            items = new ArrayList<>();
        }

        public String getName(){
        return name;
    }

        public void setName(String name){
        this.name = name;
    }

        public void addItem(Item item) {
            items.add(item);
        }

        public void removeItem(Item item) {
            items.remove(item);
        }

        public ArrayList<Item> getItems() {
            return items;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return name != null && name.equals(entity.getName());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Инвентарь под названием " + name + ".";
    }
}
