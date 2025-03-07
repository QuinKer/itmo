package Items;

import AbstractClasses.Clothing;
import AbstractClasses.Entity;

public class Jeans extends Clothing {
    public Jeans(String name) {
        super(name);
    }

    @Override
    public void grab(Entity someone) {
        System.out.print(someone.getName() + " взял брюки.");
    }

}
