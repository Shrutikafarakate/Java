package LibraryManagement;

public class Member {
    private final String name;
    private final int memberId;
    private final String email;

    public Member(String name, int memberId, String email) {
        this.name = name;
        this.memberId = memberId;
        this.email = email;
    }

    public String getName() { return name; }
    public int getMemberId() { return memberId; }
    public String getEmail() { return email; }

    public void displayMemberInfo() {
        System.out.println("Name     : " + name);
        System.out.println("Member ID: " + memberId);
        System.out.println("Email    : " + email);
    }
}
