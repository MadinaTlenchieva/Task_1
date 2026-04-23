package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
    }

    @Test
    public void shouldSetBun() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void shouldAddIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void shouldRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void shouldMoveIngredient() {
        Ingredient ing2 = mock(Ingredient.class);

        burger.addIngredient(ingredient);
        burger.addIngredient(ing2);

        burger.moveIngredient(0, 1);

        assertEquals(ing2, burger.ingredients.get(0));
        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void shouldCalculatePrice() {
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient.getPrice()).thenReturn(50f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float price = burger.getPrice();
        assertEquals(250f, price, 0.001);
    }

    @Test
    public void shouldGenerateReceipt() {
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100f);

        when(ingredient.getName()).thenReturn("cutlet");
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient.getPrice()).thenReturn(50f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("black bun"));
        assertTrue(receipt.contains("cutlet"));
        assertTrue(receipt.contains("Price"));
    }
}