package Model;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hitek on 03.07.2017.
 */
public class Validate implements InterfaceValidate{

    private URL url;
    private HttpURLConnection httpURLConnection;
    private long start,end;
    private int codeResp;


    public Validate(String urlConnection)  {
        try {
            url = new URL(urlConnection);
            httpURLConnection = (HttpURLConnection)url.openConnection();
            start = System.currentTimeMillis();
            httpURLConnection.connect();
            end = System.currentTimeMillis();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //return response code(200-400_...)
    public int codeResponse() {
        try {
            codeResp = httpURLConnection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return codeResp;
    }
    //return length of http responce
    public int contentLenght() {
        return  httpURLConnection.getContentLength();
    }
    //return time of connection
    public long timeToConnection() {
        return (end - start);
    }
}
