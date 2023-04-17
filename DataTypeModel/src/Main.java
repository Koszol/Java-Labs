import types.Alarm;
import types.Spectrum;
import types.TimeHistory;
import types.Tools;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        // Testowe obiekty
        TimeHistory obj1= new TimeHistory<>("Dev", "op", System.currentTimeMillis(), 4, "V", 100, new double[]{15, 20}, 0.5);
        System.out.println(obj1.toString());
        TimeHistory obj2=new TimeHistory<>();
        System.out.println(obj2.toString());
        Spectrum obj3=new Spectrum<>("Urz", "opisik", System.currentTimeMillis(), 3, "mV", 200, new double[]{15.5, 20}, false);
        System.out.println(obj3.toString());
        Spectrum obj4=new Spectrum<>();
        System.out.println(obj4.toString());
        Alarm obj6=new Alarm("Device1","opis urzadzenia",System.currentTimeMillis(),251.5,1);
        System.out.println(obj6.toString());
        Alarm obj5=new Alarm();
        System.out.println(obj5.toString());
        // Test serializacji do pliku
        Tools.fileSerialize(obj2);
        Object obj7= (TimeHistory) Tools.fileDeserialize("types.TimeHistory.ser");
        // Test serializacji do tablicy bajtów
        byte[] tablica= Tools.byteSerialize(obj1);
        Object obj8= Tools.byteDeserialize(tablica);
        System.out.println(obj8.toString());
    }
}
