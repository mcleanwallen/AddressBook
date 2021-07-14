package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Personaddress {
    private int personAddressId;
    private String houseNumber;
    private String streetName;
    private String city;
    private String state;
    private String zipCode;
    private Person personByPersonId;

    @Id
    @Column(name = "personAddressID")
    public int getPersonAddressId() {
        return personAddressId;
    }

    public void setPersonAddressId(int personAddressId) {
        this.personAddressId = personAddressId;
    }

    @Basic
    @Column(name = "houseNumber")
    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Basic
    @Column(name = "streetName")
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "zipCode")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaddress that = (Personaddress) o;
        return personAddressId == that.personAddressId && Objects.equals(houseNumber, that.houseNumber) && Objects.equals(streetName, that.streetName) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(zipCode, that.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personAddressId, houseNumber, streetName, city, state, zipCode);
    }

    @ManyToOne
    @JoinColumn(name = "personID", referencedColumnName = "personID", nullable = false)
    public Person getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(Person personByPersonId) {
        this.personByPersonId = personByPersonId;
    }
}
