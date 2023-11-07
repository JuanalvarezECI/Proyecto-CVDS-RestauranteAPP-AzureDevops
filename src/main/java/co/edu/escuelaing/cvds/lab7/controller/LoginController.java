package co.edu.escuelaing.cvds.lab7.controller;
import co.edu.escuelaing.cvds.lab7.model.User;
import co.edu.escuelaing.cvds.lab7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showLoginPage() {
        return "login";
    }

    @PostMapping
    public String login(String username, String password, Model model) {
        User user = userService.findUserByUsername(username);
        System.out.println(user);
        if (user != null && user.getPassword().equals(password)) {
            // Autenticación exitosa
            return "home"; // Redirige a la página de inicio
        }
        else {
            // Autenticación fallida
            model.addAttribute("error", "Credenciales inválidas");
            return "login";
        }
    }
}
