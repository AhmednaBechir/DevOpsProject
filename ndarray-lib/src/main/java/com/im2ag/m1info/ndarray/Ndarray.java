import java.util.ArrayList;
import java.util.List;

public class Ndarray {
    List l;
    int size;

    public Ndarray() {
        l = new ArrayList<>();
    }

    List getList() {
        return l;
    }

    int getSize() {
        return size;
    }
}