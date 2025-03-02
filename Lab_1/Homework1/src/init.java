public class init{

    private int n,k;
    public init(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("You must provide two arguments");

        }
        this.n = Integer.parseInt(args[0]);
        this.k = Integer.parseInt(args[1]);

        if (k > n) {
            throw new IllegalArgumentException("k must be less than n");

        }
    }

        public int getN()
        {
            return n;
        }
        public int getK()
        {
            return k;
        }



}
