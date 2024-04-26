import java.util.*;
public class recursive_set5_gfg 
{
    static int fun1(int a, int b)
    {
        if(b == 0) return 0;
        if(b % 2 == 0) return fun1(a+a, b/2);
        
        return fun1(a + a, b/2) + a;
    }

    static int fun2(int a, int b)
    {
        if(b == 0)
        {
            return 1;
        }
        if(b % 2 == 0) return fun2(a*a, b/2);

        return fun2(a*a, b/2) *a;
    }

    static int fun3(int n)
    {
        if(n > 100) return n-10;
        return fun3(fun3(n + 11));
    }
    public static void main(String[] args) 
    {
        System.out.println(fun3(99));
    }
}