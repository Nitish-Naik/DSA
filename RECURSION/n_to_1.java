public class n_to_1 
{
    public static void one_to_n(int n)
    {
        if(n != 0)
        {
            one_to_n(n-1);
            System.out.print(n + " ");
        }
    }
    
    public static void n_to_one(int n)
    {
        if(n != 0)
        {
            System.out.print(n + " ");
            n_to_one(n-1);
        }
    }
    public static void main(String[] args) 
    {
        int n = 5;
        one_to_n(n);
        System.out.println();
        n_to_one(n);
    }
}
