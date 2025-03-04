public class Init{

    private final int n,k;
    public Init(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Trebuie introduse doua argumente");

        }
        this.n = Integer.parseInt(args[0]);
        this.k = Integer.parseInt(args[1]);

        if (k > n) {
            throw new IllegalArgumentException("k trebuie sa fie mai mic ca n");

        }
    }
    public int getN()
    {
        return this.n;
    }
    public int getK()
    {
        return this.k;
    }



}