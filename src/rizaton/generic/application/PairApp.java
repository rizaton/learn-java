package rizaton.generic.application;

import rizaton.generic.Pair;

public class PairApp {
    public static void main(String[] args) {

        Pair<String, Integer> pairData = new Pair<String, Integer>("first", 1);
        System.out.println(pairData.getFirstData());
        System.out.println(pairData.getSecondData());
    }
}
