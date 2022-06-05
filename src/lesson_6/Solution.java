package lesson_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
         Solution solution = new Solution();
         int[] test = {5, 4, 1, 7, 4, 14, 8};
         int[] mas = solution.sortedMass(test);
         System.out.println(Arrays.toString(mas));
         System.out.println(solution.checkOneOrFour(test));
         System.out.println(solution.checkOneOrFour(mas));



    }

    public boolean checkOneOrFour(int[] mas){
        ArrayList<Integer> tempResul = new ArrayList<>();
        for (int i = 0; i < mas.length; i++) {
            if(mas[i] == 1 || mas[i] == 4){
                tempResul.add(mas[i]);
            }
        }

        return !tempResul.isEmpty();
    }

    public int[] sortedMass(int[] mas){
        ArrayList<Integer> tempResult = new ArrayList<>();
        boolean flag = false;
        while (!flag){
            for(int i = mas.length - 1; i >= 0; i--){
                if (mas[i] == 4){
                    flag = true;
                    break;
                }
                tempResult.add(mas[i]);
            }
            flag = true;
        }
        Collections.reverse(tempResult);
        int[] result = new int[tempResult.size()];
        for (int i = 0; i < tempResult.size(); i++) {
            result[i] = tempResult.get(i);
        }
        return  result;
    }

}
