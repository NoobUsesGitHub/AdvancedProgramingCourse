package configs;

import graph.Agent;

public class GenericConfig {
    private String name;
    private Agent[] agents;

    public void setConfFile(){

    }
    public void create(){}
    public String getName(){
        return this.name;
    }
    public int getVersion(){
        return 1;
    }

    public void close(){
        for (Agent a: this.agents){
            a.close();
        }
    }

}
