package com.company.catalog.bean;

public class News {
    private String date;
    private String country;
    private String genre;
    private String description;
    private String category;
    private String author;
    private String durationOrPublisher;

    public String toString(){
        return "category: " + category + "; author: "+ author + "; duration or publisher: " + durationOrPublisher+ "; date: " + date + "; country: " + country + "; genre: " + genre + "; description: " + description;
    }

    //---------------------------------setters & getters

    public void setDate(String date){
        this.date=date;
    }

    public void setCountry(String country){
        this.country=country;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void setGenre(String genre){
        this.genre=genre;
    }

    public void setAuthor(String author){
        this.author=author;
    }

    public void setDurationOrPublisher(String durationOrPublisher){
        this.durationOrPublisher=durationOrPublisher;
    }

    public void setCategory(String category){
        this.category=category;
    }

    public String getCategory(){
        return category;
    }

    public String getAuthor(){
        return author;
    }

    public String getDurationOrPublisher(){
        return durationOrPublisher;
    }

    public String getDate(){
        return date;
    }

    public String getCountry(){
        return country;
    }

    public String getDescription(){
        return description;
    }

    public String getGenres(){
        return genre;
    }
}
