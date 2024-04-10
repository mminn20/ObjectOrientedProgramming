package gitlet;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class StagingArea implements Serializable {

    /** StagingArea
     *  manages each state before committed
     *  especially, added stage tracks which files are added.
     */

    private Blob blob;
    private byte[] contents;
    private Date date;

}
