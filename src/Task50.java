import java.util.*;


public class Task50 {

    public static void main(String[] args)
    {
        Scanner ui = new Scanner(System.in);
        System.out.print("Число: ");
        int value  = ui.nextInt();
        System.out.print("Результа: " + isNule(value));

    }

    public static boolean isNule(int value)
    {
        String temp = Integer.toString(value);
        int valuecheck = Character.getNumericValue(temp.charAt(0));
        for (int i = 1; i < temp.length();i++)
        {
            int chec =  Character.getNumericValue(temp.charAt(i));
            if (valuecheck > chec && chec != 0)
            {
                return false;
            }
        }
        return true;
    }


}
