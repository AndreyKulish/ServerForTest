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
        Validate validate = new Validate("https://stackoverflow.com/questions/5435351/determine-size-of-http-response");
        validate.codeResponse();
        System.out.println(validate.timeToConnection());
        System.out.println(validate.contentLenght());
        System.out.println(validate.codeResponse());
        System.out.println();
        sqlRebuild.createTable();
        MySQLConnectionJDBC.endConnection();
    }

}
