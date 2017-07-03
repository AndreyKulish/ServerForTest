package DBConfig;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by hitek on 03.07.2017.
 */
public class MySQLCRUDForURLImpl implements CRUDForURL {

    String query;

    @Override
    public boolean addURL(String URL) {
        query ="INSERT INTO URL_TASK (URL) VALUES (" + URL + ")";
        try (Statement statement = MySQLConnectionJDBC.getConnection().createStatement()){

            statement.execute(query);
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteURL(int ID) {
        query ="DELETE * FROM URL_TASK WHERE ID = " + ID;
        try (Statement statement = MySQLConnectionJDBC.getConnection().createStatement()){

            statement.execute(query);
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateURL(int ID, String URL) {
        query ="UPDATE URL_TASK SET(URL) VALUES(" + URL + ") WHERE ID = " + ID;
        try (Statement statement = MySQLConnectionJDBC.getConnection().createStatement()){

            statement.execute(query);
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean getURL(int ID) {
        query ="SELECT URL FROM URL_TASK WHERE ID = " + ID;
        try (Statement statement = MySQLConnectionJDBC.getConnection().createStatement()){

            statement.execute(query);
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
