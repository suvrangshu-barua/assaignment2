

public class matrix
{
    private static final int num_of_threads = 9;

    public static void main (String args[])
    {
        int A[][] = {{8, 2, 5}, {2, 2, 1}, {1, 4, 7}};
        int B[][] = {{11, 2, 1}, {1, 8, 7}, {3, 1, 5}};
        int C[][] = new int [3][3];
        int i, j;
        int ThreadCount = 0;

        Thread thrd[] = new Thread [num_of_threads];

        try
        {
            for (i=0; i<3; i++)
        {
            for (j=0; j<3; j++)
            {
                thrd [ThreadCount] = new Thread (new Worker (i, j, A, B, C));

                thrd [ThreadCount].start();
                thrd [ThreadCount].join();

                ThreadCount++;
            }
        }
    }catch (Exception e)
    {
        System.out.println (e);
    }

    System.out.println ("A matrix : ");

    for (i=0; i<3; i++)
    {
        for (j=0; j<3; j++)
        {
            System.out.print (A[i][j]+ " ");
        }
        System.out.println ();
    }

    System.out.println ("B matrix : ");

    for (i=0; i<3; i++)
    {
        for (j=0; j<3; j++)
        {
            System.out.print (B[i][j]+ " ");
        }
        System.out.println ();
    }

    System.out.println ("C matrix : ");

    for (i=0; i<3; i++)
    {
        for (j=0; j<3; j++)
        {
            System.out.print (C[i][j]+ " ");
        }
        System.out.println ();
    }
}
}

class Worker implements Runnable
    {
        private int i, j;
        private int A[][], B[][], C[][];

        public Worker (int i, int j, int A[][], int B[][], int C[][])
        {
            this.i = i;
            this.j = j;
            this.A = A;
            this.B = B;
            this.C = C;
        }

        public void run ()
        {
            for (int k=0; k<B.length; k++)
            {
                C[i][j] = C[i][j] + A[i][k] * B[k][j];
            }
        }
    }
