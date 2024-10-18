/**
 * Sum_triangle_from_array gfg
 */
import java.util.*;
public class Sum_triangle_from_array {
    public static void sum_triangle(int a[]) {
        if(a.length == 1) {
            return;
        }

        int ans[] = new int[a.length-1];
        for(int i=0; i<a.length-1; i++) {
            ans[i] = a[i] + a[i+1];
        }
        sum_triangle(ans);
        System.out.print(Arrays.toString(a));
    }
    public static void main(String[] args) {
        int a[] = {4, 7, 3, 6, 7};
        sum_triangle(a);
    }
}

/*
 * Output : [48]
         [20, 28] 
         [8, 12, 16] 
         [3, 5, 7, 9] 
         [1, 2, 3, 4, 5] 

Explanation :
Here,   [48]
        [20, 28] -->(20 + 28 = 48)
        [8, 12, 16] -->(8 + 12 = 20, 12 + 16 = 28)
        [3, 5, 7, 9] -->(3 + 5 = 8, 5 + 7 = 12, 7 + 9 = 16)
        [1, 2, 3, 4, 5] -->(1 + 2 = 3, 2 + 3 = 5, 3 + 4 = 7, 4 + 5 = 9)
 */