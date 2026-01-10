package src.test;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;
public class Message {
    public final byte[] data;
    public final String asText;
    public final double asDouble;
    public final Date date;

    
    public Message(byte[] data){
        this.asText= new String(data);
        this.data = Arrays.copyOf(data, data.length); 
        
        double d;
        try {
            d = Double.parseDouble(this.asText.trim());
        } catch (Exception e) { // in case of NumberFormatException
            d = Double.NaN;
        }
        this.asDouble = d;
        //this.double= new Double(data);
        this.date=new Date();
    }

    public Message(String inputData){
        this(inputData.getBytes(StandardCharsets.UTF_8));
    }

    public Message(double inputData)
    {
        this(Double.toString(inputData));
    }

    
}
