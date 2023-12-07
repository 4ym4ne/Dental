package com.dental.DTO;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for {@link com.dental.entities.Patient}
 */
public class PatientDTO implements Serializable {
    private final UUID id;
    private final String username;
    private final String passwordhash;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String phone;
    private final String address;

    public PatientDTO(UUID id, String username, String passwordhash, String firstname, String lastname, String email, String phone, String address) {
        this.id = id;
        this.username = username;
        this.passwordhash = passwordhash;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientDTO entity = (PatientDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.passwordhash, entity.passwordhash) &&
                Objects.equals(this.firstname, entity.firstname) &&
                Objects.equals(this.lastname, entity.lastname) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.address, entity.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, passwordhash, firstname, lastname, email, phone, address);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "username = " + username + ", " +
                "passwordhash = " + passwordhash + ", " +
                "firstname = " + firstname + ", " +
                "lastname = " + lastname + ", " +
                "email = " + email + ", " +
                "phone = " + phone + ", " +
                "address = " + address + ")";
    }
}