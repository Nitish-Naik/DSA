import java.util.*;
public class BUBBLE_SORT 
{
    public static void printArr(int arr[])
    {
        for(int i: arr)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void bubbleSort(int arr[])
    {
        for(int i=0; i<arr.length-1; i++)
        {
            for(int j = i+1; j<arr.length; j++)
            {
                if(arr[i] > arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                System.out.println();
            }
        }
        printArr(arr);
    }
    public static void recursiveBubbleSort(int arr[], int n)
    {
        // Base Case
        if(n == 1)
        {
            return;
        }

        // Recursive Case
        for(int i=0; i<n-1; i++)
        {
            if(arr[i] > arr[i+1])
            {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        recursiveBubbleSort(arr, n-1);
    }
    public static void main(String args[])
    {
        int arr[] = {9, 5, 3,7, -1};
        // Method - 1
        System.out.println("Given Array : ");
        printArr(arr);
        System.out.println("Sorted array : ");
        bubbleSort(arr);
        // Method - 2 ->(Recursive Bubble Sort)
        System.out.println("By Recursive Bubble Sort :");
        recursiveBubbleSort(arr, arr.length);
        System.out.println("Sorted array : ");
        printArr(arr);
    }    
}
