/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.kocaeli.blm307.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author AnilAltunkan
 */
public class PrimeThread implements Runnable {
    private String threadName;
    private String foundPrimeNumber;
    private final List<Integer> primeNumbers = new ArrayList<Integer>();
    private int numberToBeSearched;
    private int divideNumber;
    private int row;
    
    public PrimeThread(String threadName, String foundPrimeNumber, int numberToBeSearched, int row) {
        this.threadName = threadName;
        this.foundPrimeNumber = foundPrimeNumber;
        this.numberToBeSearched = numberToBeSearched;
        this.row = row;
    }
    
    @Override
    public void run() {
        //System.out.println("Çalýþan Thread: " + getThreadName());
        Iterator<Integer> iterator = primeNumbers.iterator();
        while (iterator.hasNext()) {
            int primeNumber = iterator.next();
            if (getNumberToBeSearched() % primeNumber == 0) {
                setFoundPrimeNumber("true");
                setDivideNumber(primeNumber);
                break;
            }
        }
    }
    
    public void putNumberIntoList(int number) {
        getPrimeNumbers().add(number);
    }

    /**
     * @return the threadName
     */
    public String getThreadName() {
        return threadName;
    }

    /**
     * @param threadName the threadName to set
     */
    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    /**
     * @return the primeNumbers
     */
    public List<Integer> getPrimeNumbers() {
        return primeNumbers;
    }

    /**
     * @return the divideNumber
     */
    public int getDivideNumber() {
        return divideNumber;
    }

    /**
     * @param divideNumber the divideNumber to set
     */
    public void setDivideNumber(int divideNumber) {
        this.divideNumber = divideNumber;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the numberToBeSearched
     */
    public int getNumberToBeSearched() {
        return numberToBeSearched;
    }

    /**
     * @param numberToBeSearched the numberToBeSearched to set
     */
    public void setNumberToBeSearched(int numberToBeSearched) {
        this.numberToBeSearched = numberToBeSearched;
    }

    /**
     * @return the foundPrimeNumber
     */
    public String getFoundPrimeNumber() {
        return foundPrimeNumber;
    }

    /**
     * @param foundPrimeNumber the foundPrimeNumber to set
     */
    public void setFoundPrimeNumber(String foundPrimeNumber) {
        this.foundPrimeNumber = foundPrimeNumber;
    }
    
}
