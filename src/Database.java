import java.io.IOException;
import java.io.RandomAccessFile;

public class Database {

    private String filename;
    private int rowWidth;

    public Database(String filename, int rowWidth) {
        this.filename = filename;
        this.rowWidth = rowWidth;
    }

    // add a new record to the end of the database
    public void appendRecord(String data) {
        String newData = "";
        int length = data.length();
        int difference = rowWidth - length;
        if (difference != 0) {
            if (difference < 0)
                data.substring(0,9);
                FileHandler.appendLine(filename,data);
            }
            FileHandler.appendLine(filename, newData);
        }
        // TODO: Pad the data to the correct record width
        // TODO: Report an error if the data is too long for the record

    }

    // delete the record at the specified row
    public void deleteRecord(int rowNumber) {
        try (RandomAccessFile ra = new RandomAccessFile(filename, "rws")) {
            ra.seek(rowNumber * (rowWidth + 2));
            String line = ra.readLine();
            line = "";
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        return false; // TODO: replace this placeholder code
    }

}
