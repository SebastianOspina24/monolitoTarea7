package edu.eci.arep.posts.models;

public class Posts{
    private String text;

    public Posts(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
