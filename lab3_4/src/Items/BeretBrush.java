package Items;

import AbstractClasses.Clothing;
import AbstractClasses.Entity;

public class BeretBrush extends Clothing {
    public BeretBrush(String name) {
        super(name);
    }

    @Override
    public void grab(Entity someone) {
        System.out.print(someone.getName() + " взял кисточку от берета.");
    }

}
