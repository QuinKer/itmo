package Items;

import AbstractClasses.Clothing;
import AbstractClasses.Entity;

public class Pidjak extends Clothing {
    public Pidjak(String name) {
        super(name);
    }

    @Override
    public void grab(Entity someone) {
        System.out.print(someone.getName() + " взял пиджак.");
    }

}
