package controller;

import Domain.Model.Event;
import Domain.Model.Items;
import Domain.db.ItemsDB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    ItemsDB store = new ItemsDB();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public void setName(Items items, HttpServletRequest request, ArrayList<String> errors) {
        String name = request.getParameter("name");
        try {
            items.setName(name);
            request.setAttribute("namePreviousValue", name);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    public void setType(Items items, HttpServletRequest request, ArrayList<String> errors) {
        String type = request.getParameter("type");
        try {
            items.setType(type);
            request.setAttribute("typePreviousValue", type);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    public void setAmount(Items items, HttpServletRequest request, ArrayList<String> errors) {
        String amount = request.getParameter("amount");
        try {
            items.setAmount(Integer.parseInt(amount));
            request.setAttribute("amountPreviousValue", amount);
        } catch (NumberFormatException exc) {
            errors.add("Fill an amount in!");
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    public void setDiscription(Items items, HttpServletRequest request, ArrayList<String> errors) {
        String discription = request.getParameter("discription");
        try {
            items.setDiscription(discription);
            request.setAttribute("discriptionPreviousValue", discription);
        } catch (IllegalArgumentException exc) {
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
                destination = addItem(request, response);
                break;

            case "findItem":
                destination = findItem(request, response);
                break;

            case "overview":
                destination = overview(request, response);
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

            case "logBook":
                destination = logBook(request, response);
                break;

            default:
                request.setAttribute("total", store.calculateTotal());
                destination = "index.jsp";
                break;
        }
        request.getRequestDispatcher(destination).forward(request, response);
        }

    private String overview(HttpServletRequest request, HttpServletResponse response) {
        logBookSessions(request , "Checked the overview");
        request.setAttribute("items", store.getItemList());
        request.setAttribute("total", store.calculateTotal());
        Cookie cookieCount = getCookieWithKey(request , "cookieCount");

            if(cookieCount == null){
                cookieCount = new Cookie("cookieCount" , "1");
            }else {
                int value = Integer.parseInt(cookieCount.getValue()) +1 ;
                cookieCount.setValue(Integer.toString(value));
            }
            response.addCookie(cookieCount);
            request.setAttribute("cookieCount" , cookieCount.getValue());

        return "OverviewPage.jsp";
    }


    private String findItem(HttpServletRequest request, HttpServletResponse response) {
        logBookSessions(request , "Looked for an item");
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
                logBookSessions(request , "Added an item");
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
            logBookSessions(request , "Deleted an item");
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
            logBookSessions(request , "Edited an item");
            ArrayList<String> errors = new ArrayList<>();

            String name = request.getParameter("name"); // Naam kan niet veranderd worden.
            Items items = store.FindName(name);
            request.setAttribute("items" , items);
            setName(items , request , errors);
            setType(items , request , errors);
            setAmount(items , request , errors);
            setDiscription(items , request , errors);


            if (errors.size() == 0) {
                try {
                        items.setName(request.getParameter("name"));
                        items.setType(request.getParameter("type"));
                        items.setAmount(Integer.parseInt(request.getParameter("amount")));
                        items.setDiscription(request.getParameter("discription"));
                        request.setAttribute("items" , store.getItemList());
                        return overview(request , response);

                } catch (IllegalArgumentException exc) {
                    errors.add(exc.getMessage());
                }
            }
        request.setAttribute("errors" , errors);
        return "editConfirm.jsp";

    }

        private String edit(HttpServletRequest request , HttpServletResponse response) {
        String name = request.getParameter("name");
        Items items = store.FindName(name);
        request.setAttribute("items" , items);
        return "editConfirm.jsp";
    }


    private String logBook(HttpServletRequest request , HttpServletResponse response){
        logBookSessions(request , "Checked the logbook");
        return "LogBook.jsp";
    }

    private void logBookSessions(HttpServletRequest request , String pages){
        HttpSession session = request.getSession();
        ArrayList<Event> events = (ArrayList<Event>) session.getAttribute("events");

        if(events == null){
            events = new ArrayList<>();
            session.setAttribute("events" , events);
        }

        Date localTime = new Date();
        Event event = new Event(localTime , pages);
        events.add(event);

    }

    public Cookie getCookieWithKey(HttpServletRequest request, String key)
    {
        Cookie[] cookies = request.getCookies();

        if (cookies == null) return null;

        for (Cookie c: cookies) {
            if (c.getName().equals(key)) {
                return c;
            }
        }

        return null;
    }
}


