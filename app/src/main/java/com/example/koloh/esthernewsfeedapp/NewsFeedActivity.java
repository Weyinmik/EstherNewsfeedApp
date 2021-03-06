package com.example.koloh.esthernewsfeedapp;

import java.io.Serializable;

/**
 * {@link NewsFeedActivity} represents more news topics that users want to know and read.
 * It contains a default category of the news and title, as well as dates the news article was published.
 */
public class NewsFeedActivity implements Serializable {
    public static final long serialVersionUID = 21042018L;
    private String title, section, date, author, webUrl, imageUrl;

    NewsFeedActivity(String title, String section, String date, String webUrl, String author, String imageUrl) {
        this.title = title;
        this.section = section;
        this.date = date;
        this.webUrl = webUrl;
        this.author = author;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public String getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
