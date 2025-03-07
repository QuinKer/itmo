package Items;

import AbstractClasses.Clothing;
import AbstractClasses.Entity;

public class Chub extends Clothing {
    public Chub(String name) {
        super(name);
    }

    @Override
    public void grab(Entity someone) {
        System.out.print(someone.getName() + " взял чуб.");
    }

}
