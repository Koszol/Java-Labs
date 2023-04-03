package types;

public abstract class Sequence<T> extends Packet{
    protected int channelNr=1;
    protected String unit="V";
    protected double resolution=500;
    protected T buffer;
    public Sequence(){

    }
    public Sequence(String device,String description,long date,int channelNr,String unit, double resolution, T buffer){
        super(device, description, date);
        this.channelNr=channelNr;
        this.unit=unit;
        this.resolution=resolution;
        this.buffer=buffer;
    }
    @Override
    public String toString() {
        return super.toString()+"\nSequence [channelNr:"+channelNr+", unit:"+unit+", resolution:"+resolution+", buffer:"+buffer+"]";
    }
}
