package AnnotationTest;

/**
 * 注解 annotation
 * 给计算机看的
 * 元数据
 * 代码级别的说明
 * 1.5以后的新特性
 * 和 类 接口 枚举 同一层次
 * 放在 类 字段 方法 局部变量 方法参数的前面
 *  1.生成文档
 *  2.代码分析（自己定义注解）
 *  3.编译检查
 *
 * JDK中预定义的一些注解 462
 *  override    重写
 *  deprecated  已过时
 *  suppressWarnings    压制警告
 * 自己定义注解
 *  元注解
 *  public @interface name{}
 *
 * 使用注解
 *
 * 注解大部分都是用来代替配置文件的
 *
 */

@SuppressWarnings("all")
public class Test {
    public static void main(String[] args) {

    }

    @Deprecated
    public void show(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @MyAnno("all")
    public void fun(){

    }
}
