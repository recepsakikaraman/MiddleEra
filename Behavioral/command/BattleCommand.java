package Behavioral.command;

public interface BattleCommand {

    void execute();

    void undo();

    String getCommandName();
}
