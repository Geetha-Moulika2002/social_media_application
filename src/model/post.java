package model;

import java.util.*;

public class post {
    public String content;
    public user author;
    public int likes;
    public List<String> comments;

    public post(String content, user author) {
        this.content = content;
        this.author = author;
        this.likes = 0;
        this.comments = new ArrayList<>();
    }
}