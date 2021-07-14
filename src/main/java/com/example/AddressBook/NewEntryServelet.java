package com.example.AddressBook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NewEntryServlet", value = "/NewEntryServlet")
public class NewEntryServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This resource is not available directly.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head></head><body>");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String birthDate = request.getParameter("birthDate");
        String birthMonth = request.getParameter("birthMonth");
        String birthYear = request.getParameter("birthYear");
        String birthday = birthYear + "-" + birthMonth + "-" + birthDate;
        String houseNumber = request.getParameter("houseNumber");
        String streetName = request.getParameter("streetName");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipCode = request.getParameter("zipCode");
        out.println("<h1>This person has been added to the address book:</h1>");
        out.println("<p>Name: " + firstName +" " + middleName +" "+ lastName + "</p>");
        out.println("<p>Birthday: " + birthday + "</p>");
        out.println("<p>Address: " + houseNumber +" " + streetName + "</p>");
        out.println("<p>         " + city +", " + state +" " + zipCode + "</p>");
        out.println("</body></html>");
    }
}