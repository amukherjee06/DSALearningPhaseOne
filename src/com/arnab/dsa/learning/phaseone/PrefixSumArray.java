package com.arnab.dsa.learning.phaseone;

import java.util.Arrays;

//Input  : arr[] = {10, 20, 10, 5, 15}
//Output : prefixSum[] = {10, 30, 40, 45, 60}
public class PrefixSumArray {
    public static void main(String[] args) {

        int[] inputArray={10, 30, 40, 45, 60};
        int[] prefixSum=generatePrefixSumArray(inputArray);

        Arrays.stream(prefixSum).forEach(System.out::println);
    }

    private static int[] generatePrefixSumArray(int[] inputArray) {

        int[] outputArray=new int[inputArray.length];
        //this is important
        outputArray[0]=inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            outputArray[i]=outputArray[i-1]+inputArray[i];
        }
        return outputArray;
    }
}
