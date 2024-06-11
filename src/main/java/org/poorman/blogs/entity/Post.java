package org.poorman.blogs.entity;

public class Post {
    public Post(int id, String title, String text, int author_id, String description) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.author_id = author_id;
        this.description = description;
    }

    public Post() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    int id;
    String description;
    String title;
    String text;
    int author_id;
}
