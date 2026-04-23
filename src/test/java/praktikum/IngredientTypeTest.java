package praktikum;
import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void shouldContainSauce() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void shouldContainFilling() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}