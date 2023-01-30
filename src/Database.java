import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Database {

    private String filename;
    private int rowWidth;
    private int recordCount;

    public Database(String filename, int rowWidth) {
        this.filename = filename;
        this.rowWidth = rowWidth;
        recordCount = FileHandler.countLines(filename);
    }

    // add a new record to the end of the database
    public void appendRecord(String data) {
        int length = data.length();
        int difference = rowWidth - length;
        if (difference != 0) {
            if (difference < 0) {
                data = data.substring(0,10);
                FileHandler.appendLine(filename, data);
            } else if (difference > 0){
                for (int i=0;i<difference;i++){
                    data = data + " ";
                }
                FileHandler.appendLine(filename,data);
            }
        } else {
            FileHandler.appendLine(filename,data);
        }
        recordCount++;
    }
        // TODO: Pad the data to the correct record width
        // TODO: Report an error if the data is too long for the record

    // delete the record at the specified row
    public void deleteRecord(int rowNumber) {
        try (RandomAccessFile ra = new RandomAccessFile(filename, "rws")) {
            ra.seek(rowNumber * (rowWidth + 2));
            String line = ra.readLine();
            line = "";
        } catch (IOException e) {
            e.printStackTrace();
        }
        recordCount--;
    }

    // return the record at the specified row
    public String getRecord(int rowNumber) {
        return (FileHandler.readLineAt(filename, rowNumber * (rowWidth + 2)));
    }

    // return the number of records in the database
    public int getRecordCount() {
        return FileHandler.countLines(filename);
    }

    // search for a record matching data
    // return true if found
    public boolean findRecord(String data) {
        for (int i=0;i<getRecordCount();i++) {
            if (getRecord(i) == data){
                return true;
            }
        }
        return false; // TODO: replace this placeholder code
    }

}
