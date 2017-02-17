package com.company.catalog.dao.factory;

import com.company.catalog.dao.NewsDAO;
import com.company.catalog.dao.impl.DBNewsDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final NewsDAO dbNewsImpl = new DBNewsDAO();
    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return instance;
    }
    public NewsDAO getNewsDAO(){
        return dbNewsImpl;
    }
}
