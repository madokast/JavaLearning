package exception;

import java.util.Objects;

/**
 * Throwable superclass
 * two subclass
 * error exception
 *
 * error
 *
 * exception
 *  runtimeException
 *
 * 编译期异常
 * 运行期异常
 * 错误
 */

public class ExceptionTest {
    Throwable throwable;

    public static void main(String[] args) throws Exception {
        //throw new Exception("123");
        //Exception in thread "main" java.lang.Exception: 123
        //	at exception.ExceptionTest.main(ExceptionTest.java:22)

        //throw new OutOfMemoryError("123");

        NullPointerException nullPointerException;
        //RuntimeException
        //运行期异常，默认交给JVM处理

        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;

        //Objects.requireNonNull(null);
        //java.lang.NullPointerException



    }
}
