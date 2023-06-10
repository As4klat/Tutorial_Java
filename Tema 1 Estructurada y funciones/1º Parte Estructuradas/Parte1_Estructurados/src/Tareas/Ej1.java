package Tareas;
import Clases.Colors;
import Clases.Ejercicio;
import Clases.TerminalInteraction;

public class Ej1 extends Ejercicio{
    private final String name;

    public Ej1(String _NAME) {
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
            int firstNumber, secondNumber;
            firstNumber = Integer.parseInt(TerminalInteraction.getInput("Introduzca el primer número: ",false));
            secondNumber = Integer.parseInt(TerminalInteraction.getInput("Introduzca el segundo número: ",false));

            if(firstNumber > secondNumber) { TerminalInteraction.seeTextLn(firstNumber + " - " + secondNumber + " = " + (firstNumber-secondNumber)); }
            else { TerminalInteraction.seeTextLn(secondNumber + " - " + firstNumber + " = " + (secondNumber-firstNumber)); }
        }while(!TerminalInteraction.getInput("¿Deseas salir del ejercicio? y/n",true).equalsIgnoreCase("y"));
    }
}
