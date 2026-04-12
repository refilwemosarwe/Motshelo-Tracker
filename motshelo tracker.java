
public class MotsheloTracker {
    public static void main(String[] args) {
        Person p1 = new Person("M001", "Refilwe", "71234567");
        p1.contribute(500);
        p1.contribute(300);

        System.out.println(p1);
        // Output: Person{memberId='M001', name='Refilwe', phone='71234567', contributions=800.0}
    }
}
