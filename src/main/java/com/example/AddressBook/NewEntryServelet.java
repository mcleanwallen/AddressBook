package com.example.AddressBook;

import org.hibernate.JDBCException;

import java.io.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import entity.Person;
import org.hibernate.*;
import javax.persistence.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import com.example.AddressBook.DBPersonAdd;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.*;

import static com.example.AddressBook.DBPersonAdd.AddPerson;

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
    Connection connection;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This resource is not available directly.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, JDBCException
    {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        firstName = request.getParameter("firstName");
        middleName = request.getParameter("middleName");
        lastName = request.getParameter("lastName");
        houseNumber = request.getParameter("houseNumber");
        streetName = request.getParameter("streetName");
        city = request.getParameter("city");
        state = request.getParameter("state");
        zipCode = request.getParameter("zipCode");

        out.println("<html><head></head><body>");
        out.println("<h1>This person has been added to the address book:</h1>");
        out.println("<p>Name: " + firstName +" " + middleName +" "+ lastName + "</p>");
        out.println("<p>Address: " + houseNumber +" " + streetName + "</p>");
        out.println("<p>         " + city +", " + state +" " + zipCode + "</p>");
        out.println("<h2>The person has been added</h2>");
        out.println("<a href='/AddressBook_war_exploded/'>Click Here to start over</a> </br>");
        out.println("<a href=''>Click Here to view entire address book</a>");
        out.println("</body></html>");
        AddPerson(firstName, middleName, lastName, houseNumber, streetName,city,state,zipCode);



    }
}