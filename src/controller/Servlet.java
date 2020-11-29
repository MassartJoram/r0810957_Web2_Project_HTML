package controller;

import Domain.Model.Items;
import Domain.db.ItemsDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    ItemsDB store = new ItemsDB();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public void setName(Items items, HttpServletRequest request , ArrayList<String> errors){
        String name = request.getParameter("name");
        try{
            items.setName(name);
            request.setAttribute("namePreviousValue" , name);
        }catch(IllegalArgumentException exc){
            errors.add(exc.getMessage());
        }
    }

    public void setType(Items items, HttpServletRequest request , ArrayList<String> errors){
        String type = request.getParameter("type");
        try{
            items.setType(type);
            request.setAttribute("typePreviousValue" , type);
        }catch(IllegalArgumentException exc){
            errors.add(exc.getMessage());
        }
    }

    public void setAmount(Items items, HttpServletRequest request , ArrayList<String> errors){
        String amount = request.getParameter("amount");
        try{
            items.setAmount(Integer.parseInt(amount));
            request.setAttribute("amountPreviousValue" , amount);
        }catch(NumberFormatException exc){
            errors.add("Fill an amount in!");
        }catch(IllegalArgumentException exc){
            errors.add(exc.getMessage());
        }
    }

    public void setDiscription(Items items, HttpServletRequest request , ArrayList<String> errors){
        String discription = request.getParameter("discription");
        try{
            items.setDiscription(discription);
            request.setAttribute("discriptionPreviousValue" , discription);
        }catch(IllegalArgumentException exc){
            errors.add(exc.getMessage());
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination;
        String command = request.getParameter("command");
        if (command == null)
            command = "";

        switch (command) {
            case "addItem":
                destination = addItem(request , response);
                break;

            case "findItem":
                destination = findItem(request, response);
                break;

            case "overview":
                destination = overview(request , response);
                break;

            case "delete":
                destination = delete(request, response);
                break;

            case "deleteConfirm":
                destination = deleteConfirm(request, response);
                break;


            case "editConfirm":
                destination = editConfirm(request, response);
                break;


            case "edit":
                destination = edit(request, response);
                break;

/*            case "rememberMe":
                destination = rememberMe(request, response);
                break;

            case "fillInName":
                destination = fillInName(request, response);
                break;*/

            default:
                request.setAttribute("total", store.calculateTotal());
                destination = "index.jsp";
                break;
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String overview(HttpServletRequest request , HttpServletResponse response) {
        request.setAttribute("items", store.getItemList());
        request.setAttribute("total", store.calculateTotal());
        return "OverviewPage.jsp";
    }

    private String findItem(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();
        Items items = new Items();
        setName(items , request , errors);
        setType(items , request , errors);
        String name = request.getParameter("name");
        String type = request.getParameter("type");

        if(errors.size() == 0){
            try{
                Items itemList = store.Find(name , type);
                if(itemList == null) {
                    return "NotFound.jsp";
                }else{
                    request.setAttribute("items" , items);
                    return "Found.jsp";
                }
            }catch(IllegalArgumentException exc){
                errors.add(exc.getMessage());
            }
        }
        request.setAttribute("errors" , errors);
        return "SearchItem.jsp";

    }


    private String addItem(HttpServletRequest request , HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();
        Items items = new Items();
        setName(items , request , errors);
        setType(items , request , errors);
        setAmount(items , request , errors);
        setDiscription(items , request , errors);

        if(errors.size() == 0){
            try{
                store.addItem(items);
                return overview(request , response);
            }catch (IllegalArgumentException exc){
                errors.add(exc.getMessage());
            }
        }
        request.setAttribute("errors" , errors);
        return "AddPage.jsp";

    }



    private String deleteConfirm(HttpServletRequest request , HttpServletResponse response) {
        if (request.getParameter("submit").equals("Sure")) {
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            store.delete(store.Find(name, type));
            return overview(request, response);
        } else
            return "index.jsp";
    }

    private String delete(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        Items items = store.Find(name, type);
        request.setAttribute("items" , items);
        return "deleteConfirm.jsp";
    }



    private String editConfirm(HttpServletRequest request , HttpServletResponse response) {

            ArrayList<String> errors = new ArrayList<>();

            String name = request.getParameter("name"); // Naam kan niet veranderd worden.
            Items items = store.FindName(name);
            request.setAttribute("items" , items);




            if (errors.size() == 0) {
                try {
                        items.setName(request.getParameter("name"));
                        items.setType(request.getParameter("type"));
                        items.setAmount(Integer.parseInt(request.getParameter("amount")));
                        items.setDiscription(request.getParameter("discription"));

                } catch (IllegalArgumentException exc) {
                    errors.add(exc.getMessage());
                    request.setAttribute("errors" , errors);
                    return "editConfirm.jsp";
                }
            }

         request.setAttribute("items" , store.getItemList());
        return overview(request , response);
    }

        private String edit(HttpServletRequest request , HttpServletResponse response) {
        String name = request.getParameter("name");
        Items items = store.FindName(name);
        request.setAttribute("items" , items);
        return "editConfirm.jsp";
    }

/*    private String fillInName(HttpServletRequest request , HttpServletResponse response){
        ArrayList<String> errors= new ArrayList<>();
        try{
            Cookie[] cookies = request.getCookies();

            if(cookies.length == 0){
                Items items = store.FindName(request.getParameter("name"));
                request.setAttribute("items" , items);
                Cookie nameCookie = new Cookie("nameCookie", items.getName());
                response.addCookie(nameCookie);

            }else{
                for(Cookie c : cookies){
                    if(!c.getName().equals("nameCookie")){
                        Items items = store.FindName(request.getParameter("name"));
                        request.setAttribute("items" , items);
                        Cookie nameCookie = new Cookie("nameCookie" , items.getName());
                        response.addCookie(nameCookie);
                    }
                }
            }
        }catch(IllegalArgumentException exc){
            errors.add(exc.getMessage());
            request.setAttribute("errors" , errors);
            return "index.jsp";
        }
        return "index.jsp";
    }



    private String rememberMe(HttpServletRequest request , HttpServletResponse response){
        Cookie[] cookies = request.getCookies();

        try{
            if(cookies.length == 0){
                return "index.jsp";
            }else{
                for(Cookie c : cookies){
                    if(c.getName().equals("nameCookie")){
                        Items items = store.FindName(c.getValue());
                        request.setAttribute("items" , items);
                        return "found.jsp";
                    }
                }
            }
        }catch(IllegalArgumentException exc){
            return "index.jsp";
        }
        return "index.jsp";
    }*/
}


