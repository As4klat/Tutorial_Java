package Tareas;
import Clases.Ejercicio;
public class Ej1 extends Ejercicio{
    private String name;

    public Ej1(String _NAME) {
        super(_NAME);
        name = _NAME;
    }

    @Override
    public void run() {
        System.out.println(name);
    }
}
