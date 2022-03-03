package thiagod.jgfc.utils;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFruits {

    public static String getDefaultFavoriteFruit() {
        return getFavoriteFruits().get(1);
    }

    public static List<String> getFavoriteFruits() {

        List<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");
        fruits.add("Pineapple");
        fruits.add("None of the listed");

        return fruits;
    }
}
