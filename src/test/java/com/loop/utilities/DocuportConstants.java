package com.loop.utilities;

import io.cucumber.java.Scenario;

public class DocuportConstants {

    public static final String USERNAME_CLIENT = "b1g1_client@gmail.com";
    public static final String PASSWORD_CLIENT = "Group1";

    public static final String ERROR_MESSAGE_FOR_EMPTY_PASSWORD = "Please enter your password";

    public static final String LOGO_DOCUPORT = "docuport";
    public static final String  DOCUPORT_USERNAME = "username or email";
    public static final String  DOCUPORT_PASSWORD = "Password";
    public static final String  DOCUPORT_LOGIN = "Log in";

    public static final String RESET_PASSWORD_URL = "reset-password";

    public static final String RESET_PASSWORD_MESSAGE = "Enter the email address associated with your account";

    public static final String RESET_PASSWORD_EMAIL = "forgotpasswordg1@gmail.com";

    public static final String PASSWORD_ADVISOR = "Group1";
    public static final String PASSWORD_EMPLOYEE = "Group1";
    public static final String PASSWORD_SUPERVISOR = "Group1";

    public static final String PASSWORD = "Group1";
    public static final String USERNAME_ADVISOR = "b1g1_advisor@gmail.com";
    public static final String USERNAME_SUPERVISOR = "b1g1_supervisor@gmail.com";
    public static final String USERNAME_EMPLOYEE = "b1g1_employee@gmail.com";

    // roles
    public static final String ADVISOR = "advisor";
    public static final String CLIENT = "client";
    public static final String SUPERVISOR = "supervisor";
    public static final String EMPLOYEE = "employee";

    public static Scenario scenario;




    //We use static because it lets us call these by class name

    //waits

    public static final int extraSmall = 3;
    public static final int Small = 5;
    public static final int Medium = 7;
    public static final int large = 10;
    public static final int extraLarge = 20;
}
