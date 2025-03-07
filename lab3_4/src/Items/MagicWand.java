package Items;

import AbstractClasses.Entity;
import AbstractClasses.Item;
import Interfaces.Transformative;

public class MagicWand extends Item implements Transformative {
    public MagicWand(String name) {
        super(name);
    }

    @Override
    public void grab(Entity someone) {
        System.out.print(someone.getName() + " вытащил волшебную палочку");
    };

    @Override
    public void transform(Entity caster,Entity target) {
        System.out.print(caster.getName() + " превратил " + target.getName() + " в");
    }
}
