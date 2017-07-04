package DBConfig;

import java.util.List;

/**
 * Created by hitek on 03.07.2017.
 */
public interface CRUDForURL {

    public boolean addURL(String URL);

    public boolean deleteURL(int ID);

    public boolean updateURL(int ID, String URL);

    public String getURL(int ID);

    public List getAll();
}
