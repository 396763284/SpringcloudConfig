package DesignPatterns.Command;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 18:28
 */
public class FunctionCommand extends Command{

    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }


    @Override
    public void execute() {
        command.execute();
    }
}
