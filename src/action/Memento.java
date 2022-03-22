package action;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2022/3/22
 */
public class Memento {
    public static void main(String[] args) {
        Originator or = new Originator();
        Caretaker cr = new Caretaker();
        or.setState("S0");
        System.out.println("初始状态:" + or.getState());
        cr.setMemento(or.createMemento()); //保存状态
        or.setState("S1");
        System.out.println("新的状态:" + or.getState());
        or.restoreMemento(cr.getMemento()); //恢复状态
        System.out.println("恢复状态:" + or.getState());
    }
}


//备忘录
class Memento1 {
    private String state;

    public Memento1(String state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

//发起人
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento1 createMemento() {
        return new Memento1(state);
    }

    public void restoreMemento(Memento1 m) {
        this.setState(m.getState());
    }
}

//管理者
class Caretaker {
    private Memento1 memento;

    public void setMemento(Memento1 m) {
        memento = m;
    }

    public Memento1 getMemento() {
        return memento;
    }
}