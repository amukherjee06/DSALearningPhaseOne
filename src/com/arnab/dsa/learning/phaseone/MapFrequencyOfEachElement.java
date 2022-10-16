package com.arnab.dsa.learning.phaseone;

import java.util.HashMap;

public class MapFrequencyOfEachElement {
    public static void main(String[] args) {
        int[] numArray={1,2,1,5,9,17,2,3,1};
        int n=numArray.length;

        countTheFrequency(numArray,n);
    }

    private static void countTheFrequency(int[] numArray, int n) {

        HashMap<Integer,Integer> map=new HashMap<>();

        /*for (int i = 0; i <n ; i++) {
            if(map.get(numArray[i])!=null){
                map.put(numArray[i],map.get(numArray[i])+1);
            }
            else{
                map.put(numArray[i],1);
            }
        }*/
        for (int i = 0; i < n; i++) {
            map.put(numArray[i],map.get(numArray[i])==null?1:map.get(numArray[i])+1);

        }

        //Print the element in the order they appear

        for (int i = 0; i <n ; i++) {
            if (map.get(numArray[i])!=-1){
                System.out.println(numArray[i]+" - "+map.get(numArray[i]));

                map.put(numArray[i],-1);
            }
        }
        System.out.println(map);
    }
}
