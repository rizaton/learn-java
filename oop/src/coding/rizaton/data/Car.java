package coding.rizaton.data;

import coding.rizaton.annotation.Fancy;

@Fancy(name = "Car", tags = {"application", "java"})
public interface Car extends HasBrand, IsMaintenance {

    void drive();

    int getTire();

    default boolean isBig() {
        return false;
    }
}
