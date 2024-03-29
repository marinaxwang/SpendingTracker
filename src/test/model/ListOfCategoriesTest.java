package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListOfCategoriesTest {
    private ListOfCategories loc;
    private ListOfCategories locTest;
    private Category c1;
    private Category c2;
    private Category c3;

    @BeforeEach
    void runBefore() {
        loc = new ListOfCategories("Marina's categories");
        locTest = new ListOfCategories("Test");
        c1 = new Category("Food", 100);
        c2 = new Category("Tax", 200);
        c3 = new Category("Play", 300);
    }

    @Test
    void testGetListOfCategoriesEmpty() {
        locTest = loc;
        assertEquals(locTest.getListOfCategories(), loc.getListOfCategories());
    }

    @Test
    void testGetListOfCategoriesNotEmpty() {
        locTest.addCategory(c1);
        locTest.addCategory(c2);
        loc.addCategory(c1);
        loc.addCategory(c2);
        assertEquals(locTest.getListOfCategories(), loc.getListOfCategories());
    }
}
