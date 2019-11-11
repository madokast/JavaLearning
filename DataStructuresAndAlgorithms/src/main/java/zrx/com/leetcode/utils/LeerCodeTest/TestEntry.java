package zrx.com.leetcode.utils.LeerCodeTest;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 2019/11/10 15:54
 *
 * @author zrx
 * @version 1.0
 */

public class TestEntry {
    private Object solution;
    private String methodName;
    private Class[] parameters;

    public static TestEntry getInstance(Object solution,String methodName,Class...parameters){
        return new TestEntry(solution,methodName,parameters);
    }

    private TestEntry(Object solution, String methodName, Class[] parameters) {
        this.solution = solution;
        this.methodName = methodName;
        this.parameters = parameters;
    }

    public Object getSolution() {
        return solution;
    }

    public String getMethodName() {
        return methodName;
    }

    public Class[] getParameters() {
        return parameters;
    }
}
