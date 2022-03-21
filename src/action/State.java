package action;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2022/3/21
 */
public class State {
    public static void main(String[] args) {
        Context2 context2 = new Context2();    //创建环境
        context2.Handle();    //处理请求
        context2.Handle();
        context2.Handle();
        context2.Handle();

    }
}


//环境类
class Context2 {
    private State1 state1;

    //定义环境类的初始状态
    public Context2() {
        this.state1 = new ConcreteState1A();
    }

    //设置新状态
    public void setState(State1 state1) {
        this.state1 = state1;
    }

    //读取状态
    public State1 getState() {
        return (state1);
    }

    //对请求做处理
    public void Handle() {
        state1.Handle(this);
    }
}

//抽象状态类
abstract class State1 {
    public abstract void Handle(Context2 context2);
}

//具体状态A类
class ConcreteState1A extends State1 {
    public void Handle(Context2 context2) {
        System.out.println("当前状态是 A.");
        context2.setState(new ConcreteState1B());
    }
}

//具体状态B类
class ConcreteState1B extends State1 {
    public void Handle(Context2 context2) {
        System.out.println("当前状态是 B.");
        context2.setState(new ConcreteState1A());
    }
}