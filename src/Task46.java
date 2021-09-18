import java.util.*;

public class Task46 {

    public static void main(String[] args)
    {

        Scanner ui = new Scanner(System.in);
        System.out.print("Количество одноклассников: ");
        int value  = ui.nextInt();
        int[] array = new int[value];
        ui.nextLine();
        for (int i = 0; i < value; i++)
        {
            System.out.print("Процент прохождения теста: ");
            array[i] = (ui.nextInt() - 5);
        }

        System.out.print("Результат: " + takeDownAverage(array) + " %");

    }

    public static int takeDownAverage(int[] array)
    {
        int count = 0;
        for (int i = 0; i < array.length;i++)
        {
            count += array[i];
        }
        return Math.round(count/array.length) - (5 * array.length);
    }


}
