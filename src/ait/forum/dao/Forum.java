package ait.forum.dao;

import ait.forum.model.Post;

import java.time.LocalDate;

public interface Forum {
    boolean addPost(Post post);

    boolean removePost(int postId);

    boolean updatePost(int postId, String content);

    Post getPostById(int postId);

    Post[] getPostByAuthor(String author);

    Post[] getPostByAuthor(String Author, LocalDate dateFrom, LocalDate dateTo);

    int size();
}
