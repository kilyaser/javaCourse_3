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
    //Написать метод, который преобразует массив в ArrayList;
    public static <T> ArrayList getList(T mass){
        ArrayList<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(mass));
        return list;

    }





}
