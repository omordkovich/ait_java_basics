package ait.forum.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Post implements Comparable<Post>{
    private int postId;
    private String title;
    private String author;
    private String content;
    private LocalDateTime date;
    private int likes;

    public Post(int postId, String title, String author, String content) {
        this.postId = postId;
        this.title = title;
        this.author = author;
        this.content = content;
        this.date = LocalDateTime.now();
    }

    public int addLike() {
        return this.likes++;
    }

    public int unlike() {
        if (this.likes > 0) {
            return this.likes--;
        } else {
            return 0;
        }
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getLikes() {
        return likes;
    }

    @Override
    public String toString() {
        return String.format("Post ID: %d; Title: %s; Author: %s; Content: %s; At: %s; Likes: %d", postId, title, author, content, date, likes);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Post post)) return false;
        return postId == post.postId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(postId);
    }

    @Override
    public int compareTo(Post o) {
        return this.author.compareTo(o.author);
    }
}
