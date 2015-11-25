/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.kocaeli.blm307.utility;

import edu.kocaeli.blm307.connection.XeConnection;
import edu.kocaeli.blm307.thread.PrimeThread;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AnilAltunkan
 */
public class PrimeAppUtility {
    
    public int findThreadCount(int primeCountBetweenLimits, int defaultDivider) {
        if (primeCountBetweenLimits < defaultDivider)
            return 2;
        
        return ((int)primeCountBetweenLimits / defaultDivider) + 1;
    }
    
    public int getTopLimit(int number) {
        return (int)(Math.sqrt(number));
    }
    
    public int getBottomLimit() {
        return 2;
    }
    
    public void clearSwingTable(DefaultTableModel model) {
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }     
    }
    
    public List<PrimeThread> createThreadList(List<Integer> sqrtList, int threadCount, int numberToBeSearched, int primeCountBetweenLimits) {
        List<PrimeThread> threadList = new ArrayList<PrimeThread>();
        int chunkCount = 0;
        int remainChunkCount = 0;
        chunkCount = primeCountBetweenLimits / threadCount;
        remainChunkCount = primeCountBetweenLimits % threadCount;
        
        for (int i = 1; i <= threadCount; i++) {
            PrimeThread thread = new PrimeThread("Thread " + i, "false", numberToBeSearched, i-1);
            if (i == threadCount) {
                Collections.reverse(sqrtList);
                for (int j = 0; j < chunkCount + remainChunkCount; j++) {
                    thread.putNumberIntoList(sqrtList.get(0));
                    sqrtList.remove(0);
                }                
            } else {
                for (int j = 0; j < chunkCount; j++) {
                    thread.putNumberIntoList(sqrtList.get(0));
                    sqrtList.remove(0);
                }
            }
            threadList.add(thread);
        }
        return threadList;
    }
    
    public void addPrimeToTable(int number) {
        XeConnection xeCon = new XeConnection();
        Connection con = xeCon.getConnection();
        String sql = PrimeAppConstants.SQL_ADDPRIME;    
        PreparedStatement ps = null;        
        try {       
            ps = con.prepareStatement(sql);
            ps.setInt(1, number);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeAll(ps, null, con);
        }        
    }
            
    public int getMaxPrimeNumber() {
        XeConnection xeCon = new XeConnection();
        Connection con = xeCon.getConnection();
        String sql = PrimeAppConstants.SQL_MAXPRIME;
        int maxNumber = 0;
        PreparedStatement ps = null;        
        ResultSet rs = null;
        try {       
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            maxNumber = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeAll(ps, rs, con);
        }
        
        return maxNumber;      
    }
    
    public List<Integer> createSqrtList(int start, int end, List<Integer> primeNumbersList) {
        List<Integer> sqrtList = new ArrayList<Integer>();
        Iterator<Integer> iterator = primeNumbersList.iterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            if (number >= start && number <= end)
                sqrtList.add(number);
        }
        return sqrtList;
    }

    private void closeAll(PreparedStatement ps, ResultSet rs, Connection con) {
        try {
            if (ps != null)
                ps.close();
            
            if (rs != null)
                rs.close();
            
            if (con != null)
                con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Integer> getAllPrimeNumbers() {
        XeConnection xeCon = new XeConnection();
        Connection con = xeCon.getConnection();
        String sql = PrimeAppConstants.SQL_GETPRIMES;
        PreparedStatement ps = null;        
        ResultSet rs = null;
        List<Integer> primeNumbers = new ArrayList<Integer>();
        try {       
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                primeNumbers.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeAll(ps, rs, con);
        }        
        return primeNumbers;
    }
}
