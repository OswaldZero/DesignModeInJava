package action;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2022/3/21
 */
public class Command {
    public static void main(String[] args) {

        Command1 cmd = new ConcreteCommand();
        Invoker ir = new Invoker(cmd);
        System.out.println("客户访问调用者的call()方法...");
        ir.call();
    }
}


//调用者
class Invoker {
    private Command1 command;

    public Invoker(Command1 command) {
        this.command = command;
    }

    public void setCommand(Command1 command) {
        this.command = command;
    }

    public void call() {
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}

//抽象命令
interface Command1 {
    public abstract void execute();
}

//具体命令
class ConcreteCommand implements Command1 {
    private Receiver receiver;

    ConcreteCommand() {
        receiver = new Receiver();
    }

    public void execute() {
        receiver.action();
    }
}

//接收者
class Receiver {
    public void action() {
        System.out.println("接收者的action()方法被调用...");
    }
}
