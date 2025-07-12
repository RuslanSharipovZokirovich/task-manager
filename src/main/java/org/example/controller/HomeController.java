package org.example.controller;


import org.example.model.Tasks;
import org.example.repository.TasksRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    private final TasksRepository repo;

   public HomeController(TasksRepository repo) {
       this.repo = repo;
   }

    @GetMapping("/")
    public String homePage(Model model) {
       model.addAttribute("tasks", repo.findAll());
       return "index";
    }

    @GetMapping("/create")
    public String createPage() {
        return "create_task";
    }

    @PostMapping("/create-task")
    public String createTask(@RequestParam String name,
                             @RequestParam String descriptions,
                             @RequestParam boolean status) {
        Tasks tasks = new Tasks();
        tasks.setName(name);
        tasks.setDescriptions(descriptions);
        tasks.setCreatedAt(LocalDateTime.now());
        tasks.setStatus(status);
        repo.save(tasks);
        return "redirect:/";
    }

    @PostMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/tasks/update-status/{id}")
    public String updateStatus(@PathVariable Long id,
                               @RequestParam boolean status) {
        Tasks task = repo.findById(id).orElseThrow();
        task.setStatus(status);
        repo.save(task);
        return "redirect:/";
    }

    @GetMapping("/update-task/{id}")
    public String updateTask(@PathVariable Long id, Model model) {
       Tasks task = repo.findById(id).orElseThrow();
       model.addAttribute("task", task);
       return "update-task";
    }

    @PostMapping("/tasks/update-task/{id}")
    public String updateTask(@PathVariable Long id,
                             @RequestParam String name,
                             @RequestParam String descriptions,
                             @RequestParam LocalDateTime createdAt,
                             @RequestParam boolean status) {
       Tasks tasks = repo.findById(id).orElseThrow();
       tasks.setId(id);
       tasks.setName(name);
       tasks.setDescriptions(descriptions);
       tasks.setCreatedAt(createdAt);
       tasks.setStatus(status);
       repo.save(tasks);
       return "redirect:/";

    }

}
