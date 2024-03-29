/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.kocaeli.blm307.forms;

import edu.kocaeli.blm307.thread.PrimeThread;
import edu.kocaeli.blm307.utility.PrimeAppConstants;
import edu.kocaeli.blm307.utility.PrimeAppUtility;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AnilAltunkan
 */
public class PrimeNumbersForm extends javax.swing.JFrame {
    PrimeAppUtility utility;
    DefaultTableModel model;
    JTable threadTable;
    List<Integer> primeNumbersList;
    PrimeThread primeThread;
    boolean running;
    int defaultDivider;
    long defaultWaitTime;
    
    /**
     * Creates new form PrimeNumbersForm
     */
    public PrimeNumbersForm() {
        running = true;
        primeNumbersList = null;
        primeThread = null;
        
        defaultDivider = PrimeAppConstants.DEFAULT_THREADDIVIDER;
        defaultWaitTime = PrimeAppConstants.DEFAULT_WAITMSECONDS;
        
        initComponents();
        model = new DefaultTableModel() {
            Class[] types = {
                String.class, Integer.class, Integer.class, String.class
            };            
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return types[columnIndex];
            }            
        };
        threadTable = new JTable(model);
        model.addColumn("Thread Numaras�");
        model.addColumn("Ba�lang�� Noktas�");
        model.addColumn("Biti� Noktas�");
        model.addColumn("");
        
        CustomCellRenderer renderer = new CustomCellRenderer();
        threadTable.getColumnModel().getColumn(3).setCellRenderer(renderer);
        leftSubContentSPane.setViewportView(threadTable);
        threadDividerLabel.setText(String.valueOf(defaultDivider));
        waitTimeLabel.setText(String.valueOf(defaultWaitTime));
        utility = new PrimeAppUtility();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        subPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        endButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        primeNumbersLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        subContentPanel = new javax.swing.JPanel();
        leftSubContentSPane = new javax.swing.JScrollPane();
        rightSubContentPanel = new javax.swing.JPanel();
        numberPromptLabel = new javax.swing.JLabel();
        numberLabel = new javax.swing.JLabel();
        resultLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTextArea = new javax.swing.JTextArea();
        threadDividerLabelPrompt = new javax.swing.JLabel();
        waitTimeLabelPrompt = new javax.swing.JLabel();
        threadDividerLabel = new javax.swing.JLabel();
        waitTimeLabel = new javax.swing.JLabel();
        totalPrimePromptLabel = new javax.swing.JLabel();
        totalPrimeLabel = new javax.swing.JLabel();
        rangeLabel = new javax.swing.JLabel();
        rangePromptLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        changeThreadDivider = new javax.swing.JMenuItem();
        changeWaitTime = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asal Say�lar");
        setPreferredSize(new java.awt.Dimension(900, 660));
        setResizable(false);

        mainPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        mainPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        topPanel.setBackground(new java.awt.Color(204, 204, 255));
        topPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        topPanel.setPreferredSize(new java.awt.Dimension(800, 60));

        endButton.setText("Bitir");
        endButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endButtonActionPerformed(evt);
            }
        });

        startButton.setText("Ba�la");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        primeNumbersLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        primeNumbersLabel.setForeground(new java.awt.Color(255, 51, 51));
        primeNumbersLabel.setText("Asal Say�lar");
        primeNumbersLabel.setToolTipText("");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(primeNumbersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 555, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endButton)
                    .addComponent(startButton))
                .addContainerGap(20, Short.MAX_VALUE))
            .addComponent(primeNumbersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        rightSubContentPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        numberPromptLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        numberPromptLabel.setText("Ara�t�ralacak Say�");

        numberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        numberLabel.setForeground(new java.awt.Color(255, 51, 51));

        resultLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        resultLabel.setText("Sonu�:");

        resultTextArea.setEditable(false);
        resultTextArea.setColumns(20);
        resultTextArea.setRows(5);
        jScrollPane1.setViewportView(resultTextArea);

        threadDividerLabelPrompt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threadDividerLabelPrompt.setText("Thread B�leni");

        waitTimeLabelPrompt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        waitTimeLabelPrompt.setText("MiliSaniye Aral���");

        threadDividerLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threadDividerLabel.setForeground(new java.awt.Color(255, 51, 51));

        waitTimeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        waitTimeLabel.setForeground(new java.awt.Color(255, 51, 51));

        totalPrimePromptLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalPrimePromptLabel.setText("Toplam Asal Say�");

        totalPrimeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalPrimeLabel.setForeground(new java.awt.Color(255, 51, 51));

        rangeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rangeLabel.setForeground(new java.awt.Color(255, 51, 51));

        rangePromptLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rangePromptLabel.setText("Taban-Tavan Say�");

        javax.swing.GroupLayout rightSubContentPanelLayout = new javax.swing.GroupLayout(rightSubContentPanel);
        rightSubContentPanel.setLayout(rightSubContentPanelLayout);
        rightSubContentPanelLayout.setHorizontalGroup(
            rightSubContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightSubContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightSubContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightSubContentPanelLayout.createSequentialGroup()
                        .addGroup(rightSubContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resultLabel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightSubContentPanelLayout.createSequentialGroup()
                        .addGroup(rightSubContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rightSubContentPanelLayout.createSequentialGroup()
                                .addComponent(waitTimeLabelPrompt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6))
                            .addGroup(rightSubContentPanelLayout.createSequentialGroup()
                                .addGroup(rightSubContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numberPromptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(threadDividerLabelPrompt, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(rightSubContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightSubContentPanelLayout.createSequentialGroup()
                                .addComponent(waitTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(171, 171, 171))
                            .addGroup(rightSubContentPanelLayout.createSequentialGroup()
                                .addGroup(rightSubContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(threadDividerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(rightSubContentPanelLayout.createSequentialGroup()
                        .addComponent(totalPrimePromptLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(totalPrimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(171, Short.MAX_VALUE))
                    .addGroup(rightSubContentPanelLayout.createSequentialGroup()
                        .addComponent(rangePromptLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(rangeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(171, Short.MAX_VALUE))))
        );
        rightSubContentPanelLayout.setVerticalGroup(
            rightSubContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightSubContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightSubContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numberLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberPromptLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightSubContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(threadDividerLabelPrompt)
                    .addComponent(threadDividerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightSubContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(waitTimeLabelPrompt)
                    .addComponent(waitTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightSubContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalPrimePromptLabel)
                    .addComponent(totalPrimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightSubContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rangePromptLabel)
                    .addComponent(rangeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(resultLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout subContentPanelLayout = new javax.swing.GroupLayout(subContentPanel);
        subContentPanel.setLayout(subContentPanelLayout);
        subContentPanelLayout.setHorizontalGroup(
            subContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subContentPanelLayout.createSequentialGroup()
                .addComponent(leftSubContentSPane, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightSubContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 305, Short.MAX_VALUE))
        );
        subContentPanelLayout.setVerticalGroup(
            subContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subContentPanelLayout.createSequentialGroup()
                .addGroup(subContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rightSubContentPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftSubContentSPane, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(subContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout subPanelLayout = new javax.swing.GroupLayout(subPanel);
        subPanel.setLayout(subPanelLayout);
        subPanelLayout.setHorizontalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelLayout.createSequentialGroup()
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(contentPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(topPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE))
                .addGap(0, 86, Short.MAX_VALUE))
        );
        subPanelLayout.setVerticalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelLayout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(subPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(subPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jMenu1.setText("Parametreler");

        changeThreadDivider.setText("Thread B�leni");
        changeThreadDivider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeThreadDividerActionPerformed(evt);
            }
        });
        jMenu1.add(changeThreadDivider);

        changeWaitTime.setText("MiliSaniye Aral���");
        changeWaitTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeWaitTimeActionPerformed(evt);
            }
        });
        jMenu1.add(changeWaitTime);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("empty-statement")
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        final int initialStartNumber = utility.getMaxPrimeNumber();
        primeNumbersList = utility.getAllPrimeNumbers();
        
        if (!running) 
            running = true;        

        SwingWorker<Boolean, Integer> worker = new SwingWorker<Boolean, Integer>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                int numberToBeSearched = initialStartNumber;
                while (running) {
                    numberToBeSearched = numberToBeSearched + 2;
                    utility.clearSwingTable(model);
                    publish(numberToBeSearched);
                    Thread.sleep(defaultWaitTime);
                }
                return true;
            }
            
            @Override
            protected void process(List<Integer> chunks) {
                int numberToBeSearched = chunks.get(chunks.size()-1);
                int threadCount = 0;
                int primeCountBetweenLimits = 0;
                boolean isPrime = true;
                List<PrimeThread> threadList = null; 
                List<Integer> sqrtList = null;
                
                numberLabel.setText(String.valueOf(numberToBeSearched));
                
                if (threadList != null)
                    threadList.clear();  
                
                if (sqrtList != null)
                    sqrtList.clear();
                int bottom = utility.getBottomLimit();
                int top = utility.getTopLimit(numberToBeSearched);
                sqrtList = utility.createSqrtList(bottom, top, primeNumbersList);
                primeCountBetweenLimits = sqrtList.size();
                String rangeText = bottom + "-" + top + " ["+primeCountBetweenLimits+"]";
                rangeLabel.setText(rangeText);
                threadCount = utility.findThreadCount(primeCountBetweenLimits, defaultDivider);
                threadList = utility.createThreadList(sqrtList, threadCount, numberToBeSearched, primeCountBetweenLimits);     
                
                Iterator<PrimeThread> iterator = threadList.iterator();
                while(iterator.hasNext()) {
                    PrimeThread thread = iterator.next();
                    model.addRow(new Object[]{thread.getThreadName(), 
                                 new Integer(thread.getPrimeNumbers().get(0)), 
                                 new Integer(thread.getPrimeNumbers().get(thread.getPrimeNumbers().size()-1)), thread.getFoundPrimeNumber()}
                    );
                }
                
                ExecutorService executor = Executors.newFixedThreadPool(threadCount);
                for (PrimeThread thread : threadList) {
                    executor.execute(thread);
                }
                executor.shutdown();
                while (!executor.isTerminated());
                //System.out.println("B�t�n Thread'ler sonland�..");  
                
                String text = "";
                for (PrimeThread thread : threadList) {
                    if ("true".equals(thread.getFoundPrimeNumber())) {
                        text = "Say� asal de�ildir!\n" + thread.getThreadName() + 
                                " da bulunan \""+thread.getDivideNumber() + "\" \nsay�s�na tam olarak b�l�nmektedir.";
                        primeThread = thread;
                        isPrime = false;
                    }
                }
                if (isPrime) {
                    text = "Say� asald�r!";
                    primeNumbersList.add(numberToBeSearched);
                    totalPrimeLabel.setText(String.valueOf(primeNumbersList.size()));
                    //utility.addPrimeToTable(numberToBeSearched);
                } else {
                    model.setValueAt(primeThread.getFoundPrimeNumber(), primeThread.getRow(), 3);
                }
                resultTextArea.setText(text);                
            }            
        };
        worker.execute();
    }//GEN-LAST:event_startButtonActionPerformed

    private void endButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endButtonActionPerformed
        running = false;
    }//GEN-LAST:event_endButtonActionPerformed

    private void changeThreadDividerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeThreadDividerActionPerformed
        JTextField threadDividerField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Thread B�leni"));
        panel.add(threadDividerField);
        int result = JOptionPane.showConfirmDialog(null, panel, "Onay", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);        
        if (result == JOptionPane.OK_OPTION) {
            String threadDivider = threadDividerField.getText();
            if (!isInteger(threadDivider, 10)) return;
            
            defaultDivider = Integer.valueOf(threadDividerField.getText());
            threadDividerLabel.setText(String.valueOf(defaultDivider));
        }
        
    }//GEN-LAST:event_changeThreadDividerActionPerformed

    private void changeWaitTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeWaitTimeActionPerformed
        JTextField waitTimerField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("MiliSaniye Aral���"));
        panel.add(waitTimerField);
        int result = JOptionPane.showConfirmDialog(null, panel, "Onay", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);        
        if (result == JOptionPane.OK_OPTION) {
            String waitTime = waitTimerField.getText();
            if (!isInteger(waitTime, 10)) return;
            
            defaultWaitTime = Long.valueOf(waitTime);
            waitTimeLabel.setText(String.valueOf(defaultWaitTime));
        }
    }//GEN-LAST:event_changeWaitTimeActionPerformed

    
    public boolean isInteger(String s, int radix) {
        if(s.isEmpty()) 
            return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) 
                    return false;
                else 
                    continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) 
                return false;
        }
        return true;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrimeNumbersForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem changeThreadDivider;
    private javax.swing.JMenuItem changeWaitTime;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton endButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane leftSubContentSPane;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JLabel numberPromptLabel;
    private javax.swing.JLabel primeNumbersLabel;
    private javax.swing.JLabel rangeLabel;
    private javax.swing.JLabel rangePromptLabel;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JTextArea resultTextArea;
    private javax.swing.JPanel rightSubContentPanel;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel subContentPanel;
    private javax.swing.JPanel subPanel;
    private javax.swing.JLabel threadDividerLabel;
    private javax.swing.JLabel threadDividerLabelPrompt;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel totalPrimeLabel;
    private javax.swing.JLabel totalPrimePromptLabel;
    private javax.swing.JLabel waitTimeLabel;
    private javax.swing.JLabel waitTimeLabelPrompt;
    // End of variables declaration//GEN-END:variables
}
