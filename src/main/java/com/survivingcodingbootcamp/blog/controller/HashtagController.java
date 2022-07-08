package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hashtags")
public class HashtagController {
    private HashtagRepository hashtagRepo;
    private PostRepository postRepo;

    public HashtagController(HashtagRepository hashtagRepo, PostRepository postRepo) {
        this.hashtagRepo = hashtagRepo;
        this.postRepo = postRepo;
    }
    @RequestMapping("")
    public String showAllHashtags(Model model) {
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "hashtags";
    }

    @RequestMapping("/{id}")
    public String showHashTagPosts(Model model, @PathVariable Long id) {
        model.addAttribute("hashtag", hashtagRepo.findById(id).get());
        return "single-hashtag-template";
    }
}
