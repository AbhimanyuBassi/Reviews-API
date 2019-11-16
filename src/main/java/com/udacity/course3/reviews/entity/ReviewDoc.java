package com.udacity.course3.reviews.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Document("reviews")
public class ReviewDoc {
    @Id
    private Integer reviewId;
    private String reviewContent;
    private Integer productId;
    private List<CommentDoc> commentDocs = new ArrayList<>();

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<CommentDoc> getCommentDocs() {
        return commentDocs;
    }

    public void add(CommentDoc comment) {
        this.commentDocs.add(comment);
    }
}
