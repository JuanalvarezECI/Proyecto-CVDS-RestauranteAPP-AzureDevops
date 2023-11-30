package co.edu.escuelaing.cvds.lab7.service;
import co.edu.escuelaing.cvds.lab7.model.Menu;
import co.edu.escuelaing.cvds.lab7.model.Preferencias;
import co.edu.escuelaing.cvds.lab7.repository.PreferenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PreferenciasService {

    private final PreferenciasRepository preferenciasRepository;

    @Autowired
    public PreferenciasService(PreferenciasRepository preferenciasRepository) {
        this.preferenciasRepository = preferenciasRepository;
    }

    public void guardarPreferencia(Preferencias preferencias) {
        preferenciasRepository.save(preferencias);
    }

    public List<Preferencias> obtenerTodasLasPreferencias() {
        return preferenciasRepository.findAll();
    }
    public void preferenciasprueba() {
        Preferencias preferencia1 = new Preferencias("Bandeja Paisa",  "es un plato típico de la región paisa en Colombia. Es conocido por su abundancia y variedad de ingredientes. Incluye arroz, frijoles, carne molida, chicharrón, huevo frito, plátano maduro y aguacate");
        preferenciasRepository.save(preferencia1);
        Preferencias preferencia2 = new Preferencias("Sancocho",  "s una sopa espesa y abundante que contiene varios tipos de carne como pollo, res o cerdo, así como maíz, yuca, plátano y otros vegetales.");
        preferenciasRepository.save(preferencia2);
        Preferencias preferencia3 = new Preferencias("Lechona",  " Consiste en un cerdo relleno con arroz, guisado con guisos y condimentos.");
        preferenciasRepository.save(preferencia3);
    }
}
