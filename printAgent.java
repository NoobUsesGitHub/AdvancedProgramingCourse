import graph.*;

public class printAgent implements Agent{
    private String input;

    public printAgent(String n){this.input=n;
        TopicManagerSingleton.get().getTopic(n).subscribe(this);
    }
    public String getName(){return "";}
    public void reset(){return;}
    public void callback(String topic, Message msg){
        if(this.input.equals(topic)){
            System.out.println(msg.asDouble);
        }
    }

    public void close(){return;}
}