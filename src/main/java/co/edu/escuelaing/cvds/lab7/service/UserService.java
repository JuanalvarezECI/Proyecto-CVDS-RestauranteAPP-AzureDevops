package co.edu.escuelaing.cvds.lab7.service;
import co.edu.escuelaing.cvds.lab7.model.Menu;
import co.edu.escuelaing.cvds.lab7.model.User;
import co.edu.escuelaing.cvds.lab7.repository.MenuRepository;
import co.edu.escuelaing.cvds.lab7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public void guardarUsuarios(){
        User user1 = new User("demo1", "demo1","demo1@demo.com");
        userRepository.save(user1);
        User user2 = new User("demo2", "demo2","demo2@demo.com");
        userRepository.save(user2);
        User user3 = new User("juan.jc", "demo","juan@demo.jc.com");
        userRepository.save(user3);

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