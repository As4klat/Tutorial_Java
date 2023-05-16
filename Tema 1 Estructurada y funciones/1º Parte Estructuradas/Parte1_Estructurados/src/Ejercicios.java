import Clases.Ejercicio;
import Tareas.Ej1;

import java.util.HashMap;
import java.util.Map;

public class Ejercicios {
    private Map<Integer, Ejercicio> mapEje = new HashMap<>();

    public Ejercicios() {
        mapEje.put(1,new Ej1("Ejercicio 1"));
    }

    public void executeActivityById(int id) {
        mapEje.get(id).run();
    }
}
