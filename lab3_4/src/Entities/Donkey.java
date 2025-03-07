package Entities;

import AbstractClasses.BodyPart;
import AbstractClasses.Entity;
import Enums.Gender;
import Enums.Location;
public class Donkey extends Entity {
    public BackLegs backLegs;
    public FrontLegs frontLegs;


    public Donkey(String name){
        super(name);
        this.setGender(Gender.MALE);
        this.setLocation(Location.FENCE);
        backLegs = new BackLegs("задние ноги");
        frontLegs = new FrontLegs("передние ноги");
    }

    public class BackLegs extends BodyPart {
        private Entity owner = Donkey.this;

        public BackLegs(String name) {
            super(name);
        }

        public Entity getOwner() {
            return owner;
        }
    }

    public class FrontLegs extends BodyPart {
        private Entity owner = Donkey.this;

        public FrontLegs(String name) {
            super(name);
        }

        public Entity getOwner() {
            return owner;
        }
    }

    public void transformation(){
        System.out.print(this.getName() + " приподнялся на " + backLegs.getName() + "...");
    }
}
