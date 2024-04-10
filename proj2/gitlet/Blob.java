package gitlet;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static gitlet.Utils.*;

/**
 * blobs : The saved contents of files.
 * Each being tracked in a different commit.
 */

// blob : shaId, contents 로 검증해야 해

public class Blob implements Serializable {

    private final String shaId;
    private final File source;      // Initial file is the source file.
    private final File file;
    private final byte[] contents;
    private String fileName;


    /** File ~~ BLOB.
     * Each file is a blob, which provides data such as
     * shaId, contents, etc.
     */
    public Blob(File file){
        shaId = blobId(file);
        fileName = file.getName();
        source = file;
        file = file;
        contents = readContents(file);
//        if (!blobMap.containsKey(shaId)){
//            blobMap.put(shaId, fileName);
//        }
        if (isNewBlob(file)) {
            blobMap.put(shaId, fileName);
        }
    }

    public String blobId(File file){
        byte[] fileContents = readContents(file);
        String filePath = file.getPath();
        return sha1(filePath, fileContents);
    }


    /** BlobMap keep tracks each file.
     * key = shaId, value = file contents
     */
    Map<String, String> blobMap = new HashMap<>();


    /** isNewBlob
     * checks if there is a same file.
     * If the file is a new blob, returns true.
     */
    public boolean isNewBlob(File file){
        if (blobMap.containsKey(sha1(file))){
            return false;
        }
        return true;
    }

    /** getBlob
     * returns a blob, which is file;
     */
    public File getBlob(){
        return file;
    }

    /** getBlobContents
     *  returns contents inside a blob
     */
    public byte[] getBlobContents(){
        return readContents(file);
    }

    /** getShaId
     *  returns a SHA-1 for the blob
     */
    public String getShaId(){
        return shaId;
    }

}

