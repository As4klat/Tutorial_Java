package Tareas;
import Clases.Colors;
import Clases.Ejercicio;
import Clases.TerminalInteraction;

import java.net.PasswordAuthentication;

public class Ej4 extends Ejercicio{
    private final String name;

    public Ej4(String _NAME) {
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
            boolean allOk = false;
            String errEntrada = "";
            double valorX;
            double valorY;
            double valorZ;

            while(!allOk){
                try {
                    if (errEntrada.isEmpty() || errEntrada.equals("x")) {
                        String valorXString = TerminalInteraction.getInput("Introduzca el valor de 'X': ",false);
                        try { valorX = Double.parseDouble(valorXString); }catch (Exception e){ throw new Exception("x"); }
                        errEntrada = "";
                    }
                    if (errEntrada.isEmpty() || errEntrada.equals("y")) {
                        String valorYString = TerminalInteraction.getInput("Introduzca el valor de 'Y': ",false);
                        try { valorY = Double.parseDouble(valorYString); }catch (Exception e){ throw new Exception("y"); }
                        errEntrada = "";
                    }
                    if (errEntrada.isEmpty() || errEntrada.equals("z")) {
                        String valorZString = TerminalInteraction.getInput("Introduzca el valor de 'Z': ",false);
                        try { valorZ = Double.parseDouble(valorZString); }catch (Exception e){ throw new Exception("z"); }
                        errEntrada = "";
                    }
                    allOk = true;
                }catch (Exception e) {
                    errEntrada = e.getMessage();
                }
            }
        }while(!TerminalInteraction.getInput("¿Deseas salir del ejercicio? y/n",true).equals("y"));
    }
}
