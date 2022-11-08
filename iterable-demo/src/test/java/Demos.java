import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * 任何继承Iterable接口的对象都可以迭代
 * Collection继承Iterable
 * 提示：可以从源码看起
 */
class Demos {

    /**
     * ArrayList测试遍历
     */
    @Test
    void arrayListDemo() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("No.1");
        strings.add("No.2");
        strings.add("No.3");
        strings.add("No.4");
        strings.add("No.5");

        System.out.println("foreach处理便利：");
        for (String string : strings) {
            System.out.println(string);
        }

        System.out.println("Iterator对象方法处理遍历：");
        ListIterator<String> stringListIterator = strings.listIterator();
        while (stringListIterator.hasNext()){
            String string = stringListIterator.next();
            System.out.println(string);
        }
    }

}
