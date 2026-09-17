package vectorwing.farmersdelight.common.registry;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;
import vectorwing.farmersdelight.common.tag.ModTags;

public class ModMaterials
{
	/**
	 * Tiers were replaced by the ToolMaterial record in 1.21.5. Values match the old flint tier:
	 * stone-grade durability and speed, with a small attack bonus, repaired by flint.
	 */
	public static final ToolMaterial FLINT = new ToolMaterial(
			BlockTags.INCORRECT_FOR_WOODEN_TOOL, 131, 4.0F, 1.0F, 5, ModTags.Items.FLINT_TOOL_MATERIALS);
}
