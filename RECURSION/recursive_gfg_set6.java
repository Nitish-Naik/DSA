import java.util.*;
public class recursive_gfg_set6 
{
    // doubt
    static void abc(String s) 
    {
        if(s.length() == 0)
            return;

        abc(s.substring(1));
        abc(s.substring(1));
        System.out.println(s.charAt(0));    
    }

    static int fun(int count)
    {
        System.out.println(count);
        if(count < 3)
        {
            fun(fun(fun(++count)));
        }
        return count;
    }
    public static void main(String[] args) 
    {
        System.out.println(fun(1)); 
    }    
}