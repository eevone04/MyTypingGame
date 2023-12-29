


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author linna
 */
public class Leaderboards extends javax.swing.JFrame {

    public Leaderboards() {
        initComponents();
        displayLeaderboard("name.txt");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        leaderboard = new javax.swing.JTable();
        profileb = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("LEADERBOARDS");

        leaderboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No.", "Name", "average WPM (last 10 games)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(leaderboard);

        profileb.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        profileb.setForeground(new java.awt.Color(51, 51, 255));
        profileb.setText("Click here to view player's profiles ");
        profileb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilebActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("*NaN means player deosn't played before");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(profileb))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileb)
                    .addComponent(jLabel2))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profilebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilebActionPerformed
        //Open Player profile
        playerprofile1 profile = new playerprofile1();
        profile.show();//display player profile here
        
        dispose(); //close leaderboard
        
    }//GEN-LAST:event_profilebActionPerformed

    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Leaderboards().setVisible(true);
            }
        });
        
        
    }
    
//    private void leaderboardMouseClicked(java.awt.event.MouseEvent evt) {
//        int selectedRow = leaderboard.getSelectedRow();
//        if (selectedRow != -1) {
//            String playerName = (String) leaderboard.getValueAt(selectedRow, 1);
//        }
//    }
//    
    

//    private void showPlayerProfile(String playerName){
//        playerprofile1 playerProfileFrame = new playerprofile1(playerName);
//        playerProfileFrame.setVisible(true);
//    }
    
    private void displayLeaderboard(String fileName) {
        DefaultTableModel tblModel = (DefaultTableModel) leaderboard.getModel();
        tblModel.setRowCount(0); // Clear existing data in the table

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line, name;
            int rowNumber=1;
            double averagewpm;
            
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\s+"); // Assuming space-separated values in the file
                name = data[0];
               
                averagewpm=Averagelast10WPM(name+".txt");
                
                // Add data to the table model
                tblModel.addRow(new Object[]{rowNumber++, name, averagewpm});
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    private double Averagelast10WPM(String fileName) {
        
        double averagelast10wpm=0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int last10wpm=0;
            int totalgame=0;
           
            ArrayList<Integer> last10WPM = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\s+"); // Assuming space-separated values in the file

                if(data.length>=2){
                    int wpm = Integer.parseInt(data[0]);
                    totalgame++;
                    
                    last10WPM.add(wpm);
                    
                    if(last10WPM.size()>10){
                        last10WPM.remove(0); //only have last 10 wpm
                    }
                }
            }
            
                if(totalgame>=10){
                    last10wpm = last10WPM.stream().mapToInt(Integer::intValue).sum();
                    averagelast10wpm = (double)last10wpm/10;
                }else{
                    last10wpm = last10WPM.stream().mapToInt(Integer::intValue).sum();
                    averagelast10wpm = (double)last10wpm/totalgame;
                }
                
        } catch (IOException e) {
            e.printStackTrace();
        }
        return averagelast10wpm;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable leaderboard;
    private javax.swing.JButton profileb;
    // End of variables declaration//GEN-END:variables
}
