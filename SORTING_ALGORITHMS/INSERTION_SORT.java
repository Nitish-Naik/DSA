public class INSERTION_SORT 
{
    public static void printArr(int a[])
    {
        for(int i=0; i<a.length; i++)
        {
            System.out.print(a[i]+ " ");
        }
        System.out.println();
    }

    public static void insertionSort(int a[])
    {
        for(int i=1; i<a.length; i++)
        {
            int curr = a[i];
            int prev = i-1;
            while(prev >= 0 && a[prev] > curr)
            {
                a[prev+1] = a[prev];
                prev--;
            }
            // insertion
            a[prev+1] = curr;
        }
        printArr(a);
    }
    public static void recursiveInsertionSort(int a[], int i, int n)
    {
        if(i == n)
        {
            return;

        }
        int prev = i;
        while(prev > 0 && a[prev-1] > a[prev])
        {
            int temp = a[prev-1];
            a[prev-1] = a[prev];
            a[prev] = temp;
            prev--;
        }
        recursiveInsertionSort(a, i+1, n);
    }

    public static void main(String[] args)
    {
        int arr[] = {5,4,3,2,1};
        System.out.println("Given array :");
        printArr(arr);
        System.out.println("Sorted array :");
        insertionSort(arr);
        System.out.println("Sorted array By Recursion :");
        insertionSort(arr);
        
    }
}
