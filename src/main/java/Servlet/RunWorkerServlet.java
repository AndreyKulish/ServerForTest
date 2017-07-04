package Servlet;

import DBConfig.CRUDForURL;
import DBConfig.MySQLCRUDForURLImpl;
import DBConfig.TableEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hitek on 03.07.2017.
 */
@WebServlet("/RunWorkerServlet")
public class RunWorkerServlet extends HttpServlet {

    private String FLAG;
    private boolean DO;
    private Thread thread;
    private TableEntity tableEntity;
    private CRUDForURL crudForURL = new MySQLCRUDForURLImpl();
    private static List<Thread> threadList = new ArrayList<>();
    private static List<Work> tableWork = new ArrayList<>();
    private Work work;

    public static List<Thread> getThreadList() {
        return threadList;
    }

    public static List<Work> getWork() {
        return tableWork;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FLAG = request.getParameter("FLAG");
        if(FLAG.equals("START")){
            threadList.clear();
            DO = true;
            System.out.println(FLAG + "  " + DO);
            for (TableEntity tableEntity :crudForURL.getAll()) {
                work = new Work(tableEntity);
                thread = new Thread(work);
                tableWork.add(work);
                thread.setName(Integer.toString(tableEntity.getID()));
                threadList.add(thread);
                thread.start();
            }
        }else {
            DO = false;
            System.out.println(FLAG + "  " + DO);
            for (Thread thread : threadList) {
                //мега костыль, its a magic
                thread.setName("KILL_MY_PLZ");
            }
        }


    }

}
