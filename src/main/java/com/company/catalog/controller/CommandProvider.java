package com.company.catalog.controller;

import com.company.catalog.controller.command.Command;
import com.company.catalog.controller.command.CommandName;
import com.company.catalog.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {

    private final Map<CommandName, Command> commandList = new HashMap<CommandName,Command>();

    CommandProvider() {
        commandList.put(CommandName.ADD_NEWS, new AddNews());
        commandList.put(CommandName.SEARCH_NEWS, new SearchNews());
        commandList.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String request) {

        CommandName commandName;
        Command command;
        try{
            commandName = CommandName.valueOf(request.toUpperCase());
            command = commandList.get(commandName);

        }catch( NullPointerException e){
            command = commandList.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
