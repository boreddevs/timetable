package app.tt;

public class Main {

    public static void main(String[] args) {

        /*System.out.println("Osszes ora:");
        printLessons();

        System.out.println("Rendezett orak:");
        printSortedLessons();

        System.out.println("Osszes tanar:");
        printTeachers();

        System.out.println("Rendezett tanarok:");
        printSortedTeachers();*/

        final String s = (new FileReader().read("test/1.txt")[0]).toString();
        System.out.println(s);

    }
}
