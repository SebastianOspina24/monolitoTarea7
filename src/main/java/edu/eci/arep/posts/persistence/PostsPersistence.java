package edu.eci.arep.posts.persistence;

import java.util.Queue;

import edu.eci.arep.posts.models.Posts;

public interface PostsPersistence {
    
    public void addPost(Posts ps);

    public Queue<Posts> getPosts();

}
