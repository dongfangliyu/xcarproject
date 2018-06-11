import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jwdstef
 * @Description:
 * @Date 2017/10/23
 */
public class Test {
    public static void main(String[] args) {
        List l = new ArrayList();
        l.add("A");
        l.add(0,"B");
        System.out.print(l.get(0));
    }
}
