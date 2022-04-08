package edu.eci.arep.posts.persistence.impl;

import java.util.LinkedList;
import java.util.Queue;

import edu.eci.arep.posts.models.Posts;
import edu.eci.arep.posts.persistence.PostsPersistence;

public class PostsPersistenceImpl implements PostsPersistence{

    private static Queue<Posts> cola = new LinkedList<>();


    @Override
    public void addPost(Posts ps) {
        if(cola.size()==10)cola.peek();
        cola.add(ps);
    }

    @Override
    public Queue<Posts> getPosts() {
        return cola;
    }
    
}
