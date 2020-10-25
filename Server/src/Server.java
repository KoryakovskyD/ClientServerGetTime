import com.common.Phone;

import java.io.*;
import java.net.ServerSocket;
import java.util.Date;

/**
 * Created by Дмитрий on 25.10.2020.
 */
public class Server {

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server started!");

            while (true) {

                Phone phone = new Phone(server);

                new Thread(() -> {
                    String request = phone.readLine();
                    System.out.println("request: " + request);
                    Date date = new Date();
                    String response = date.toString();
                    phone.writeLine(response);
                    System.out.println("Response: " + response);
                    try {phone.close(); } catch (IOException e) {}
                }).start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
