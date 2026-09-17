package vectorwing.farmersdelight.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import javax.annotation.Nullable;

/**
 * Deprecated - Fuel is now defined in a NeoForge datamap: {@link NeoForgeDataMaps#FURNACE_FUELS}.
 */
@Deprecated(forRemoval = true)
public class FuelItem extends Item
{
	public final int burnTime;

	public FuelItem(Properties properties) {
		super(properties);
		this.burnTime = 100;
	}

	public FuelItem(Properties properties, int burnTime) {
		super(properties);
		this.burnTime = burnTime;
	}

	/**
	 * Burn times come from the {@link NeoForgeDataMaps#FURNACE_FUELS} data map; this value is kept
	 * only so existing references to it keep working.
	 */
	public int getBurnTime() {
		return this.burnTime;
	}
}
