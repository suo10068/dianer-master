package 学习模块.设计模式.命令模式;

/**
 * 抽象组
 */
public abstract class Command {

    protected RequirmentGroup requirmentGroup = new RequirmentGroup();
    protected PageGroup pageGroup = new PageGroup();
    protected CodeGroup codeGroup = new CodeGroup();


    // 只有一个方法，你要我干什么事情
    public abstract void execute();
}
