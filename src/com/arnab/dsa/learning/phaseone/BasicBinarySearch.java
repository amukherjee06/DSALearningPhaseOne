package com.arnab.dsa.learning.phaseone;

import java.util.Arrays;

public class BasicBinarySearch {
    public static void main(String[] args) {
        int numArray[]={3, 2, 1, 5, 6, 4};
        int n=numArray.length;
        int x=6;
        System.out.println(basicBinarySearch(numArray,n,x));

        int k=2;
        System.out.println(isKSortedArray(numArray,n,k));

    }

    private static String isKSortedArray(int[] numArray, int n, int k) {

        int aux[]=new int[n];

        for (int i = 0; i < n; i++) {
            aux[i]=numArray[i];
        }

        Arrays.sort(aux);

        for (int i = 0; i <n ; i++) {

            int j=basicBinarySearch(aux,n,numArray[i]);

            if(Math.abs(i-j)>k){
                return "No";
            }
        }

        return "Yes";
    }

    private static int basicBinarySearch(int[] numArray, int n, int x) {

        int low=0;
        int high=n-1;


        while(low<=high){
            int mid=(low+high)/2;
            if(numArray[mid]==x){
                return mid;
            }
           else if(numArray[mid]>x){
               high=mid-1;
            }
           else{
               low=mid+1;
           }
        }
        return -1;
    }
}
