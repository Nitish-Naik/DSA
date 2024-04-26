public class recursive_gfg_set3
{
    static void func1(int n)
    {
        if(n > 1)
        {
            func1(n-1);
        }
        for(int i=0; i<n; i++)
        {
            System.out.print(" " + n);
        }
    }
    static int LIMIT = 1000;
    static void func2(int n)
    {
        if(n <= 0) return;
        if(n > LIMIT) return;
        System.out.print(String.format("%d ", n));
        func2(2 * n);
        System.out.print(String.format("%d ", n));
    }


    public static void main(String[] args) 
    {
        // func1(5);
        // func2(5);

    }
}