import Classes.ClothToColorMatch;
import Entities.Baby;
import Entities.Donkey;
import Entities.Neznaika;
import Enums.*;
import Exceptions.BodyPartTypeMismatchException;
import Items.*;

public class Main {
    public static void main(String[] args) {
        Donkey donkey = new Donkey("Осёл");
        donkey.locate(Time.STILL, RangeType.NULL, InCoords.BEHIND);
        donkey.move_to(Location.GATE, Time.JUST, RangeType.CLOSER, InCoords.NEXT_TO);
        Neznaika neznaika = new Neznaika("Незнайка");
        MagicWand magicWand = new MagicWand("волшебная палочка");
        neznaika.look_around();
        neznaika.grab_item(magicWand);

        neznaika.transform_creature(donkey);;
        System.out.print("Он взмахнул ею и сказал: Не успел он сказать этих слов, как увидел, что ");
        donkey.transformation();

        Baby baby = new Baby("Малыш");

        System.out.println(" и уже это был не осел,а самый настоящий " + baby.getName() + ".");

        Pidjak pidjak = new Pidjak("пиджак");
        Chub chub = new Chub("чуб");
        Jeans jeans = new Jeans("брюки");
        Beret beret = new Beret("берет");
        BeretBrush beretBrush = new BeretBrush("кисточка");

        ClothToColorMatch bodyCloth = new ClothToColorMatch(baby.body, pidjak, Color.GREEN.getTitle());
        ClothToColorMatch headOnCloth = new ClothToColorMatch(baby.head, beret, Color.BRIGHT_BLUE.getTitle());
        ClothToColorMatch legsCloth = new ClothToColorMatch(baby.legs, jeans, Color.GREENY_YELLOW.getTitle());
        ClothToColorMatch headCloth = new ClothToColorMatch(baby.head, chub, Color.NONE.getTitle());
        ClothToColorMatch headBrush = new ClothToColorMatch(baby.head, beretBrush, Color.ORANGE.getTitle());

        try {
            baby.put_on_clothes(bodyCloth.clothes(), bodyCloth.bodyPart());
            baby.put_on_clothes(headCloth.clothes(), headCloth.bodyPart());
            baby.put_on_clothes(legsCloth.clothes(), legsCloth.bodyPart());
            baby.put_on_clothes(headOnCloth.clothes(), headOnCloth.bodyPart());
        } catch (BodyPartTypeMismatchException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }


        System.out.println("На нём был кургузый " + bodyCloth.color() + " " + bodyCloth.clothes().getName() + ", " + legsCloth.color()+ " " + legsCloth.clothes().getName() + ".");

        System.out.println("На " + headCloth.bodyPart().getName() + " красовался " + headOnCloth.color() + " " +  headOnCloth.clothes().getName() + " с " + headBrush.color() + " горошинами, с такой же " +headBrush.color() + " кисточкой на макушке.");

        System.out.print(InCoords.FROM_UNDER.getTitle().substring(0, 1).toUpperCase() + InCoords.FROM_UNDER.getTitle().substring(1) + headOnCloth.clothes().getName() + " выбивался длинный " + chub.getName() + " и свешивался прямо на " + baby.foreHead.getName() + ", закрывая его до самых " + baby.eyeBrows.getName() + ".");
    }
}