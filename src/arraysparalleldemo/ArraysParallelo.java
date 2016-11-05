/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysparalleldemo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Ykaro
 */
public class ArraysParallelo {

    public static int[] arraySort;
    public static int[] arrayParallelSort;

    public static void main(String[] args) {

        ArrayList<Long> timeSerial = new ArrayList<Long>();
        ArrayList<Long> timeParallel = new ArrayList<Long>();

        for (int i = 0; i < 1000; i++) {
            arraySort = SortUtils.generateRandomData(1000000);
            arrayParallelSort = Arrays.copyOf(arraySort, arraySort.length);

            long startTime = System.nanoTime();
//            System.out.println(Arrays.toString(arraySort));
            Arrays.sort(arraySort);
//            System.out.println(Arrays.toString(arraySort));
            long endTime = System.nanoTime() - startTime;
            long endTimeMilli = endTime / 1000000;
            System.out.println("Time take in serial: "
                    + endTimeMilli);
            timeSerial.add(endTimeMilli);

            long startTime2 = System.nanoTime();
            System.out.println(Arrays.toString(arrayParallelSort));
            Arrays.parallelSort(arrayParallelSort);
            System.out.println(Arrays.toString(arrayParallelSort));
            long endTime2 = System.nanoTime() - startTime2;
            endTimeMilli = endTime2 / 1000000;
            System.out.println("Time take in parallel: "
                    + endTimeMilli);

            timeParallel.add(endTimeMilli);

        }

        System.out.println("Media Arrays.sort: " + SortUtils.mediaAritimetica(timeSerial));
        System.out.println("Desvio padrão Arrays.sort: " + SortUtils.desvioPadrao(timeSerial));

        System.out.println("Media Arrays.parallelSort: " + SortUtils.mediaAritimetica(timeParallel));
        System.out.println("Desvio padrão Arrays.parallelSort: " + SortUtils.desvioPadrao(timeParallel));

        if (SortUtils.mediaAritimetica(timeParallel) > SortUtils.mediaAritimetica(timeSerial)) {
            System.out.println("Media parallel foi maior");
        } else {
            System.out.println("Media parallel foi menor");
        }
    }
}

