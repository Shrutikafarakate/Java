
class Student {
    int roll_no;

    void setRollNo(int roll_no) {
        this.roll_no = roll_no;
    }

    void getRollNo() {
        System.out.println("Roll Number: " + roll_no);
    }
}


class Test extends Student {
    int sub1, sub2;

    void setMarks(int sub1, int sub2) {
        this.sub1 = sub1;
        this.sub2 = sub2;
    }

    void getMarks() {
        System.out.println("Marks of Subject 1: " + sub1);
        System.out.println("Marks of Subject 2: " + sub2);
    }
}


class Result extends Test {
    void displayResult() {
        int total = sub1 + sub2;
        double percentage = total / 2.0;

        getRollNo();
        getMarks();
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage + "%");
    }
}


public class MultilevelInheritanceTest {
    public static void main(String[] args) {
        Result result = new Result();

        result.setRollNo(101);
        result.setMarks(85, 90);
        result.displayResult();
    }
}
