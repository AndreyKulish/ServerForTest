import DBConfig.MySQLConnectionJDBC;
import DBConfig.CreateNewTableImpl;
import DBConfig.CreateNewTable;
import Model.Validate;

import java.io.*;

/**
 * Created by hitek on 03.07.2017.
 */
public class Main {

    static CreateNewTable sqlRebuild = new CreateNewTableImpl();

    public static void main(String[] args) throws IOException {
        MySQLConnectionJDBC.setConnection("localhost", "hitekdada", "root", "root");
        sqlRebuild.createTable();
        MySQLConnectionJDBC.endConnection();
    }

}
