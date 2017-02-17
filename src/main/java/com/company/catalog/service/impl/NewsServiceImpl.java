package com.company.catalog.service.impl;


import com.company.catalog.bean.News;
import com.company.catalog.dao.NewsDAO;
import com.company.catalog.dao.exception.DAOException;
import com.company.catalog.dao.factory.DAOFactory;
import com.company.catalog.service.NewsService;
import com.company.catalog.service.exception.ServiceException;
import java.util.HashMap;

public class NewsServiceImpl implements NewsService{

    public boolean addNews(String data) throws ServiceException {
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
            if (newsDAO.addNewsInDB(convertToNews(data))){
                return true;
            }
        }
        catch (DAOException e){
            throw new ServiceException();
        }
        return false;
    }


    public String searchNews(String criterion, String data) throws ServiceException{
        if((criterion.equals("date")) || (criterion.equals("country")) || (criterion.equals("genre"))) {
            String result="";
            try {
                DAOFactory daoObjectFactory = DAOFactory.getInstance();
                NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
                HashMap<News, String> news = newsDAO.readAllNewsFromDB();

                for (News n : news.keySet()) {
                    if (searchCriterion(n, data)) {
                        result += n.toString() + System.lineSeparator();
                    }
                }
            }
            catch (DAOException e){
                throw new ServiceException();
            }
            return result;
        }
        else{
            throw new ServiceException();
        }
    }

    private News convertToNews(String data){
        String[] s = data.split("\"");
        News news = new News();
        news.setCategory(s[0]);
        news.setAuthor(s[1]);
        news.setDurationOrPublisher(s[2]);
        news.setDate(s[3]);
        news.setCountry(s[4]);
        news.setGenre(s[5]);
        news.setDescription(s[6]);
        return news;
    }


    private boolean searchCriterion(News news, String data){
        return (news.getGenres().equals(data)) || ((news.getDate().equals(data))) || (news.getCountry().equals(data));
    }
}
