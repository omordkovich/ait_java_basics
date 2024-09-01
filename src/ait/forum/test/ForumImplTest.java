package ait.forum.test;

import ait.forum.dao.ForumImpl;
import ait.forum.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ForumImplTest {
    Post[] posts;
    ForumImpl forum;

    @BeforeEach
    void setUp() {
        forum = new ForumImpl();
        posts = new Post[4];
        posts[0] = new Post(123, "title1", "author1", "content");
        posts[0].setDate(LocalDateTime.now().minusDays(1));
        posts[1] = new Post(124, "title2", "author2", "content");
        posts[1].setDate(LocalDateTime.now().minusDays(2));
        posts[2] = new Post(125, "title3", "author1", "content");
        posts[2].setDate(LocalDateTime.now().minusDays(3));
        posts[3] = new Post(117, "title1", "author3", "content");
        posts[3].setDate(LocalDateTime.now().minusDays(6));

        for (int i = 0; i < posts.length; i++) {
            forum.addPost(posts[i]);
        }
    }

    @Test
    void addPost() {
        assertFalse(forum.addPost(null));
        assertFalse(forum.addPost(posts[1]));
        Post post = new Post(122, "title5", "author1", "content");
        assertTrue(forum.addPost(post));
        assertEquals(5, forum.size());
        post = new Post(156, "title9", "author3", "content");
        assertFalse(forum.addPost(post));
    }

    @Test
    void removePost() {
        assertTrue(forum.removePost(123));
        assertFalse(forum.removePost(321));
        assertEquals(3, forum.size());
    }

    @Test
    void updatePost() {
        assertTrue(forum.updatePost(123, "newContent"));
        assertEquals("newContent", forum.getPostById(123).getContent());
    }

    @Test
    void getPostById() {
        assertEquals(posts[0], forum.getPostById(123));
    }

    @Test
    void TestGetPostByAuthor() {
        Post[] expected = {posts[2], posts[0]};
        Post[] actual = forum.getPostByAuthor("author1");
        assertArrayEquals(expected, actual);

    }

    @Test
    void getPostByAuthorTime() {
        Post[] expected = {posts[0]};
        Post[] actual = forum.getPostByAuthor("author1", LocalDate.now().minusDays(2), LocalDate.now());
        assertArrayEquals(expected, actual);
    }

    @Test
    void size() {
        assertEquals(4, forum.size());
    }
}