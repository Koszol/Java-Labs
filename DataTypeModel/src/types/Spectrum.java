package types;

import javax.xml.stream.FactoryConfigurationError;

public class Spectrum<T> extends Sequence<T>{
    protected boolean scaling;  //false - linear; true - log

    public Spectrum(){

    }
    public Spectrum(String device,String description,long date,int channelNr,String unit, double resolution, T buffer,boolean scaling){
        super(device,description,date,channelNr,unit,resolution,buffer);
        this.scaling=scaling;
    }
    public String toString() {
        String scale=null;
        //skala
        if(scaling=true){
            scale="logarithmic";
        } else if (scaling=false) {
            scale="linear";
        }
        return super.toString()+"\nSpectrum: [scaling:"+scale+"]";
    }
}
