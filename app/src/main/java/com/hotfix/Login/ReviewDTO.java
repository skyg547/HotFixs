package com.hotfix.Login;


public class ReviewDTO {
        String seq;
        String reviewSubject;
        String reviewContent;
        String reviewUserId;
        String reviewComment;
        String reviewLike;
        String reviewInto;

        public String getReviewComment() {
            return reviewComment;
        }

        public void setReviewComment(String reviewComment) {
            this.reviewComment = reviewComment;
        }

        public String getReviewLike() {
            return reviewLike;
        }

        public void setReviewLike(String reviewLike) {
            this.reviewLike = reviewLike;
        }

        public String getReviewInto() {
            return reviewInto;
        }

        public void setReviewInto(String reviewInto) {
            this.reviewInto = reviewInto;
        }

        public String getSeq() {
            return seq;
        }

        public void setSeq(String seq) {
            this.seq = seq;
        }

        public String getReviewSubject() {
            return reviewSubject;
        }

        public void setReviewSubject(String reviewSubject) {
            this.reviewSubject = reviewSubject;
        }

        public String getReviewContent() {
            return reviewContent;
        }

        public void setReviewContent(String reviewContent) {
            this.reviewContent = reviewContent;
        }

        public String getReviewUserId() {
            return reviewUserId;
        }

        public void setReviewUserId(String reviewUserId) {
            this.reviewUserId = reviewUserId;
        }
}
