/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysparalleldemo;

import java.security.SecureRandom;
import java.util.List;

/**
 *
 * @author Ykaro
 */
public class SortUtils {
  
    public static int[] generateRandomData(int count) {

        int[] randomData = new int[count];
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < count; i++) {
            randomData[i] = random.nextInt(count);
        }

        return randomData;
    }
    
    public static double desvioPadrao(List<Long> input) {
        if(input.size() == 1) {
            return 0.0;
        } else {
            double mediaAritimetica = mediaAritimetica(input);
            double somatorio = 0l;
            for (int i = 0; i < input.size(); i++) {
                double result = input.get(i) - mediaAritimetica;
                somatorio = somatorio + (result * result);
            }
            return Math.sqrt((double)1/(input.size()-1) * somatorio);
        }
    }
    
    public  static double mediaAritimetica(List<Long> input) {
        double somatorio = 0l;
        for(Long d : input) {
            somatorio +=d;
        }
        return somatorio/input.size();
    }
    
    public static boolean isSorted(int[] input) {

        for (int count = 0; count < input.length - 1; count++) {
            if (input[count] > input[count + 1]) {
                return false;
            }

        }
        return true;
    }
    
    
}
