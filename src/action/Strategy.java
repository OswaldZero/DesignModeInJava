package action;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2022/3/20
 */
public class Strategy {
    public static void main(String[] args) {

        Context c = new Context();
        Strategy1 s = new ConcreteStrategyA();
        c.setStrategy(s);
        c.strategyMethod();
        System.out.println("-----------------");
        s = new ConcreteStrategyB();
        c.setStrategy(s);
        c.strategyMethod();
    }

}


//抽象策略类
interface Strategy1 {
    public void strategyMethod();    //策略方法
}

//具体策略类A
class ConcreteStrategyA implements Strategy1 {
    public void strategyMethod() {
        System.out.println("具体策略A的策略方法被访问！");
    }
}

//具体策略类B
class ConcreteStrategyB implements Strategy1 {
    public void strategyMethod() {
        System.out.println("具体策略B的策略方法被访问！");
    }
}

//环境类
class Context {
    private Strategy1 strategy;

    public Strategy1 getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy1 strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }
}