package learn.算法第四版.动态联通问题;

public class UF01 implements IUF {
    private int[] id;
    private int count;
    private int N;

    public UF01(int N) {
        this.N = N;
        this.count = N;
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }



    @Override
    public void union(int p, int q) {
        if(connected(p,q))
            return;

        int max = Math.max(id[p],id[q]);
        int min = Math.min(id[p],id[q]);

        for (int i = 0; i < N; i++) {
            if(id[i]==max)
                id[i] = min;
        }

        count--;
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int getN() {
        return N;
    }
}
