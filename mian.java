
public class mian {
    public static void main(String[] args) {
        Hashtables<String, String> object = new Hashtables<>(5);
        object.insert("12", "Ahsan");
        object.insert("12", "Ahsan");
        object.insert("2", "Ali");
        object.print();
        object.delete("12");
        object.print();
    }
}
