package com.udacity.course3.reviews.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("comments")
public class CommentDoc {
    private Integer commentId;
    private String commentContent;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
