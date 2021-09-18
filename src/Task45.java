import java.util.*;

public class Task45 {

    public static void main(String[] args)
    {

        Scanner ui = new Scanner(System.in);
        System.out.print("Количество элементов в массиве: ");
        int value  = ui.nextInt();
        int[] array = new int[value];
        for (int i = 0; i < array.length; i++ )
        {
            array[i] = (int) (Math.random() * 16 + 5);
        }
        int result = longestRun(array);
        if (result == 0)
        {
            System.out.println("Результат: 1");
        }
        else
        {
            System.out.println("Результат: " + result);
        }

    }

    public static int longestRun(int[] array)
    {
        Arrays.sort(array);
        ArrayList<Integer> countlargest = new ArrayList<Integer>();
        int lenght = 0;
        for (int i = 0; i < array.length - 1; i++)
        {
            if (Math.abs(array[i+1] - array[i]) == 1)
            {
                if (lenght == 0)
                {
                    lenght+=2;
                }
                else
                {
                    lenght++;
                }
            }
            else if(Math.abs(array[i+1] - array[i]) > 1 && lenght != 0)
            {
                countlargest.add(lenght);
                lenght = 0;
            }
        }
        countlargest.add(lenght);
        if (countlargest.size() > 0)
        {
            return Collections.max(countlargest);
        }
        return lenght;
    }


}
