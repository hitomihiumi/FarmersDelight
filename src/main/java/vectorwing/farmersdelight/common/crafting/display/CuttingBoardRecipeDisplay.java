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
 * How a cutting board recipe is presented to clients: the item being cut, the tool needed for it,
 * and everything the cut produces.
 */
public record CuttingBoardRecipeDisplay(
		SlotDisplay ingredient,
		SlotDisplay tool,
		List<SlotDisplay> results,
		SlotDisplay result,
		SlotDisplay craftingStation
) implements RecipeDisplay
{
	public static final MapCodec<CuttingBoardRecipeDisplay> MAP_CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
			SlotDisplay.CODEC.fieldOf("ingredient").forGetter(CuttingBoardRecipeDisplay::ingredient),
			SlotDisplay.CODEC.fieldOf("tool").forGetter(CuttingBoardRecipeDisplay::tool),
			SlotDisplay.CODEC.listOf().fieldOf("results").forGetter(CuttingBoardRecipeDisplay::results),
			SlotDisplay.CODEC.fieldOf("result").forGetter(CuttingBoardRecipeDisplay::result),
			SlotDisplay.CODEC.fieldOf("crafting_station").forGetter(CuttingBoardRecipeDisplay::craftingStation)
	).apply(inst, CuttingBoardRecipeDisplay::new));

	public static final StreamCodec<RegistryFriendlyByteBuf, CuttingBoardRecipeDisplay> STREAM_CODEC = StreamCodec.composite(
			SlotDisplay.STREAM_CODEC, CuttingBoardRecipeDisplay::ingredient,
			SlotDisplay.STREAM_CODEC, CuttingBoardRecipeDisplay::tool,
			SlotDisplay.STREAM_CODEC.apply(ByteBufCodecs.list()), CuttingBoardRecipeDisplay::results,
			SlotDisplay.STREAM_CODEC, CuttingBoardRecipeDisplay::result,
			SlotDisplay.STREAM_CODEC, CuttingBoardRecipeDisplay::craftingStation,
			CuttingBoardRecipeDisplay::new
	);

	public static final RecipeDisplay.Type<CuttingBoardRecipeDisplay> TYPE = new RecipeDisplay.Type<>(MAP_CODEC, STREAM_CODEC);

	@Override
	public RecipeDisplay.Type<CuttingBoardRecipeDisplay> type() {
		return TYPE;
	}

	@Override
	public boolean isEnabled(FeatureFlagSet enabledFeatures) {
		return this.results.stream().allMatch(res -> res.isEnabled(enabledFeatures))
				&& RecipeDisplay.super.isEnabled(enabledFeatures);
	}
}
