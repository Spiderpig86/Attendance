package com.clubattendance.attendance.source;


/* ----------------------------- IMPORTS ----------------------------- */

// Java Imports
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.Serializable;


/* ----------------------------- CLASS DEFINITION ----------------------------- */


public class Password implements Serializable {

    /* ----------------------- INSTANCE VAR ----------------------- */

    private String password;
    private static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{4,20})");
    private static Matcher matcher;


    /* ----------------------- CONSTRUCTORS ----------------------- */

    /**
     * Default Password constructor.
     * @param  initPassword             desired password
     * @throws IllegalArgumentException if illegal password
     */
    public Password(String initPassword) throws IllegalArgumentException{
        this.password = "";
        setPassword(initPassword);
    }

    /**
     * Modified Password constructor.
     */
    public Password(){
        this.password = "";
    }


    /* ----------------------- METHODS ----------------------- */

    /**
     * Retrieves the password.
     * @return the String password
     */
    public String getPassword() { return this.password; }

    /**
     * Attempts to set the password.
     * @param  password                  desired password
     * @throws IllegalArgumentException  if illegal password
     */
    public void setPassword(String password) throws IllegalArgumentException{
        boolean valid = validate(password);
        if (!valid)
            throw new IllegalArgumentException("Invalid Password");
        this.password = password;
    }

    /**
     * Validates the password using regex.
     * @param  password      password to check
     * @return               true if valid
     */
    private boolean validate(String password){
        matcher = VALID_PASSWORD_REGEX.matcher(password);
        return matcher.matches();
    }

}
