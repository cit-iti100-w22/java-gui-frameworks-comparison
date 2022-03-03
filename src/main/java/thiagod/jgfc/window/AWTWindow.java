package thiagod.jgfc.window;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import thiagod.jgfc.utils.FavoriteFruits;

public class AWTWindow extends Frame {

    private static final long serialVersionUID = -6974581879075380709L;

    public AWTWindow() {

        setTitle("Java AWT Window");

        setLayout(new BorderLayout());

        add(createWestComponents(), BorderLayout.CENTER);
        setMenuBar(createMenuBar());

        setVisible(true);

        setMinimumSize(new Dimension(300, 600));

        pack();

        // We need to add this event to stop the program when the window close button is
        // pressed
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private Panel createWestComponents() {

        Panel panel = new Panel(new GridBagLayout());

        int yIndex = 0;

        panel.add(new Label("First Name:"), getConstraints(0, yIndex++, 2, 1));
        panel.add(new TextField(10), getConstraints(0, yIndex++, 2, 1));
        panel.add(new Label("Last Name:"), getConstraints(0, yIndex++, 2, 1));
        panel.add(new TextField(10), getConstraints(0, yIndex++, 2, 1));

        panel.add(new Label("Position:"), getConstraints(0, yIndex++, 2, 1));
        panel.add(createRadioButton("Manager", "Staff"), getConstraints(0, yIndex++, 2, 1));
        
        panel.add(new Label("Favorite Fruit:"), getConstraints(0, yIndex++, 2, 1));
        panel.add(createDropdownMenu(), getConstraints(0, yIndex++, 2, 1));

        panel.add(new Label("Comments:"), getConstraints(0, yIndex++, 2, 1));
        panel.add(new TextArea(10, 10), getConstraints(0, yIndex++, 2, 1));

        panel.add(new Checkbox("I Agree to Terms and Conditions"), getConstraints(0, yIndex++, 2, 1));

        panel.add(new Button("Save"), getConstraints(0, yIndex, 1, 1));
        panel.add(new Button("Cancel"), getConstraints(1, yIndex, 1, 1));

        return panel;
    }

    private GridBagConstraints getConstraints(int gx, int gy, int gw, int gh) {

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = gx;
        gbc.gridy = gy;
        gbc.gridwidth = gw;
        gbc.gridheight = gh;
        gbc.insets = new Insets(0, 0, 7, 0); // top padding

        return gbc;
    }
      
    private Panel createRadioButton(String... options) {

        CheckboxGroup group = new CheckboxGroup();

        List<Checkbox> cbs = new ArrayList<>();

        for (String option : options) {
            cbs.add(new Checkbox(option, group, false));
        }

        Panel panel = new Panel();

        for (int i = 0; i < cbs.size(); i++) {
            panel.add(cbs.get(i));
        }

        return panel;
    }

    private MenuBar createMenuBar() {

        MenuBar mb = new MenuBar();

        mb.add(createFileMenu());
        mb.add(createEditMenu());
        mb.add(createHelpMenu());

        return mb;
    }

    private Menu createFileMenu() {

        Menu menu = new Menu("File");

        menu.add(new MenuItem("Open"));
        menu.addSeparator();
        menu.add(new MenuItem("Quit"));

        return menu;
    }

    private Menu createEditMenu() {

        Menu menu = new Menu("Edit");

        menu.add(new MenuItem("Copy"));
        menu.add(new MenuItem("Paste"));

        return menu;
    }

    private Menu createHelpMenu() {

        Menu menu = new Menu("Help");

        menu.add(new MenuItem("About"));

        return menu;
    }
    
    private Choice createDropdownMenu() {

        Choice drop = new Choice();
        
        for (String fruit : FavoriteFruits.getFavoriteFruits()) {
            drop.addItem(fruit);
        }

        drop.select(FavoriteFruits.getDefaultFavoriteFruit());

        return drop;
    }
}
