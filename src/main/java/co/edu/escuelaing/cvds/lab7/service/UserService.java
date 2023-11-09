package co.edu.escuelaing.cvds.lab7.service;
import co.edu.escuelaing.cvds.lab7.model.Menu;
import co.edu.escuelaing.cvds.lab7.model.User;
import co.edu.escuelaing.cvds.lab7.repository.PaisRepository;
import co.edu.escuelaing.cvds.lab7.repository.PlatoRepository;
import co.edu.escuelaing.cvds.lab7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    PlatoRepository platoRepository;
    PaisRepository paisRepository;

    public void guardarUsuarios(){
        User user1 = new User("demo1", "demo1","correo23");
        userRepository.save(user1);
        User user2 = new User("demo2", "demo2","correo23");
        userRepository.save(user2);
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
    public void guardarPais(){
        User user1 = new User("demo1", "demo1","correo23");
        paisRepository.save(user1);
        User user2 = new User("demo2", "demo2","correo23");
        paisRepository.save(user2);
    }
    public void guardarMenus() {
        Menu menu1 = new Menu(001,"lomo",20000,"pronto");
        platoRepository.save(menu1);
        Menu menu2 = new Menu(002,"ceviche", 20000, "pronto");
        platoRepository.save(menu2);
        Menu menu3 = new Menu(003,"ajiaco", 15000, "lejos");
        platoRepository.save(menu3);
        Menu menu4 = new Menu(004,"empanadas", 2000, "pronto");
        platoRepository.save(menu4);
    }
}