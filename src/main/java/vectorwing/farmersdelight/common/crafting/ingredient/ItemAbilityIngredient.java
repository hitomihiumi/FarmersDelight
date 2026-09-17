package vectorwing.farmersdelight.common.crafting.ingredient;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.crafting.ICustomIngredient;
import net.neoforged.neoforge.common.crafting.IngredientType;
import vectorwing.farmersdelight.common.registry.ModIngredientTypes;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Ingredient that checks if the given stack can perform a ItemAbility from Forge.
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ItemAbilityIngredient implements ICustomIngredient
{
	public static final MapCodec<ItemAbilityIngredient> CODEC = RecordCodecBuilder.mapCodec(inst ->
			inst.group(ItemAbility.CODEC.fieldOf("action").forGetter(ItemAbilityIngredient::getItemAbility)
			).apply(inst, ItemAbilityIngredient::new));

	protected final ItemAbility itemAbility;
	@Nullable
	protected List<Holder<Item>> matchingItems;

	public ItemAbilityIngredient(ItemAbility itemAbility) {
		this.itemAbility = itemAbility;
	}

	protected void dissolve() {
		if (this.matchingItems == null) {
			this.matchingItems = BuiltInRegistries.ITEM.listElements()
					.filter(holder -> new ItemStack(holder.value()).canPerformAction(itemAbility))
					.collect(Collectors.toList());
		}
	}

	@Override
	public boolean test(@Nullable ItemStack stack) {
		return stack != null && stack.canPerformAction(itemAbility);
	}

	@Override
	public Stream<Holder<Item>> items() {
		dissolve();
		return this.matchingItems.stream();
	}

	@Override
	public boolean isSimple() {
		return false;
	}

	public ItemAbility getItemAbility() {
		return itemAbility;
	}

	public IngredientType<?> getType() {
		return ModIngredientTypes.ITEM_ABILITY_INGREDIENT.get();
	}
}
