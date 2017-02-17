package com.company.catalog.controller.command.impl;

import com.company.catalog.controller.command.Command;

public class WrongRequest implements Command {
    public String execute(String request) {
        return "Wrong request";
    }
}
