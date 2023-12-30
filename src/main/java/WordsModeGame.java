import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author USER
 */
public class WordsModeGame extends javax.swing.JFrame {
    private int numberWords;
    WordsMode wordsMode = new WordsMode();
    /**
     * Creates new form WordsModeGame
     */
    private Random random = new Random();
    private int time;
    private boolean includePunctuation;
    private boolean isGameEnded = false; 
    private Timer timer;

    private JLabel timerLabel;
    private JScrollPane jScrollPane2;
    
    private String currentWord;
    private int currentIndex;
    private Highlighter.HighlightPainter painterCorrect;
    private Highlighter.HighlightPainter painterWrong;
    private List<Boolean> wordStatus;
    /**
     * Creates new form TimedModeGame
     */
    public WordsModeGame(int numberWords) {
        initComponents();
        this.time = time;
        this.includePunctuation = includePunctuation;
        setupTextFieldListener();
        generateRandomWords();
        setupHighlightPainters();
    }
    private void handleGameEnd() {
        jTextField1.setEditable(false);
        isGameEnded = true;
    }

    private void handleTextFieldEnter() {
        if (!isGameEnded) {
            JOptionPane.showMessageDialog(this, "Game end");
            jTextField1.setEditable(false); // Disable further input in the text field
            timer.stop(); // Stop the timer when the game ends
        }
    }
    private void highlightUserInput() {
    String userInput = jTextField1.getText().trim();

    try {
        String text = jTextArea1.getText();
        int start = 0;

        Highlighter highlighter = jTextField1.getHighlighter();
        highlighter.removeAllHighlights(); // Clear previous highlights

        for (int i = 0; i < userInput.length() && start + i < text.length(); i++) {
            char inputChar = userInput.charAt(i);
            char textChar = text.charAt(start + i);

            if (inputChar == textChar) {
                // Set character as correct
                highlighter.addHighlight(start + i, start + i + 1, painterCorrect);
            } else {
                // Set character as wrong
                highlighter.addHighlight(start + i, start + i + 1, painterWrong);
            }
        }
    } catch (BadLocationException e) {
        e.printStackTrace();
    }
}
    private void setupHighlightPainters() {
    painterCorrect = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
    painterWrong = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
}
    private void generateRandomWords() {
    try {
        Scanner scanner = new Scanner(new File("C:/Users/USER/Downloads/random-words.txt"));
        List<String> wordsList = new ArrayList<>();

        // Read all words from the file
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (!includePunctuation) {
                // Remove punctuation
                word = word.replaceAll("[^a-zA-Z]", "");
            }
            wordsList.add(word);
        }

        // Shuffle the list to get random words
        Collections.shuffle(wordsList);

        // Take the first 30 words or less if the file has fewer words
        int wordsToDisplay = Math.min(wordsList.size(), wordsMode.getNumberWords());
        StringBuilder randomWords = new StringBuilder();

        for (int i = 0; i < wordsToDisplay; i++) {
            randomWords.append(wordsList.get(i)).append(" ");
        }

        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setText(randomWords.toString().trim());
        jTextArea1.setEditable(false);
        // Center align the text
        jTextArea1.setAlignmentX(CENTER_ALIGNMENT);
        jTextArea1.setAlignmentY(CENTER_ALIGNMENT);
        wordStatus = new ArrayList<>(Collections.nCopies(wordsToDisplay, false));
        currentWord = wordsList.get(0);
        currentIndex = 0;

            jTextField1.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    highlightUserInput();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    highlightUserInput();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    highlightUserInput();
                }
            });

    } catch (FileNotFoundException e) {
        System.err.println("File not found: random-words.txt");
    }
}

    private void setupTextFieldListener() {
        jTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleTextFieldEnter();
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
    }
});
        jButton3.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
    }
});
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Play Again");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("New Text");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        handleTextFieldEnter();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        WordsMode wordsMode = new WordsMode();
        wordsMode.show();//display TimedMode here
        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        resetGame();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        generateRandomWords();
        resetGame();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void resetGame() {
    // Reset game-related variables
    isGameEnded = false;
    jTextField1.setText("");
    jTextField1.setEditable(true);

    // Reset word status
    wordStatus.replaceAll(status -> false);

    // Reset highlights
    jTextField1.getHighlighter().removeAllHighlights();
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WordsModeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WordsModeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WordsModeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WordsModeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WordsModeGame(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
