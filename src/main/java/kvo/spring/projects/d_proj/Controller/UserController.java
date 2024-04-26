package kvo.spring.projects.d_proj.Controller;

import jakarta.websocket.server.PathParam;
import kvo.spring.projects.d_proj.model.User;
import kvo.spring.projects.d_proj.service.DepartmentService;
import kvo.spring.projects.d_proj.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String FindAllUser(Model model){
        System.out.println("test FindAllUser");
        model.addAttribute("users", userService.findAllUser());
        User user = new User();
        model.addAttribute("user", user);
        System.out.println(userService.findAllUser());
        //return userService.findAllUser();
        return "index";
    };

    @PostMapping("/save_user")
    public String saveUser(User user, Model model){
        System.out.println("test saveUser");
        model.addAttribute("user", userService.saveUser(user));
        //return userService.saveUser(user);
        return "redirect:/api/v1/users";
    };
    @GetMapping("/{familiyaUser}")
    public List<User> findByFamiliyaUser(@PathVariable String  familiyaUser){
        System.out.println("test findByFamiliyaUser");
        return userService.findByFamiliyaUser(familiyaUser);
    };
    @GetMapping("/user/{id}")
    public User findByID(@PathVariable Long id){
        System.out.println("test findByID");
        return userService.findById(id);
    };
    @DeleteMapping("/delete_user")
    public void deleteUser(@PathParam("id") Long id){
        System.out.println("test deleteUser");
        userService.deleteById(id);
    };
}
