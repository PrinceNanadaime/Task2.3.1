package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UsersController {

    private final UserDao userDao;

    @Autowired
    public UsersController(UserDao userDao) {
        this.userDao = userDao;
    }


    @GetMapping()
    public String getUsers (Model model) {
        model.addAttribute("user", userDao.getUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userDao.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "pages/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        userDao.save(user);
        return bindingResult.hasErrors()?"pages/new": "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDao.show(id));
        return "pages/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id) {
        if(bindingResult.hasErrors()) return "pages/edit";
        userDao.update(id, user);
        return bindingResult.hasErrors()?"pages/edit": "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userDao.delete(id);
        return "redirect:/user";
    }
}