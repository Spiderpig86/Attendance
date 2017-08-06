package com.clubattendance.attendance.source;

/* ------------------------- IMPORTS ------------------------- */

// Java Imports
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.Serializable;



/* ----------------------------- CLASS DEF ----------------------------- */


public class Email implements Serializable {

    /* ----------------------- INSTANCE VAR ----------------------- */

    private String email;
    private static final Pattern VALID_EMAIL_REGEX =
            Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",Pattern.CASE_INSENSITIVE);
    private static Matcher matcher;

    /* ----------------------- CONSTRUCTORS ----------------------- */

    /**
     * Default Email constructor.
     * @param  email                    desired email
     * @throws IllegalArgumentException if invalid email
     */
    public Email(String email) throws IllegalArgumentException{
        this.email = "";
        setEmail(email);
    }

    /**
     * Modified Email constructor
     */
    public Email(){
        this.email = "";
    }


    /* ----------------------- METHODS ----------------------- */

    /**
     * Retrieves the email.
     * @return email as a String
     */
    public String getEmail(){ return this.email; }

    /**
     * Attempts to change the email.
     * @param  email                    the desired email`
     * @throws IllegalArgumentException if invalid email
     */
    public void setEmail(String email) throws IllegalArgumentException{
        boolean valid = validate(email);
        if (!valid)
            throw new IllegalArgumentException("Invalid Email");
        this.email = email;
    }

    /**
     * Checks an email against the valid regex.
     * @param  email         testing email
     * @return               true if valid
     */
    private boolean validate(String email){
        matcher = VALID_EMAIL_REGEX.matcher(email);
        return matcher.matches();
    }

}
