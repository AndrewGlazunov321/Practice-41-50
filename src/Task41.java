import java.util.*;

public class Task41 {



    public static void main(String[] args)
    {
        String value,valueone;
        Scanner ui = new Scanner(System.in);
        System.out.print("Введите текст: ");
        value = ui.nextLine();
        System.out.print("Введите текст: ");
        valueone = ui.nextLine();

        String[] resultone = sameLetterPattern(value).split("[ ]");
        String[] resulttwo = sameLetterPattern(valueone).split("[ ]");

        System.out.println("Результат: " + checkResult(resultone,resulttwo));

    }

    public static String sameLetterPattern(String value)
    {
        ArrayList<String> symbol = new ArrayList<String>();
        ArrayList<String> code = new ArrayList<String>();
        String result = "";
        for (int i = 0; i < value.length();i++)
        {
            if (!checkSymbol(value.charAt(i),symbol,i))
            {
                symbol.add(Character.toString(value.charAt(i)));
                code.add(createCode(code));
            }
            else
            {
                code.add(code.get(findIndex(symbol,code,value.charAt(i))));
            }

        }
        for (int i = 0; i < code.size(); i++)
        {
            result += " " + code.get(i);
        }
        return result;
    }


    public static boolean checkSymbol(char a,ArrayList<String> symbol, int i)
    {
        for (int j = 0; j < symbol.size();j++)
        {
            char temp = symbol.get(j).charAt(0);
            if (temp == a)
            {
                return true;
            }
        }
        return false;
    }

    public static String createCode(ArrayList<String> codeset)
    {
        String code = "";
        for (int i = 0; i < codeset.size()+1; i++)
        {
            if (i % 2 == 0)
            {
                code += "#";
            }
            else
            {
                code += "/";
            }
        }
        return code;
    }

    public static int findIndex(ArrayList<String> symbol, ArrayList<String> code, char temp)
    {
        int index = -1;
        for (int i = 0; i < symbol.size();i++)
        {
            if (temp == symbol.get(i).charAt(0))
            {
                index = i;
            }
        }
        return index;
    }

    public static boolean checkResult(String[] resultone, String[] resulttwo)
    {
        for (int i = 0; i < resultone.length;i++)
        {
            if (!(resultone[i].equals(resulttwo[i])))
            {
                return false;
            }
        }
        return true;

    }


}
