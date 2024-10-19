import java.util.Scanner;

public class Keyboard {
    private final Scanner input;

    public Keyboard()
    {
        input = new Scanner(System.in);
    }

    public int getQuantity()
    {
        return input.nextInt();
    }
}
