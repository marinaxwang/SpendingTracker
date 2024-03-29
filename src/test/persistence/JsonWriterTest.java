package persistence;

import model.Category;
import model.Expense;
import model.ListOfCategories;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            ListOfCategories c = new ListOfCategories("Marina's categories");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyLOC() {
        try {
            ListOfCategories c = new ListOfCategories("Marina's categories");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyListOfCategories.json");
            writer.open();
            writer.write(c);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyListOfCategories.json");
            c = reader.read();
            assertEquals("Marina's categories", c.getName());
            assertEquals(0, c.numExpenses());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
/*
    @Test
    void testWriterGeneralLOC() {
        try {
            ListOfCategories c = new ListOfCategories("Marina's categories");
            c.addCategory(new Category("food", 20));
            c.addCategory(new Category("tax", 30));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralListOfCategories.json");
            writer.open();
            writer.write(c);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralListOfCategories.json");
            c = reader.read();
            assertEquals("Marina's categories", c.getName());
            List<Category> loe = c.getCategories();
            assertEquals(2, loe.size());
            checkExpenses("food", 20, loe.get(0));
            checkExpenses("tax", 30, loe.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

 */
}