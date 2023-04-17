package types;

import java.io.*;

public class Tools {

    public static void fileSerialize(Object obj){
        String className= obj.getClass().getName()+".ser";
        try{
            FileOutputStream fileOut = new FileOutputStream(className);
            ObjectOutputStream out=new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.writeObject(className);
            out.close();
            fileOut.close();
        } catch (IOException i){
            i.printStackTrace();
        }
    }
    public static Object fileDeserialize(String name){
        Object obj=null;
        try {
            FileInputStream fileIn = new FileInputStream(name);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj=in.readObject();
            in.close();
            return obj;
        } catch (IOException i){
            i.printStackTrace();
            return obj;
        } catch (ClassNotFoundException c){
            c.printStackTrace();
        }
       return null;
    }
    public static byte[] byteSerialize(Object obj){
        ByteArrayOutputStream bobj = new ByteArrayOutputStream();
        ObjectOutput out;
        try{
            out=new ObjectOutputStream(bobj);
            out.writeObject(obj);
            out.flush();
            return bobj.toByteArray();
        } catch (IOException a){
            a.printStackTrace();
            return null;
        }
        finally {
            try {
                bobj.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static Object byteDeserialize(byte[] bytes) throws ClassNotFoundException {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream in = new ObjectInputStream(bis);
            obj = in.readObject();
            in.close();
            System.out.println("Serialized data is retrieved from bytes array");
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
            return obj;
        }
    }
}
