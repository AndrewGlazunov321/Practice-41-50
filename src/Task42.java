import java.util.*;

public class Task42 {

    private static String t="ABCDEFGH";
    private static void update(List<String> path, int pt, int pr) {path.add(String.valueOf(t.charAt(pt))+String.valueOf(pr));}

    public static void main(String[] args)
    {
        Scanner ui = new Scanner(System.in);
        System.out.print("Координата начальной точки: ");
        String valueone  = ui.nextLine();
        System.out.print("Координата конечной точки: ");
        String valuetwo  = ui.nextLine();
        System.out.print("Результат: "+ spiderToFly(valueone,valuetwo));

    }

    public static String spiderToFly(final String spider, final String fly) {
        int st=t.indexOf(spider.charAt(0)), ft=t.indexOf(fly.charAt(0)), sr=spider.charAt(1)-'0', fr=fly.charAt(1)-'0';
        List<String> path = new ArrayList<String>();
        double ct = Math.abs(sr-fr)+Math.min(sr,fr)*Math.min((st-ft+8)%8,(ft-st+8)%8)*Math.sqrt(2-Math.sqrt(2)), cr = sr+fr;
        if(st==ft) {
            for(; sr!=fr; sr+=(sr<fr?1:-1)) update(path,st,sr);
        } else if(cr<=ct) {
            for(; sr>0; sr--) update(path,st,sr);
            if(fr>0) update(path,0,sr++);
            for(; sr<fr; sr++) update(path,ft,sr);
        } else if(sr>=fr) {
            for(; sr!=fr; sr+=(sr<fr?1:-1)) update(path,st,sr);
            for(; st!=ft; st=(st+((st-ft+8)%8<4?7:1))%8) update(path,st,sr);
        } else {
            for(; st!=ft; st=(st+((st-ft+8)%8<4?7:1))%8) update(path,st,sr);
            for(; sr!=fr; sr+=(sr<fr?1:-1)) update(path,st,sr);
        }
        update(path,ft,fr);
        return String.join("-",path);
    }



}

