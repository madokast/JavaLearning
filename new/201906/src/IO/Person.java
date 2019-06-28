package IO;

import java.io.Serializable;

public class Person implements Serializable {
    public String name;
    public int age;
    private static final long serialVersionUID = 2575352518912626865L;

    public Person() {
        this("a",0);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * public interface Serializable
     * 类通过实现 java.io.Serializable 接口以启用其序列化功能。
     * 未实现此接口的类将无法使其任何状态序列化或反序列化。
     * 可序列化类的所有子类型本身都是可序列化的。
     * !!!序列化接口没有方法或字段，仅用于标识可序列化的语义。
     *
     * 要允许不可序列化类的子类型序列化，
     * 可以假定该子类型负责保存和恢复超类型的公用 (public)、
     * 受保护的 (protected) 和（如果可访问）包 (package) 字段的状态。
     * 仅在子类型扩展的类有一个可访问的无参数构造方法来初始化该类的状态时，
     * 才可以假定子类型有此职责。
     * 如果不是这种情况，则声明一个类为可序列化类是错误的。
     * 该错误将在运行时检测到。
     *
     * 在反序列化过程中，
     * 将使用该类的公用或受保护的无参数构造方法初始化不可序列化类的字段。
     * 可序列化的子类必须能够访问无参数构造方法。可序列化子类的字段将从该流中恢复。
     *
     * 当遍历一个图形时，可能会遇到不支持 Serializable 接口的对象。
     * 在此情况下，将抛出 NotSerializableException，并将标识不可序列化对象的类。
     *
     * 在序列化和反序列化过程中需要特殊处理的类必须使用下列准确签名来实现特殊方法：
     *
     *  private void writeObject(java.io.ObjectOutputStream out)
     *      throws IOException
     *  private void readObject(java.io.ObjectInputStream in)
     *      throws IOException, ClassNotFoundException;
     *  private void readObjectNoData()
     *      throws ObjectStreamException;
     *
     * writeObject 方法负责写入特定类的对象的状态，
     * 以便相应的 readObject 方法可以恢复它。
     * 通过调用 out.defaultWriteObject 可以调用保存 Object 的字段的默认机制。
     * 该方法本身不需要涉及属于其超类或子类的状态。
     * 通过使用 writeObject 方法或使用 DataOutput
     * 支持的用于基本数据类型的方法将各个字段写入 ObjectOutputStream，状态可以被保存。
     *
     * readObject 方法负责从流中读取并恢复类字段。
     * 它可以调用 in.defaultReadObject 来调用默认机制，
     * 以恢复对象的非静态和非瞬态字段。defaultReadObject
     * 方法使用流中的信息来分配流中通过当前对象中相应指定字段保存的对象的字段。
     * 这用于处理类演化后需要添加新字段的情形。
     * 该方法本身不需要涉及属于其超类或子类的状态。
     * 通过使用 writeObject 方法或使用 DataOutput
     * 支持的用于基本数据类型的方法将各个字段写入 ObjectOutputStream，状态可以被保存。
     *
     * 在序列化流不列出给定类作为将被反序列化对象的超类的情况下
     * ，readObjectNoData 方法负责初始化特定类的对象状态。
     * 这在接收方使用的反序列化实例类的版本不同于发送方，
     * 并且接收者版本扩展的类不是发送者版本扩展的类时发生。
     * 在序列化流已经被篡改时也将发生；
     * 因此，不管源流是“敌意的”还是不完整的，
     * readObjectNoData 方法都可以用来正确地初始化反序列化的对象。
     *
     * 将对象写入流时需要指定要使用的替代对象的可序列化类，
     * 应使用准确的签名来实现此特殊方法：
     *
     *  ANY-ACCESS-MODIFIER Object writeReplace() throws ObjectStreamException;
     *
     * 此 writeReplace 方法将由序列化调用，
     * 前提是如果此方法存在，而且它可以通过被序列化对象的类中定义的一个方法访问。
     * 因此，该方法可以拥有私有 (private)、受保护的 (protected) 和
     * 包私有 (package-private) 访问。子类对此方法的访问遵循 java 访问规则。
     *
     * 在从流中读取类的一个实例时需要指定替代的类应使用的准确签名来实现此特殊方法。
     *
     *  ANY-ACCESS-MODIFIER Object readResolve() throws ObjectStreamException;
     *
     * 此 readResolve 方法遵循与 writeReplace 相同的调用规则和访问规则。
     *
     * 序列化运行时使用一个称为 serialVersionUID 的版本号与每个可序列化类相关联，
     * 该序列号在反序列化过程中用于验证序列化对象的发送者
     * 和接收者是否为该对象加载了与序列化兼容的类。
     * 如果接收者加载的该对象的类的 serialVersionUID 与对应的发送者的类的版本号不同，
     * 则反序列化将会导致 InvalidClassException。
     * 可序列化类可以通过声明名为 "serialVersionUID" 的字段
     * （该字段必须是静态 (static)、最终 (final) 的 long 型字段）显式声明其自己的 serialVersionUID：
     *
     *  ANY-ACCESS-MODIFIER static final long serialVersionUID = 42L;
     *
     * 如果可序列化类未显式声明 serialVersionUID，
     * 则序列化运行时将基于该类的各个方面计算该类的默认 serialVersionUID 值，
     * 如“Java(TM) 对象序列化规范”中所述。
     * 不过， 强烈建议 所有可序列化类都显式声明 serialVersionUID 值，
     * 原因是计算默认的 serialVersionUID 对类的详细信息具有较高的敏感性，
     * 根据编译器实现的不同可能千差万别，
     * 这样在反序列化过程中可能会导致意外的 InvalidClassException。
     * 因此，为保证 serialVersionUID 值跨不同 java 编译器实现的一致性，
     * 序列化类必须声明一个明确的 serialVersionUID 值。
     * 还强烈建议使用 private 修饰符显示声明 serialVersionUID（如果可能），
     * 原因是这种声明仅应用于直接声明类 -- serialVersionUID 字段作为继承成员没有用处。
     * 数组类不能声明一个明确的 serialVersionUID，因此它们总是具有默认的计算值，
     * 但是数组类没有匹配 serialVersionUID 值的要求。
     */
    static Serializable serializable;
}
