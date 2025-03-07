package Interfaces;

import AbstractClasses.BodyPart;
import AbstractClasses.Clothing;
import Exceptions.BodyPartTypeMismatchException;

public interface PutOnCloth {
    void put_on_clothes(Clothing item, BodyPart bodyPart) throws BodyPartTypeMismatchException;
}
