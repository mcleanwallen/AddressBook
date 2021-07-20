package com.example.AddressBook;

import com.example.AddressBook.NewEntryServelet;
import entity.Person;
import javax.persistence.*;

public class DBPersonAdd {
    public static void main(String[] args)/*addingPerson(String firstName,
                                    String middleName,
                                    String lastName,
                                    String houseNumber,
                                    String streetName,
                                    String city,
                                    String state,
                                    String zipCode) */{
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Person newEntry = new Person();
            newEntry.setFirstName("Elise");
            newEntry.setMiddleName("");
            newEntry.setLastName("Martin");
            newEntry.setHouseNumber("39");
            newEntry.setStreetName("S Millbrook St");
            newEntry.setCity("Aurora");
            newEntry.setState("CO");
            newEntry.setZipCode("80018");
            /*newEntry.setFirstName(firstName);
            newEntry.setMiddleName(middleName);
            newEntry.setLastName(lastName);
            newEntry.setHouseNumber(houseNumber);
            newEntry.setStreetName(streetName);
            newEntry.setCity(city);
            newEntry.setState(state);
            newEntry.setZipCode(zipCode);*/
            entityManager.persist(newEntry);
            System.out.println("The person has been added");
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
