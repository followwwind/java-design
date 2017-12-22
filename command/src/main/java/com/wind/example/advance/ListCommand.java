package com.wind.example.advance;

import java.util.List;

/**
 * 组合命令,顺序执行
 * @author wind
 */
public class ListCommand implements ICommand{

    private List<ICommand> commandList;

    public ListCommand(List<ICommand> commandList) {
        this.commandList = commandList;
    }

    @Override
    public void execute() {
        commandList.forEach(ICommand::execute);
    }
}
