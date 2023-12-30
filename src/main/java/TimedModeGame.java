import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
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
public class TimedModeGame extends javax.swing.JFrame {
    TimedMode timedMode = new TimedMode();
    int time;
    private Random random = new Random();
    private boolean includePunctuation;
    private boolean isGameEnded = false; 
    private Timer timer;
    int second;
    private JLabel timerLabel;
    private boolean timerStarted = false;
    private String currentWord;
    private int currentIndex;
    private Highlighter.HighlightPainter painterCorrect;
    private Highlighter.HighlightPainter painterWrong;
    private List<Boolean> wordStatus;
    
    private int totalCharCount = 0;
    private int incorrectCharCount = 0;
    
    Login_Application loginname = new Login_Application();
    private String uname;
    /**
     * Creates new form TimedModeGame
     */
    public TimedModeGame(boolean includePunctuation) {
        initComponents();
        this.includePunctuation = includePunctuation;
        setupTextFieldListener();
        generateRandomWords();
        setupHighlightPainters();
    }
    private void handleGameEnd() {
        jTextField2.setEditable(false);
        isGameEnded = true;
    }

    private void handleTextFieldEnter() {
        if (!isGameEnded) {
            if (!timerStarted) {
                simpleTimer(); // Start the timer if not already started
                timerStarted = true;
            }
            if (second == 0) {
             jTextField2.setEditable(false); // Do nothing if the timer has reached zero
        }
        }
    }
    
    private void generateRandomWords() {
    try {
        String userHome = System.getProperty("user.home");
        String filePath = userHome + "/Downloads/random-words.txt";
        Scanner scanner = new Scanner(new File(filePath));
        List<String> wordsList = new ArrayList<>();

        // Read all words from the file
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (!includePunctuation) {
        // Remove punctuation
        word = word.replaceAll("[^a-zA-Z]", "");
           } else {
        // Add random punctuation with a probability of 40%
                if (random.nextDouble() < 0.4) {
                String[] punctuation = {",", ".", "!", "?", "\"", ";", ":"};
                word += punctuation[random.nextInt(punctuation.length)];
                }
           }
            wordsList.add(word);
        }

        // Shuffle the list to get random words
        Collections.shuffle(wordsList);

        // Take the first 30 words or less if the file has fewer words
        int wordsToDisplay = Math.min(wordsList.size(), 30);
        StringBuilder randomWords = new StringBuilder();
        
        for (int i = 0; i < wordsToDisplay; i++) {
            randomWords.append(wordsList.get(i)).append(" ");
        }

        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setText(randomWords.toString().trim());

        // Center align the text
        jTextArea1.setAlignmentX(CENTER_ALIGNMENT);
        jTextArea1.setAlignmentY(CENTER_ALIGNMENT);
        wordStatus = new ArrayList<>(Collections.nCopies(wordsToDisplay, false));
        currentWord = wordsList.get(0);
        currentIndex = 0;
        jTextField2.getDocument().addDocumentListener(new DocumentListener() {
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
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextField2KeyTyped(evt);
    }

            private void jTextField2KeyTyped(KeyEvent evt) {
                char typedChar = evt.getKeyChar();

    // Check if the timer has started
    if (!timerStarted) {
        simpleTimer(); // Start the timer if not already started
        timerStarted = true;
    }

    // Handle the typed character, you can add custom logic here

    // For example, you might want to check if the time has reached zero
    if (second == 0) {
        jTextField2.setEditable(false);
    }
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
    private void highlightUserInput() {
    String userInput = jTextField2.getText().trim();

    try {
        String text = jTextArea1.getText();
        int start = 0;

        Highlighter highlighter = jTextField2.getHighlighter();
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
    public void simpleTimer() {
    time = timedMode.getTimer();
    second = time;

    long startTime = System.currentTimeMillis();

    timer = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            second = (int) (time - elapsedTime / 1000);

            if (second <= 0) {
                int[] correctWordInfo = countCorrectWordsAndCharacters();
                int correctWord = correctWordInfo[0];
                int correctchar = correctWordInfo[1];
                int wpm=wpm();
                double accuracy=Accuracy();
                
                timer.stop();
                jLabel2.setText("0");
                
                // Format accuracy to two decimal places
                String formattedAccuracy = String.format("%.2f", accuracy);
                
                JOptionPane.showMessageDialog(null, "Game end!"+ "\nCorrect words: " + correctWord + "/" + jTextArea1.getText().split("\\s+").length+"\nCorrect character: "+correctchar+ "\nwpm: " +wpm+"\nAccuracy: "+formattedAccuracy);
                writeScoreToFile();
                handleGameEnd(); // You may want to handle game end actions here
            } else {
                jLabel2.setText("" + second);
            }
        }
    });

    timer.start();
}
    
private int[] countCorrectWordsAndCharacters() {
    String[] expectedWords = jTextArea1.getText().split("\\s+");
    String userInput = jTextField2.getText().trim();
    String[] userWords = userInput.split("\\s+");

    int minLen = Math.min(expectedWords.length, userWords.length);
    int correctWordCount = 0;
    int correctCharCount = 0;
    int incorrectCharCount = 0;

    for (int i = 0; i < minLen; i++) {
        String expectedWord = expectedWords[i];
        String userWord = i < userWords.length ? userWords[i] : "";

        for (int j = 0; j < expectedWord.length(); j++) {
            totalCharCount++;
            char expectedChar = expectedWord.charAt(j);
            char userChar = (j < userWord.length()) ? userWord.charAt(j) : ' ';

            if (expectedChar == userChar) {
                correctCharCount++;
            } else {
                incorrectCharCount++;
            }
        }

        // Check for extra characters in userWord
        for (int j = expectedWord.length(); j < userWord.length(); j++) {
            incorrectCharCount++;
        }

        // Check if the entire word is correct
        if (expectedWord.equalsIgnoreCase(userWord)) {
            correctWordCount++;
        }
    }

    return new int[]{correctWordCount, correctCharCount, incorrectCharCount};
}

// Calculate accuracy based on correct and incorrect character counts
private double Accuracy() {
    int[] correctWordInfo = countCorrectWordsAndCharacters();
    int correctCharCount = correctWordInfo[1];
    int incorrectCharCount = correctWordInfo[2];

    int totalCorrectAndIncorrectChars = correctCharCount + incorrectCharCount;

    if (totalCorrectAndIncorrectChars > 0) {
        return (correctCharCount * 100.0) / totalCorrectAndIncorrectChars;
    } else {
        return 0; // If no characters are typed yet
    }
}
    //wpm
    private int wpm() {
    int[] correctWordInfo = countCorrectWordsAndCharacters();
    int correctCharCount = correctWordInfo[1];

    int wpm = (int) ((((double) correctCharCount / 5)/time)* 60);
    return wpm;
    }
    
    //data
    private void writeScoreToFile() {
        String username = loginname.getUname(); // Get the username
         int wpm=wpm();
         double accuracy=Accuracy();
         String formattedAccuracy = String.format("%.2f", accuracy);
        
        try{
            FileWriter fw = new FileWriter(username+".txt",true);
            fw.write(wpm+"\t"+formattedAccuracy+"\n");
            fw.close();
            JOptionPane.showMessageDialog(null, "Score saved successfully!");
        }catch(IOException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving the score!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Time remaining:");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                            .addComponent(jTextField2))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton2)
                .addGap(39, 39, 39)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        handleTextFieldEnter();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        TimedMode timedMode = new TimedMode();
        timedMode.show();//display TimedMode here
        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        generateRandomWords();
        resetGame();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        resetGame();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void resetGame() {
    // Reset game-related variables
    isGameEnded = false;
    timerStarted = false;
    second = time;
    jLabel2.setText(Integer.toString(second));
    jTextField2.setText("");
    jTextField2.setEditable(true);

    // Reset word status
    wordStatus.replaceAll(status -> false);

    // Reset highlights
    jTextField2.getHighlighter().removeAllHighlights();
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimedModeGame(false).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
