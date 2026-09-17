package vectorwing.farmersdelight.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.crafting.display.CookingPotRecipeDisplay;
import vectorwing.farmersdelight.common.crafting.display.CuttingBoardRecipeDisplay;

import java.util.function.Supplier;

/**
 * Recipe displays are the client-facing half of a recipe as of 1.21.5, and each kind needs a
 * registered type so it can be encoded over the network.
 */
public class ModRecipeDisplays
{
	public static final DeferredRegister<RecipeDisplay.Type<?>> RECIPE_DISPLAYS =
			DeferredRegister.create(Registries.RECIPE_DISPLAY, FarmersDelight.MODID);

	public static final Supplier<RecipeDisplay.Type<?>> COOKING = RECIPE_DISPLAYS.register("cooking", () -> CookingPotRecipeDisplay.TYPE);
	public static final Supplier<RecipeDisplay.Type<?>> CUTTING = RECIPE_DISPLAYS.register("cutting", () -> CuttingBoardRecipeDisplay.TYPE);
}
