import com.common.Phone;

import java.io.*;

/**
 * Created by Дмитрий on 25.10.2020.
 */
public class Client {
    public static void main(String[] args) {
        try ( Phone phone = new Phone("127.0.0.1", 8000)) {
            System.out.println("Connected to server");

            String request = "Date and time in Saint-Petersburg";
            System.out.println(request);
            phone.writeLine(request);

            String response = phone.readLine();
            System.out.println("Response from server: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
