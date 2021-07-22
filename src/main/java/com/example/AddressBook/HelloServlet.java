package com.example.AddressBook;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/add-address")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        //out.println("<html><body>");
        //out.println("<h1>" + message + "</h1>");
        out.println("<html lang='en'>" +
                "<head>" +
                "<meta charset='UTF-8'>" +
                "<title>Add an Address</title>" +
                "</head>" +
                "<body>" +
                "<header>" +
                "<h1>Add an Address</h1>" +
                "</header>" +
                "<main>" +
                "<p>Enter your information here:</p>" +
                "<form action='NewEntryServlet' method='post'>" +
                "<label>First Name:</label> <input name='firstName' type='text'><br><br>" +
                "<label>Middle Name:</label> <input name='middleName' type='text'><br><br>" +
                "<label>Last Name:</label> <input name='lastName' type='text'><br><br>" +
                "<label>House Number:</label> <input name='houseNumber' type='text'><br><br>" +
                "<label>Street Name:</label> <input name='streetName' type='text'><br><br>" +
                "<label>City/Town:</label> <input name='city' type='text'><br><br>" +
                "<label>State:</label> <input name='state' type='text'><br><br>" +
                "<label>Zip Code:</label> <input name='zipCode' type='text'><br><br>" +
                "<input type='submit' value='Submit'>" +
                "</form>" +
                "</main>" +
                "<footer>" +
                "</footer>" +
                "</body>" +
                "</html>");
        //out.println("</body></html>");
    }

    public void destroy() {
    }
}