package types;

public abstract class Sequence<T> extends Packet{
    protected int channelNr;
    protected String unit;
    protected double resolution;
    protected T[] buffer;

}
