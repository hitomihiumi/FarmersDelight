package vectorwing.farmersdelight.common.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.BlockShapes;
import vectorwing.farmersdelight.common.block.*;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks
{
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FarmersDelight.MODID);

	/**
	 * Builds the default block loot table key for a block in this mod's namespace, without
	 * touching the registry. Used by wall/hanging sign variants that drop their standing counterpart.
	 */
	private static Optional<ResourceKey<LootTable>> blockLootTable(String name) {
		return Optional.of(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(FarmersDelight.MODID, "blocks/" + name)));
	}

	private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
		return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
	}

	private static ToIntFunction<BlockState> glowingFeastBlockEmission() {
		return (state) -> state.getValue(FeastBlock.SERVINGS) * 3;
	}

	private static Block.Properties feastProperties() {
		return BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).mapColor(MapColor.WOOD).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY);
	}

	// Workstations
	public static final Supplier<Block> STOVE = BLOCKS.registerBlock("stove",
			props -> new StoveBlock(props), Block.Properties.ofFullCopy(Blocks.BRICKS).lightLevel(litBlockEmission(13)));
	public static final Supplier<Block> COOKING_POT = BLOCKS.registerBlock("cooking_pot",
			props -> new CookingPotBlock(props), Block.Properties.of().mapColor(MapColor.METAL).strength(0.5F, 6.0F).sound(SoundType.LANTERN));
	public static final Supplier<Block> SKILLET = BLOCKS.registerBlock("skillet",
			props -> new SkilletBlock(props), Block.Properties.of().mapColor(MapColor.METAL).strength(0.5F, 6.0F).sound(SoundType.LANTERN));
	public static final Supplier<Block> WOODEN_BASKET = BLOCKS.registerBlock("wooden_basket",
			props -> new BasketBlock(props), Block.Properties.of().strength(1.5F).sound(SoundType.WOOD));
	public static final Supplier<Block> BAMBOO_BASKET = BLOCKS.registerBlock("bamboo_basket",
			props -> new BasketBlock(props), Block.Properties.of().strength(1.5F).sound(SoundType.BAMBOO_WOOD));
	public static final Supplier<Block> CUTTING_BOARD = BLOCKS.registerBlock("cutting_board",
			props -> new CuttingBoardBlock(props), Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F).sound(SoundType.WOOD));

	/**
	 * Deprecated reference added for backwards compatibility. Use BAMBOO_BASKET instead.
	 */
	@Deprecated(forRemoval = true)
	public static final Supplier<Block> BASKET = BAMBOO_BASKET;

	// Crop Storage
	public static final Supplier<Block> CARROT_CRATE = BLOCKS.registerBlock("carrot_crate",
			props -> new Block(props), Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
	public static final Supplier<Block> POTATO_CRATE = BLOCKS.registerBlock("potato_crate",
			props -> new Block(props), Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
	public static final Supplier<Block> BEETROOT_CRATE = BLOCKS.registerBlock("beetroot_crate",
			props -> new Block(props), Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
	public static final Supplier<Block> CABBAGE_CRATE = BLOCKS.registerBlock("cabbage_crate",
			props -> new Block(props), Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
	public static final Supplier<Block> TOMATO_CRATE = BLOCKS.registerBlock("tomato_crate",
			props -> new Block(props), Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
	public static final Supplier<Block> ONION_CRATE = BLOCKS.registerBlock("onion_crate",
			props -> new Block(props), Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
	public static final Supplier<Block> RICE_BALE = BLOCKS.registerBlock("rice_bale",
			props -> new RiceBaleBlock(props), Block.Properties.ofFullCopy(Blocks.HAY_BLOCK));
	public static final Supplier<Block> RICE_BAG = BLOCKS.registerBlock("rice_bag",
			props -> new Block(props), Block.Properties.ofFullCopy(Blocks.WHITE_WOOL));
	public static final Supplier<Block> STRAW_BALE = BLOCKS.registerBlock("straw_bale",
			props -> new StrawBaleBlock(props), Block.Properties.ofFullCopy(Blocks.HAY_BLOCK));

	// Building
	public static final Supplier<Block> ROPE = BLOCKS.registerBlock("rope",
			props -> new RopeBlock(props), Block.Properties.ofFullCopy(Blocks.BROWN_CARPET).noCollission().noOcclusion().strength(0.2F).sound(SoundType.WOOL));
	public static final Supplier<Block> SAFETY_NET = BLOCKS.registerBlock("safety_net",
			props -> new SafetyNetBlock(props), Block.Properties.ofFullCopy(Blocks.BROWN_CARPET).strength(0.2F).sound(SoundType.WOOL));
	public static final Supplier<Block> ROPE_FENCE = BLOCKS.registerBlock("rope_fence",
			props -> new RopeFenceBlock(props), Block.Properties.ofFullCopy(Blocks.OAK_FENCE).strength(1.0F));
	public static final Supplier<Block> ROPE_FENCE_GATE = BLOCKS.registerBlock("rope_fence_gate",
			props -> new RopeFenceGateBlock(props), Block.Properties.ofFullCopy(Blocks.OAK_FENCE).strength(1.0F));
	public static final Supplier<Block> OAK_CABINET = BLOCKS.registerBlock("oak_cabinet",
			props -> new CabinetBlock(props), Block.Properties.ofFullCopy(Blocks.BARREL));
	public static final Supplier<Block> SPRUCE_CABINET = BLOCKS.registerBlock("spruce_cabinet",
			props -> new CabinetBlock(props), Block.Properties.ofFullCopy(Blocks.BARREL));
	public static final Supplier<Block> BIRCH_CABINET = BLOCKS.registerBlock("birch_cabinet",
			props -> new CabinetBlock(props), Block.Properties.ofFullCopy(Blocks.BARREL));
	public static final Supplier<Block> JUNGLE_CABINET = BLOCKS.registerBlock("jungle_cabinet",
			props -> new CabinetBlock(props), Block.Properties.ofFullCopy(Blocks.BARREL));
	public static final Supplier<Block> ACACIA_CABINET = BLOCKS.registerBlock("acacia_cabinet",
			props -> new CabinetBlock(props), Block.Properties.ofFullCopy(Blocks.BARREL));
	public static final Supplier<Block> DARK_OAK_CABINET = BLOCKS.registerBlock("dark_oak_cabinet",
			props -> new CabinetBlock(props), Block.Properties.ofFullCopy(Blocks.BARREL));
	public static final Supplier<Block> MANGROVE_CABINET = BLOCKS.registerBlock("mangrove_cabinet",
			props -> new CabinetBlock(props), Block.Properties.ofFullCopy(Blocks.BARREL));
	public static final Supplier<Block> CHERRY_CABINET = BLOCKS.registerBlock("cherry_cabinet",
			props -> new CabinetBlock(props), Block.Properties.ofFullCopy(Blocks.BARREL).sound(SoundType.CHERRY_WOOD));
	public static final Supplier<Block> BAMBOO_CABINET = BLOCKS.registerBlock("bamboo_cabinet",
			props -> new CabinetBlock(props), Block.Properties.ofFullCopy(Blocks.BARREL).sound(SoundType.BAMBOO_WOOD));
	public static final Supplier<Block> CRIMSON_CABINET = BLOCKS.registerBlock("crimson_cabinet",
			props -> new CabinetBlock(props), Block.Properties.ofFullCopy(Blocks.BARREL).sound(SoundType.NETHER_WOOD));
	public static final Supplier<Block> WARPED_CABINET = BLOCKS.registerBlock("warped_cabinet",
			props -> new CabinetBlock(props), Block.Properties.ofFullCopy(Blocks.BARREL).sound(SoundType.NETHER_WOOD));
	public static final Supplier<Block> CANVAS_RUG = BLOCKS.registerBlock("canvas_rug",
			props -> new CanvasRugBlock(props), Block.Properties.ofFullCopy(Blocks.WHITE_CARPET).sound(SoundType.GRASS).strength(0.2F));
	public static final Supplier<Block> TATAMI = BLOCKS.registerBlock("tatami",
			props -> new TatamiBlock(props), Block.Properties.ofFullCopy(Blocks.WHITE_WOOL));
	public static final Supplier<Block> FULL_TATAMI_MAT = BLOCKS.registerBlock("full_tatami_mat",
			props -> new TatamiMatBlock(props), Block.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.3F));
	public static final Supplier<Block> HALF_TATAMI_MAT = BLOCKS.registerBlock("half_tatami_mat",
			props -> new TatamiHalfMatBlock(props), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.3F).pushReaction(PushReaction.DESTROY));

	public static final Supplier<Block> CANVAS_SIGN = BLOCKS.registerBlock("canvas_sign",
			props -> new StandingCanvasSignBlock(props, null), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> WHITE_CANVAS_SIGN = BLOCKS.registerBlock("white_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.WHITE), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> ORANGE_CANVAS_SIGN = BLOCKS.registerBlock("orange_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.ORANGE), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> MAGENTA_CANVAS_SIGN = BLOCKS.registerBlock("magenta_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.MAGENTA), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> LIGHT_BLUE_CANVAS_SIGN = BLOCKS.registerBlock("light_blue_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.LIGHT_BLUE), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> YELLOW_CANVAS_SIGN = BLOCKS.registerBlock("yellow_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.YELLOW), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> LIME_CANVAS_SIGN = BLOCKS.registerBlock("lime_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.LIME), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> PINK_CANVAS_SIGN = BLOCKS.registerBlock("pink_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.PINK), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> GRAY_CANVAS_SIGN = BLOCKS.registerBlock("gray_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.GRAY), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> LIGHT_GRAY_CANVAS_SIGN = BLOCKS.registerBlock("light_gray_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.LIGHT_GRAY), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> CYAN_CANVAS_SIGN = BLOCKS.registerBlock("cyan_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.CYAN), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> PURPLE_CANVAS_SIGN = BLOCKS.registerBlock("purple_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.PURPLE), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> BLUE_CANVAS_SIGN = BLOCKS.registerBlock("blue_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.BLUE), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> BROWN_CANVAS_SIGN = BLOCKS.registerBlock("brown_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.BROWN), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> GREEN_CANVAS_SIGN = BLOCKS.registerBlock("green_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.GREEN), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> RED_CANVAS_SIGN = BLOCKS.registerBlock("red_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.RED), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));
	public static final Supplier<Block> BLACK_CANVAS_SIGN = BLOCKS.registerBlock("black_canvas_sign",
			props -> new StandingCanvasSignBlock(props, DyeColor.BLACK), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN));

	public static final Supplier<Block> CANVAS_WALL_SIGN = BLOCKS.registerBlock("canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, null), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("canvas_sign")));
	public static final Supplier<Block> WHITE_CANVAS_WALL_SIGN = BLOCKS.registerBlock("white_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.WHITE), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("white_canvas_sign")));
	public static final Supplier<Block> ORANGE_CANVAS_WALL_SIGN = BLOCKS.registerBlock("orange_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.ORANGE), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("orange_canvas_sign")));
	public static final Supplier<Block> MAGENTA_CANVAS_WALL_SIGN = BLOCKS.registerBlock("magenta_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.MAGENTA), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("magenta_canvas_sign")));
	public static final Supplier<Block> LIGHT_BLUE_CANVAS_WALL_SIGN = BLOCKS.registerBlock("light_blue_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.LIGHT_BLUE), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("light_blue_canvas_sign")));
	public static final Supplier<Block> YELLOW_CANVAS_WALL_SIGN = BLOCKS.registerBlock("yellow_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.YELLOW), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("yellow_canvas_sign")));
	public static final Supplier<Block> LIME_CANVAS_WALL_SIGN = BLOCKS.registerBlock("lime_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.LIME), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("lime_canvas_sign")));
	public static final Supplier<Block> PINK_CANVAS_WALL_SIGN = BLOCKS.registerBlock("pink_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.PINK), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("pink_canvas_sign")));
	public static final Supplier<Block> GRAY_CANVAS_WALL_SIGN = BLOCKS.registerBlock("gray_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.GRAY), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("gray_canvas_sign")));
	public static final Supplier<Block> LIGHT_GRAY_CANVAS_WALL_SIGN = BLOCKS.registerBlock("light_gray_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.LIGHT_GRAY), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("light_gray_canvas_sign")));
	public static final Supplier<Block> CYAN_CANVAS_WALL_SIGN = BLOCKS.registerBlock("cyan_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.CYAN), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("cyan_canvas_sign")));
	public static final Supplier<Block> PURPLE_CANVAS_WALL_SIGN = BLOCKS.registerBlock("purple_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.PURPLE), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("purple_canvas_sign")));
	public static final Supplier<Block> BLUE_CANVAS_WALL_SIGN = BLOCKS.registerBlock("blue_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.BLUE), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("blue_canvas_sign")));
	public static final Supplier<Block> BROWN_CANVAS_WALL_SIGN = BLOCKS.registerBlock("brown_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.BROWN), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("brown_canvas_sign")));
	public static final Supplier<Block> GREEN_CANVAS_WALL_SIGN = BLOCKS.registerBlock("green_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.GREEN), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("green_canvas_sign")));
	public static final Supplier<Block> RED_CANVAS_WALL_SIGN = BLOCKS.registerBlock("red_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.RED), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("red_canvas_sign")));
	public static final Supplier<Block> BLACK_CANVAS_WALL_SIGN = BLOCKS.registerBlock("black_canvas_wall_sign",
			props -> new WallCanvasSignBlock(props, DyeColor.BLACK), Block.Properties.ofFullCopy(Blocks.SPRUCE_SIGN).overrideLootTable(blockLootTable("black_canvas_sign")));

	public static final Supplier<Block> HANGING_CANVAS_SIGN = BLOCKS.registerBlock("hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, null), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> WHITE_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("white_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.WHITE), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> ORANGE_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("orange_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.ORANGE), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> MAGENTA_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("magenta_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.MAGENTA), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> LIGHT_BLUE_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("light_blue_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.LIGHT_BLUE), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> YELLOW_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("yellow_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.YELLOW), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> LIME_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("lime_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.LIME), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> PINK_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("pink_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.PINK), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> GRAY_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("gray_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.GRAY), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> LIGHT_GRAY_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("light_gray_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.LIGHT_GRAY), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> CYAN_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("cyan_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.CYAN), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> PURPLE_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("purple_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.PURPLE), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> BLUE_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("blue_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.BLUE), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> BROWN_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("brown_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.BROWN), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> GREEN_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("green_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.GREEN), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> RED_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("red_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.RED), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));
	public static final Supplier<Block> BLACK_HANGING_CANVAS_SIGN = BLOCKS.registerBlock("black_hanging_canvas_sign",
			props -> new CeilingHangingCanvasSignBlock(props, DyeColor.BLACK), Block.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN));

	public static final Supplier<Block> HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, null), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("hanging_canvas_sign")));
	public static final Supplier<Block> WHITE_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("white_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.WHITE), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("white_hanging_canvas_sign")));
	public static final Supplier<Block> ORANGE_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("orange_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.ORANGE), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("orange_hanging_canvas_sign")));
	public static final Supplier<Block> MAGENTA_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("magenta_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.MAGENTA), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("magenta_hanging_canvas_sign")));
	public static final Supplier<Block> LIGHT_BLUE_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("light_blue_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.LIGHT_BLUE), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("light_blue_hanging_canvas_sign")));
	public static final Supplier<Block> YELLOW_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("yellow_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.YELLOW), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("yellow_hanging_canvas_sign")));
	public static final Supplier<Block> LIME_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("lime_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.LIME), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("lime_hanging_canvas_sign")));
	public static final Supplier<Block> PINK_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("pink_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.PINK), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("pink_hanging_canvas_sign")));
	public static final Supplier<Block> GRAY_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("gray_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.GRAY), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("gray_hanging_canvas_sign")));
	public static final Supplier<Block> LIGHT_GRAY_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("light_gray_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.LIGHT_GRAY), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("light_gray_hanging_canvas_sign")));
	public static final Supplier<Block> CYAN_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("cyan_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.CYAN), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("cyan_hanging_canvas_sign")));
	public static final Supplier<Block> PURPLE_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("purple_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.PURPLE), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("purple_hanging_canvas_sign")));
	public static final Supplier<Block> BLUE_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("blue_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.BLUE), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("blue_hanging_canvas_sign")));
	public static final Supplier<Block> BROWN_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("brown_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.BROWN), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("brown_hanging_canvas_sign")));
	public static final Supplier<Block> GREEN_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("green_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.GREEN), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("green_hanging_canvas_sign")));
	public static final Supplier<Block> RED_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("red_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.RED), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("red_hanging_canvas_sign")));
	public static final Supplier<Block> BLACK_HANGING_CANVAS_WALL_SIGN = BLOCKS.registerBlock("black_wall_hanging_canvas_sign",
			props -> new WallHangingCanvasSignBlock(props, DyeColor.BLACK), Block.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).overrideLootTable(blockLootTable("black_hanging_canvas_sign")));

	// Composting
	public static final Supplier<Block> BROWN_MUSHROOM_COLONY = BLOCKS.registerBlock("brown_mushroom_colony",
			props -> new MushroomColonyBlock(Items.BROWN_MUSHROOM.builtInRegistryHolder(), props), Block.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
	public static final Supplier<Block> RED_MUSHROOM_COLONY = BLOCKS.registerBlock("red_mushroom_colony",
			props -> new MushroomColonyBlock(Items.RED_MUSHROOM.builtInRegistryHolder(), props), Block.Properties.ofFullCopy(Blocks.RED_MUSHROOM));
	public static final Supplier<Block> ORGANIC_COMPOST = BLOCKS.registerBlock("organic_compost",
			props -> new OrganicCompostBlock(props), Block.Properties.ofFullCopy(Blocks.DIRT).strength(1.2F).sound(SoundType.CROP));
	public static final Supplier<Block> RICH_SOIL = BLOCKS.registerBlock("rich_soil",
			props -> new RichSoilBlock(props), Block.Properties.ofFullCopy(Blocks.DIRT).randomTicks());
	public static final Supplier<Block> RICH_SOIL_FARMLAND = BLOCKS.registerBlock("rich_soil_farmland",
			props -> new RichSoilFarmlandBlock(props), Block.Properties.ofFullCopy(Blocks.FARMLAND));

	// Pastries
	public static final Supplier<Block> APPLE_PIE = BLOCKS.registerBlock("apple_pie",
			props -> new PieBlock(props, ModItems.APPLE_PIE_SLICE), Block.Properties.ofFullCopy(Blocks.CAKE));
	public static final Supplier<Block> SWEET_BERRY_CHEESECAKE = BLOCKS.registerBlock("sweet_berry_cheesecake",
			props -> new PieBlock(props, ModItems.SWEET_BERRY_CHEESECAKE_SLICE), Block.Properties.ofFullCopy(Blocks.CAKE));
	public static final Supplier<Block> CHOCOLATE_PIE = BLOCKS.registerBlock("chocolate_pie",
			props -> new PieBlock(props, ModItems.CHOCOLATE_PIE_SLICE), Block.Properties.ofFullCopy(Blocks.CAKE));
	public static final Supplier<Block> PUMPKIN_PIE = BLOCKS.registerBlock("pumpkin_pie",
			props -> new PieBlock(props, ModItems.PUMPKIN_PIE_SLICE), Block.Properties.ofFullCopy(Blocks.CAKE));

	// Wild Crops
	public static final Supplier<Block> SANDY_SHRUB = BLOCKS.registerBlock("sandy_shrub",
			props -> new SandyShrubBlock(props), Block.Properties.ofFullCopy(Blocks.TALL_GRASS));

	public static final Supplier<Block> WILD_CABBAGES = BLOCKS.registerBlock("wild_cabbages",
			props -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, props), Block.Properties.ofFullCopy(Blocks.TALL_GRASS));
	public static final Supplier<Block> WILD_ONIONS = BLOCKS.registerBlock("wild_onions",
			props -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 6, props), Block.Properties.ofFullCopy(Blocks.TALL_GRASS));
	public static final Supplier<Block> WILD_TOMATOES = BLOCKS.registerBlock("wild_tomatoes",
			props -> new WildCropBlock(MobEffects.POISON, 10, props), Block.Properties.ofFullCopy(Blocks.TALL_GRASS));
	public static final Supplier<Block> WILD_CARROTS = BLOCKS.registerBlock("wild_carrots",
			props -> new WildCropBlock(MobEffects.DIG_SLOWDOWN, 6, props), Block.Properties.ofFullCopy(Blocks.TALL_GRASS));
	public static final Supplier<Block> WILD_POTATOES = BLOCKS.registerBlock("wild_potatoes",
			props -> new WildCropBlock(MobEffects.CONFUSION, 8, props), Block.Properties.ofFullCopy(Blocks.TALL_GRASS));
	public static final Supplier<Block> WILD_BEETROOTS = BLOCKS.registerBlock("wild_beetroots",
			props -> new WildCropBlock(MobEffects.WATER_BREATHING, 8, props), Block.Properties.ofFullCopy(Blocks.TALL_GRASS));
	public static final Supplier<Block> WILD_RICE = BLOCKS.registerBlock("wild_rice",
			props -> new WildRiceBlock(props), Block.Properties.ofFullCopy(Blocks.TALL_GRASS));

	// Crops
	public static final Supplier<Block> CABBAGE_CROP = BLOCKS.registerBlock("cabbages",
			props -> new CabbageBlock(props), Block.Properties.ofFullCopy(Blocks.WHEAT));
	public static final Supplier<Block> ONION_CROP = BLOCKS.registerBlock("onions",
			props -> new OnionBlock(props), Block.Properties.ofFullCopy(Blocks.WHEAT));
	public static final Supplier<Block> BUDDING_TOMATO_CROP = BLOCKS.registerBlock("budding_tomatoes",
			props -> new BuddingTomatoBlock(props), Block.Properties.ofFullCopy(Blocks.WHEAT));
	public static final DeferredHolder<Block, TomatoBlock> TOMATO_CROP = BLOCKS.registerBlock("tomatoes",
			props -> new TomatoBlock(props), Block.Properties.of().noCollission().randomTicks().instabreak().sound(SoundType.CROP));
	public static final DeferredHolder<Block, HangingTomatoBlock> TOMATO_CROP_ON_ROPE = BLOCKS.registerBlock("tomatoes_on_rope",
			props -> new HangingTomatoBlock(props), Block.Properties.ofFullCopy(ModBlocks.TOMATO_CROP.get()).pushReaction(PushReaction.NORMAL));
	public static final Supplier<Block> RICE_CROP = BLOCKS.registerBlock("rice",
			props -> new RiceBlock(props), Block.Properties.ofFullCopy(Blocks.WHEAT).strength(0.2F));
	public static final Supplier<Block> RICE_CROP_PANICLES = BLOCKS.registerBlock("rice_panicles",
			props -> new RicePaniclesBlock(props), Block.Properties.ofFullCopy(Blocks.WHEAT));

	// Feasts
	public static final Supplier<Block> ROAST_CHICKEN_BLOCK = BLOCKS.registerBlock("roast_chicken_block",
			props -> new RotatedFeastBlock(props, ModItems.ROAST_CHICKEN, true, BlockShapes.ROAST_CHICKEN_SHAPES, BlockShapes.TRAY_SHAPE), feastProperties());
	public static final Supplier<Block> STUFFED_PUMPKIN_BLOCK = BLOCKS.registerBlock("stuffed_pumpkin_block",
			props -> new FeastBlock(props, ModItems.STUFFED_PUMPKIN, false, true), feastProperties());
	public static final Supplier<Block> HONEY_GLAZED_HAM_BLOCK = BLOCKS.registerBlock("honey_glazed_ham_block",
			props -> new RotatedFeastBlock(props, ModItems.HONEY_GLAZED_HAM, true, BlockShapes.HONEY_GLAZED_HAM_SHAPES, BlockShapes.TRAY_SHAPE), feastProperties());
	public static final Supplier<Block> SHEPHERDS_PIE_BLOCK = BLOCKS.registerBlock("shepherds_pie_block",
			props -> new RotatedFeastBlock(props, ModItems.SHEPHERDS_PIE, true, BlockShapes.SHEPHERDS_PIE_SHAPES, BlockShapes.TRAY_SHAPE), feastProperties());
	public static final Supplier<Block> GLEAMING_SALAD_BLOCK = BLOCKS.registerBlock("gleaming_salad_block",
			props -> new GleamingSaladBlock(props, ModItems.GLEAMING_SALAD, true), feastProperties().lightLevel(glowingFeastBlockEmission()));
	public static final Supplier<Block> RICE_ROLL_MEDLEY_BLOCK = BLOCKS.registerBlock("rice_roll_medley_block",
			props -> new RiceRollMedleyBlock(props), feastProperties());
}
