import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sayemkcn on 1/1/17.
 */
public class HttpCall {

    public HttpCall(String url, TextArea textArea){
        this.recursiveCall(url,textArea);
    }

    private void recursiveCall(final String url,final TextArea textArea) {
        new Thread(new Runnable() {
            public void run() {
                hitUrl(url,textArea);
                try {
                    Thread.sleep(60000);
                    recursiveCall(url,textArea);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void hitUrl(String urlString,TextArea textArea) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int code = connection.getResponseCode();
            textArea.appendText("Response Code: " + code+"\n");
//            System.out.println("HIT - RESPONSE CODE:\n" + code);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
