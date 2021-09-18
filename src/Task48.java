import java.util.*;

public class Task48 {


    public static void main(String[] args)
    {

        Scanner ui = new Scanner(System.in);
        System.out.print("Первое число: ");
        int valueone  = ui.nextInt();
        System.out.print("Второе число: ");
        int valuetwo  = ui.nextInt();
        System.out.print("Результат: " + maxPossble(valueone,valuetwo));

    }

    public static String  maxPossble(int valueone,int valuetwo)
    {
        char[] tempone = Integer.toString(valueone).toCharArray();
        ArrayList<Integer> temponemax = new ArrayList<Integer>();
        char[] temptwo = Integer.toString(valuetwo).toCharArray();
        ArrayList<Integer> temptwomax = new ArrayList<Integer>();
        int[] result = new int[tempone.length];
        for (int i = 0; i < tempone.length;i++)
        {
            temponemax.add(Character.getNumericValue(tempone[i]));
        }
        for (int j = 0; j < temptwo.length;j++)
        {
            temptwomax.add(Character.getNumericValue(temptwo[j]));
        }
        for (int i = 0; i < tempone.length;i++)
        {
            int maxtwo = Collections.max(temptwomax);
            if (temponemax.get(i) > maxtwo)
            {
                result[i] = temponemax.get(i);
                temponemax.set(temponemax.indexOf(temponemax.get(i)),-1);
            }
            else
            {
                result[i] = maxtwo;
                temptwomax.set(temptwomax.indexOf(maxtwo),-1);
            }
        }

        String resulttext = "";
        for (int i = 0; i < result.length;i++ )
        {
            resulttext += Integer.toString(result[i]);
        }
        return resulttext;
    }



    public static boolean check(ArrayList<Integer> arrayList)
    {
        for (int i = 0; i < arrayList.size();i++)
        {
            if (arrayList.get(i) != -1)
            {
                return true;
            }
        }
        return false;
    }


}
