import java.util.*;
public class binarySearch 
{
    public static int BinarySearch(int arr[], int key, int low, int high)
    {
        // int low = 0;
        // int high = arr.length-1;
        /*
        // Method - 1
        while(low < high)
        {
            int mid = (low + high)/2;
            if(arr[mid] == key)
            {
                return mid;
                // System.out.println(mid);
            }
            else if(arr[mid] < key)
            {
                low = mid + 1;

            }
            else
            {
                high = mid -1;
            }
        }
        return -1;
        */
        // Method - 2 -> (Recursive Approach)
        //  Base Case
        if(low >high)
        {
            return -1;
        }
        // Recursive Case
        int mid = (low + high)/2;
        if(arr[mid] == key)
        {
            return mid;
        }
        if(arr[mid] < key)
        {
            low = mid +1;
        }
        else if(arr[mid] > key)
        {
            high = mid - 1;
        }
        return BinarySearch(arr, key, low, high);
    }
    public static void main(String[] args)
    {
        int arr[] = {2,3,5,6,8,9,75,89,123};
        int key = 75;
        System.out.println(BinarySearch(arr, key, 0, arr.length-1));
    }
}
