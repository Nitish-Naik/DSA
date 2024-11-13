public class FixedSize {
    public static int maxsum(int a[], int k) {
        int n = a.length;
        if(n < k) {
            throw new IllegalArgumentException("Array size must be greater than or equal to k.");
        }
        int maxSum = 0;
        for(int i=0; i<k; i++) {
            maxSum += a[i];
        }

        int windowSum = maxSum;
        for(int i=k; i<n; i++) {
            windowSum += a[i] - a[i-k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }



    public static int countTargetSumSubarrays(int a[], int target, int k) {
        int count = 0;

        int n = a.length;
        int maxSum = 0;
        for(int i =0; i<k; i++) {
            maxSum += a[i];
        }
        if(maxSum == target) count++;
        int windowSum = maxSum;
        for(int i=k; i<n; i++) {
            windowSum += a[i]-a[i-k];
            if(windowSum == target) count++;
        }
        return count; 
    }

    public static double maxAverageSubarray(int a[], int k) {

        int n = a.length;
        if (n < k) {
            throw new IllegalArgumentException("Array size must be greater than or equal to k.");
        }
        int totalSum = 0;
        int maxSum = 0;
        for(int i=0; i<k; i++) {
            maxSum += a[i];
        }
        int windowSum = maxSum;
        for(int i=k; i<n; i++) {
            windowSum += a[i]-a[i-k];
            totalSum += windowSum;
        }

        return totalSum / n;
    }

    public static void main(String[] args) {
        // int[] a = {2, 1, 5, 1, 3, 2};
        // int k = 3;
        // System.out.println("Maximum sum of subarrays of size " + k + ": " + maxsum(a, k));
        // int[] a = {1, 2, 3, 4, 5, 6, 3, 3};
        // int k = 3;
        // int target = 9;
        // System.out.println("Count of subarrays with target sum: " + countTargetSumSubarrays(a, target, k));


        int[] a = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println("Maximum average of subarrays of size " + k + ": " + maxAverageSubarray(a, k));
    }
}