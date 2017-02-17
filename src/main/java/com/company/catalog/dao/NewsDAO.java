package com.company.catalog.dao;
import java.sql.SQLException;
import java.util.HashMap;

import com.company.catalog.bean.News;
import com.company.catalog.dao.exception.DAOException;

public interface NewsDAO {
    public boolean addNewsInDB(News news)  throws DAOException;
    public HashMap<News, String> readAllNewsFromDB()  throws DAOException;
}
