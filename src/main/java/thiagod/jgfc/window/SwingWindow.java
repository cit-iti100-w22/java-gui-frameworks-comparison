package thiagod.jgfc.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import thiagod.jgfc.utils.FavoriteFruits;

public class SwingWindow extends JFrame {

    private static final long serialVersionUID = 6963322753462708702L;

    public SwingWindow() {

        setTitle("Java Swing Window");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        add(createWestComponents(), BorderLayout.CENTER);
        setJMenuBar(createMenuBar());

        setVisible(true);

        setMinimumSize(new Dimension(300, 600));

        pack();
    }

    private JPanel createWestComponents() {

        JPanel panel = new JPanel(new GridBagLayout());

        int yIndex = 0;

        panel.add(new JLabel("First Name:"), getConstraints(0, yIndex++, 2, 1));
        panel.add(new JTextField(10), getConstraints(0, yIndex++, 2, 1));
        panel.add(new JLabel("Last Name:"), getConstraints(0, yIndex++, 2, 1));
        panel.add(new JTextField(10), getConstraints(0, yIndex++, 2, 1));

        panel.add(new JLabel("Position:"), getConstraints(0, yIndex++, 2, 1));
        panel.add(createRadioButton("Manager", "Staff"), getConstraints(0, yIndex++, 2, 1));

        panel.add(new JLabel("Favorite Fruit:"), getConstraints(0, yIndex++, 2, 1));
        panel.add(createDropdownMenu(), getConstraints(0, yIndex++, 2, 1));

        panel.add(new JLabel("Comments:"), getConstraints(0, yIndex++, 2, 1));
        panel.add(creteTextArea(), getConstraints(0, yIndex++, 2, 1));

        panel.add(new JCheckBox("I Agree to Terms and Conditions"), getConstraints(0, yIndex++, 2, 1));

        panel.add(new JButton("Save"), getConstraints(0, yIndex, 1, 1));
        panel.add(new JButton("Cancel"), getConstraints(1, yIndex, 1, 1));

        return panel;
    }

    private JScrollPane creteTextArea() {

        JTextArea ta = new JTextArea(10, 10);

        JScrollPane scroll = new JScrollPane(ta);

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        return scroll;
    }

    private JPanel createRadioButton(String... options) {

        List<JRadioButton> buttons = new ArrayList<>();

        for (String option : options) {
            buttons.add(new JRadioButton(option));
        }

        JPanel panel = new JPanel();
        ButtonGroup group = new ButtonGroup();

        for (int i = 0; i < buttons.size(); i++) {
            group.add(buttons.get(i));
            panel.add(buttons.get(i));
        }

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

    private JMenuBar createMenuBar() {

        JMenuBar mb = new JMenuBar();

        mb.add(createFileMenu());
        mb.add(createEditMenu());
        mb.add(createHelpMenu());

        return mb;
    }

    private JMenu createFileMenu() {

        JMenu menu = new JMenu("File");

        menu.add(new JMenuItem("Open"));
        menu.addSeparator();
        menu.add(new JMenuItem("Quit"));

        return menu;
    }

    private JMenu createEditMenu() {

        JMenu menu = new JMenu("Edit");

        menu.add(new JMenuItem("Copy"));
        menu.add(new JMenuItem("Paste"));

        return menu;
    }

    private JMenu createHelpMenu() {

        JMenu menu = new JMenu("Help");

        menu.add(new JMenuItem("About"));

        return menu;
    }

    private JComboBox<String> createDropdownMenu() {

        JComboBox<String> drop = new JComboBox<>();

        for (String fruit : FavoriteFruits.getFavoriteFruits()) {
            drop.addItem(fruit);
        }

        drop.setSelectedItem(FavoriteFruits.getDefaultFavoriteFruit());

        return drop;
    }

}
