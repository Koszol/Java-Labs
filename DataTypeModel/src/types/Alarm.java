package types;

public class Alarm extends Packet{
    protected double threshold=50;
    protected int direction=0;      //0-dowolny; -1-w dół 1- w góre
    public Alarm(){

    }
    public Alarm(String device,String description,long date,double threshold, int direction){
        super(device,description,date);
        this.threshold=threshold;
        this.direction=direction;
    }

    @Override
    public String toString() {
        return super.toString()+"\nAlarm [threshold:"+threshold+", direction:"+direction+"]";
    }
}
