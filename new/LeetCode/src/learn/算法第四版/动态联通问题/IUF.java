package learn.算法第四版.动态联通问题;

public interface IUF {
    // 加入 p-q 连接
    void union(int p,int q);

    // p 所处的类编号
    int find(int p);

    // 所有连接类的数目
    int count();

    //所有连接数目
    int getN();


    // p-q是否连接
    default boolean connected(int p,int q){
        return find(p)==find(q);
    };
}
