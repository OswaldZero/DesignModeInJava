package action;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2022/3/22
 */
public class Iterator {
    public static void main(String[] args) {

        Aggregate ag = new ConcreteAggregate();
        ag.add("华中农业大学");
        ag.add("武汉大学");
        ag.add("湖北大学");
        System.out.print("聚合的内容有：");
        Iterator1 it = ag.getIterator();
        while (it.hasNext()) {
            Object ob = it.next();
            System.out.print(ob.toString() + "\t");
        }
        Object ob = it.first();
        System.out.println("\nFirst：" + ob.toString());
    }
}



//抽象聚合
interface Aggregate {
    public void add(Object obj);

    public void remove(Object obj);

    public Iterator1 getIterator();
}

//具体聚合
class ConcreteAggregate implements Aggregate {
    private List<Object> list = new ArrayList<Object>();

    public void add(Object obj) {
        list.add(obj);
    }

    public void remove(Object obj) {
        list.remove(obj);
    }

    public Iterator1 getIterator() {
        return (new ConcreteIterator(list));
    }
}

//抽象迭代器
interface Iterator1 {
    Object first();

    Object next();

    boolean hasNext();
}

//具体迭代器
class ConcreteIterator implements Iterator1 {
    private List<Object> list = null;
    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        } else {
            return false;
        }
    }

    public Object first() {
        index = 0;
        Object obj = list.get(index);
        ;
        return obj;
    }

    public Object next() {
        Object obj = null;
        if (this.hasNext()) {
            obj = list.get(++index);
        }
        return obj;
    }
}