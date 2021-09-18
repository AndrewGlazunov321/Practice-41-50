import java.util.*;

public class Task44 {

    public static void main(String[] args)
    {
        String word,finalword;
        int finalscore = 0;
        Scanner ui = new Scanner(System.in);
        System.out.print("Количество слов которые вы впишите: ");
        int value  = ui.nextInt();
        String[] array = new String[value];
        ui.nextLine();
        for (int i = 0; i < value; i++ )
        {
            System.out.print("Введите " + (i+1) + " слово: ");
            array[i] = ui.nextLine();
        }
        System.out.print("Слово из 6-и букв которое будет угадываться: ");
        finalword = ui.nextLine();
        for (int i = 0; i < array.length;i++)
        {
            finalscore += totalPoints(array,i,finalword);
        }
        System.out.println("Итог: " + finalscore);
    }

    public static int totalPoints(String[] array, int i, String finalworld)
    {
        int score = 0;
        int count = 0;
        char[] textarray = array[i].toCharArray();
        char[] finalarray = finalworld.toCharArray();
        for (int k = 0; k < textarray.length; k++)
        {
            char temp = textarray[k];
            for (int j = 0; j < finalarray.length; j++)
            {
                if (temp == finalarray[j])
                {
                    count++;
                    finalarray[j] = ' ';
                    break;
                }
            }
        }
        if ((array[i].length() - count) == 0)
        {
            switch (array[i].length()) {
                case 3:
                    score +=1;
                    break;

                case 4:
                    score += 2;
                    break;

                case 5:
                    score += 3;
                    break;

                case 6:
                    score += 54;
                    break;

                default:
                    score += 0;
                    break;
            }
        }
        return score;
    }


}
