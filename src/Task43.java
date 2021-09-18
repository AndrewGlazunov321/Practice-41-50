import java.util.*;

public class Task43 {

    public static void main(String[] args)
    {
        long value;
        Scanner ui = new Scanner(System.in);
        System.out.print("Введите число: ");
        value = ui.nextLong();
        System.out.print(digitsCount(value));
    }



    public static int digitsCount(long value)
    {
        return (int) Math.ceil(Math.log10(value + 2));
    }


}
