import java.util.*;
import java.text.*;

public class Task49 {

    public static void main(String[] args) throws ParseException {

        Scanner ui = new Scanner(System.in);
        HashMap<String,String> cityGMT = new HashMap<String,String>();

        cityGMT.put("Los Angeles","8.00");
        cityGMT.put("New York","5.00");
        cityGMT.put("Caracas","4.30");
        cityGMT.put("Buenos Aires","3.00");
        cityGMT.put("London","0.00");
        cityGMT.put("Rome","1.00");
        cityGMT.put("Moscow","3.00");
        cityGMT.put("Tehran","3.30");
        cityGMT.put("New Delhi","5.30");
        cityGMT.put("Beijing","8.00");
        cityGMT.put("Canberra","10.00");

        ArrayList<String> a = new ArrayList<String>();
        System.out.print("Город №1: ");
        String valueone  = ui.nextLine();
        System.out.print("Город №2: ");
        String valuetwo  = ui.nextLine();
        System.out.print("Дата (Пример заполнение April 7, 2010 20:30) : ");
        String datetext = ui.nextLine();
        String[] array = datetext.split("[ ]");


        for (String temp : array)
        {
            if (temp.contains(","))
            {
                String ar = "";
                for (int i = 0; i < temp.length();i++)
                {
                    if (temp.charAt(i) != ',')
                    {
                        ar += Character.toString(temp.charAt(i));
                    }
                }
                a.add(ar);
            }
            else if (temp.contains(":"))
            {
                String[] ar = temp.split("[:]");
                for (int i = 0; i < ar.length;i++)
                {
                    a.add(ar[i]);
                }
                break;
            }
            else
            {
                a.add(temp);
            }
        }

        Date date = new SimpleDateFormat("MMMM",Locale.US).parse(a.get(0));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int datemonth = cal.get(Calendar.MONTH);

        Calendar calendar = new GregorianCalendar(Integer.parseInt(a.get(2)), datemonth, Integer.parseInt(a.get(1)),Integer.parseInt(a.get(3)),Integer.parseInt(a.get(4)));
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        System.out.print("Результат: " + dateFormat.format(timeDifference(a,valueone,valuetwo,cityGMT,calendar).getTime()));
    }

    public static Calendar timeDifference(ArrayList<String> a,String valueone,String valuetwo , HashMap<String,String> cityGMT,Calendar calendar)
    {
        double value1 = findGMT(cityGMT,valueone);
        double value2 = findGMT(cityGMT,valuetwo);
        double result = value1 + value2;
        String[] hourmin = Double.toString(result).split("[.]");
        for (int i = 0; i < hourmin.length;i++)
        {
            if (i==0)
            {
                calendar.add(Calendar.HOUR_OF_DAY,Integer.parseInt(hourmin[i]));
            }
            else if(i == 1)
            {
                calendar.add(Calendar.MINUTE,Integer.parseInt(hourmin[i]));
            }
        }
        return calendar;
    }

    public static double findGMT(HashMap<String,String> cityGMT, String text)
    {
        Set keys = cityGMT.keySet();
        double count = 0;
        for (Map.Entry entry : cityGMT.entrySet())
        {
            if (entry.getKey().equals(text))
            {
                count = Double.parseDouble((String) entry.getValue());
            }
        }
        return count;
    }


}
