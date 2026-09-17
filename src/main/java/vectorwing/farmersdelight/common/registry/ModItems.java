package vectorwing.farmersdelight.common.registry;

import com.google.common.collect.Sets;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.*;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
@ParametersAreNonnullByDefault
public class ModItems
{
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FarmersDelight.MODID);
	public static LinkedHashSet<Supplier<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

	public static Supplier<Item> registerWithTab(final String name, final Function<Item.Properties, ? extends Item> factory, final Item.Properties properties) {
		Supplier<Item> newItem = ITEMS.registerItem(name, factory, properties);
		CREATIVE_TAB_ITEMS.add(newItem);
		return newItem;
	}

	public static Supplier<Item> registerHidden(final String name, final Function<Item.Properties, ? extends Item> factory, final Item.Properties properties) {
		return ITEMS.registerItem(name, factory, properties);
	}

	// Helper methods
	public static Item.Properties basicItem() {
		return new Item.Properties();
	}

	public static Item.Properties knifeItem(ToolMaterial material) {
		return KnifeItem.createProperties(material, new Item.Properties());
	}

	public static Item.Properties foodItem(FoodValues.FoodValue food) {
		return new Item.Properties().food(food.food(), food.consumable());
	}

	public static Item.Properties bowlFoodItem(FoodValues.FoodValue food) {
		return new Item.Properties().food(food.food(), food.consumable()).craftRemainder(Items.BOWL).stacksTo(16);
	}

	public static Item.Properties drinkItem() {
		return new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
	}

	// Blocks
	public static final Supplier<Item> STOVE = registerWithTab("stove",
			props -> new BlockItem(ModBlocks.STOVE.get(), props), basicItem());
	public static final Supplier<Item> COOKING_POT = registerWithTab("cooking_pot",
			props -> new CookingPotItem(ModBlocks.COOKING_POT.get(), props), basicItem().stacksTo(1));
	public static final Supplier<Item> SKILLET = registerWithTab("skillet",
			props -> new SkilletItem(ModBlocks.SKILLET.get(), props), basicItem().stacksTo(1).attributes(SkilletItem.createAttributes(SkilletItem.SKILLET_TIER, 5.0F, -3.1F)));
	public static final Supplier<Item> CUTTING_BOARD = registerWithTab("cutting_board",
			props -> new BlockItem(ModBlocks.CUTTING_BOARD.get(), props), basicItem());
	public static final Supplier<Item> WOODEN_BASKET = registerWithTab("wooden_basket",
			props -> new BlockItem(ModBlocks.WOODEN_BASKET.get(), props), basicItem());
	public static final Supplier<Item> BAMBOO_BASKET = registerWithTab("bamboo_basket",
			props -> new BlockItem(ModBlocks.BAMBOO_BASKET.get(), props), basicItem());

	/**
	 * Deprecated reference added for backwards compatibility. Use BAMBOO_BASKET instead.
	 */
	@Deprecated(forRemoval = true)
	public static final Supplier<Item> BASKET = BAMBOO_BASKET;

	public static final Supplier<Item> CARROT_CRATE = registerWithTab("carrot_crate",
			props -> new BlockItem(ModBlocks.CARROT_CRATE.get(), props), basicItem());
	public static final Supplier<Item> POTATO_CRATE = registerWithTab("potato_crate",
			props -> new BlockItem(ModBlocks.POTATO_CRATE.get(), props), basicItem());
	public static final Supplier<Item> BEETROOT_CRATE = registerWithTab("beetroot_crate",
			props -> new BlockItem(ModBlocks.BEETROOT_CRATE.get(), props), basicItem());
	public static final Supplier<Item> CABBAGE_CRATE = registerWithTab("cabbage_crate",
			props -> new BlockItem(ModBlocks.CABBAGE_CRATE.get(), props), basicItem());
	public static final Supplier<Item> TOMATO_CRATE = registerWithTab("tomato_crate",
			props -> new BlockItem(ModBlocks.TOMATO_CRATE.get(), props), basicItem());
	public static final Supplier<Item> ONION_CRATE = registerWithTab("onion_crate",
			props -> new BlockItem(ModBlocks.ONION_CRATE.get(), props), basicItem());
	public static final Supplier<Item> RICE_BALE = registerWithTab("rice_bale",
			props -> new BlockItem(ModBlocks.RICE_BALE.get(), props), basicItem());
	public static final Supplier<Item> RICE_BAG = registerWithTab("rice_bag",
			props -> new BlockItem(ModBlocks.RICE_BAG.get(), props), basicItem());
	public static final Supplier<Item> STRAW_BALE = registerWithTab("straw_bale",
			props -> new BlockItem(ModBlocks.STRAW_BALE.get(), props), basicItem());

	public static final Supplier<Item> SAFETY_NET = registerWithTab("safety_net",
			props -> new BlockItem(ModBlocks.SAFETY_NET.get(), props), basicItem());
	public static final Supplier<Item> OAK_CABINET = registerWithTab("oak_cabinet",
			props -> new BlockItem(ModBlocks.OAK_CABINET.get(), props), basicItem());
	public static final Supplier<Item> SPRUCE_CABINET = registerWithTab("spruce_cabinet",
			props -> new BlockItem(ModBlocks.SPRUCE_CABINET.get(), props), basicItem());
	public static final Supplier<Item> BIRCH_CABINET = registerWithTab("birch_cabinet",
			props -> new BlockItem(ModBlocks.BIRCH_CABINET.get(), props), basicItem());
	public static final Supplier<Item> JUNGLE_CABINET = registerWithTab("jungle_cabinet",
			props -> new BlockItem(ModBlocks.JUNGLE_CABINET.get(), props), basicItem());
	public static final Supplier<Item> ACACIA_CABINET = registerWithTab("acacia_cabinet",
			props -> new BlockItem(ModBlocks.ACACIA_CABINET.get(), props), basicItem());
	public static final Supplier<Item> DARK_OAK_CABINET = registerWithTab("dark_oak_cabinet",
			props -> new BlockItem(ModBlocks.DARK_OAK_CABINET.get(), props), basicItem());
	public static final Supplier<Item> MANGROVE_CABINET = registerWithTab("mangrove_cabinet",
			props -> new BlockItem(ModBlocks.MANGROVE_CABINET.get(), props), basicItem());
	public static final Supplier<Item> CHERRY_CABINET = registerWithTab("cherry_cabinet",
			props -> new BlockItem(ModBlocks.CHERRY_CABINET.get(), props), basicItem());
	public static final Supplier<Item> BAMBOO_CABINET = registerWithTab("bamboo_cabinet",
			props -> new BlockItem(ModBlocks.BAMBOO_CABINET.get(), props), basicItem());
	public static final Supplier<Item> CRIMSON_CABINET = registerWithTab("crimson_cabinet",
			props -> new BlockItem(ModBlocks.CRIMSON_CABINET.get(), props), basicItem());
	public static final Supplier<Item> WARPED_CABINET = registerWithTab("warped_cabinet",
			props -> new BlockItem(ModBlocks.WARPED_CABINET.get(), props), basicItem());
	public static final Supplier<Item> TATAMI = registerWithTab("tatami",
			props -> new BlockItem(ModBlocks.TATAMI.get(), props), basicItem());
	public static final Supplier<Item> FULL_TATAMI_MAT = registerWithTab("full_tatami_mat",
			props -> new BlockItem(ModBlocks.FULL_TATAMI_MAT.get(), props), basicItem());
	public static final Supplier<Item> HALF_TATAMI_MAT = registerWithTab("half_tatami_mat",
			props -> new BlockItem(ModBlocks.HALF_TATAMI_MAT.get(), props), basicItem());
	public static final Supplier<Item> CANVAS_RUG = registerWithTab("canvas_rug",
			props -> new BlockItem(ModBlocks.CANVAS_RUG.get(), props), basicItem());
	public static final Supplier<Item> ROPE_FENCE = registerWithTab("rope_fence",
			props -> new BlockItem(ModBlocks.ROPE_FENCE.get(), props), basicItem());
	public static final Supplier<Item> ROPE_FENCE_GATE = registerWithTab("rope_fence_gate",
			props -> new BlockItem(ModBlocks.ROPE_FENCE_GATE.get(), props), basicItem());
	public static final Supplier<Item> ORGANIC_COMPOST = registerWithTab("organic_compost",
			props -> new BlockItem(ModBlocks.ORGANIC_COMPOST.get(), props), basicItem());
	public static final Supplier<Item> RICH_SOIL = registerWithTab("rich_soil",
			props -> new BlockItem(ModBlocks.RICH_SOIL.get(), props), basicItem());
	public static final Supplier<Item> RICH_SOIL_FARMLAND = registerWithTab("rich_soil_farmland",
			props -> new BlockItem(ModBlocks.RICH_SOIL_FARMLAND.get(), props), basicItem());
	public static final Supplier<Item> ROPE = registerWithTab("rope",
			props -> new RopeItem(ModBlocks.ROPE.get(), props), basicItem());

	// Canvas Signs...
	public static final Supplier<Item> CANVAS_SIGN = registerWithTab("canvas_sign",
			props -> new SignItem(props, ModBlocks.CANVAS_SIGN.get(), ModBlocks.CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> HANGING_CANVAS_SIGN = registerWithTab("hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.HANGING_CANVAS_SIGN.get(), ModBlocks.HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> WHITE_CANVAS_SIGN = registerWithTab("white_canvas_sign",
			props -> new SignItem(props, ModBlocks.WHITE_CANVAS_SIGN.get(), ModBlocks.WHITE_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> WHITE_HANGING_CANVAS_SIGN = registerWithTab("white_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.WHITE_HANGING_CANVAS_SIGN.get(), ModBlocks.WHITE_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> LIGHT_GRAY_CANVAS_SIGN = registerWithTab("light_gray_canvas_sign",
			props -> new SignItem(props, ModBlocks.LIGHT_GRAY_CANVAS_SIGN.get(), ModBlocks.LIGHT_GRAY_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> LIGHT_GRAY_HANGING_CANVAS_SIGN = registerWithTab("light_gray_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.LIGHT_GRAY_HANGING_CANVAS_SIGN.get(), ModBlocks.LIGHT_GRAY_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> GRAY_CANVAS_SIGN = registerWithTab("gray_canvas_sign",
			props -> new SignItem(props, ModBlocks.GRAY_CANVAS_SIGN.get(), ModBlocks.GRAY_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> GRAY_HANGING_CANVAS_SIGN = registerWithTab("gray_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.GRAY_HANGING_CANVAS_SIGN.get(), ModBlocks.GRAY_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> BLACK_CANVAS_SIGN = registerWithTab("black_canvas_sign",
			props -> new SignItem(props, ModBlocks.BLACK_CANVAS_SIGN.get(), ModBlocks.BLACK_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> BLACK_HANGING_CANVAS_SIGN = registerWithTab("black_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.BLACK_HANGING_CANVAS_SIGN.get(), ModBlocks.BLACK_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> BROWN_CANVAS_SIGN = registerWithTab("brown_canvas_sign",
			props -> new SignItem(props, ModBlocks.BROWN_CANVAS_SIGN.get(), ModBlocks.BROWN_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> BROWN_HANGING_CANVAS_SIGN = registerWithTab("brown_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.BROWN_HANGING_CANVAS_SIGN.get(), ModBlocks.BROWN_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> RED_CANVAS_SIGN = registerWithTab("red_canvas_sign",
			props -> new SignItem(props, ModBlocks.RED_CANVAS_SIGN.get(), ModBlocks.RED_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> RED_HANGING_CANVAS_SIGN = registerWithTab("red_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.RED_HANGING_CANVAS_SIGN.get(), ModBlocks.RED_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> ORANGE_CANVAS_SIGN = registerWithTab("orange_canvas_sign",
			props -> new SignItem(props, ModBlocks.ORANGE_CANVAS_SIGN.get(), ModBlocks.ORANGE_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> ORANGE_HANGING_CANVAS_SIGN = registerWithTab("orange_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.ORANGE_HANGING_CANVAS_SIGN.get(), ModBlocks.ORANGE_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> YELLOW_CANVAS_SIGN = registerWithTab("yellow_canvas_sign",
			props -> new SignItem(props, ModBlocks.YELLOW_CANVAS_SIGN.get(), ModBlocks.YELLOW_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> YELLOW_HANGING_CANVAS_SIGN = registerWithTab("yellow_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.YELLOW_HANGING_CANVAS_SIGN.get(), ModBlocks.YELLOW_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> LIME_CANVAS_SIGN = registerWithTab("lime_canvas_sign",
			props -> new SignItem(props, ModBlocks.LIME_CANVAS_SIGN.get(), ModBlocks.LIME_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> LIME_HANGING_CANVAS_SIGN = registerWithTab("lime_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.LIME_HANGING_CANVAS_SIGN.get(), ModBlocks.LIME_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> GREEN_CANVAS_SIGN = registerWithTab("green_canvas_sign",
			props -> new SignItem(props, ModBlocks.GREEN_CANVAS_SIGN.get(), ModBlocks.GREEN_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> GREEN_HANGING_CANVAS_SIGN = registerWithTab("green_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.GREEN_HANGING_CANVAS_SIGN.get(), ModBlocks.GREEN_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> CYAN_CANVAS_SIGN = registerWithTab("cyan_canvas_sign",
			props -> new SignItem(props, ModBlocks.CYAN_CANVAS_SIGN.get(), ModBlocks.CYAN_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> CYAN_HANGING_CANVAS_SIGN = registerWithTab("cyan_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.CYAN_HANGING_CANVAS_SIGN.get(), ModBlocks.CYAN_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> LIGHT_BLUE_CANVAS_SIGN = registerWithTab("light_blue_canvas_sign",
			props -> new SignItem(props, ModBlocks.LIGHT_BLUE_CANVAS_SIGN.get(), ModBlocks.LIGHT_BLUE_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> LIGHT_BLUE_HANGING_CANVAS_SIGN = registerWithTab("light_blue_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.LIGHT_BLUE_HANGING_CANVAS_SIGN.get(), ModBlocks.LIGHT_BLUE_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> BLUE_CANVAS_SIGN = registerWithTab("blue_canvas_sign",
			props -> new SignItem(props, ModBlocks.BLUE_CANVAS_SIGN.get(), ModBlocks.BLUE_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> BLUE_HANGING_CANVAS_SIGN = registerWithTab("blue_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.BLUE_HANGING_CANVAS_SIGN.get(), ModBlocks.BLUE_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> PURPLE_CANVAS_SIGN = registerWithTab("purple_canvas_sign",
			props -> new SignItem(props, ModBlocks.PURPLE_CANVAS_SIGN.get(), ModBlocks.PURPLE_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> PURPLE_HANGING_CANVAS_SIGN = registerWithTab("purple_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.PURPLE_HANGING_CANVAS_SIGN.get(), ModBlocks.PURPLE_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> MAGENTA_CANVAS_SIGN = registerWithTab("magenta_canvas_sign",
			props -> new SignItem(props, ModBlocks.MAGENTA_CANVAS_SIGN.get(), ModBlocks.MAGENTA_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> MAGENTA_HANGING_CANVAS_SIGN = registerWithTab("magenta_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.MAGENTA_HANGING_CANVAS_SIGN.get(), ModBlocks.MAGENTA_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	public static final Supplier<Item> PINK_CANVAS_SIGN = registerWithTab("pink_canvas_sign",
			props -> new SignItem(props, ModBlocks.PINK_CANVAS_SIGN.get(), ModBlocks.PINK_CANVAS_WALL_SIGN.get()), basicItem());
	public static final Supplier<Item> PINK_HANGING_CANVAS_SIGN = registerWithTab("pink_hanging_canvas_sign",
			props -> new HangingSignItem(ModBlocks.PINK_HANGING_CANVAS_SIGN.get(), ModBlocks.PINK_HANGING_CANVAS_WALL_SIGN.get(), props), basicItem());

	// Tools
	public static final Supplier<Item> FLINT_KNIFE = registerWithTab("flint_knife",
			KnifeItem::new, knifeItem(ModMaterials.FLINT));
	public static final Supplier<Item> IRON_KNIFE = registerWithTab("iron_knife",
			KnifeItem::new, knifeItem(ToolMaterial.IRON));
	public static final Supplier<Item> DIAMOND_KNIFE = registerWithTab("diamond_knife",
			KnifeItem::new, knifeItem(ToolMaterial.DIAMOND));
	public static final Supplier<Item> NETHERITE_KNIFE = registerWithTab("netherite_knife",
			KnifeItem::new, knifeItem(ToolMaterial.NETHERITE).fireResistant());
	public static final Supplier<Item> GOLDEN_KNIFE = registerWithTab("golden_knife",
			KnifeItem::new, knifeItem(ToolMaterial.GOLD));

	public static final Supplier<Item> STRAW = registerWithTab("straw",
			props -> new Item(props), basicItem());
	public static final Supplier<Item> CANVAS = registerWithTab("canvas",
			props -> new Item(props), basicItem());
	public static final Supplier<Item> TREE_BARK = registerWithTab("tree_bark",
			props -> new Item(props), basicItem());

	// Wild Crops
	public static final Supplier<Item> SANDY_SHRUB = registerWithTab("sandy_shrub",
			props -> new BlockItem(ModBlocks.SANDY_SHRUB.get(), props), basicItem());
	public static final Supplier<Item> WILD_CABBAGES = registerWithTab("wild_cabbages",
			props -> new BlockItem(ModBlocks.WILD_CABBAGES.get(), props), basicItem());
	public static final Supplier<Item> WILD_ONIONS = registerWithTab("wild_onions",
			props -> new BlockItem(ModBlocks.WILD_ONIONS.get(), props), basicItem());
	public static final Supplier<Item> WILD_TOMATOES = registerWithTab("wild_tomatoes",
			props -> new BlockItem(ModBlocks.WILD_TOMATOES.get(), props), basicItem());
	public static final Supplier<Item> WILD_CARROTS = registerWithTab("wild_carrots",
			props -> new BlockItem(ModBlocks.WILD_CARROTS.get(), props), basicItem());
	public static final Supplier<Item> WILD_POTATOES = registerWithTab("wild_potatoes",
			props -> new BlockItem(ModBlocks.WILD_POTATOES.get(), props), basicItem());
	public static final Supplier<Item> WILD_BEETROOTS = registerWithTab("wild_beetroots",
			props -> new BlockItem(ModBlocks.WILD_BEETROOTS.get(), props), basicItem());
	public static final Supplier<Item> WILD_RICE = registerWithTab("wild_rice",
			props -> new DoubleHighBlockItem(ModBlocks.WILD_RICE.get(), props), basicItem());

	public static final Supplier<Item> BROWN_MUSHROOM_COLONY = registerWithTab("brown_mushroom_colony",
			props -> new MushroomColonyItem(ModBlocks.BROWN_MUSHROOM_COLONY.get(), props), basicItem());
	public static final Supplier<Item> RED_MUSHROOM_COLONY = registerWithTab("red_mushroom_colony",
			props -> new MushroomColonyItem(ModBlocks.RED_MUSHROOM_COLONY.get(), props), basicItem());

	// Basic Crops
	public static final Supplier<Item> CABBAGE = registerWithTab("cabbage",
			props -> new Item(props), foodItem(FoodValues.CABBAGE));
	public static final Supplier<Item> TOMATO = registerWithTab("tomato",
			props -> new Item(props), foodItem(FoodValues.TOMATO));
	public static final Supplier<Item> ONION = registerWithTab("onion",
			props -> new BlockItem(ModBlocks.ONION_CROP.get(), props.useItemDescriptionPrefix()), foodItem(FoodValues.ONION));
	public static final Supplier<Item> RICE_PANICLE = registerWithTab("rice_panicle",
			props -> new Item(props), basicItem());
	public static final Supplier<Item> RICE = registerWithTab("rice",
			props -> new RiceItem(ModBlocks.RICE_CROP.get(), props.useItemDescriptionPrefix()), basicItem());
	public static final Supplier<Item> CABBAGE_SEEDS = registerWithTab("cabbage_seeds",
			props -> new BlockItem(ModBlocks.CABBAGE_CROP.get(), props.useItemDescriptionPrefix()), basicItem());
	public static final Supplier<Item> TOMATO_SEEDS = registerWithTab("tomato_seeds",
			props -> new BlockItem(ModBlocks.BUDDING_TOMATO_CROP.get(), props.useItemDescriptionPrefix()), basicItem());
	public static final Supplier<Item> ROTTEN_TOMATO = registerWithTab("rotten_tomato",
			props -> new RottenTomatoItem(props), new Item.Properties().stacksTo(16));

	// Foodstuffs
	public static final Supplier<Item> FRIED_EGG = registerWithTab("fried_egg",
			props -> new Item(props), foodItem(FoodValues.FRIED_EGG));
	public static final Supplier<Item> MILK_BOTTLE = registerWithTab("milk_bottle",
			props -> new MilkBottleItem(props), drinkItem());
	public static final Supplier<Item> HOT_COCOA = registerWithTab("hot_cocoa",
			props -> new HotCocoaItem(props), drinkItem());
	public static final Supplier<Item> APPLE_CIDER = registerWithTab("apple_cider",
			props -> new DrinkableItem(props, true, false), drinkItem().food(FoodValues.APPLE_CIDER.food(), FoodValues.APPLE_CIDER.consumable()));
	public static final Supplier<Item> MELON_JUICE = registerWithTab("melon_juice",
			props -> new MelonJuiceItem(props), drinkItem());
	public static final Supplier<Item> TOMATO_SAUCE = registerWithTab("tomato_sauce",
			props -> new ConsumableItem(props), foodItem(FoodValues.TOMATO_SAUCE).craftRemainder(Items.BOWL));
	public static final Supplier<Item> WHEAT_DOUGH = registerWithTab("wheat_dough",
			props -> new Item(props), foodItem(FoodValues.WHEAT_DOUGH));
	public static final Supplier<Item> RAW_PASTA = registerWithTab("raw_pasta",
			props -> new Item(props), foodItem(FoodValues.RAW_PASTA));
	public static final Supplier<Item> PUMPKIN_SLICE = registerWithTab("pumpkin_slice",
			props -> new Item(props), foodItem(FoodValues.PUMPKIN_SLICE));
	public static final Supplier<Item> CABBAGE_LEAF = registerWithTab("cabbage_leaf",
			props -> new Item(props), foodItem(FoodValues.CABBAGE_LEAF));
	public static final Supplier<Item> MINCED_BEEF = registerWithTab("minced_beef",
			props -> new Item(props), foodItem(FoodValues.MINCED_BEEF));
	public static final Supplier<Item> BEEF_PATTY = registerWithTab("beef_patty",
			props -> new Item(props), foodItem(FoodValues.BEEF_PATTY));
	public static final Supplier<Item> CHICKEN_CUTS = registerWithTab("chicken_cuts",
			props -> new Item(props), foodItem(FoodValues.CHICKEN_CUTS));
	public static final Supplier<Item> COOKED_CHICKEN_CUTS = registerWithTab("cooked_chicken_cuts",
			props -> new Item(props), foodItem(FoodValues.COOKED_CHICKEN_CUTS));
	public static final Supplier<Item> BACON = registerWithTab("bacon",
			props -> new Item(props), foodItem(FoodValues.BACON));
	public static final Supplier<Item> COOKED_BACON = registerWithTab("cooked_bacon",
			props -> new Item(props), foodItem(FoodValues.COOKED_BACON));
	public static final Supplier<Item> COD_SLICE = registerWithTab("cod_slice",
			props -> new Item(props), foodItem(FoodValues.COD_SLICE));
	public static final Supplier<Item> COOKED_COD_SLICE = registerWithTab("cooked_cod_slice",
			props -> new Item(props), foodItem(FoodValues.COOKED_COD_SLICE));
	public static final Supplier<Item> SALMON_SLICE = registerWithTab("salmon_slice",
			props -> new Item(props), foodItem(FoodValues.SALMON_SLICE));
	public static final Supplier<Item> COOKED_SALMON_SLICE = registerWithTab("cooked_salmon_slice",
			props -> new Item(props), foodItem(FoodValues.COOKED_SALMON_SLICE));
	public static final Supplier<Item> MUTTON_CHOPS = registerWithTab("mutton_chops",
			props -> new Item(props), foodItem(FoodValues.MUTTON_CHOPS));
	public static final Supplier<Item> COOKED_MUTTON_CHOPS = registerWithTab("cooked_mutton_chops",
			props -> new Item(props), foodItem(FoodValues.COOKED_MUTTON_CHOPS));
	public static final Supplier<Item> HAM = registerWithTab("ham",
			props -> new Item(props), foodItem(FoodValues.HAM));
	public static final Supplier<Item> SMOKED_HAM = registerWithTab("smoked_ham",
			props -> new Item(props), foodItem(FoodValues.SMOKED_HAM));
	public static final Supplier<Item> PIE_CRUST = registerWithTab("pie_crust",
			props -> new Item(props), foodItem(FoodValues.PIE_CRUST));

	// Sweets
	public static final Supplier<Item> APPLE_PIE = registerWithTab("apple_pie",
			props -> new PlaceableItem(ModBlocks.APPLE_PIE.get(), props), basicItem());
	public static final Supplier<Item> SWEET_BERRY_CHEESECAKE = registerWithTab("sweet_berry_cheesecake",
			props -> new PlaceableItem(ModBlocks.SWEET_BERRY_CHEESECAKE.get(), props), basicItem());
	public static final Supplier<Item> CHOCOLATE_PIE = registerWithTab("chocolate_pie",
			props -> new PlaceableItem(ModBlocks.CHOCOLATE_PIE.get(), props), basicItem());
	public static final Supplier<Item> CAKE_SLICE = registerWithTab("cake_slice",
			props -> new ConsumableItem(props), foodItem(FoodValues.CAKE_SLICE));
	public static final Supplier<Item> APPLE_PIE_SLICE = registerWithTab("apple_pie_slice",
			props -> new ConsumableItem(props), foodItem(FoodValues.PIE_SLICE));
	public static final Supplier<Item> SWEET_BERRY_CHEESECAKE_SLICE = registerWithTab("sweet_berry_cheesecake_slice",
			props -> new ConsumableItem(props), foodItem(FoodValues.PIE_SLICE));
	public static final Supplier<Item> CHOCOLATE_PIE_SLICE = registerWithTab("chocolate_pie_slice",
			props -> new ConsumableItem(props), foodItem(FoodValues.PIE_SLICE));
	public static final Supplier<Item> PUMPKIN_PIE_SLICE = registerWithTab("pumpkin_pie_slice",
			props -> new ConsumableItem(props), foodItem(FoodValues.PIE_SLICE));
	public static final Supplier<Item> SWEET_BERRY_COOKIE = registerWithTab("sweet_berry_cookie",
			props -> new Item(props), foodItem(FoodValues.COOKIES));
	public static final Supplier<Item> HONEY_COOKIE = registerWithTab("honey_cookie",
			props -> new Item(props), foodItem(FoodValues.COOKIES));
	public static final Supplier<Item> MELON_POPSICLE = registerWithTab("melon_popsicle",
			props -> new PopsicleItem(props), foodItem(FoodValues.POPSICLE));
	public static final Supplier<Item> GLOW_BERRY_CUSTARD = registerWithTab("glow_berry_custard",
			props -> new ConsumableItem(props), foodItem(FoodValues.GLOW_BERRY_CUSTARD).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16));
	public static final Supplier<Item> FRUIT_SALAD = registerWithTab("fruit_salad",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.FRUIT_SALAD));

	// Basic Meals
	public static final Supplier<Item> MIXED_SALAD = registerWithTab("mixed_salad",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.MIXED_SALAD));
	public static final Supplier<Item> NETHER_SALAD = registerWithTab("nether_salad",
			props -> new ConsumableItem(props, false), bowlFoodItem(FoodValues.NETHER_SALAD));
	public static final Supplier<Item> BARBECUE_STICK = registerWithTab("barbecue_stick",
			props -> new Item(props), foodItem(FoodValues.BARBECUE_STICK));
	public static final Supplier<Item> EGG_SANDWICH = registerWithTab("egg_sandwich",
			props -> new Item(props), foodItem(FoodValues.EGG_SANDWICH));
	public static final Supplier<Item> CHICKEN_SANDWICH = registerWithTab("chicken_sandwich",
			props -> new Item(props), foodItem(FoodValues.CHICKEN_SANDWICH));
	public static final Supplier<Item> HAMBURGER = registerWithTab("hamburger",
			props -> new Item(props), foodItem(FoodValues.HAMBURGER));
	public static final Supplier<Item> BACON_SANDWICH = registerWithTab("bacon_sandwich",
			props -> new Item(props), foodItem(FoodValues.BACON_SANDWICH));
	public static final Supplier<Item> MUTTON_WRAP = registerWithTab("mutton_wrap",
			props -> new Item(props), foodItem(FoodValues.MUTTON_WRAP));
	public static final Supplier<Item> DUMPLINGS = registerWithTab("dumplings",
			props -> new Item(props), foodItem(FoodValues.DUMPLINGS));
	public static final Supplier<Item> STUFFED_POTATO = registerWithTab("stuffed_potato",
			props -> new Item(props), foodItem(FoodValues.STUFFED_POTATO));
	public static final Supplier<Item> CABBAGE_ROLLS = registerWithTab("cabbage_rolls",
			props -> new Item(props), foodItem(FoodValues.CABBAGE_ROLLS));
	public static final Supplier<Item> SALMON_ROLL = registerWithTab("salmon_roll",
			props -> new Item(props), foodItem(FoodValues.SALMON_ROLL));
	public static final Supplier<Item> COD_ROLL = registerWithTab("cod_roll",
			props -> new Item(props), foodItem(FoodValues.COD_ROLL));
	public static final Supplier<Item> KELP_ROLL = registerWithTab("kelp_roll",
			props -> new Item(props), foodItem(FoodValues.KELP_ROLL));
	public static final Supplier<Item> KELP_ROLL_SLICE = registerWithTab("kelp_roll_slice",
			props -> new Item(props), foodItem(FoodValues.KELP_ROLL_SLICE));

	// Soups and Stews
	public static final Supplier<Item> COOKED_RICE = registerWithTab("cooked_rice",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.COOKED_RICE));
	public static final Supplier<Item> BONE_BROTH = registerWithTab("bone_broth",
			props -> new DrinkableItem(props), bowlFoodItem(FoodValues.BONE_BROTH));
	public static final Supplier<Item> BEEF_STEW = registerWithTab("beef_stew",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.BEEF_STEW));
	public static final Supplier<Item> CHICKEN_SOUP = registerWithTab("chicken_soup",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.CHICKEN_SOUP));
	public static final Supplier<Item> VEGETABLE_SOUP = registerWithTab("vegetable_soup",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.VEGETABLE_SOUP));
	public static final Supplier<Item> FISH_STEW = registerWithTab("fish_stew",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.FISH_STEW));
	public static final Supplier<Item> FRIED_RICE = registerWithTab("fried_rice",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.FRIED_RICE));
	public static final Supplier<Item> PUMPKIN_SOUP = registerWithTab("pumpkin_soup",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.PUMPKIN_SOUP));
	public static final Supplier<Item> BAKED_COD_STEW = registerWithTab("baked_cod_stew",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.BAKED_COD_STEW));
	public static final Supplier<Item> NOODLE_SOUP = registerWithTab("noodle_soup",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.NOODLE_SOUP));
	public static final Supplier<Item> ONION_SOUP = registerWithTab("onion_soup",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.ONION_SOUP));

	// Plated Meals
	public static final Supplier<Item> BACON_AND_EGGS = registerWithTab("bacon_and_eggs",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.BACON_AND_EGGS));
	public static final Supplier<Item> PASTA_WITH_MEATBALLS = registerWithTab("pasta_with_meatballs",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.PASTA_WITH_MEATBALLS));
	public static final Supplier<Item> PASTA_WITH_MUTTON_CHOP = registerWithTab("pasta_with_mutton_chop",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.PASTA_WITH_MUTTON_CHOP));
	public static final Supplier<Item> MUSHROOM_RICE = registerWithTab("mushroom_rice",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.MUSHROOM_RICE));
	public static final Supplier<Item> ROASTED_MUTTON_CHOPS = registerWithTab("roasted_mutton_chops",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.ROASTED_MUTTON_CHOPS));
	public static final Supplier<Item> VEGETABLE_NOODLES = registerWithTab("vegetable_noodles",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.VEGETABLE_NOODLES));
	public static final Supplier<Item> STEAK_AND_POTATOES = registerWithTab("steak_and_potatoes",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.STEAK_AND_POTATOES));
	public static final Supplier<Item> RATATOUILLE = registerWithTab("ratatouille",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.RATATOUILLE));
	public static final Supplier<Item> SQUID_INK_PASTA = registerWithTab("squid_ink_pasta",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.SQUID_INK_PASTA));
	public static final Supplier<Item> GRILLED_SALMON = registerWithTab("grilled_salmon",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.GRILLED_SALMON));

	// Feasts
	public static final Supplier<Item> ROAST_CHICKEN_BLOCK = registerWithTab("roast_chicken_block",
			props -> new PlaceableItem(ModBlocks.ROAST_CHICKEN_BLOCK.get(), props), basicItem().stacksTo(1));
	public static final Supplier<Item> ROAST_CHICKEN = registerWithTab("roast_chicken",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.ROAST_CHICKEN));

	public static final Supplier<Item> STUFFED_PUMPKIN_BLOCK = registerWithTab("stuffed_pumpkin_block",
			props -> new PlaceableItem(ModBlocks.STUFFED_PUMPKIN_BLOCK.get(), props), basicItem().stacksTo(1));
	public static final Supplier<Item> STUFFED_PUMPKIN = registerWithTab("stuffed_pumpkin",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.STUFFED_PUMPKIN));

	public static final Supplier<Item> HONEY_GLAZED_HAM_BLOCK = registerWithTab("honey_glazed_ham_block",
			props -> new PlaceableItem(ModBlocks.HONEY_GLAZED_HAM_BLOCK.get(), props), basicItem().stacksTo(1));
	public static final Supplier<Item> HONEY_GLAZED_HAM = registerWithTab("honey_glazed_ham",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.HONEY_GLAZED_HAM));

	public static final Supplier<Item> SHEPHERDS_PIE_BLOCK = registerWithTab("shepherds_pie_block",
			props -> new PlaceableItem(ModBlocks.SHEPHERDS_PIE_BLOCK.get(), props), basicItem().stacksTo(1));
	public static final Supplier<Item> SHEPHERDS_PIE = registerWithTab("shepherds_pie",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.SHEPHERDS_PIE));

	public static final Supplier<Item> GLEAMING_SALAD_BLOCK = registerWithTab("gleaming_salad_block",
			props -> new PlaceableItem(ModBlocks.GLEAMING_SALAD_BLOCK.get(), props), basicItem().stacksTo(1));
	public static final Supplier<Item> GLEAMING_SALAD = registerWithTab("gleaming_salad",
			props -> new ConsumableItem(props), bowlFoodItem(FoodValues.GLEAMING_SALAD));

	public static final Supplier<Item> RICE_ROLL_MEDLEY_BLOCK = registerWithTab("rice_roll_medley_block",
			props -> new PlaceableItem(ModBlocks.RICE_ROLL_MEDLEY_BLOCK.get(), props), basicItem().stacksTo(1));

	// Pet Foods
	public static final Supplier<Item> DOG_FOOD = registerWithTab("dog_food",
			props -> new DogFoodItem(props), bowlFoodItem(FoodValues.DOG_FOOD));
	public static final Supplier<Item> HORSE_FEED = registerWithTab("horse_feed",
			props -> new HorseFeedItem(props), basicItem().stacksTo(16));

	// Hidden (Debug) Items
	public static final Supplier<Item> DEBUG_PUMPKIN_PIE = registerHidden("debug_pumpkin_pie",
			props -> new BlockItem(ModBlocks.PUMPKIN_PIE.get(), props), basicItem());
}
