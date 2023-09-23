import java.util.*;
public class MERGE_SORT 
{
    public static void printArr(int arr[])
    {
        for(int i: arr)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    // Method - 1
    
	public static void merge1(int arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		// Create temp arrays
		int L[] = new int[n1];
		int R[] = new int[n2];

		// Copy data to temp arrays
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		// Merge the temp arrays

		// Initial indices of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of L[] if any
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		// Copy remaining elements of R[] if any
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
    }

	// Main function that sorts arr[l..r] using
	// merge()
	static void mergeSort1(int arr[], int l, int r)
	{
		if (l < r) {

			// Find the middle point
			int m = l + (r - l) / 2;

			// Sort first and second halves
			mergeSort1(arr, l, m);
			mergeSort1(arr, m + 1, r);

			// Merge the sorted halves
			merge1(arr, l, m, r);
		}
    }
    
    // Method - 2
    public static void mergeSort2(int arr[], int si, int ei)
    {
        // si == start index
        // ei == end index 
        if(si < ei)
        {
            int mid = si + (ei - si)/2;
            mergeSort2(arr, si, mid);
            mergeSort2(arr, mid + 1, ei);
            merge2(arr, si, mid, ei);
        }
    }
    public static void merge2(int arr[], int si, int mid, int ei)
    {
        int temp[] = new int[ei - si + 1];
        int i=si;
        int j=mid+1;
        int k=0;
        while(i <= mid && j<=ei)
        {
            if(arr[i]<arr[j])
            {
                temp[k++] = arr[i++];
            }
            else
            {
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid)
        {
            temp[k++] = arr[i+1];
        }
        while(j<=ei)
        {
            temp[k++] = arr[j++];

        }

        for(int p=0, q=si; p<temp.length; p++, q++)
        {
            arr[q] = temp[p];
        }
    }
	public static void main(String args[])
	{
		int arr[] = { 12, 11, 13, 5, 6, 7 };
        // Method - 1
		System.out.println("Given array is");
		printArr(arr);
		mergeSort1(arr, 0, arr.length - 1);
		System.out.println("\nSorted array is");
		printArr(arr);
        // Method - 2
        System.out.println("Given array is");
		printArr(arr);
		mergeSort2(arr, 0, arr.length - 1);
		System.out.println("\nSorted array is");
		printArr(arr);
	}
}
