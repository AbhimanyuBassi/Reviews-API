package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.CommentDoc;
import com.udacity.course3.reviews.entity.ReviewDoc;
import com.udacity.course3.reviews.repositories.Mongo.MongoReviewRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class MongoTests {

    @Autowired
    MongoReviewRepository mongoReviewRepository;

    @AfterEach
    public void tearDown() {
        mongoReviewRepository.deleteAll();
    }

    @Test
    public void testReviewDocument() {
        CommentDoc comment = new CommentDoc();
        comment.setCommentContent("some comment");
        comment.setCommentId(123);

        ReviewDoc review = new ReviewDoc();
        review.setReviewId(123);
        review.setProductId(456);
        review.setReviewContent("some review");
        review.add(comment);

        mongoReviewRepository.save(review);

        ReviewDoc savedReview = mongoReviewRepository.findAll().get(0);
        CommentDoc savedComment = savedReview.getCommentDocs().get(0);
        assertEquals(123, savedReview.getReviewId().intValue());
        assertEquals(456, savedReview.getProductId().intValue());
        assertEquals("some review", savedReview.getReviewContent());
        assertEquals(123, comment.getCommentId().intValue());
        assertEquals("some comment", comment.getCommentContent());
    }

}