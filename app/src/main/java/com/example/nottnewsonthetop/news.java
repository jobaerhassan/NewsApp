package com.example.nottnewsonthetop;

public class news {
    String title;
    String author;
    String description;
    String url;
    String urlToImage;

    public news(String title,String author,String url, String urlToImg)

    {
        this.title = title;
        this.author = author;
//        this.description = description;
        this.url = url;
        this.urlToImage = urlToImg;
    }
}
