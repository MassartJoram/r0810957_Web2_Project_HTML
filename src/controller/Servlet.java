package controller;

import Domain.Model.Items;
import Domain.db.ItemsDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    ItemsDB store = new ItemsDB();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = "index.jsp";
        String command = request.getParameter("command");
        if (command == null)
            command = "";

        switch (command) {
            case "addItem":
                destination = addItem(request);
                break;

            case "findItem":
                destination = findItem(request);
                break;

            case "overview":
                destination = overview(request);
                break;

            case "delete":
                destination = delete(request);
                break;

            case "deleteConfirm":
                destination = deleteConfirm(request);
                break;

            default:
                request.setAttribute("total", store.calculateTotal());
                destination = "index.jsp";
                break;
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String overview(HttpServletRequest request) {
        request.setAttribute("items", store.getItemList());
        request.setAttribute("total", store.calculateTotal());
        return "OverviewPage.jsp";
    }

    private String findItem(HttpServletRequest request) {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String destination = "";

        if (name == null || type == null) {
            destination = "NotFound.jsp";
        } else {
            Items items = store.Find(name, type);
            if (items == null) {
                destination = "NotFound.jsp";
            } else {
                destination = "Found.jsp";
                request.setAttribute("items", items);
            }
        }
        return destination;
    }

    private String addItem(HttpServletRequest request) {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String amount = request.getParameter("amount");
        String discription = request.getParameter("discription");
        String destination = "";

        if (!name.isEmpty() && name !=null && !type.isEmpty() && type != null &&
                !amount.isEmpty() && amount != null && !discription.isEmpty() && discription != null) {
            Items items = new Items(name, type, Integer.parseInt(amount), discription);
            store.addItem(items);
            request.setAttribute("items", store.getItemList());
            request.setAttribute("total", store.calculateTotal());
            destination = "OverviewPage.jsp";
        } else {
            destination = "AddPage.jsp";
        }
        return destination;
    }

    private String deleteConfirm(HttpServletRequest request) {
        if (request.getParameter("submit").equals("Sure")) {
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            store.delete(store.Find(name, type));
            return overview(request);
        } else
            return "index.jsp";
    }

    private String delete(HttpServletRequest request) {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        Items items = store.Find(name, type);
        request.setAttribute("items" , items);
        return "deleteConfirm.jsp";
    }
}


