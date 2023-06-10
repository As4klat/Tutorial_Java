package Tareas;
import Clases.Colors;
import Clases.Ejercicio;
import Clases.TerminalInteraction;

public class Ej3 extends Ejercicio{
    private final String name;

    public Ej3(String _NAME) {
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
            final double transferencia = 166.3860;
            boolean err = true;
            double cantidad = 0;

            String textoInput = "Introduzca la cantidad deseada a convertir: ";
            while(err){
                try {
                    String cantidadString = TerminalInteraction.getInput(textoInput,false);
                    cantidad = Double.parseDouble(cantidadString);
                    err = false;
                }catch (Exception e) {
                    textoInput = "El valor introducido no es reconocible como valor numérico.\n" + textoInput;
                }
            }

            String monedaAlCamio = TerminalInteraction.getInput("Introduzca al tipo de moneda a realizar conversión. [peseta|euro]",true);

            double cantidadConvertida = 0;
            if (monedaAlCamio.trim().equalsIgnoreCase("peseta")) { cantidadConvertida = cantidad * transferencia; }
            else if (monedaAlCamio.trim().equalsIgnoreCase("euro")) { cantidadConvertida = cantidad / transferencia; }
            else{TerminalInteraction.seeTextLn("La moneda marcada no pertenece a ninguna de las opciones aportadas, cancelando...");}

            TerminalInteraction.seeTextLn("La conversión de '" + cantidad + "' a " + monedaAlCamio.trim() + " es: " + cantidadConvertida);

        }while(!TerminalInteraction.getInput("¿Deseas salir del ejercicio? y/n",true).equals("y"));
    }
}
