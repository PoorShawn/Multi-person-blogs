package org.poorman.blogs.entity;

import java.time.LocalDateTime;

public class Comment {
    Integer id;
    String content;

    public Comment(Integer id, String content, LocalDateTime createAt, Integer userId, Integer postId) {
        this.id = id;
        this.content = content;
        this.createAt = createAt;
        this.userId = userId;
        this.postId = postId;
    }

    LocalDateTime createAt;
    Integer postId;
    Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
