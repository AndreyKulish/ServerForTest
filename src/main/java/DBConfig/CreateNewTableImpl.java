package DBConfig;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by hitek on 03.07.2017.
 */
public class CreateNewTableImpl implements CreateNewTable {

    public boolean createTable() {

        String query = "CREATE TABLE URL_TASK(" +
                " ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                " URL TEXT," +
                " STATUS_RESPONSE_CODE INT," +
                " PERIOD_MMONITORING INT," +
                " TIME_RESPONSE_OK INT," +
                " TIME_RESPONSE_WARNING INT," +
                " TIME_RESPONSE_CRITICAL INT," +
                " RESPONSE_SIZE_MIN INT," +
                " RESPONSE_SIZE_MAX INT" +
                ")";
        try (Statement statement = MySQLConnectionJDBC.getConnection().createStatement()){

            System.out.println(statement.execute(query));

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return false;
    }
}
