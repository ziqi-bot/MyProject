package MyProject.TCPandUDPandURL;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

    public static void main(String[] args) {


        String str = "https://media.geeksforgeeks.org/wp-content/uploads/20220306170607/Fig48.jpg";

        URL url;


            FileOutputStream fileOutputStream = null;
            InputStream inputStream = null;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(str);
                urlConnection = (HttpURLConnection) url.openConnection();
                inputStream = urlConnection.getInputStream();
                File file = new File("C:\\Users\\DouZi\\Downloads\\SpringBootcopy.png");
                fileOutputStream = new FileOutputStream(file);

                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, len);

                }


//                System.out.println(url.getProtocol());
//                System.out.println(url.getHost());
//                System.out.println(url.getPort());
//                System.out.println(url.getPath());
//                System.out.println(url.getFile());
//                System.out.println(url.getQuery());


            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                urlConnection.disconnect();

            }

    }
}
