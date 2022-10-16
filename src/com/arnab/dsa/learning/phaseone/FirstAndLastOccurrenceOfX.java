package com.arnab.dsa.learning.phaseone;

import java.util.ArrayList;

public class FirstAndLastOccurrenceOfX {

    public static void main(String[] args) {
        int numArray[]={1,2,2,2,3,4,4,5,6};
        int n=numArray.length;
        int x=9;

        System.out.println(findFisrtAndLastOccurrence(numArray,n,x));
    }

    private static ArrayList<Integer> findFisrtAndLastOccurrence(int[] numArray, int n, int x) {

        int lb=lowerBound(numArray,n,x);
        int ub=upperBound(numArray,n,x);
        ArrayList arrList=new ArrayList();

        if(lb==ub){
            //Element is not present
            arrList.add(-1);
            arrList.add(-1);
            return arrList;
        }
        else{
            arrList.add(lb);
            arrList.add(ub-1);
            return arrList;
        }
    }

    //Lower Bound - number>=
    private static int lowerBound(int[] numArray, int n, int x) {
        int low=0;
        int high=n-1;
        int ans=-1;

        while(low<=high) {
            int mid = (low + high) / 2;

            if(numArray[mid]>=x){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private static int upperBound(int[] numArray, int n, int x) {
        int low=0;
        int high=n-1;
        int ans=-1;

        while(low<=high) {
            int mid = (low + high) / 2;

            if(numArray[mid]>x){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
