package learn.算法第四版.动态联通问题;

public class Test {
    public static void main(String[] args) {
        int N = 10;
        IUF iuf = new UF01(N);
        int[][] conn = new int[][]{
                {4,3},
                {3,8},
                {6,5},
                {9,4},

                {2,1},
                {5,0},
                {7,2},
                {6,1},

                {1,0},
                {6,7},

        };

        int p,q;
        for (int i = 0; i < conn.length; i++) {
            p = conn[i][0];
            q = conn[i][1];

            if(iuf.connected(p,q))
                continue;

            iuf.union(p,q);
        }

        System.out.println("iuf = " + iuf.count());
    }
}
