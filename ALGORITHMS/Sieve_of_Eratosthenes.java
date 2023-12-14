public class Sieve_of_Eratosthenes 
{
    public static int[] isPrime(int n)
    {
        int a[] = new int[2];
        boolean prime[] = new boolean[n+1];
        for(int i=0; i<prime.length; i++)
        {
            prime[i] = true;
        }
        for(int i=2; i<n; i++)
        {
            if(prime[i] == true)
            {
                for(int j=i*i; j<=n; j+=i)
                {
                    prime[j] = false;
                }
            }
        }
        int j=0;
        for(int i=2; i<prime.length; i++)
        {
            if(prime[i] == true && n % i == 0)
            {
                a[j++] = i;
            }
        }
        return a;
    }
    public static void main(String[] args) 
    {
        int n = 100;    
        isPrime(n);
        int a[] = isPrime(n);
        for(int i: a)
        {
            System.out.print(i + " ");
        }
    }
    
}