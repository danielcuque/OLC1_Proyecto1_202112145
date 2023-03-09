/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.daniel.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author daniel
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    
    private File currentFile;
    private boolean isSaved = false;
    
    public MainMenu() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TextEditor = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Console = new javax.swing.JTextArea();
        MainMenuBar = new javax.swing.JMenuBar();
        FileOptions = new javax.swing.JMenu();
        NewFile = new javax.swing.JMenuItem();
        OpenFile = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        SaveAs = new javax.swing.JMenuItem();
        GenerateDFA = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 700));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        TextEditor.setColumns(20);
        TextEditor.setRows(5);
        TextEditor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextEditorKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TextEditor);

        Console.setColumns(20);
        Console.setRows(5);
        Console.setEnabled(false);
        jScrollPane2.setViewportView(Console);

        FileOptions.setText("File");

        NewFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        NewFile.setText("Nuevo Archivo");
        NewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewFileActionPerformed(evt);
            }
        });
        FileOptions.add(NewFile);

        OpenFile.setText("Abrir Archivo");
        OpenFile.setToolTipText("");
        OpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileActionPerformed(evt);
            }
        });
        FileOptions.add(OpenFile);

        Save.setText("Guardar");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        FileOptions.add(Save);

        SaveAs.setText("Guardar Como");
        SaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveAsActionPerformed(evt);
            }
        });
        FileOptions.add(SaveAs);

        GenerateDFA.setText("Generar Autómata");
        GenerateDFA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateDFAActionPerformed(evt);
            }
        });
        FileOptions.add(GenerateDFA);

        MainMenuBar.add(FileOptions);

        setJMenuBar(MainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileActionPerformed
        // TODO add your handling code here:
        String desktopPath = System.getProperty("user.home") + "/Desktop/";
        JFileChooser fileChooser = new JFileChooser(desktopPath);
        fileChooser.setFileFilter(new FileNameExtensionFilter("OLC files (*.olc)", "olc"));
        int selection = fileChooser.showOpenDialog(null);
        if (selection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            this.currentFile = file;
            
            this.setTitle("Archivo "+ file.getName());
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                
    String line;
    while ((line = br.readLine()) != null) {
        this.TextEditor.append(line + "\n");
        
    }
    br.close();
} catch (IOException e) {
    // Maneja cualquier error de lectura del archivo
}
        }
    }//GEN-LAST:event_OpenFileActionPerformed

    private void saveFile() {
    if (currentFile == null) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("OLC Files", "olc");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            if (!filePath.endsWith(".olc")) {
                selectedFile = new File(filePath + ".olc");
            }
            currentFile = selectedFile;
        } else {
            return;
        }
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))) {
        String text = this.TextEditor.getText();
        writer.write(text);
        isSaved = true;
        setTitle(currentFile.getName() + " - OLC Editor");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    private void saveAsFile(){
        JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Guardar archivo como...");
    fileChooser.setCurrentDirectory(new File("."));
    int userSelection = fileChooser.showSaveDialog(this);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        if (fileToSave.exists()) {
            int response = JOptionPane.showConfirmDialog(this, "El archivo ya existe. ¿Desea reemplazarlo?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {
                saveAsFile();
                return;
            }
        }
        try {
            FileWriter writer = new FileWriter(fileToSave);
            this.TextEditor.write(writer);
            writer.close();
            isSaved = true;
            currentFile = fileToSave;
            setTitle("Mi editor de texto - " + currentFile.getName());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    }
    
    public void newFile() {
    if (!isSaved && this.currentFile != null) {
        int option = JOptionPane.showConfirmDialog(null, "¿Desea guardar el archivo actual?", "Nuevo archivo", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            saveFile();
        } else if (option == JOptionPane.CANCEL_OPTION) {
            return;
        }
    }
    this.TextEditor.setText("");
    currentFile = null;
    isSaved = false;
    this.setTitle("Nuevo archivo");
    }
    
    private void generateDFA(){
        
    }
    
    private void NewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewFileActionPerformed
        // TODO add your handling code here:
       newFile();
    }//GEN-LAST:event_NewFileActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formKeyTyped

    private void TextEditorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextEditorKeyReleased
        // TODO add your handling code here:
        this.isSaved = false;
        if (this.currentFile != null){
            this.setTitle(this.currentFile.getName() + " (sin guardar)");
        }
    }//GEN-LAST:event_TextEditorKeyReleased

    private void SaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveAsActionPerformed
        // TODO add your handling code here:
        saveAsFile();
    }//GEN-LAST:event_SaveAsActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        saveFile();
    }//GEN-LAST:event_SaveActionPerformed

    private void GenerateDFAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateDFAActionPerformed
        // TODO add your handling code here:
        generateDFA();
    }//GEN-LAST:event_GenerateDFAActionPerformed

   
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Console;
    private javax.swing.JMenu FileOptions;
    private javax.swing.JMenuItem GenerateDFA;
    private javax.swing.JMenuBar MainMenuBar;
    private javax.swing.JMenuItem NewFile;
    private javax.swing.JMenuItem OpenFile;
    private javax.swing.JMenuItem Save;
    private javax.swing.JMenuItem SaveAs;
    private javax.swing.JTextArea TextEditor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}