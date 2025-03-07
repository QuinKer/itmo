package Classes;

import AbstractClasses.BodyPart;
import AbstractClasses.Clothing;
import Enums.Color;

public record ClothToColorMatch(BodyPart bodyPart, Clothing clothes, String color) {
}
