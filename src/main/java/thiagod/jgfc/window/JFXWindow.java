package thiagod.jgfc.window;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import thiagod.jgfc.utils.FavoriteFruits;

public class JFXWindow extends GridPane {

    public JFXWindow() {

        this.setVgap(10); // vertical gap in pixels
        this.setPadding(new Insets(10, 10, 10, 10));

        int yIndex = 0;
        
        this.add(new Label("First Name"), 0, yIndex++, 1, 1);
        this.add(new TextField(), 0, yIndex++, 1, 1);

        this.add(new Label("Last Name"), 0, yIndex++, 1, 1);
        this.add(new TextField(), 0, yIndex++, 1, 1);

        this.add(new Label("Position"), 0, yIndex++, 1, 1);

        this.add(createRadioButton("Manager", "Staff"), 0, yIndex++, 1, 1);

        this.add(new Label("Favorite Fruit:"), 0, yIndex++, 1, 1);
        this.add(createDropdownMenu(), 0, yIndex++);

        this.add(new Label("Comments:"), 0, yIndex++, 1, 1);
        this.add(new TextArea(), 0, yIndex++, 1, 1);

        this.add(new CheckBox("I Agree to Terms and Conditions"), 0, yIndex++, 1, 1);

        HBox hbox2 = new HBox(new Button("Save"), new Button("Clear"));

        this.add(hbox2, 0, yIndex, 1, 1);

    }

    private HBox createRadioButton(String... options) {

        ToggleGroup radioGroup = new ToggleGroup();

        HBox hbox = new HBox();

        for (String option : options) {

            RadioButton rb = new RadioButton(option);

            rb.setPadding(new Insets(0, 10, 0, 0));
            rb.setToggleGroup(radioGroup);

            hbox.getChildren().add(rb);
        }

        return hbox;
    }

    private ComboBox<String> createDropdownMenu() {

        ComboBox<String> drop = new ComboBox<>();

        for (String fruit : FavoriteFruits.getFavoriteFruits()) {
            drop.getItems().add(fruit);
        }

        drop.setValue(FavoriteFruits.getDefaultFavoriteFruit());

        return drop;
    }

}
