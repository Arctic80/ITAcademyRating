package com.itacademy.rating.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Entity
public class User
{
    @Id
    private String dni;

    public User() {}

    public User(String dni) throws ResponseStatusException
    {
        if (!checkDni(dni)) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        this.dni = dni;
    }

    private boolean checkDni(String dni)
    {
        Pattern p = Pattern.compile("^[0-9]{8,8}[TRWAGMYFPDXBNJZSQVHLCKE]$");
        Matcher m = p.matcher(dni);

        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        Integer dniNumber = Integer.valueOf(dni.substring(0,8));

        return m.matches() && dni.substring(8,9).charAt(0) == (Character) letters.charAt(dniNumber % 23);
    }

    public String getDni() {
        return dni;
    }
}