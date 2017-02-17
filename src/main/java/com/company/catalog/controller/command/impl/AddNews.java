package com.company.catalog.controller.command.impl;

import com.company.catalog.controller.command.Command;
import com.company.catalog.service.NewsService;
import com.company.catalog.service.exception.ServiceException;
import com.company.catalog.service.factory.ServiceFactory;

public class AddNews implements Command {

    public String execute(String record) {
        String response;
        boolean flag = false;
        try {
            ServiceFactory daoObjectFactory = ServiceFactory.getInstance();
            NewsService newsDAO = daoObjectFactory.getNewsService();

            flag = newsDAO.addNews(record);

        } catch (ServiceException e) {
            return "News adding error";
        }
        response = flag ? "You add this record": "News adding error";
        return response;
    }
}
