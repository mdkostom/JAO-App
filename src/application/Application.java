package application;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.UIManager;
import components.Background;
import forms.DashboardForm;
import menu.FormManager;


public class Application extends JFrame {

    public Application() {
        init();
    }

    private void init() {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set the size of the window (unzoomed view)
        setSize(UIScale.scale(new Dimension(1366, 768)));
        
        // Center the window on the screen
        setLocationRelativeTo(null);
        
        // Set the background content
        setContentPane(new Background());
        
        // Install the FormManager and show the initial form
        FormManager.install(this);
        FormManager.showForm(new DashboardForm());
    }

    public static void main(String[] args) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
        EventQueue.invokeLater(() -> new Application().setVisible(true));
    }
}
