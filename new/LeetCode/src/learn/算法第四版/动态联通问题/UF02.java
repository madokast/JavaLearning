package learn.算法第四版.动态联通问题;

public class UF02 implements IUF{
    private int[] id;
    private int count;

    public UF02(int n){
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i]=i;
        }
        count=n;
    }

    @Override
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
//        System.out.println(rootP+" "+rootQ);
        if(rootP==rootQ) {
            return;
        }

        id[rootP]=rootQ;
        count--;
    }

    private int root(int i){
        while (id[i]!=i)
            i = id[i];

        return i;
    }

    @Override
    public int find(int p) {
        return root(p);
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int getN() {
        return id.length;
    }

    @Override
    public boolean connected(int p, int q) {
//        System.out.println(p+" "+q);
        return root(p)==root(q);
    }
}
