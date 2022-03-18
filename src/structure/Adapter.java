package structure;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2022/3/17
 */
public class Adapter {
    public static void main(String[] args) {
        System.out.println("类适配器模式测试：");
        Target target = new ClassAdapter();
        target.request();

        System.out.println("对象适配器模式测试：");
        Adaptee adaptee = new Adaptee();
        Target target1 = new ObjectAdapter(adaptee);
        target1.request();
    }
}

//类适配器模式
//目标接口
interface Target
{
    public void request();
}
//适配者接口
class Adaptee
{
    public void specificRequest()
    {
        System.out.println("适配者中的业务代码被调用！");
    }
}
//类适配器类
class ClassAdapter extends Adaptee implements Target
{
    public void request()
    {
        specificRequest();
    }
}

//对象适配器模式
//对象适配器类
class ObjectAdapter implements Target
{
    private Adaptee adaptee;
    public ObjectAdapter(Adaptee adaptee)
    {
        this.adaptee=adaptee;
    }
    public void request()
    {
        adaptee.specificRequest();
    }
}

