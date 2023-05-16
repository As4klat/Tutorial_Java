import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListView {

    private List<String> list;

    public ListView() {
        list = new ArrayList<>();
    }

    public ListView(ArrayList<String> list) {
        this();
        this.list = List.copyOf(list);
    }

    public void printList() {
        StringBuilder str = new StringBuilder();
        for (String s : list) {
            str.append("%d. %s\n".formatted((list.indexOf(s)+1), s));
        }
        System.out.println(str);
    }

    public void generateSimpleList(int nEjercicios) {
        for (int i = 0; i < nEjercicios; i++) {
            list.add("Ejercicio %d".formatted(i + 1));
        }
        list.add("Salir");
    }

    public int selectOption() {
        System.out.print("Seleccione una opción: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
