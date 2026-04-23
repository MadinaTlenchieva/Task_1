package praktikum;


import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void shouldReturnAvailableBuns() {
        Database db = new Database();

        assertEquals(3, db.availableBuns().size());
        assertEquals("black bun", db.availableBuns().get(0).getName());
    }

    @Test
    public void shouldReturnAvailableIngredients() {
        Database db = new Database();

        assertEquals(6, db.availableIngredients().size());
    }

    @Test
    public void shouldContainSaucesAndFillings() {
        Database db = new Database();

        boolean hasSauce = false;
        boolean hasFilling = false;

        for (Ingredient ingredient : db.availableIngredients()) {
            if (ingredient.getType() == IngredientType.SAUCE) {
                hasSauce = true;
            }
            if (ingredient.getType() == IngredientType.FILLING) {
                hasFilling = true;
            }
        }
        assertTrue(hasSauce);
        assertTrue(hasFilling);
    }
}