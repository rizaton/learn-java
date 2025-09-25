package rizaton.generic;

public class Pair<T, U> {

    private T firstData;

    private U secondData;

    public T getFirstData() {
        return firstData;
    }

    public void setFirstData(T firstData) {
        this.firstData = firstData;
    }

    public U getSecondData() {
        return secondData;
    }

    public void setSecondData(U secondData) {
        this.secondData = secondData;
    }

    public Pair(T firstData, U secondData) {
        this.firstData = firstData;
        this.secondData = secondData;
    }
}
