package structure;

import java.util.ArrayList;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2022/3/20
 */
public class Composite {
    public static void main(String[] args) {

    }
}

//透明组合模式
//抽象构件
interface Component1 {
    public void add(Component1 c);

    public void remove(Component1 c);

    public Component1 getChild(int i);

    public void operation();
}

//树叶构件
class Leaf implements Component1 {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    public void add(Component1 c) {
    }

    public void remove(Component1 c) {
    }

    public Component1 getChild(int i) {
        return null;
    }

    public void operation() {
        System.out.println("树叶" + name + "：被访问！");
    }
}

//树枝构件
class Composite1 implements Component1 {
    private ArrayList<Component1> children = new ArrayList<Component1>();

    public void add(Component1 c) {
        children.add(c);
    }

    public void remove(Component1 c) {
        children.remove(c);
    }

    public Component1 getChild(int i) {
        return children.get(i);
    }

    public void operation() {
        for (Object obj : children) {
            ((Component1) obj).operation();
        }
    }
}

//安全模式
interface Component2 {
    public void operation();
}
