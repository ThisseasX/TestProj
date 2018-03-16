package controllers;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllUsers(Model m) {
        m.addAttribute("list", userService.getAll());
        return "user";
    }

    @GetMapping("/{id}")
    public String getUserById(Model m, @PathVariable int id) {
        m.addAttribute("user", userService.getById(id));
        return "user";
    }

    @GetMapping("/{name}/{surname}")
    public String insert(Model m,
                         @PathVariable String name,
                         @PathVariable String surname) {
        User u = new User();
        u.setUsername(name);
        u.setPassword(surname);
        userService.insert(u);
        m.addAttribute("user", u);
        return "user";
    }
}
