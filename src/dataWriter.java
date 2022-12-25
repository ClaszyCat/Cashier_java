import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @see this interface using for datawriter or payment history if the customer succesfully paying
 */
public interface dataWriter {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();

    /**
     * File maker that save payment history
     * @param pdh get from the total of pdh
     * @param jacket get from the total of
     * @param Tshirt-shirt get from the total of
     * @param total get from the total of
     * @throws IOException handling error
     */
    default void dataMaker(int pdh, int jacket, int Tshirt, double total) throws IOException {
    FileWriter writeData = new FileWriter("paymentHistory.txt", true);
    BufferedWriter bufferWrite = new BufferedWriter(writeData);
    bufferWrite.write(pdh + " PDH | " + jacket  + " Jacket | " + Tshirt + " T-shirt | " + total + " | Date " + formatter.format(date));
    bufferWrite.newLine();
    bufferWrite.flush();
    bufferWrite.close();
    }

}
