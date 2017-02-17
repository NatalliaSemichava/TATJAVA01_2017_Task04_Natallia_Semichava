package com.company.catalog.dao.impl;

import com.company.catalog.bean.News;
import com.company.catalog.dao.NewsDAO;
import com.company.catalog.dao.connection.ConnectionPool;
import com.company.catalog.dao.connection.exception.ConnectionException;
import com.company.catalog.dao.exception.DAOException;
import java.sql.*;
import java.util.HashMap;

public class DBNewsDAO implements NewsDAO {
    private HashMap<News, String> allNews = new HashMap<News, String>();
    private Connection connection;
    private final String INSERT = "INSERT INTO news.records VALUES (?, ?, ?, ?, ?, ?, ?)";

    private Connection getConnection() throws DAOException{
        try {
            ConnectionPool.getInstance().initPoolData();
            connection = ConnectionPool.getInstance().takeConnection();
        }
        catch (ConnectionException e) {
            throw new DAOException();
        }
        return connection;
    }
    public boolean addNewsInDB(News news) throws DAOException {
        try {
            getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,news.getCategory());
            preparedStatement.setString(2,news.getAuthor());
            preparedStatement.setString(3,news.getDurationOrPublisher());
            preparedStatement.setString(4,news.getDate());
            preparedStatement.setString(5,news.getCountry());
            preparedStatement.setString(6,news.getGenres());
            preparedStatement.setString(7,news.getDescription());
            preparedStatement.executeUpdate();
            ConnectionPool.closeConnection(connection,preparedStatement);
            return true;
        }
        catch (SQLException e){
            throw new DAOException();
        }
    }

    public HashMap<News, String> readAllNewsFromDB() throws DAOException{
        try {
            convertNewsToList();
        }
        catch (SQLException e){
            throw new DAOException();
        }
        return allNews;
    }

    private void convertNewsToList() throws DAOException, SQLException {
        getConnection();

        Statement st = connection.createStatement();
        String sql = ("SELECT * FROM records;");
        ResultSet rs = st.executeQuery(sql);

        String category;
        while (rs.next()) {
            category = rs.getString(1);
            News news = new News();
            setStandardInfo(news, rs);
            allNews.put(news, category);
        }
        ConnectionPool.closeConnection(connection, st);
    }

    private News setStandardInfo(News news, ResultSet rs) throws SQLException {
        news.setCategory(rs.getString(1));
        news.setAuthor(rs.getString(2));
        news.setDurationOrPublisher(rs.getString(3));
        news.setDate(rs.getString(4));
        news.setCountry(rs.getString(5));
        news.setGenre(rs.getString(6));
        news.setDescription(rs.getString(7));
        return news;
    }
}
