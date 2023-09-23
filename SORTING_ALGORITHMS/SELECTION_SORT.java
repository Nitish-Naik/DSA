import java.util.*;
public class SELECTION_SORT 
{
    public static void printArr(int arr[])
    {
        for(int i: arr)
        
            System.out.print(i + " ");
        
        System.out.println();
    }
    public static void selectionSort(int arr[])
    {
        for(int i=0; i<arr.length; i++)
        {
            int min_idx = i;
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[min_idx] > arr[j])
                {
                    min_idx = j;
                }
                int temp = arr[i];
                arr[i] = arr[min_idx];
                arr[min_idx] = temp;
            }
        }
    }
    public static void recursiveSelectionSort(int arr[], int i)
    {
        // Base Case
        if(i == arr.length)
        {
            return;
        }
        // Recursive Case
        int min_idx = i;
        for(int j=0; j<arr.length; j++)
        {
            if(arr[min_idx] < arr[j])
            {
                min_idx = j;
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
        recursiveSelectionSort(arr, i+1);
    }
    public static void main(String[] args)
    {
        int arr[] = {9, 5, 3,7, -1};
        System.out.print("Original Array : ");
        printArr(arr);
        System.out.println("Sorted array : ");
        selectionSort(arr);
        printArr(arr);
        System.out.println("Sorted array by Recursive Case : ");
        recursiveSelectionSort(arr, 0);
        printArr(arr);
    }
}
