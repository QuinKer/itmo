package Items;

import AbstractClasses.Clothing;
import AbstractClasses.Entity;

public class Beret extends Clothing {
    public Beret(String name) {
        super(name);
    }

    @Override
    public void grab(Entity someone) {
        System.out.print(someone.getName() + " взял берет.");
    }

}
