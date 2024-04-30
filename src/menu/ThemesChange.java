package menu;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class ThemesChange extends JPanel {

    private boolean isDarkMode = false;
    boolean isEnglish = true;

    private final String[] englishText = {
        "MAIN", "Dashboard", "APP", "Email", "Calendar",
        "DETAILS", "Job Application", "CV", "Covering Letter",
        "Interview Process", "Personal Notes", "OTHER",
        "Settings", "Help", "Logout"
    };

    private final String[] estonianText = {
        "PEAMISED", "Armatuurlaud", "APP", "Meil", "Kalender",
        "ANDMED", "Tööavaldus", "CV", "Kaaskiri",
        "Intervjuu protsess", "Isiklikud märkmed", "MUU",
        "Seaded", "Abi", "Logi välja"
    };

    public ThemesChange() {
        init();
    }

    private Icon createIcon(String path) {
        FlatSVGIcon icon = new FlatSVGIcon(path, 0.7f);
        FlatSVGIcon.ColorFilter colorFilter = new FlatSVGIcon.ColorFilter();
        colorFilter.add(Color.decode("#969696"), Color.decode("#FAFAFA"), Color.decode("#969696"));
        icon.setColorFilter(colorFilter);
        return icon;
    }

    private void init() {
        putClientProperty(FlatClientProperties.STYLE, ""
                + "background:null");
        setLayout(new MigLayout("al center", "[fill,200]", "[]5[]10[]"));
        
        // Language change buttons
        JButton buttonEng = new JButton("Eng");
        JButton buttonEst = new JButton("Est");
        
        // Theme change buttons
        JPanel panel = new JPanel(new MigLayout("fill", "[fill]10[fill]", "fill"));
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:999;"
                + "background:darken($Drawer.background,5%)");
        JButton buttonLight = new JButton(createIcon("resources/icon/light.svg"));
        JButton buttonDark = new JButton(createIcon("resources/icon/dark.svg"));
        
        buttonLight.addActionListener(e -> changeMode(false));
        buttonDark.addActionListener(e -> changeMode(true));
        buttonLight.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:999;"
                + "[dark]background:null;"
                + "[light]background:$Drawer.background;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:3,5,3,5");

        buttonDark.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:999;"
                + "[dark]background:$Drawer.background;"
                + "[light]background:null;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:3,5,3,5");
        panel.add(buttonDark);
        panel.add(buttonLight);
        
        // Add Eng and Est buttons side by side
        JPanel langPanel = new JPanel(new MigLayout("fill, insets 0"));
        langPanel.add(buttonEng, "grow");
        langPanel.add(buttonEst, "grow");
        
        add(langPanel, "wrap");
        add(panel);
        
        // Set action listeners for language buttons
        buttonEng.addActionListener(e -> {
            if (!isEnglish) {
                setLanguage(englishText);
                isEnglish = true;
            }
        });

        buttonEst.addActionListener(e -> {
            if (isEnglish) {
                setLanguage(estonianText);
                isEnglish = false;
            }
        });
    }

    private void changeMode(boolean dark) {
        if (dark != isDarkMode) {
            if (dark) {
                EventQueue.invokeLater(() -> {
                    FlatAnimatedLafChange.showSnapshot();
                    FlatMacDarkLaf.setup();
                    FlatLaf.updateUI();
                    FormManager.updateTempFormUI();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                });
            } else {
                EventQueue.invokeLater(() -> {
                    FlatAnimatedLafChange.showSnapshot();
                    FlatMacLightLaf.setup();
                    FlatLaf.updateUI();
                    FormManager.updateTempFormUI();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                });
            }
            isDarkMode = dark;
        }
    }

    private void setLanguage(String[] textArray) {
        // Fetch the panel's components
        Component[] components = getComponents();
        for (Component comp : components) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                String buttonText = button.getText();
                // Iterate over the button text arrays to find a match and update the button text
                for (int i = 0; i < englishText.length; i++) {
                    if (buttonText.equals(englishText[i])) {
                        button.setText(textArray[i]);
                        break;
                    }
                }
            }
        }
    }
}