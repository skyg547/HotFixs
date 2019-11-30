package com.hotfix.Cumu;

public class ReviewItem {
    String title;
    String content;

    public ReviewItem(String title, String content) {
        this.title = title;
        this.content = content;
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

    @Override
    public String toString() {
        return "ReviewItem{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
