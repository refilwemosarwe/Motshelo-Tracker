
public class MotsheloTracker {
    public static void main(String[] args) {
        Person p1 = new Person("M091", "Refilwe", "71234567");
        p1.contribute(500);
        p1.contribute(300);

        System.out.println(p1);

    }
}
