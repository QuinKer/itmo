package AbstractClasses;

import Enums.*;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Entity {
    private String name;
    private Location location;
    private Gender gender;

    public Entity(String name){

        this.name = name;

    }

    public void move_to(Location to_what, Time time, RangeType range, InCoords coords){
        System.out.println(this.name + " " +  time.getTitle() + "подошёл " + range.getTitle() + coords.getTitle() +  to_what.getTitle() + ".");
        this.setLocation(to_what);
    }

    public void locate(Time time,RangeType range, InCoords coords){
        System.out.println(this.name + " " +  time.getTitle() + "находился " + range.getTitle() + coords.getTitle() +  this.location.getTitle() + ".");

    }
    public String getLocationTitle() {
        return location.getTitle();
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender.getTitle();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
        return "Меня зовут " + this.getName() + " ,мой пол " + this.getGender();
    }
}
