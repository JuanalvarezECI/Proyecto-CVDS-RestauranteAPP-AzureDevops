package co.edu.escuelaing.cvds.lab7.repository;
import co.edu.escuelaing.cvds.lab7.model.Menu;
import co.edu.escuelaing.cvds.lab7.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    List<Menu> findAll();
    Menu findByPlato(String plato);
    Menu save(Menu menu);

}
