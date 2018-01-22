package com.project.sources;

public class Reviews {
	private int reviewId;
	private int cutomerId;
	private double rating;
	private String review;
	
	public Reviews() {}

	public Reviews(int reviewId, int cutomerId, double rating, String review) {
		super();
		this.reviewId = reviewId;
		this.cutomerId = cutomerId;
		this.rating = rating;
		this.review = review;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getCutomerId() {
		return cutomerId;
	}

	public void setCutomerId(int cutomerId) {
		this.cutomerId = cutomerId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	
}
