package lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        // check task 1
        Integer[] intMas = {10, 20, 30, 40};
        String[] stringsMas = {"one", "two", "three"};
        System.out.println(Arrays.deepToString(intMas));
        System.out.println(Arrays.deepToString(stringsMas));
        switchPlace(intMas, 0, intMas.length - 1);
        switchPlace(stringsMas, 1, 0);
        System.out.println(Arrays.deepToString(intMas));
        System.out.println(Arrays.deepToString(stringsMas));

        // check task 2
        ArrayList<String> list = getList(stringsMas);
        ArrayList<Integer> intList = getList(intMas);
        System.out.println(Arrays.deepToString(intList.toArray()));
        System.out.println(Arrays.deepToString(list.toArray()));

        // check task 3
        Box boxOranges = new Box<>();
        boxOranges.add(new Orange());
        boxOranges.add(new Orange());
          // проверка работы метода getWeight();
        System.out.printf("Общий вес: %s\n",
                boxOranges.getWeight());
         // проверка метода compare
        Box boxApple = new Box<>();
        boxApple.add(new Apple());
        boxApple.add(new Apple());
        System.out.println(boxOranges.compare(boxApple));
        boxApple.add(new Apple());
        System.out.println(boxApple.getWeight());
        System.out.println(boxOranges.compare(boxApple));
         // пересыпаем в другую коробку putIntoAnotherBox
        Box appleBox2 = new Box<>();
        appleBox2.add(new Apple());
        System.out.println(boxApple.putIntoAnotherBox(boxOranges));
        System.out.println(boxApple.putIntoAnotherBox(appleBox2));
        System.out.println(appleBox2.getSizeBox());



    }


    //1 Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)
    public static <T> void switchPlace(T[] mass, int one, int two) {
        if (mass.length < one && mass.length < two) {
            throw new IndexOutOfBoundsException();
        } else {
            T temp = mass[one];
            mass[one] = mass[two];
            mass[two] = temp;
        }
    }
    //2 Написать метод, который преобразует массив в ArrayList;
    public static <T> ArrayList getList(T mass){
        ArrayList<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(mass));
        return list;

    }





}
