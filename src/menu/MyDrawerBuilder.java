package menu;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import utilities.drawer.component.DrawerPanel;
import utilities.drawer.component.SimpleDrawerBuilder;
import utilities.drawer.component.footer.SimpleFooterData;
import utilities.drawer.component.header.SimpleHeaderData;
import utilities.drawer.component.header.SimpleHeaderStyle;
import utilities.drawer.component.menu.MenuAction;
import utilities.drawer.component.menu.MenuEvent;
import utilities.drawer.component.menu.SimpleMenuOption;
import utilities.drawer.component.menu.SimpleMenuStyle;
import utilities.drawer.component.menu.data.Item;
import utilities.drawer.component.menu.data.MenuItem;
import forms.DashboardForm;
import forms.InboxForm;
import forms.ReadForm;
import forms.SimpleWebBrowser;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import utilities.swing.AvatarIcon;

public class MyDrawerBuilder extends SimpleDrawerBuilder {

    static void setMenuItemText(int i, String main) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private final ThemesChange themesChange;

    public MyDrawerBuilder() {
        themesChange = new ThemesChange();
    }

    @Override
    public Component getFooter() {
        return themesChange;
    }

    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        AvatarIcon icon = new AvatarIcon(getClass().getResource("/resources/image/profile.png"), 60, 60, 999);
        icon.setBorder(2);
        return new SimpleHeaderData()
                .setIcon(icon)
                .setTitle("Job Application Organizer")
                .setDescription("myemail@mail.com")
                .setHeaderStyle(new SimpleHeaderStyle() {

                    @Override
                    public void styleTitle(JLabel label) {
                        label.putClientProperty(FlatClientProperties.STYLE, ""
                                + "[light]foreground:#FAFAFA");
                    }

                    @Override
                    public void styleDescription(JLabel label) {
                        label.putClientProperty(FlatClientProperties.STYLE, ""
                                + "[light]foreground:#E1E1E1");
                    }
                });
    }

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData();
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {

        MenuItem items[] = new MenuItem[]{
            new Item.Label("MAIN"),
            new Item("Dashboard"),
            new Item.Label("APP"),
            new Item("Email"),
            new Item("Calendar"),
            new Item.Label("DETAILS"),
            new Item("Job Application"),
            new Item("CV"),
            new Item("Covering Letter"),
            new Item("Interview Process"),
            new Item("Personal Notes"),
            new Item.Label("OTHER"),
            new Item("Settings"),
            new Item("Help"),
            new Item("Logout"),

        };

        SimpleMenuOption simpleMenuOption = new SimpleMenuOption() {
            @Override
            public Icon buildMenuIcon(String path, float scale) {
                FlatSVGIcon icon = new FlatSVGIcon(path, scale);
                FlatSVGIcon.ColorFilter colorFilter = new FlatSVGIcon.ColorFilter();
                colorFilter.add(Color.decode("#969696"), Color.decode("#FAFAFA"), Color.decode("#969696"));
                icon.setColorFilter(colorFilter);
                return icon;
            }
        };

        simpleMenuOption.setMenuStyle(new SimpleMenuStyle() {
            @Override
            public void styleMenuItem(JButton menu, int[] index) {
                menu.putClientProperty(FlatClientProperties.STYLE, ""
                        + "[light]foreground:#FAFAFA;"
                        + "arc:10");
            }

            @Override
            public void styleMenu(JComponent component) {
                component.putClientProperty(FlatClientProperties.STYLE, ""
                        + "background:$Drawer.background");
            }

            @Override
            public void styleLabel(JLabel label) {
                label.putClientProperty(FlatClientProperties.STYLE, ""
                        + "[light]foreground:darken(#FAFAFA,15%);"
                        + "[dark]foreground:darken($Label.foreground,30%)");
            }
        });
        simpleMenuOption.addMenuEvent(new MenuEvent() {
            @Override
            public void selected(MenuAction action, int[] index) {
                if (index.length == 1) {
                    switch (index[0]) {
                        case 0:
                            FormManager.showForm(new DashboardForm());
                            break;
                        case 1:
                            FormManager.showForm(new ReadForm());
                            break;
                        case 2:
                            FormManager.showForm(new SimpleWebBrowser());
                            break;
                        case 3:
                            FormManager.showForm(new ReadForm());
                            break;
                        default:
                            break;
                    }
                } /*else if (index.length == 2) {
                    if (index[0] == 1) {
                        if (index[1] == 0) {
                            FormManager.showForm(new ReadForm());
                        } else if (index[1] == 1) {
                            FormManager.showForm(new ReadForm());
                        }
                    }
                }*/
            }
        });

        simpleMenuOption.setMenus(items)
                .setBaseIconPath("resources/menu")
                .setIconScale(0.45f);
        return simpleMenuOption;
    }

    @Override
    public void build(DrawerPanel drawerPanel) {
        drawerPanel.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Drawer.background");
    }

    @Override
    public int getDrawerWidth() {
        return 270;
    }
}