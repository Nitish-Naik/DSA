public class factorial 
{
    static int fact_recr(int n)
    {
        if(n == 0)
        {
            return 1;
        }
        return n * fact_recr(n-1);
    }
    static void fact_iter(int n)
    {
        int fact = 1;
        for(int i=1; i<=n; i++)
        {
            fact = fact * i;    
        }
        System.out.println("factorial of "+n+": "+fact);
    }
    public static void main(String[] args) 
    {
        System.out.println(fact_recr(5));
        fact_iter(5);
    }
}
