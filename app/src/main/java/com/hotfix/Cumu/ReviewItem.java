package com.hotfix.Cumu;

public class ReviewItem {
    String title;
    String content;
    String name;
    int review_number;

    public ReviewItem(int review_number, String name, String title, String content) {
        this.review_number = review_number;
        this.title = title;
        this.content = content;
        this.name = name;
    }

    public int getReview_number() {
        return review_number;
    }

    public void setReview_number(int review_number) {
        this.review_number = review_number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReviewItem{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
