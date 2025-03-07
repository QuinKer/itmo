package Entities;

import AbstractClasses.BodyPart;
import AbstractClasses.Clothing;
import AbstractClasses.Entity;
import AbstractClasses.Inventory;
import Classes.ClothToColorMatch;
import Enums.Color;
import Enums.Gender;
import Exceptions.BodyPartTypeMismatchException;
import Interfaces.PutOnCloth;
import Items.Beret;
import Items.Chub;
import Items.Jeans;
import Items.Pidjak;

public class Baby extends Entity implements PutOnCloth {
    public Body body;
    public Head head;
    public Legs legs;
    public ForeHead foreHead;
    public EyeBrows eyeBrows;
    public Gender gender;
    public Inv inv;

    public Baby(String name) {
        super(name);
        this.setGender(Gender.MALE);
        head = new Head("голова");
        body = new Body("туловище");
        foreHead = new ForeHead("лоб");
        eyeBrows = new EyeBrows("брови");
        legs = new Legs("ноги");
        inv = new Inv("сумка");
    }

    public class Inv extends Inventory {
        private Entity owner = Baby.this;

        public Inv(String name) {
            super(name);
        }

        public Entity getOwner() {
            return owner;
        }
    };

    public class ForeHead extends BodyPart {
        private Entity owner = Baby.this;

        public ForeHead(String name) {
            super(name);
        }

        public Entity getOwner() {
            return owner;
        }
    }

    public class EyeBrows extends BodyPart {
        private Entity owner = Baby.this;

        public EyeBrows(String name) {
            super(name);
        }

        public Entity getOwner() {
            return owner;
        }
    }

    public class Head extends BodyPart {
        private Entity owner = Baby.this;

        public Head(String name) {
            super(name);
        }

        public Entity getOwner() {
            return owner;
        }
    }

    public class Body extends BodyPart {
        private Entity owner = Baby.this;

        public Body(String name) {
            super(name);
        }

        public Entity getOwner() {
            return owner;
        }
    }

    public class Legs extends BodyPart {
        private Entity owner = Baby.this;

        public Legs(String name) {
            super(name);
        }

        public Entity getOwner() {
            return owner;
        }
    }

    @Override
    public void put_on_clothes(Clothing item, BodyPart body_part) throws BodyPartTypeMismatchException {
        if ((item instanceof Pidjak && body_part != body)
                | (item instanceof Chub && body_part != head)
                | (item instanceof Jeans && body_part != legs)
                | (item instanceof Beret && body_part != head)) {
            throw new BodyPartTypeMismatchException("ВЫ НЕ МОЖЕТЕ НАДЕТЬ ДАННЫЙ ПРЕДМЕТ НА ЭТУ ЧАСТЬ ТЕЛА!");
        }
        item.grab(this);
        body_part.equipedItem = item;
        inv.addItem(item);
        System.out.println("Малыш надел " + item.getName() + " на " + body_part.getName() + ". ");
    }
}
