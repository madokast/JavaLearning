package zrx.com.others.Symbolics;

/**
 * 符号，代表一个变量
 * 如 x MyTools A11
 *
 * 这是一个不可变类!
 */

public class Symbol {
    private String sym;//内部存储的符号，即一个字符串

    public Symbol(String sym) {
        this.sym = sym;
    }

    @Override
    public String toString() {
        return sym;
    }

    /**
     * 判断符号是否相同
     * 字符串一致就是相同符号
     * @param o o
     * @return 符号是否相同
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol = (Symbol) o;

        return sym != null ? sym.equals(symbol.sym) : symbol.sym == null;
    }

    /**
     * 有用啊
     * 因子 factor 就是用的hash map
     * @return 重写的hash值
     */
    @Override
    public int hashCode() {
        return sym != null ? sym.hashCode() : 0;
    }
}
