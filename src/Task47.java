import java.util.*;
import java.util.regex.*;

public class Task47 {

    public static void main(String[] args)
    {

        Scanner ui = new Scanner(System.in);
        System.out.print("Количество элементов в массиве: ");
        String text  = ui.nextLine();
        System.out.print("Результат: " + rearrange(text));

    }

    public static String rearrange(String text)
    {
        String[] array = text.split("[ ]");
        ArrayList<Integer> index = new ArrayList<Integer>();
        String[] resulttext = new String[array.length];

        Pattern pattern =  Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        int start = 0;
        while (matcher.find(start)) {
            String value = text.substring(matcher.start(), matcher.end());
            int result = Integer.parseInt(value);
            index.add(result-1);
            start = matcher.end();
        }

        for (int i = 0; i < array.length;i++)
        {
            String temp = "";
            for (int j = 0;j < array[i].length();j++)
            {
                if (Character.isLetter(array[i].charAt(j)))
                {
                    temp += array[i].charAt(j);
                }
            }
            array[i] = temp;
        }

        
        String temp = "";
        for (int i = 0; i < index.size();i++)
        {
            resulttext[index.get(i)] = array[i];
        }
        return String.join(" ",resulttext);
    }



}
