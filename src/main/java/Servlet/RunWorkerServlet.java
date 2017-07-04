package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hitek on 03.07.2017.
 */
@WebServlet("/RunWorkerServlet")
public class RunWorkerServlet extends HttpServlet {

    private String FLAG;
    private boolean DO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FLAG = request.getParameter("FLAG");
        if(FLAG.equals("START")){
            DO = true;
        }else {
            DO = false;
        }
        System.out.println(FLAG + "" + DO);
        while(DO) {
            System.out.println("wvwvwevwevwevwe");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
