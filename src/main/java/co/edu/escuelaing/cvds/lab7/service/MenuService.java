package co.edu.escuelaing.cvds.lab7.service;
import co.edu.escuelaing.cvds.lab7.model.Menu;
import co.edu.escuelaing.cvds.lab7.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService{
    @Autowired
    MenuRepository menuRepository;
    public void guardarMenus() {
        Menu menu1 = new Menu(001,"lomo",20000,"pronto");
        menuRepository.save(menu1);
        Menu menu2 = new Menu(002,"ceviche", 20000, "pronto");
        menuRepository.save(menu2);
        Menu menu3 = new Menu(003,"ajiaco", 15000, "lejos");
        menuRepository.save(menu3);
        Menu menu4 = new Menu(004,"empanadas", 2000, "pronto");
        menuRepository.save(menu4);
    }
}