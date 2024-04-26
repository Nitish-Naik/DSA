public class recursive_set4_gfg 
{
    static void fun1(int x)
    {
        if(x > 0)
        {
            fun1(--x);
            System.out.print(x + " ");
            fun1(--x);
        }
    }

    static int func2(int a[], int n)
    {
        int x;
        if(n == 1) return a[0];
        else
        {
            x = func2(a, n-1);
        }
        if(x > a[n-1])
        {
            return x;
        }
        else
        {
            return a[n-1];
        }
    }

    static int fun3(int i)
    {
        if(i % 2 == 1) return (i++);
        else return fun3(fun3(i-1));
    }
    public static void main(String[] args) 
    {
        // fun1(4);
        // int arr[] = {12, 10, 30, 50, 100};
        // System.out.println(" "+func2(arr, 5)+" ");
        System.out.println(" " + fun3(200) + " ");
    }   
}