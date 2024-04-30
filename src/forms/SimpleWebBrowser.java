/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package forms;

import components.SimpleForm;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

public class SimpleWebBrowser extends SimpleForm {

    private final JEditorPane editorPane;

    public SimpleWebBrowser() {
        editorPane = new JEditorPane();
        editorPane.setEditable(false); // Make the editor pane non-editable

        JScrollPane scrollPane = new JScrollPane(editorPane);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        try {
            // Load an initial web page, such as Google's home page
            editorPane.setPage("https://www.google.com");
        } catch (IOException e) {
            System.err.println("Error loading web page: " + e.getMessage());
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 838, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}