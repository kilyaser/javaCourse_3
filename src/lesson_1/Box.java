package lesson_1;

import java.util.ArrayList;

public class Box<F extends Fruit> {
    private ArrayList<F> fruitBox;


    public Box() {
        fruitBox = new ArrayList<>();
    }
    public void add(F fruit) {
        if(!fruitBox.isEmpty()) {
            if (fruit instanceof Orange & fruitBox.get(0) instanceof Orange) {
                fruitBox.add(fruit);
            } else if (fruit instanceof Apple & fruitBox.get(0) instanceof Apple) {
                fruitBox.add(fruit);
            } else {
                throw new ClassCastException();
            }
        } else {
            fruitBox.add(fruit);
        }

    }
    public int getSizeBox(){
        return fruitBox.size();
    }

    public float getWeight(){
        float weight = 0f;
        if(!fruitBox.isEmpty()){
        weight =  fruitBox.size() * 1.0f * fruitBox.get(0).getWeight().floatValue();
        }
        return  weight;
    }
    public boolean compare(Box box){
        return this.getWeight() == box.getWeight();
    }
    public boolean putIntoAnotherBox(Box box){
        if(box.fruitBox.get(0) instanceof Orange & this.fruitBox.get(0) instanceof Orange){
            box.fruitBox.addAll(this.fruitBox);
            this.fruitBox.clear();
            return true;
        } else if(box.fruitBox.get(0) instanceof Apple & this.fruitBox.get(0) instanceof Apple) {
            box.fruitBox.addAll(this.fruitBox);
            this.fruitBox.clear();
            return true;
        } else {
            //throw new IllegalArgumentException();
            return false;
        }

    }


}
