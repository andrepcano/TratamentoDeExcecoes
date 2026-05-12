import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TryCatch {
    public static void main(String[] args) {

        Scanner sc = new  Scanner(System.in);

        try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        }
        // InputMismatchException (OU) ArrayIndexOutOfBoundsException (multi-catch)
        catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("End of Program!");
        }



        sc.close();
    }
}