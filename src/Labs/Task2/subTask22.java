package Labs.Task2;

public class subTask22 implements Ifunction {
    private int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    @Override
    public double function(int n,double x) {
        return (Math.pow(-1,n)*Math.pow(x,n)) / factorial(n);
    }
}
