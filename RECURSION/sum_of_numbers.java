public class sum_of_numbers
{
    static int sum_of_number_recr(int n)
    {
        if(n == 1)
        {
            return 1;
        }
        int snm1 = sum_of_number_recr(n-1);
        int sn =  n + snm1;
        return sn;
        
    }
    static int sum_of_number_iter(int n)
    {
        int sum = 0;
        for(int i=1; i<=n; i++)
        {
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) 
    {
        System.out.println(sum_of_number_recr(2));
        System.out.println(sum_of_number_iter(2));
    }   
}
