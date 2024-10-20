import java.util.Scanner;

public class Input {
    private final Scanner input;

    public Input()
    {
        input = new Scanner(System.in);
    }

    public int getQuantity()
    {
        return input.nextInt();
    }
}
