import org.junit.jupiter.api.Test;

// enum is short for 'enumerate'
// enum与class、interface同级
enum Apple {
    // Enum constants
    // 枚举常量隐式声明为Apple的公共、静态和final成员
    // 枚举类型为“自类型化”，即只能在枚举类型内通过枚举常量来实例化
    Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);// 枚举常量格式与构造方法相关联，如果传参为空枚举常量括号可省略不写
    private final int price;
    // Constructor
    Apple(int p) {
        price = p;
    }
    int getPrice() {
        return price;
    }
}

public class Demos {
    /**
     * 枚举类型变量赋值
     */
    @Test
    void demo1() {
        Apple apple;

        apple = Apple.RedDel;//枚举类型的变量只能赋值枚举常量
        System.out.println("Value of ap: " + apple);

        apple = Apple.GoldenDel;
        System.out.println("Value of ap: " + apple);
    }

    /**
     * 枚举的values()与valueOf()方法
     */
    @Test
    void demo2() {

        System.out.println("Here are all Apple constants:");

        // use values()
        Apple[] allApples = Apple.values();
        for (Apple a :
                allApples) {
            System.out.println(a);
        }
        System.out.println();

        // use valueOf()
        Apple ap = Apple.valueOf("Winesap");
        System.out.println(ap);
    }

    /**
     * 枚举类型的构造方法使用
     */
    @Test
    void demo3() {
        Apple ap;
        // Display price of Winesap
        System.out.println("Winesap costs " +
                Apple.Winesap.getPrice() +
                " cents.\n");
        // Display all apples and price.
        System.out.println("All apple prices:");
        for (Apple a :
                Apple.values()) {
            System.out.println(a + "costs " +
                    a.getPrice() + " cents.");
        }
    }

    /**
     * 枚举的ordinal()、compareTo()和equals()方法
     * ordinal()获取枚举常量的序数值
     * compareTo()比较枚举常量的序数值
     * equals()判断枚举类型是否相等（枚举对equals进行了重写）
     */
    @Test
    void demo4() {
        Apple ap, ap2, ap3;

        // Obtain all ordinal values using ordinal().
        System.out.println("Here are all apples constants and their ordinal values");

        for (Apple a :
                Apple.values()) {
            System.out.println(a + " " + a.ordinal());
        }
        System.out.println();

        ap = Apple.RedDel;
        ap2 = Apple.GoldenDel;
        ap3 = Apple.RedDel;

        // Demonstrate compareTo() and equals()
        if (ap.compareTo(ap2) < 0) {
            System.out.println(ap + " comes before " + ap);
        }
        if (ap.compareTo(ap2) > 0) {
            System.out.println(ap2 + " comes before " + ap);
        }
        if (ap.compareTo(ap2) == 0) {
            System.out.println(ap + " equals " + ap2);
        }
        System.out.println();

        if (ap.equals(ap2)) {
            System.out.println("Error!");
        }
        if (ap.equals(ap3)) {
            System.out.println(ap + " equals " + ap3);
        }
        if (ap == ap3) {
            System.out.println(ap + " == " + ap3);
        }
    }
}


