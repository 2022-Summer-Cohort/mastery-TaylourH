package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/topics")
public class TopicController {

    private TopicRepository topicRepo;
    private PostRepository postRepo;

    public TopicController(TopicRepository topicRepo, PostRepository postRepo) {
        this.topicRepo = topicRepo;
        this.postRepo = postRepo;
    }
    @GetMapping("/{id}")
    public String displaySingleTopic(@PathVariable long id, Model model) {
        model.addAttribute("topic", topicRepo.findById(id).get());
        return "single-topic-template";
    }
    @PostMapping("/{id}/addPost")
    public String addPost(@PathVariable Long id, @RequestParam String title, @RequestParam String author, @RequestParam String content){
        Topic topic = topicRepo.findById(id).get();
//        Optional<Post> postOptional = postRepo.findByTitle(title);
        Post post1 = new Post(title, topic, content,author);
        postRepo.save(post1);
        topic.addPost(post1);
        topicRepo.save(topic);
        return "redirect:/topics/"+id;
    }

}
