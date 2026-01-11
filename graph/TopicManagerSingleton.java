package graph;

import java.util.Collection;
import java.util.HashMap;


public class TopicManagerSingleton {

    public static TopicManager get(){
        return TopicManager.instance;
    }
        public static class TopicManager{
            private static final TopicManager instance=new TopicManager();
            
            private HashMap<String,Topic> topics;

            private TopicManager()
            {
                this.topics=new HashMap<>();
            }

            public Topic getTopic(String key){
                Topic t=(Topic)this.topics.get(key);
                if(t==null)
                    this.topics.put(key,new Topic(key));
                return (Topic)this.topics.get(key);

            }

            public Collection<Topic> getTopics(){
                return this.topics.values();
            }

            public void clear(){
                this.topics.clear();
            }
        }
}
