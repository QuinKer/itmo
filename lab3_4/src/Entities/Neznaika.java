package Entities;

import AbstractClasses.*;
import Enums.Gender;
import Exceptions.BodyPartTypeMismatchException;
import Exceptions.TransformMisMatchException;
import Interfaces.PutOnCloth;
import Interfaces.Transformative;
import Items.MagicWand;

import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class Neznaika extends Entity implements PutOnCloth {
    public LeftArm leftArm;
    public RightArm rightArm;
    public Body body;
    public Head head;
    public LeftLeg leftLeg;
    public RightLeg rightLeg;
    public Inv inv;
    public Neznaika(String name) {
        super(name);
        this.setGender(Gender.MALE);
        leftArm = new LeftArm("левая рука");
        rightArm = new RightArm("правая рука");
        head = new Head("голова");
        body = new Body("туловище");
        inv = new Inv("сумка");
    }

    public class Inv extends Inventory{
        private Entity owner = Neznaika.this;

        public Inv(String name) {
           super(name);
        }

        public Entity getOwner() {
            return owner;
        }
    };

    public class LeftArm extends BodyPart {
        private Entity owner = Neznaika.this;

        public LeftArm(String name) {
            super(name);
        }

        public Entity getOwner() {
            return owner;
        }
    }

    public class RightArm extends BodyPart {
        private Entity owner = Neznaika.this;

        public RightArm(String name) {
            super(name);
        }

        public Entity getOwner() {
            return owner;
        }
    }

    public class Head extends BodyPart {
        private Entity owner = Neznaika.this;

        public Head(String name) {
            super(name);
        }

        public Entity getOwner() {
            return owner;
        }
    }

    public class Body extends BodyPart {
        private Entity owner = Neznaika.this;

        public Body(String name) {
            super(name);
        }

        public Entity getOwner() {
            return owner;
        }
    }

    public class LeftLeg extends BodyPart {
        private Entity owner = Neznaika.this;

        public LeftLeg(String name) {
            super(name);
        }

        public Entity getOwner() {
            return owner;
        }
    }

    public class RightLeg extends BodyPart {
        private Entity owner = Neznaika.this;

        public RightLeg(String name) {
            super(name);
        }

        public Entity getOwner() {
            return owner;
        }
    }

    @Override
    public void put_on_clothes(Clothing item, BodyPart body_part) throws BodyPartTypeMismatchException {
        if ((body_part == rightArm)
                | (body_part == leftArm)) {
            throw new BodyPartTypeMismatchException("ВЫ НЕ МОЖЕТЕ НАДЕТЬ ДАННЫЙ ПРЕДМЕТ НА ЭТУ ЧАСТЬ ТЕЛА!");
        }
        item.grab(this);
        body_part.equipedItem = item;
        System.out.println("Незнайка надел на себя " + item.getName());
    }

    public void look_around() {
        System.out.println("Незнайка осмотрелся.");
    }


    public void grab_item(Item item) {
        item.grab(this);
        if (rightArm.equipedItem == null) {
            rightArm.equipedItem = item;
            inv.addItem(item);
            System.out.println(" в правую руку. ");
        }
        else if (leftArm.equipedItem == null) {
            leftArm.equipedItem = item;
            inv.addItem(item);
            System.out.println(" в левую руку. ");
        }
    }

    public void transform_creature(Entity target){
        for(Item item:inv.getItems()){
            if(item instanceof Transformative){
                Random rnd = new Random();
                Integer type = rnd.nextInt(5);
                String transformation;
                if(type >= 2){
                    transformation = "Малыш";
                }
                else{
                    transformation = "Осёл";
                }
                if (transformation.equals(target.getName())){
                    throw new TransformMisMatchException("ВЫ НЕ МОЖЕТЕ ПРЕВРАТИТЬ СУЩЕСТВО " + transformation.toUpperCase(Locale.ROOT) +  " САМО В СЕБЯ!"); // unchecked exception
                }
                ((Transformative) item).transform(this, target);
                System.out.print(" " + transformation + ".");

            }
        }
    };
}

