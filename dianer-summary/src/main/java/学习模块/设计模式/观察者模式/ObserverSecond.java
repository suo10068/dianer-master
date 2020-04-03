package 学习模块.设计模式.观察者模式;

public class ObserverSecond extends Observer {

    public ObserverSecond(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Second Observer " + this.subject.getState());
    }
}
