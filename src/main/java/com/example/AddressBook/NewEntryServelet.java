package com.example.AddressBook;

import entity.Person;
import com.mysql.cj.jdbc.Driver;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "NewEntryServlet", value = "/NewEntryServlet")
public class NewEntryServelet extends HttpServlet {
    public String firstName;
    public String middleName;
    public String lastName;
    public String houseNumber;
    public String streetName;
    public String city;
    public String state;
    public String zipCode;

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
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head></head><body>");
            firstName = request.getParameter("firstName");
            middleName = request.getParameter("middleName");
            lastName = request.getParameter("lastName");
            houseNumber = request.getParameter("houseNumber");
            streetName = request.getParameter("streetName");
            city = request.getParameter("city");
            state = request.getParameter("state");
            zipCode = request.getParameter("zipCode");
            out.println("<h1>This person has been added to the address book:</h1>");
            out.println("<p>Name: " + firstName +" " + middleName +" "+ lastName + "</p>");
            out.println("<p>Address: " + houseNumber +" " + streetName + "</p>");
            out.println("<p>         " + city +", " + state +" " + zipCode + "</p>");

            transaction.begin();
            Person newEntry = new Person();
            newEntry.setFirstName(firstName);
            newEntry.setMiddleName(middleName);
            newEntry.setLastName(lastName);
            newEntry.setHouseNumber(houseNumber);
            newEntry.setStreetName(streetName);
            newEntry.setCity(city);
            newEntry.setState(state);
            newEntry.setZipCode(zipCode);
            entityManager.persist(newEntry);
            transaction.commit();

            out.println("<h2>The person has been added</h2>");
            out.println("<a href='/AddressBook_war_exploded/'>Click Here to start over</a> </br>");
            out.println("<a href=''>Click Here to view entire address book</a>");
            out.println("</body></html>");

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }


    }
}