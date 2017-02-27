package edu.cpp.cs.cs141.GECLYfinalproj;

/**
 * @author Gavin Kremer
 */
public enum Action {
    DIED("You have been slain by the Ninja\'s \"Mortal Strike\""),
    KILLED("A ninja disintegrated upon touching your invinciblility field!"),
    GOTCASE("You picked up the briefcase!"),
    GOTITEM("You obtained "),
    SEARCHROOM("You searched the room... ");
    private String desc;
    private String append;
    Action(String desc){
        this.desc = desc;
        this.append = "";
    }
    public void appendDesc(String append){
        this.append = append;
    }

    public String getDesc() {
        return desc+append;
    }
}
