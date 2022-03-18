package create;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2022/3/17
 */
//具体原型类
public class Prototype implements Cloneable {
    Prototype() {
        System.out.println("具体原型创建成功！");
    }
    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (Prototype) super.clone();
    }
}
//原型模式的测试类
class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype obj1 = new Prototype();
        Prototype obj2 = (Prototype) obj1.clone();
        System.out.println("obj1==obj2?" + (obj1 == obj2));
    }
}
