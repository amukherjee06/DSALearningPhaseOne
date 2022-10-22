package com.arnab.dsa.learning.phaseone.SlidingWindow;

import java.util.ArrayList;

/**
 * Courtesy - Geeksforgeeks
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Output: Sum found between indexes 2 and 4
 * Explanation: Sum of elements between indices 2 and 4 is 20 + 3 + 10 = 33
 *
 * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
 * Output: Sum found between indexes 1 and 4
 * Explanation: Sum of elements between indices 1 and 4 is 4 + 0 + 0 + 3 = 7
 *
 * Input: arr[] = {1, 4}, sum = 0
 * Output: No subarray found
 * Explanation: There is no subarray with 0 sum
 */
public class SubarrayWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        int n=arr.length;
        int sumRequired = 33;
        foundbetweenIndices_2(arr,n,sumRequired);
    }

    private static void foundbetweenIndices(int[] arr, int n, int sumRequired) {

        int sumInProgress=0;

        //Two pointer -
        for (int i = 0; i <n ; i++) {
            sumInProgress=arr[i];
            if(sumInProgress==sumRequired){
                System.out.println("Sum found at index "+i);
                return;
            }
            else{
                for (int j = i+1; j < n; j++) {
                    sumInProgress+=arr[j];
                    if(sumInProgress==sumRequired){
                        System.out.println("Sum found between indices "+i+" and "+j);
                        return;
                    }
                }

            }
        }

        System.out.println("No subarray found");
        return;
    }

    private static int foundbetweenIndices_2(int[] arr, int n, int sumRequired) {

        int sumInProgress=arr[0];
        int start = 0;


        //Two pointer -
        for (int i = 1; i <n ; i++) {

            while((sumInProgress>sumRequired) && (start<i-1)){
                sumInProgress=sumInProgress-arr[start];
                start++;
            }

            if(sumInProgress==sumRequired){
                int p=i-1;
                System.out.println("Sum found between indexes " + start
                        + " and " + p);
                return 1;
            }

            if(i<n){
                sumInProgress+=arr[i];
            }

        }
        System.out.println("No subarray found");
        return 0;
    }
}
