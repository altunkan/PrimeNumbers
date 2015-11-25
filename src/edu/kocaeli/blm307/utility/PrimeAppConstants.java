/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.kocaeli.blm307.utility;

/**
 *
 * @author AnilAltunkan
 */
public class PrimeAppConstants {
    public static final String  ORACLE_CONSTRING = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    public static final String  ORACLE_CONUSERNAME = "HR";
    public static final String  ORACLE_CONPASSWORD = "hr";
    
    public static final String  SQL_MAXPRIME = "SELECT MAX (prime_number) FROM prime_numbers";
    public static final String  SQL_TOTALPRIMECOUNT = "SELECT COUNT (prime_number) FROM prime_numbers";
    public static final String  SQL_GETPRIMES = "SELECT prime_number FROM prime_numbers ORDER BY prime_number ASC";
    public static final String  SQL_ADDPRIME = "INSERT INTO prime_numbers (prime_number) VALUES (?)";
    
    public static final Long    DEFAULT_WAITMSECONDS = 100L;
    public static final Integer DEFAULT_THREADDIVIDER = 100;
}
