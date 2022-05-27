package lesson_1;

public class Fruit<N extends Number> {
    private N weight;


    public N getWeight() {
        return weight;
    }

    public void setWeight(N weight) {
        this.weight = weight;
    }
}
