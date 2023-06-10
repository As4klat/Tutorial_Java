import Clases.Ejercicio;
import Tareas.Ej1;
import Tareas.Ej2;
import Tareas.Ej3;
import Tareas.Ej4;

import java.util.HashMap;
import java.util.Map;

public class Ejercicios {
    private Map<Integer, Ejercicio> mapEje = new HashMap<>();

    public Ejercicios() {
        mapEje.put(1,new Ej1("Ejercicio 1"));
        mapEje.put(2,new Ej2("Ejercicio 2"));
        mapEje.put(3,new Ej3("Ejercicio 3"));
        mapEje.put(4,new Ej4("Ejercicio 4"));
    }

    public void executeActivityById(int id) {
        mapEje.get(id).run();
    }
}
