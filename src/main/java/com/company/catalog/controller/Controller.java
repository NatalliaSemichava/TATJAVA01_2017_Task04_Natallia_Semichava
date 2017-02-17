package com.company.catalog.controller;

import com.company.catalog.controller.command.Command;

public final class Controller {

    private final CommandProvider provider = new CommandProvider();

    public String executeCommand(String command,String request)  {

        Command executeCommand = provider.getCommand(command);
        String response = executeCommand.execute(request);

        return response;
    }
}
