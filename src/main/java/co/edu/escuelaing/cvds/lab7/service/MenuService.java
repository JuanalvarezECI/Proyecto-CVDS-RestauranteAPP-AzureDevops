package co.edu.escuelaing.cvds.lab7.service;
import co.edu.escuelaing.cvds.lab7.model.Menu;
import co.edu.escuelaing.cvds.lab7.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        Menu menu1 = new Menu("lomo de cerdo", 20000, "2023-12-20", 20);
        menuRepository.save(menu1);
        Menu menu2 = new Menu("ceviche", 20000, "2023-12-07", 20);
        menuRepository.save(menu2);
        Menu menu3 = new Menu("ajiaco", 15000, "2023-11-23", 4);
        menuRepository.save(menu3);
        Menu menu4 = new Menu("empanadas", 2000, "2023-11-23", 2);
        menuRepository.save(menu4);
    }

    public void aplicarDescuento() {
        List<Menu> menuItems = menuRepository.findAll();

        for (Menu menu : menuItems) {
            // Obtener la fecha actual
            Date fechaActual = new Date();

            // Parsear la fecha de caducidad del plato
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fechaCaducidad = sdf.parse(menu.getCaducidad());

                // Calcular la diferencia en días
                long diff = fechaCaducidad.getTime() - fechaActual.getTime();
                long diffDias = diff / (24 * 60 * 60 * 1000);

                // Aplicar descuento del 30% si la caducidad es menor a 2 semanas (14 días)
                if (diffDias < 14) {
                    double descuento = 0.3; // 30%
                    Integer precioConDescuento = (int) (menu.getPrecio() * (1 - descuento));
                    menu.setPrecio(precioConDescuento);
                    menuRepository.save(menu);
                }
            } catch (ParseException e) {
                e.printStackTrace(); // Manejar la excepción de parseo de fecha si es necesario
            }
        }
    }

    public List<Menu> getAllMenuItems() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(Integer id) {
        return menuRepository.findById(id).orElse(null);
    }

    public void modificarMenu(Menu menu) {
        menuRepository.save(menu);
    }

    public void agregarPlatillo(Menu menu) {

        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Parsear la fecha de caducidad del plato
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaCaducidad = sdf.parse(menu.getCaducidad());

            // Calcular la diferencia en días
            long diff = fechaCaducidad.getTime() - fechaActual.getTime();
            long diffDias = diff / (24 * 60 * 60 * 1000);

            // Aplicar descuento del 30% si la caducidad es menor a 2 semanas (14 días)
            if (diffDias < 14) {
                double descuento = 0.3; // 30%
                Integer precioConDescuento = (int) (menu.getPrecio() * (1 - descuento));
                menu.setPrecio(precioConDescuento);
                menuRepository.save(menu);
            }
        } catch (ParseException e) {
            e.printStackTrace(); // Manejar la excepción de parseo de fecha si es necesario
        }
    }
}