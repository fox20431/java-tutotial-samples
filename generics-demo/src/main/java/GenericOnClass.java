/**
 * set generic on class
 *
 * if you want to limit generic type range, you can use "extends" or "super".
 * for example "T extends String", it means T is String's child class.
 *
 * @param <T>
 */
public class GenericOnClass<T> {

    private T type;

    // the generic is used as parameter
    public void setFliedOfTType(T type) {
        this.type = type;
    }

    // the generic is used as return value, you must return the value of T type.
    T getFliedOfTType() {
        return type;
    }
}
