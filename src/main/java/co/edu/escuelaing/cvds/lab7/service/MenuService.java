package co.edu.escuelaing.cvds.lab7.service;
import co.edu.escuelaing.cvds.lab7.model.Menu;
import co.edu.escuelaing.cvds.lab7.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;

    public void realizarPedido(String nombrePlato) {
        Menu menu = menuRepository.findByPlato(nombrePlato);
        if (menu != null && menu.getUnidades() > 0) {
            menu.setUnidades(menu.getUnidades() - 1);
            menuRepository.save(menu);
        }
    }
    public void guardarMenus() {
        Menu menu1 = new Menu("lomo", 20000, "pronto", 20);
        menuRepository.save(menu1);
        Menu menu2 = new Menu("ceviche", 20000, "pronto", 20);
        menuRepository.save(menu2);
        Menu menu3 = new Menu("ajiaco", 15000, "lejos", 4);
        menuRepository.save(menu3);
        Menu menu4 = new Menu("empanadas", 2000, "pronto", 2);
        menuRepository.save(menu4);
    }

    public List<Menu> getAllMenuItems() {
        return menuRepository.findAll();
    }
}