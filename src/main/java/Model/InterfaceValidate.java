package Model;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by hitek on 03.07.2017.
 */
public interface InterfaceValidate {

    public int codeResponse() throws IOException;

    public int contentLenght();

    public long timeToConnection() throws IOException;

}
