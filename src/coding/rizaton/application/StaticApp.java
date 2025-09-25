package coding.rizaton.application;

import static coding.rizaton.data.Application.PROCESSORS;
import static coding.rizaton.data.Constant.*;
import coding.rizaton.data.Country;
import coding.rizaton.util.MathUtil;

public class StaticApp {

    public static void main(String[] args) {

        System.out.println(APPLICATION);
        System.out.println(VERSION);

        System.out.println(
                MathUtil.sum(1,2,3,4,5)
        );

        Country.City city = new Country.City();
        city.setName("Jakarta");

        System.out.println(city.getName());

        System.out.println(PROCESSORS);

    }
}
