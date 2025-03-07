package AbstractClasses;

import Entities.Neznaika;

public abstract class BodyPart {
    private String name;

    public Item equipedItem;
    {
        name = "часть тела";
    }

    public BodyPart(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEquipedItemName(){return equipedItem.getName();};
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodyPart bodyPart = (BodyPart) o;
        return name != null && name.equals(bodyPart.name);
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
        return "Часть тела под названием " + name + ".";
    }
}
