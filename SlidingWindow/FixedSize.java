
    public static ArrayList<Integer> countDistinct(int k, int[] a) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        // Initialize the frequency map for the first window
        for (int i = 0; i < k; i++) {
            freqMap.put(a[i], freqMap.getOrDefault(a[i], 0) + 1);
        }
        result.add(freqMap.size()); // Add the count of distinct elements in the first window
        
        // Slide the window
        for (int i = k; i < a.length; i++) {
            // Remove the element going out of the window
            int outgoing = a[i - k];
            freqMap.put(outgoing, freqMap.get(outgoing) - 1);
            if (freqMap.get(outgoing) == 0) {
                freqMap.remove(outgoing);
            }
            
            // Add the new element coming into the window
            int incoming = a[i];
            freqMap.put(incoming, freqMap.getOrDefault(incoming, 0) + 1);
            
            // Add the distinct count for the current window
            result.add(freqMap.size());
        }
        
        return result;
    }


    public static int countDistinctOccurences(int a[]) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : a) {
            set.add(num);
        }
        return set.size();
        
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


        // int[] a = {1, 12, -5, -6, 50, 3};
        // int k = 4;
        // System.out.println("Maximum average of subarrays of size " + k + ": " + maxAverageSubarray(a, k));

        int []nums = {1, 2, 1, 3, 4, 2, 1};
        // int x = 1;
        int k = 4;
        // countOccurences(nums, k, x);

        countDistinctOccurencesInSubarray(nums, k);
    }
}