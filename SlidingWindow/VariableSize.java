import java.util.HashMap;

public class VariableSize {
    public static int longestSubarraySumK(int a[], int k) {
        int left=0, sum=0, maxLength=0;
        for(int right=0; right<a.length; right++) {
            sum += a[right];

            while (sum > k) {
                sum -= a[left];
                left++;
            }

            maxLength = Math.max(maxLength, right-left+1);
        }

        return maxLength;
    }


    public static int smallestSubarraySum(int a[], int k) {
        int left=0; int sum=0; 
        int minLength = Integer.MAX_VALUE;

        for(int right=0; right<a.length; right++) {
            sum += a[right];
            while (sum >= k) {
                minLength = Math.min(minLength, right-left+1);
                sum -= a[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }


    public static int longestSubstringKUnique(String s, int k) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        int left =0, maxLength = -1;
        for(int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            
            
            while(charCount.size() > k) {
                char leftChar = s.charAt(left);
                
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                
                if(charCount.get(leftChar) == 0) charCount.remove(leftChar);
                left++;
            }
            
            if(charCount.size() == k) {
                maxLength = Math.max(maxLength, right-left+1);
            }
        }
        return maxLength;
    }   


    public static int maxSubarraySumAtMostK(int[] a, int k) {

        int left =0; int sum=0; int maxSum=0;

        for(int right=0; right<a.length; right++) {
            sum += a[right];

            while (right - left + 1 > k) {
                sum -= a[left];
                left++;
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }


    public static int countSubarraysSumK(int[] nums, int k) {
        int count =0;
        int sum = 0;

        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        for(int num : nums) {
            sum += num;

            if(sumMap.containsKey(sum - k)) {
                count += sumMap.get(sum-k);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        // int a[] = {1, 2, 3, 4, 5};
        // int k = 8;
        // System.out.println("Longest Subarray Length: " + longestSubarraySumK(a, k));

        // int[] nums = {2, 3, 1, 2, 4, 3};
        // int k = 7;
        // System.out.println("Smallest Subarray Length: " + smallestSubarraySum(nums, k));


        // String s = "aabacbebebe";
        // int k = 3;
        // System.out.println("Longest Substring Length: " + longestSubstringKUnique(s, k));


        // int[] nums = {1, 2, 3, 4, 5};
        // int k = 3;
        // System.out.println("Maximum Sum: " + maxSubarraySumAtMostK(nums, k));


        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println("Subarrays with Sum K: " + countSubarraysSumK(nums, k));
    }
}
