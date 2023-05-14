import java.util.ArrayList;
import java.util.List;

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
            str.append("%d. %s\n".formatted(list.indexOf(s), s));
        }
        System.out.println(str);
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
