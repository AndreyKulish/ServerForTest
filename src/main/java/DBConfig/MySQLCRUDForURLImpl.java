package DBConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hitek on 03.07.2017.
 */
public class MySQLCRUDForURLImpl implements CRUDForURL {

    private String query;
    private List<TableEntity> list = new ArrayList<>();
    private TableEntity tableEntity;

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
    public String getURL(int ID) {
        query ="SELECT URL FROM URL_TASK WHERE ID = " + ID;
        try (Statement statement = MySQLConnectionJDBC.getConnection().createStatement()){
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            return resultSet.getString(1);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List getAll() {
        query ="SELECT * FROM URL_TASK";
        try (Statement statement = MySQLConnectionJDBC.getConnection().createStatement()){
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                tableEntity = new TableEntity();
                tableEntity.setID(resultSet.getInt(1));
                tableEntity.setURL(resultSet.getString(2));
                tableEntity.setSTATUS_RESPONSE_CODE(resultSet.getInt(3));
                tableEntity.setPERIOD_MMONITORING(resultSet.getInt(4));
                tableEntity.setTIME_RESPONSE_OK(resultSet.getInt(5));
                tableEntity.setTIME_RESPONSE_WARNING(resultSet.getInt(6));
                tableEntity.setTIME_RESPONSE_CRITICAL(resultSet.getInt(7));
                tableEntity.setRESPONSE_SIZE_MIN(resultSet.getInt(8));
                tableEntity.setRESPONSE_SIZE_MAX(resultSet.getInt(9));
                list.add(tableEntity);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }
}
