import types.Spectrum;
import types.TimeHistory;

import java.sql.Time;

public class Main {
    public static void main(String[] args) {
        TimeHistory obj1= new TimeHistory<>("Dev", "op", 100, 4, "V", 100, new double[]{15, 20}, 0.5);
        System.out.println(obj1.toString());
        TimeHistory obj2=new TimeHistory<>();
        System.out.println(obj2.toString());
        Spectrum obj3=new Spectrum<>("Urz", "opisik", 50, 3, "mV", 200, new double[]{15.5, 20}, false);
        System.out.println(obj3.toString());
        Spectrum obj4=new Spectrum<>();
        System.out.println(obj4.toString());
    }
}
