package AnnotationTest;

import java.lang.annotation.*;

/**
 * 注解的返回值
 *  基本类型、字符串、枚举、字符串、注解
 *
 * 元注解
 *  用于描述注解的注解
 *  JDK已经帮我们定义了
 *
 * Target 注解能作用的位置
 * Retention 描述注解保留的阶段——三个阶段。源码、class、runtime
 * Document 会抽取到文档中
 * Inherited 注解是否被子类继承
 *
 */

@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})//方法 类 成员变量
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited

//    /**
//     * Annotations are to be discarded by the compiler.
//     */
//    SOURCE,
//
//    /**
//     * Annotations are to be recorded in the class file by the compiler
//     * but need not be retained by the VM at run time.  This is the default
//     * behavior.
//     */
//    CLASS,
//
//    /**
//     * Annotations are to be recorded in the class file by the compiler and
//     * retained by the VM at run time, so they may be read reflectively.
//     *
//     * @see java.lang.reflect.AnnotatedElement
//     */
//    RUNTIME

public @interface MyAnno{
//    String show() default "all";
    String value();
}
