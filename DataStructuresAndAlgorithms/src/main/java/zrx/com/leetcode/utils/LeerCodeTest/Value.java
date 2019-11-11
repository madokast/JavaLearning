package zrx.com.leetcode.utils.LeerCodeTest;

/**
 * Description
 * 值
 * <p>
 * Data
 * 2019/11/10 15:41
 *
 * @author zrx
 * @version 1.0
 */

public class Value {

    private Class clazz;
    private Object value;

    private Value(){}

    private Value(Class clazz, Object val) {
        this.clazz = clazz;
        this.value = val;
    }

    public static Value newInstance(Class clazz, Object val){
        return new Value(clazz,val);
    }

    public Class getClazz() {
        return clazz;
    }

    public Object getValue() {
        return value;
    }
}
