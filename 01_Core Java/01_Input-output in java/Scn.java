import java.util.*;

public class Scn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        char gender = scanner.next().charAt(0);
        long contactNumber = scanner.nextLong();
        double cgpa = scanner.nextDouble();

        // correctly obtained.
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Mobile Number: " + contactNumber);
        System.out.println("CGPA: " + cgpa);
    }

}
