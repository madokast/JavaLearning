package 函数式编程;

public class CCT {
    private int n;

    public CCT() {
    }

    public CCT(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "CCT{" +
                "n=" + n +
                '}';
    }
}
