class StaticExample {
    static int count; // Static variable

    // Static block
    static {
        System.out.println("Static block executed.");
        count = 10;
    }

    // Static method
    static void displayCount() {
        System.out.println("Count value: " + count);
    }

    public static void main(String[] args) {
        System.out.println("Main method executed.");
        displayCount();
    }
}
