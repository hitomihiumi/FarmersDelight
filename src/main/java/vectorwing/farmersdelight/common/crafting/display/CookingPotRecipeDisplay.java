package vectorwing.farmersdelight.common.crafting.display;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;

import java.util.List;

/**
 * How a cooking pot recipe is presented to clients. Recipes stopped being synchronized wholesale
 * in 1.21.5; recipe displays are what the recipe book and ghost recipes are built from now.
 */
public record CookingPotRecipeDisplay(
		List<SlotDisplay> ingredients,
		SlotDisplay result,
		SlotDisplay container,
		SlotDisplay craftingStation,
		int cookTime,
		float experience
) implements RecipeDisplay
{
	public static final MapCodec<CookingPotRecipeDisplay> MAP_CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
			SlotDisplay.CODEC.listOf().fieldOf("ingredients").forGetter(CookingPotRecipeDisplay::ingredients),
			SlotDisplay.CODEC.fieldOf("result").forGetter(CookingPotRecipeDisplay::result),
			SlotDisplay.CODEC.fieldOf("container").forGetter(CookingPotRecipeDisplay::container),
			SlotDisplay.CODEC.fieldOf("crafting_station").forGetter(CookingPotRecipeDisplay::craftingStation),
			com.mojang.serialization.Codec.INT.fieldOf("cooking_time").forGetter(CookingPotRecipeDisplay::cookTime),
			com.mojang.serialization.Codec.FLOAT.fieldOf("experience").forGetter(CookingPotRecipeDisplay::experience)
	).apply(inst, CookingPotRecipeDisplay::new));

	public static final StreamCodec<RegistryFriendlyByteBuf, CookingPotRecipeDisplay> STREAM_CODEC = StreamCodec.composite(
			SlotDisplay.STREAM_CODEC.apply(ByteBufCodecs.list()), CookingPotRecipeDisplay::ingredients,
			SlotDisplay.STREAM_CODEC, CookingPotRecipeDisplay::result,
			SlotDisplay.STREAM_CODEC, CookingPotRecipeDisplay::container,
			SlotDisplay.STREAM_CODEC, CookingPotRecipeDisplay::craftingStation,
			ByteBufCodecs.VAR_INT, CookingPotRecipeDisplay::cookTime,
			ByteBufCodecs.FLOAT, CookingPotRecipeDisplay::experience,
			CookingPotRecipeDisplay::new
	);

	public static final RecipeDisplay.Type<CookingPotRecipeDisplay> TYPE = new RecipeDisplay.Type<>(MAP_CODEC, STREAM_CODEC);

	@Override
	public RecipeDisplay.Type<CookingPotRecipeDisplay> type() {
		return TYPE;
	}

	@Override
	public boolean isEnabled(FeatureFlagSet enabledFeatures) {
		return this.ingredients.stream().allMatch(ingredient -> ingredient.isEnabled(enabledFeatures))
				&& RecipeDisplay.super.isEnabled(enabledFeatures);
	}
}
