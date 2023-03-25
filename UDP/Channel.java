public class Channel {
    private int channelNr;
    private String channelName;
    private int bits;
    private double rangeMin, rangeMax;
    private double sensitivity;
    private String unit;
    private double samplingFreq;
    private int length;
    private short[] samples;
    public Channel(){     //pierwszy konstruktor (przykładowe zmienne)
        channelNr=4;
        channelName="Kanal 1";
        bits=8;
        rangeMin=0;
        rangeMax=5;
        sensitivity=0.05;
        unit="V";
        samplingFreq=1024;
        samples= new short[]{19, 21, 32};   //przykładowe wartości
        length= samples.length;
    }
    public Channel(int chNr, String chN, int b, double rmin,double rmax,double sens, String u, double fs, short[]s){
        channelNr=chNr;
        channelName=chN;
        bits=b;
        rangeMin=rmin;
        rangeMax=rmax;
        sensitivity=sens;
        unit=u;
        samplingFreq=fs;
        length= s.length;
        samples=s;
    }
    public double value(int i){
        return samples[i]*sensitivity;
    }
    public double mean(){
        double sumVal=0;
        for (int i=0; i<length; i++){
             sumVal += value(i);
        }
        return sumVal/length;
    }
    public double rms(){
        double sumVal=0;
        for (int i=0; i<length; i++){
            sumVal += Math.pow(value(i),2);
        }
        return Math.sqrt((1/(double)length)*sumVal);
    }
    public String toString(){
        String probeList="Probki:";
        for (int i=0; i<length; i++){
            String probe=String.format("%d ",samples[i]);
            probeList= probeList.concat(probe);
        }
        return "Name:%s Nr:%d bitNumber:%d Range:[%.2f, %.2f] Sensitivity=%.3f unit=%s sampFreq=%.2f sampLength=%d %s".formatted(channelName,channelNr,bits,rangeMin,rangeMax,sensitivity,unit,samplingFreq,length,probeList);
    }
    public static void  main(String[] args){
        Channel obj=new Channel();
        short[] samps={22, 12, 20, 30};
        Channel obj2 = new Channel(2, "Kanal 2", 32, 10, 50, 0.05, "V", 1024, samps);
        System.out.println(obj.toString());
        System.out.println(obj2.toString());
        System.out.println("Srednia obj1="+obj.mean());
        System.out.println("Srednia obj2="+obj.mean());
        System.out.println("RMS obj1="+obj.rms());
        System.out.println("RMS obj2="+obj2.rms());
    }
}
