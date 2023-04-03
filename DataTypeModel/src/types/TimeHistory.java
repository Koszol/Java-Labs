package types;

public class TimeHistory<T> extends Sequence<T> {
    public double sensitivity=0.5;

    public TimeHistory(){

    }
    public TimeHistory(String device,String description,long date,int channelNr,String unit, double resolution, T buffer,double sensitivity){
        super(device,description,date,channelNr,unit,resolution, buffer);
        this.sensitivity=sensitivity;
    }

    public String toString() {
        return super.toString()+"\nTimeHistory: [sens:"+sensitivity+"]";
    }
}
