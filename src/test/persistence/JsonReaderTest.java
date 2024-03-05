package persistence;

import model.Category;
import model.ListOfCategories;
import model.Expense;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ListOfCategories c = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyLOC() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyListOfCategories.json");
        try {
            ListOfCategories c = reader.read();
            assertEquals("Marina's categories", c.getName());
            assertEquals(0, c.numExpenses());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralLOC() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralListOfCategories.json");
        try {
            ListOfCategories c = reader.read();
            assertEquals("Marina's categories", c.getName());
            List<Category> loc = c.getCategories();
            assertEquals(2, loc.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}