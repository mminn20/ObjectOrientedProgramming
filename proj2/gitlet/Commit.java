package gitlet;

// TODO: any imports you need here

import java.io.Serializable;
import java.util.Date; // TODO: You'll likely use this in this class

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
    private String message;
    private String author;
    private Date date;
    private final String id;

    /* TODO: fill in the rest of this class. */

    public Commit(String a, Date d, String m, String i){
        author = a;
        date = d;
        message = m;
        id = i;
    }

    /* Saves a snapshot of tracked files in the current commit and staging area
    * so they can be restored at a later time, creating a new commit.
    */




}
