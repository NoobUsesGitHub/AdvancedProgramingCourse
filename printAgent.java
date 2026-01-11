import graph.Agent;
import graph.Message;
import graph.TopicManagerSingleton;

public class printAgent implements Agent{
    private String input;

    public printAgent(String n){this.input=n;
        TopicManagerSingleton.get().getTopic(n).subscribe(this);
    }
    @Override
    public String getName(){return "";}
    @Override
    public void reset(){}
    @Override
    public void callback(String topic, Message msg){
        if(this.input.equals(topic)){
            System.out.println(msg.asDouble);
        }
    }
    @Override
    public void close(){}
}