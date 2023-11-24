class DutchNationalFlagAlgorithm
{
    public static void main(String[] args) 
    {
        int a[] = {0,2,1,2,0};
        int n =a.length;
        int low=0;
        int mid = 0;
        int high = n-1;
        while (mid <= high) 
        {
            if(a[mid] == 0)
            {
                int temp = a[mid];
                a[mid] = a[low];
                a[low] = temp;
                low++;
                mid++;
            }    
            else if(a[mid] == 1)
            {
                mid++;
            }
            else
            {
                int temp=a[mid];
                a[mid] = a[high];
                a[high] = temp;
                high--;
            }
        }    
        for(int i=0; i<a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }
}