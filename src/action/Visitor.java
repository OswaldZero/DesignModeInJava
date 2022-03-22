package action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2022/3/22
 */
public class Visitor {
    public static void main(String[] args) {

        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        Visitor1 visitor1 = new ConcreteVisitor1A();
        os.accept(visitor1);
        System.out.println("------------------------");
        visitor1 = new ConcreteVisitor1B();
        os.accept(visitor1);
    }
}


//抽象访问者
interface Visitor1 {
    void visit(ConcreteElementA element);

    void visit(ConcreteElementB element);
}

//具体访问者A类
class ConcreteVisitor1A implements Visitor1 {
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者A访问-->" + element.operationA());
    }

    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者A访问-->" + element.operationB());
    }
}

//具体访问者B类
class ConcreteVisitor1B implements Visitor1 {
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者B访问-->" + element.operationA());
    }

    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者B访问-->" + element.operationB());
    }
}

//抽象元素类
interface Element {
    void accept(Visitor1 visitor1);
}

//具体元素A类
class ConcreteElementA implements Element {
    public void accept(Visitor1 visitor1) {
        visitor1.visit(this);
    }

    public String operationA() {
        return "具体元素A的操作。";
    }
}

//具体元素B类
class ConcreteElementB implements Element {
    public void accept(Visitor1 visitor1) {
        visitor1.visit(this);
    }

    public String operationB() {
        return "具体元素B的操作。";
    }
}

//对象结构角色
class ObjectStructure {
    private List<Element> list = new ArrayList<Element>();

    public void accept(Visitor1 visitor1) {
        Iterator<Element> i = list.iterator();
        while (i.hasNext()) {
            ((Element) i.next()).accept(visitor1);
        }
    }

    public void add(Element element) {
        list.add(element);
    }

    public void remove(Element element) {
        list.remove(element);
    }
}
