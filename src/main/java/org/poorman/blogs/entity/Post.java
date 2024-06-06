package org.poorman.blogs.entity;

import java.awt.*;

public class Post {
    public Post(int id, String title, String text, int author_id) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.author_id = author_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    int id;
    String title;
    String text;
    int author_id;
}
