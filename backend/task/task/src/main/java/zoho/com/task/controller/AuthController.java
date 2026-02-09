package zoho.com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import zoho.com.task.model.User;
import zoho.com.task.repository.UserRepository;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="http://localhost:5176")
public class AuthController {

    @Autowired
    UserRepository userRepo;

    @PostMapping("/login")
    public User login(@RequestBody User request){

        User user = userRepo
                .findByUsername(request.getUsername())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if(!user.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}
