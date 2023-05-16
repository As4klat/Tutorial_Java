import Clases.Colors;
import Clases.TerminalInteraction;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        ListView lv = new ListView();
        lv.generateSimpleList(42);

        boolean endApp = false;
        do {
            try {
                lv.printList();
                int option = lv.selectOption();
                if (option == lv.getList().size()) { endApp=true; } else{
                    Ejercicios ejercicios = new Ejercicios();
                    ejercicios.executeActivityById(option);
                }
            }catch(Exception e) {
                TerminalInteraction.seeTextLn(
                        Colors.ANSI_RED +
                                "\n-------------------------------------------------------------------------------------------------------\n" +
                                e.getMessage() +
                                "\n-------------------------------------------------------------------------------------------------------\n" +
                        Colors.ANSI_RESET
                );
                String resp = TerminalInteraction.getInput("Se ha producido un error. Deseas salir de la aplicación? Y/N",true);
                if (resp.trim().equalsIgnoreCase("y")){
                    endApp = true;
                }

            }

        }while (!endApp);

    }
}