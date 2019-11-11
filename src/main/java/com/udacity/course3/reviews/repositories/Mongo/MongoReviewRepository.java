package com.udacity.course3.reviews.repositories.Mongo;

import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.entity.ReviewDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoReviewRepository extends MongoRepository<ReviewDoc, Integer> {
    List<Review> findAllByProductId(Integer productId);
}
