package kvo.spring.projects.d_proj.Controller;

import jakarta.websocket.server.PathParam;
import kvo.spring.projects.d_proj.model.User;
import kvo.spring.projects.d_proj.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> FindAllUser(){
        System.out.println("test FindAllUser");
        return userService.findAllUser();
    };

    @PostMapping("/save_user")
    public User saveUser(@RequestBody User user){
        System.out.println("test saveUser");
        return userService.saveUser(user);
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
