


public class Person extends Member {
    private String name;
    private String phoneNumber;

    public Person(String memberId, String name, String phoneNumber) {
        super(memberId); 
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
               "memberId='" + getMemberId() + '\'' +
               ", name='" + name + '\'' +
               ", phone='" + phoneNumber + '\'' +
               ", contributions=" + getTotalContributions() +
               '}';
    }
}
