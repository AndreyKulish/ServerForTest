package Servlet;

import DBConfig.*;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hitek on 03.07.2017.
 */
@WebServlet("/data")
public class DataServlet extends HttpServlet {

    private CreateNewTable sqlRebuild = new CreateNewTableImpl();
    private CRUDForURL crudForURL = new MySQLCRUDForURLImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MySQLConnectionJDBC.setConnection("localhost", "hitekdada", "root", "root");

        //if u need new table
        /*sqlRebuild.createTable();*/

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

            String json = new Gson().toJson(crudForURL.getAll());
            out.println(json);
            out.flush();

    }

}