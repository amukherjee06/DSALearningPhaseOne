package com.arnab.dsa.learning.phaseone;
//To find the subarray
//whose sum is zero

import java.util.Arrays;
import java.util.HashMap;

//P[r]=P[l-1] --> Prefix sum
public class SubarrayWithSumZero {
    public static void main(String[] args) {

        int[] inputArray={15,-2,2,-8,1,7,10,23};
        int[] prefixSum=generatePrefixSumArray_1(inputArray);

        //HashMap<Integer,Integer> map=new HashMap<>();
        int max_len=0;

        for (int i = 0; i < prefixSum.length; i++) {
            if(prefixSum[0]==prefixSum[i]){
                max_len=i;
            }
        }
        System.out.println(max_len);


    }

    private static int[] generatePrefixSumArray_1(int[] inputArray) {
        int[] outputArray=new int[inputArray.length];
        outputArray[0]=inputArray[0];

        for (int i = 1; i < inputArray.length; i++) {
            outputArray[i]=outputArray[i-1]+inputArray[i];
        }
        return outputArray;
    }
}
