package forms;


import components.SimpleForm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DashboardForm extends SimpleForm {

    private JButton newEntryButton;
    private JPanel entryPanel;

    public DashboardForm() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout for buttonPanel
        entryPanel = new JPanel(); // Use default FlowLayout for entryPanel

        newEntryButton = new JButton("New Entry");
        newEntryButton.addActionListener((ActionEvent e) -> {
            String caption = JOptionPane.showInputDialog("Enter caption:");
            if (caption != null && !caption.isEmpty()) {
                addNewEntryButton(caption);
            }
        });

        buttonPanel.add(newEntryButton);
        add(buttonPanel, BorderLayout.NORTH); // Add buttonPanel to the top of the form

        // Create a JScrollPane and add the entryPanel to it
        JScrollPane scrollPane = new JScrollPane(entryPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add the scrollPane to the center of the form
        add(scrollPane, BorderLayout.CENTER);

        // Set the preferred size for entryPanel
        entryPanel.setPreferredSize(new Dimension(800, 400));
    }

    private void addNewEntryButton(String caption) {
    JButton newButton = new JButton(caption);
    newButton.setPreferredSize(new Dimension(200, 100)); // Set preferred size for new buttons
    entryPanel.add(newButton);
    
    // Update the preferred size of entryPanel
    //entryPanel.setPreferredSize(new Dimension(entryPanel.getWidth(), entryPanel.getHeight() + 100)); // Increase height by button height
    
    // Refresh layout of entryPanel to reflect the changes
    entryPanel.revalidate();
    entryPanel.repaint();
    }
}