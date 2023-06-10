package Tareas;
import Clases.Colors;
import Clases.Ejercicio;
import Clases.TerminalInteraction;

public class Ej2 extends Ejercicio{
    private final String name;

    public Ej2(String _NAME) {
        super(_NAME);
        name = _NAME;
    }

    @Override
    public void run() {
        TerminalInteraction.seeTextLn(
                Colors.ANSI_GREEN +
                        "\n---------------------------------------------------\n" +
                        "       Ejecutando ejercicio: " + name +
                        "\n---------------------------------------------------\n" +
                        Colors.ANSI_RESET
        );

        do {
            boolean err = true;
            int anno = 0;
            String textoInput = "Introduzca un año: ";
            while(err){
                try {
                    String annoString = TerminalInteraction.getInput(textoInput,false);
                    anno = Integer.parseInt(annoString);
                    err = false;
                }catch (Exception e) {
                    textoInput = "Error en los datos introducidos. Solo se admiten números enteros.\n" + textoInput;
                }
            }

            TerminalInteraction.seeTextLn("El año " + anno + (anno%4==0 ? " es bisiesto.":" no es bisiesto."));

        }while(!TerminalInteraction.getInput("¿Deseas salir del ejercicio? y/n",true).equals("y"));
    }
}
