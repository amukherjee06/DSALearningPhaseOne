package com.arnab.dsa.learning.phaseone;

/**
 * Courtesy - Geeksforgeeks
 * Input: arr[] = {1, 2, 1}, D = 2
 * Output: 3
 * Explanation:
 * Consider the minimum weight required by the boat as 3, then below is the order of
 * weights such all the weight can be shipped within D(= 2) days:
 * Day 1: Ship the weights of values 1 and 2 on the first day as the sum of weights 1 + 2 = 3(<= 3).
 * Day 2: Ship the weights of value 1 on the second day as the sum of weights 1(<= 3).
 * Considering the minimum weight amount as 3, ships all the weight within D(= 2) days. Therefore, print 3.
 *
 * Input: arr[] = {9, 8, 10}, D = 3
 * Output: 10
 */
public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        int[] array = {};
        int n = array.length;
        int d = 1;
        int cap = findTheCapacity(array, n, d);
        System.out.println(requiredNumberOfDays(cap, array, n));
    }


    private static int requiredNumberOfDays(int cap, int[] array, int n) {

        int requiredDays = 1;
        int remainingCap = cap;

        for (int i = 0; i < n; i++) {
            if (array[i] < remainingCap) {
                remainingCap -= array[i];
            } else {
                requiredDays++;
                remainingCap = cap;
                remainingCap -= array[i];
            }

        }
        return requiredDays;
    }

    /**
     * Min capacity = Largest element of the array
     * Max Capacity = Sum of the array
     *
     * @param array
     * @param n
     * @param d
     * @return
     */
    private static int findTheCapacity(int[] array, int n, int d) {

        int minCapacity = -1;
        int maxCapacity = 0;
        int ans = minCapacity;
        for (int i = 0; i < n; i++) {
            maxCapacity += array[i];
            minCapacity = Math.max(minCapacity, array[i]);

            int start = minCapacity;
            int end = maxCapacity;



            while (start <= end) {
                int guessedCapacity = start + (end - start) / 2;
                int days = requiredNumberOfDays(guessedCapacity, array, n);
                if (days > d) {
                    start = guessedCapacity + 1;
                } else {
                    ans = Math.min(ans, guessedCapacity);
                    end = end - 1;
                }

            }

        }
        return ans;
    }
}
