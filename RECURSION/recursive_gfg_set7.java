public class recursive_gfg_set7 
{
    static int fp = 1;
    static int fun(int n)
    {
        int t, f;
        if(n <= 2)
        {
            fp = 1;
            return 1;
        }
        t =fun(n-1);
        f = t+fp;
        fp = t;
        return f;
    }

    static void fun2(int n)
    {
        if(n > 0)
        {
            fun2(n - 1);
            System.out.print(n + " ");
            fun2(n-1);
        }
    }
    public static void main(String[] args) 
    {
        fun2(4);
    }   
}