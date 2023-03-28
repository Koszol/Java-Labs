package types;

import java.io.Serializable;

public abstract class Packet implements Serializable {
    protected String device="Urzadzenie";
    protected String description="Opis";
    protected long  date=50;
    public Packet(){
    }
    public Packet(String device,String description,long date){
        this.device=device;
        this.description=description;
        this.date=date;
    }
    public String toString(){
        return "Packet [device="+device+", Description:"+description+",Date:"+date+"]";
    }
}
