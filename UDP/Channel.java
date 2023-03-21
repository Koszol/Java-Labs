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
        length=128;
        samples= new short[]{19, 21, 32};   //przykładowe wartości
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
        for (short i : samples = s) {
            samples[i] = s[i];
        }
        length= samples.length;
    }
    public double value(int i){
        return samples[i]*sensitivity;
    }
    public double mean(){
        double sumVal=0;
        for (int i=0; i<length; i++){
             sumVal += (value(samples[i]));
        }
        return sumVal/length;
    }

    public static void  main(String[] args){
        Channel obj=new Channel();
        System.out.println(obj.value(1));
    }
}
