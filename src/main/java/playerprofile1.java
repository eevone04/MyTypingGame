


import java.awt.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class playerprofile1 extends javax.swing.JFrame {

    public playerprofile1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        playername = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        averagewpm = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        Accuracyscore = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "WPM", "Accuracy", "10 most misspelled words", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("PLAYER PROFILE");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel2.setText("Enter player's username:");

        playername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playernameActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No.", "WPM", "Accuracy"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        averagewpm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "all-time", "last 10 games"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(averagewpm);

        Accuracyscore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "all-time", "last 10 games"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(Accuracyscore);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("Average WPM");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Accuracy Scores");

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "10 most misspelled words"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable6);

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setText("Badge of Shame");

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(498, 498, 498))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(128, 128, 128)
                                        .addComponent(jLabel3))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(89, 89, 89)))))
                        .addGap(230, 230, 230))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(619, 619, 619))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(playername, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(553, 553, 553)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playername, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = playername.getText();
        
        boolean matched = false;
        
        
        try {
            Scanner in = new Scanner(new FileInputStream("name.txt"));
            
            while(in.hasNextLine()){
                String line=in.nextLine();
                if(line.equals(name)){
                    matched = true;
                    break;
            }
        }
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        
        if(matched){
            JOptionPane.showMessageDialog(null, "User Found: "+name);
            
                displayDataInTable(name+".txt");
                
                displayAverageWPM(name+".txt");
                
                displayAverageAccuracy(name+".txt");
            
            
            
        }else{
            JOptionPane.showMessageDialog(null, "Player does not exist!","Message",JOptionPane.ERROR_MESSAGE);
        }
        
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void playernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playernameActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        NewJFrame main = new NewJFrame();
        main.show();
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

   
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new playerprofile1().setVisible(true);
            }
        });
    }

    
     // Method to display data from a text file in JTable
    private void displayDataInTable(String fileName) {
        DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();
        tblModel.setRowCount(0); // Clear existing data in the table

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int rowNumber=1;
            
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\s+"); // Assuming space-separated values in the file

                //Insert the row number as the first colum
                Object[] rowData = new Object[data.length + 1];
                rowData[0] = rowNumber++;
                System.arraycopy(data, 0, rowData, 1, data.length);
                
                // Add data to the table model
                tblModel.addRow(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    private void displayAverageWPM(String fileName) {
        DefaultTableModel tblModel = (DefaultTableModel) averagewpm.getModel();
        tblModel.setRowCount(0); // Clear existing data in the table

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int totalwpm=0;
            int last10wpm=0;
            int totalgame=0;
            double averagelast10wpm;

            ArrayList<Integer> last10WPM = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\t+"); // tab-separated values in the file

                if(data.length>=2){
                    int wpm = Integer.parseInt(data[0]);
                    totalwpm+=wpm;
                    totalgame++;
                    
                    last10WPM.add(wpm);
                    
                    if(last10WPM.size()>10){
                        last10WPM.remove(0); //only have last 10 wpm
                    }
                }
            }
            
                double averagewpm = (double)totalwpm/totalgame;
                
                if(totalgame>=10){
                    last10wpm = last10WPM.stream().mapToInt(Integer::intValue).sum();
                    averagelast10wpm = (double)last10wpm/10;
                }else{
                    last10wpm = last10WPM.stream().mapToInt(Integer::intValue).sum();
                    averagelast10wpm = (double)last10wpm/totalgame;
                }
                
                // Format the double values with two decimal places
                String formattedAverageWPM = String.format("%.2f", averagewpm);
                String formattedAverageLast10WPM = String.format("%.2f", averagelast10wpm);
                
                // Add data to the table model
                tblModel.addRow(new Object[]{formattedAverageWPM,formattedAverageLast10WPM});
                
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    private void displayAverageAccuracy(String fileName) {
        DefaultTableModel tblModel = (DefaultTableModel) Accuracyscore.getModel();
        tblModel.setRowCount(0); // Clear existing data in the table

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int totalaccuracy=0;
            int last10accuracy=0;
            int totalgame=0;
            double averagelast10accuracy;

            ArrayList<Double> last10Accuracy = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\t+"); // tab-separated values in the file

                if(data.length>=2){
                    double accuracy = Double.parseDouble(data[1]);
                    totalaccuracy+=accuracy;
                    totalgame++;
                    
                    last10Accuracy.add(accuracy);
                    
                    if(last10Accuracy.size()>10){
                        last10Accuracy.remove(0); //only have last 10 wpm
                    }
                }
            }
            
                double averageaccuracy = (double)totalaccuracy/totalgame;
                
                if(totalgame>=10){
                    last10accuracy = last10Accuracy.stream().mapToInt(Double::intValue).sum();
                    averagelast10accuracy = (double)last10accuracy/10;
                }else{
                    last10accuracy = last10Accuracy.stream().mapToInt(Double::intValue).sum();
                    averagelast10accuracy = (double)last10accuracy/totalgame;
                }
                
                // Format the double values with two decimal places
                String formattedAverageAccuracy = String.format("%.2f", averageaccuracy);
                String formattedAverageLast10Accuracy = String.format("%.2f", averagelast10accuracy);
                
                // Add data to the table model
                tblModel.addRow(new Object[]{formattedAverageAccuracy,formattedAverageLast10Accuracy});
                
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Accuracyscore;
    private javax.swing.JTable averagewpm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField playername;
    // End of variables declaration//GEN-END:variables
}
