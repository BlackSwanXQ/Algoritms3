package com.example.Algoritms3;

import com.example.Algoritms3.MyArrayList3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Algoritms3Application {

    public static void main(String[] args) {
        MyArrayList3 myArrayList = new MyArrayList3(8);
        myArrayList.add(8);
        myArrayList.add(4);
        myArrayList.add(7);
        myArrayList.add(9);
        myArrayList.add(3);
        myArrayList.add(6);
        myArrayList.add(8);
        myArrayList.add(4);
        myArrayList.add(7);
        myArrayList.add(9);
        myArrayList.add(3);
        myArrayList.add(6);

//        myArrayList.add("F");
//        myArrayList.add("G");

//        myArrayList.set(1, 333);
        myArrayList.add(3, 55);
        myArrayList.add(5, 66);
        myArrayList.add(6, 77);

        System.out.println("contains " + myArrayList.contains(7));

        System.out.println("kk " + Arrays.toString(myArrayList.toArray()));

        System.out.println("indexOf " + myArrayList.indexOf(7));

        long start = System.currentTimeMillis();
        Algoritms3Application.sortBubble(getArr());
        System.out.println(System.currentTimeMillis() - start);
        long start1 = System.currentTimeMillis();
        Algoritms3Application.sortSelection(getArr());
        System.out.println(System.currentTimeMillis() - start1);
        long start2 = System.currentTimeMillis();
        Algoritms3Application.sortInsertion(getArr());
        System.out.println(System.currentTimeMillis() - start2);
        long start3 = System.currentTimeMillis();
        Algoritms3Application.quickSort(getArr(), 0, getArr().length - 1);
        System.out.println(System.currentTimeMillis() - start3);
    }

    ////  Пузырьковая сортировка
    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    ////  Сортировка выбором
    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    //// Сортировка вставкой
    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    ////   Быстрая рекурсивная сортировка
    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }


    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private static int[] getArr() {
        Random random = new Random();
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000);
        }
        return arr;
    }

}




