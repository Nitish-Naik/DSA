public class QUICK_SORT 
{
    public static void printArr(int arr[])
    {
        for(int i : arr)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i=low-1;
        for(int j=low; j<high; j++)
        {
            if(arr[j] <= pivot)
            {
                i += 1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            printArr(arr);
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    public static void quickSort(int arr[], int low, int high)
    {
        if(low < high)
        {
            int pi  = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
    public static void main(String args[])
    {
        int arr[] = {5,4,3,2,1};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }    
}
