package reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * “框架”
 * 具体方法：
 *      1.配置文件
 *          需要创建对象的全类名，和需要执行的方法配置在文件中
 *          读配置文件
 *      2.反射
 *          利用反射
 */

public class ReflectTest {
    public static void main(String[] args) throws Exception{
        final File file = new File("201907/src/pro.properties");
//        System.out.println("file.exists() = " + file.exists());


        //可以创建任意类的对象，可以执行任意方法

        //1 加载配置文件
        Properties pro = new Properties();
//        pro.load(new FileInputStream(file));
        final InputStream inputStream = ReflectTest.class.getClassLoader().getResourceAsStream("pro.properties");
        pro.load(inputStream);

        // 获得对象和方法
        final String className = pro.getProperty("className");
        final String methodName = pro.getProperty("methodName");

        final Class<?> aClass = Class.forName(className);
        final Method method = aClass.getMethod(methodName);

        //创建对象执行方法
        final Object o = aClass.getConstructor().newInstance();
        System.out.println("o = " + o);
        method.invoke(o);


    }
}
