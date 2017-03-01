package edu.cpp.cs.cs141.GECLYfinalproj;

/**
 * This enum is for use with the player and keeps track of what they did on their last turn.
 *
 * @author GECLY
 */
public enum Action {
    DIED("You have been slain by the Ninja\'s \"Mortal Strike\""),
    KILLED("A ninja disintegrated upon touching your invinciblility field!"),
    GOTCASE("You picked up the briefcase!"),
    GOTITEM("You obtained "),
    SEARCHROOM("You searched the room... ");

    /**
     * This field represents the base message that is associated with each action to be displayed.
     */
    private String desc;

    /**
     * This field represents additional info that the base message may need, for use with messages that have variants.
     */
    private String append;

    /**
     * This is the constructor for Action.
     * @param desc description to bind to it.
     */
    Action(String desc){
        this.desc = desc;
        this.append = "";
    }

    /**
     * This method adds things to the base message.
     * @param append
     */
    public void appendDesc(String append){
        this.append = append;
    }

    /**
     * Getter for {@link #desc}
     * @return value of {@link #desc}
     */
    public String getDesc() {
        return desc+append;
    }
}
