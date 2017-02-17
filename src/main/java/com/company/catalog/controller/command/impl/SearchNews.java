package com.company.catalog.controller.command.impl;

import com.company.catalog.controller.command.Command;
import com.company.catalog.service.NewsService;
import com.company.catalog.service.exception.ServiceException;
import com.company.catalog.service.factory.ServiceFactory;

public class SearchNews implements Command {

    public String execute(String request) {
        String response="";
        String[] array = request.split(" ");
        try {
            ServiceFactory daoObjectFactory = ServiceFactory.getInstance();
            NewsService newsDAO = daoObjectFactory.getNewsService();
            response = newsDAO.searchNews(array[0], array[1]);

        } catch (ServiceException e) {
            return "News searching error";
        }
        if (response.equals("")){
            response = "There is no such record";
        }
        return response;
    }
}
