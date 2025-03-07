package AbstractClasses;

import Entities.Neznaika;
import Interfaces.Grabable;

import java.util.Objects;

public abstract class Item implements Grabable {
    private String name;

    public Item(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Item comparable = (Item) o;
        return this.getName() != null && this.getName().equals(comparable.getName());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.getName() == null) ? 0 : this.getName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Данный предмет называется " + name + ".";
    }
}
