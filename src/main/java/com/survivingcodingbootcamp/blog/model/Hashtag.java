package com.survivingcodingbootcamp.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private long id;
    private String hashtagDescription;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Post> posts;

    public Hashtag(String hashtagDescription) {
        this.hashtagDescription = hashtagDescription;
        this.posts = new ArrayList<Post>();
    }

    public Hashtag() {
    }

    public long getId() {
        return id;
    }

    public String getHashtagDescription() {
        return hashtagDescription;
    }

    public Collection<Post> getPosts() {
        return posts;
    }
}
