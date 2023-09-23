import java.util.*;
class linearSearch
{
    public static void printArr(int arr[])
    {
        for(int i: arr)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void LinearSearch(int arr[], int key)
    {
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] == key)
            {
                System.out.print(i);
                arr[i] = Integer.MIN_VALUE;
                continue;
            }
            continue;
        }
        System.out.println(-1);
        return;
    }
    public static void recursiveLinearSearch(int arr[], int key, int i)
    {
        // Base Case
        if(i == arr.length)
        {
            System.out.println(-1);
            return;
        }
        // Recursive Case
        if(arr[i] == key)
        {
            System.out.println(i);
            return;
        }
        recursiveLinearSearch(arr, key, i+1);
    }
    
    
    public static void main(String[] args)
    {
        int arr[] = {5,7,3,9,7,2,5};
        int key = 7;
        System.out.print("Given array :");
        printArr(arr);
        System.out.print("Key found at index : ");
        LinearSearch(arr, key);
        System.out.print("By recursion : ");
        recursiveLinearSearch(arr, key, 0);
    }
}