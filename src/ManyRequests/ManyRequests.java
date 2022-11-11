package ManyRequests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class ManyRequests {
    public static volatile int success = 0;
    public static volatile int error = 0;
    public static boolean next = false;
    public static Object syncObject = new Object();

    public static void main(String[] args) {
        int i = 0;

        try {
            while (i <= 150) {
                Thread t = new Thread(ManyRequests::run);
                t.start();
                i++;
            }

            Thread.sleep(10000);
            System.out.println("Success: " + ManyRequests.success);
            System.out.println("Error: " + ManyRequests.error);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void run() {
        try {
            URL url = new URL("https://api.fanbattle.space/api/application/profile");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer 32759|hTzjacFDZrvEJTOpzxNIsWHdCRgvfYHpU7V3NR4t");
            con.setRequestMethod("GET");

            int code = con.getResponseCode();
            if (code == 200) {
                ManyRequests.success++;
            } else {
                ManyRequests.error++;
            }

            System.out.println(code + " | " + getFullResponse(con));

            con.disconnect();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static String getFullResponse(HttpURLConnection con) throws IOException {
        StringBuilder fullResponseBuilder = new StringBuilder();
        Reader streamReader = null;

        if (con.getResponseCode() > 299) {
            streamReader = new InputStreamReader(con.getErrorStream());
        } else {
            streamReader = new InputStreamReader(con.getInputStream());
        }

        BufferedReader in = new BufferedReader(streamReader);
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();

        fullResponseBuilder.append("Response: ")
                .append(content);

        return fullResponseBuilder.toString();
    }
}
