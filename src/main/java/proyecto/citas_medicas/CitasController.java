package proyecto.citas_medicas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CitasController {
    private final List<Cita> citas = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("citas", citas); // Enviamos la lista de citas al modelo
        return "index"; 
    }

    @PostMapping("/agendar")
    public String agendarCita(@RequestParam String nombre, 
                               @RequestParam String fecha, 
                               @RequestParam String hora, 
                               Model model) {
        citas.add(new Cita(nombre, fecha, hora)); // Agregamos la cita a la lista
        model.addAttribute("citas", citas); // Actualizamos la lista de citas en el modelo
        return "index"; // Regresamos a la vista principal
    }

    public static class Cita {
        private final String nombre;
        private final String fecha;
        private final String hora;

        public Cita(String nombre, String fecha, String hora) {
            this.nombre = nombre;
            this.fecha = fecha;
            this.hora = hora;
        }

        public String getNombre() { return nombre; }
        public String getFecha() { return fecha; }
        public String getHora() { return hora; }
    }
}
