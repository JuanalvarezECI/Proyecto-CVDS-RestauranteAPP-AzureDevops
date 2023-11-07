package co.edu.escuelaing.cvds.lab7.service;
import co.edu.escuelaing.cvds.lab7.model.User;
import co.edu.escuelaing.cvds.lab7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public void guardarUsuarios(){
        User user1 = new User("usuario1", "contraseña1");
        userRepository.save(user1);
    }

    public User findUserByUsername(String username) {
        List<User> users = userRepository.findByUsername(username);
        System.out.println("users" + users);
        if (users.isEmpty()) {
            return null;
        }
        else {
            return userRepository.findByUsername(username).get(0);
        }
    }
}