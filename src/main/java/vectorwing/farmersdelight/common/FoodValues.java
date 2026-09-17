package vectorwing.farmersdelight.common;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class FoodValues
{
	public static final int BRIEF_DURATION = 600;    // 30 seconds
	public static final int SHORT_DURATION = 1200;    // 1 minute
	public static final int MEDIUM_DURATION = 3600;    // 3 minutes
	public static final int LONG_DURATION = 6000;    // 5 minutes

	/**
	 * Seconds taken to eat a food marked as fast, matching what FoodProperties.Builder#fast used
	 * to set before eating behaviour moved into the Consumable component in 1.21.2.
	 */
	public static final float FAST_EAT_SECONDS = 0.8F;

	public static MobEffectInstance nourishment(int duration) {
		return new MobEffectInstance(ModEffects.NOURISHMENT, duration, 0, false, false);
	}

	/**
	 * As of 1.21.2, a food item's nutrition data (FoodProperties) and its consumption behaviour
	 * -- how long it takes to eat and which effects it grants -- live in two separate item
	 * components. This pairs them so each food can still be declared in one place.
	 */
	public record FoodValue(FoodProperties food, Consumable consumable)
	{
	}

	/**
	 * Mirrors the pre-1.21.2 FoodProperties.Builder API, splitting what it receives across the
	 * FoodProperties and Consumable components.
	 */
	public static class Builder
	{
		private final FoodProperties.Builder food = new FoodProperties.Builder();
		private final Consumable.Builder consumable = Consumables.defaultFood();

		public Builder nutrition(int nutrition) {
			this.food.nutrition(nutrition);
			return this;
		}

		public Builder saturationModifier(float saturationModifier) {
			this.food.saturationModifier(saturationModifier);
			return this;
		}

		public Builder alwaysEdible() {
			this.food.alwaysEdible();
			return this;
		}

		public Builder fast() {
			this.consumable.consumeSeconds(FAST_EAT_SECONDS);
			return this;
		}

		public Builder consumeSeconds(float seconds) {
			this.consumable.consumeSeconds(seconds);
			return this;
		}

		public Builder effect(Supplier<MobEffectInstance> effect, float probability) {
			this.consumable.onConsume(new ApplyStatusEffectsConsumeEffect(effect.get(), probability));
			return this;
		}

		public FoodValue build() {
			return new FoodValue(this.food.build(), this.consumable.build());
		}
	}

	// Raw Crops
	public static final FoodValue CABBAGE = (new Builder())
			.nutrition(2).saturationModifier(0.4f).build();
	public static final FoodValue TOMATO = (new Builder())
			.nutrition(1).saturationModifier(0.3f).build();
	public static final FoodValue ONION = (new Builder())
			.nutrition(2).saturationModifier(0.4f).build();

	// Drinks (mostly for effects)
	public static final FoodValue APPLE_CIDER = (new Builder())
			.alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0F).build();

	// Basic Foods
	public static final FoodValue FRIED_EGG = (new Builder())
			.nutrition(4).saturationModifier(0.4f).build();
	public static final FoodValue TOMATO_SAUCE = (new Builder())
			.nutrition(4).saturationModifier(0.4f).build();
	public static final FoodValue WHEAT_DOUGH = (new Builder())
			.nutrition(2).saturationModifier(0.3f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build();
	public static final FoodValue RAW_PASTA = (new Builder())
			.nutrition(2).saturationModifier(0.3F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build();
	public static final FoodValue PIE_CRUST = (new Builder())
			.nutrition(2).saturationModifier(0.2f).build();
	public static final FoodValue PUMPKIN_SLICE = (new Builder())
			.nutrition(3).saturationModifier(0.3f).build();
	public static final FoodValue CABBAGE_LEAF = (new Builder())
			.nutrition(1).saturationModifier(0.4f).fast().build();
	public static final FoodValue MINCED_BEEF = (new Builder())
			.nutrition(2).saturationModifier(0.3f).fast().build();
	public static final FoodValue BEEF_PATTY = (new Builder())
			.nutrition(4).saturationModifier(0.8f).fast().build();
	public static final FoodValue CHICKEN_CUTS = (new Builder())
			.nutrition(1).saturationModifier(0.3f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).fast().build();
	public static final FoodValue COOKED_CHICKEN_CUTS = (new Builder())
			.nutrition(3).saturationModifier(0.6f).fast().build();
	public static final FoodValue BACON = (new Builder())
			.nutrition(2).saturationModifier(0.3f).fast().build();
	public static final FoodValue COOKED_BACON = (new Builder())
			.nutrition(4).saturationModifier(0.8f).fast().build();
	public static final FoodValue COD_SLICE = (new Builder())
			.nutrition(1).saturationModifier(0.1f).fast().build();
	public static final FoodValue COOKED_COD_SLICE = (new Builder())
			.nutrition(3).saturationModifier(0.5f).fast().build();
	public static final FoodValue SALMON_SLICE = (new Builder())
			.nutrition(1).saturationModifier(0.1f).fast().build();
	public static final FoodValue COOKED_SALMON_SLICE = (new Builder())
			.nutrition(3).saturationModifier(0.8f).fast().build();
	public static final FoodValue MUTTON_CHOPS = (new Builder())
			.nutrition(1).saturationModifier(0.3f).fast().build();
	public static final FoodValue COOKED_MUTTON_CHOPS = (new Builder())
			.nutrition(3).saturationModifier(0.8f).fast().build();
	public static final FoodValue HAM = (new Builder())
			.nutrition(5).saturationModifier(0.3f).build();
	public static final FoodValue SMOKED_HAM = (new Builder())
			.nutrition(10).saturationModifier(0.8f).build();

	// Sweets
	public static final FoodValue POPSICLE = (new Builder())
			.nutrition(3).saturationModifier(0.2f).fast().alwaysEdible().build();
	public static final FoodValue COOKIES = (new Builder())
			.nutrition(2).saturationModifier(0.1f).fast().build();
	public static final FoodValue CAKE_SLICE = (new Builder())
			.nutrition(2).saturationModifier(0.1f).fast()
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0, false, false), 1.0F).build();
	public static final FoodValue PIE_SLICE = (new Builder())
			.nutrition(3).saturationModifier(0.3f).fast()
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0, false, false), 1.0F).build();
	public static final FoodValue FRUIT_SALAD = (new Builder())
			.nutrition(6).saturationModifier(0.6f)
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F).build();
	public static final FoodValue GLOW_BERRY_CUSTARD = (new Builder())
			.nutrition(7).saturationModifier(0.6f).alwaysEdible()
			.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 100, 0), 1.0F).build();

	// Handheld Foods
	public static final FoodValue MIXED_SALAD = (new Builder())
			.nutrition(6).saturationModifier(0.6f)
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F).build();
	public static final FoodValue NETHER_SALAD = (new Builder())
			.nutrition(5).saturationModifier(0.4f)
			.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 240, 0), 0.3F).build();
	public static final FoodValue BARBECUE_STICK = (new Builder())
			.nutrition(8).saturationModifier(0.9f).build();
	public static final FoodValue EGG_SANDWICH = (new Builder())
			.nutrition(8).saturationModifier(0.8f).build();
	public static final FoodValue CHICKEN_SANDWICH = (new Builder())
			.nutrition(10).saturationModifier(0.8f).build();
	public static final FoodValue HAMBURGER = (new Builder())
			.nutrition(11).saturationModifier(0.8f).build();
	public static final FoodValue BACON_SANDWICH = (new Builder())
			.nutrition(10).saturationModifier(0.8f).build();
	public static final FoodValue MUTTON_WRAP = (new Builder())
			.nutrition(10).saturationModifier(0.8f).build();
	public static final FoodValue DUMPLINGS = (new Builder())
			.nutrition(8).saturationModifier(0.8f).build();
	public static final FoodValue STUFFED_POTATO = (new Builder())
			.nutrition(10).saturationModifier(0.7f).build();
	public static final FoodValue CABBAGE_ROLLS = (new Builder())
			.nutrition(5).saturationModifier(0.5f).build();
	public static final FoodValue SALMON_ROLL = (new Builder())
			.nutrition(7).saturationModifier(0.6f).build();
	public static final FoodValue COD_ROLL = (new Builder())
			.nutrition(7).saturationModifier(0.6f).build();
	public static final FoodValue KELP_ROLL = new FoodValue(
			new FoodProperties(12, 12, false), Consumables.defaultFood().consumeSeconds(2.4F).build());
	public static final FoodValue KELP_ROLL_SLICE = (new Builder())
			.nutrition(6).saturationModifier(0.5f).fast().build();

	// Bowl Foods
	public static final FoodValue COOKED_RICE = (new Builder())
			.nutrition(6).saturationModifier(0.4f)
			.effect(() -> nourishment(BRIEF_DURATION), 1.0F).build();
	public static final FoodValue BONE_BROTH = (new Builder())
			.nutrition(8).saturationModifier(0.7f)
			.effect(() -> nourishment(SHORT_DURATION), 1.0F).build();
	public static final FoodValue BEEF_STEW = (new Builder())
			.nutrition(12).saturationModifier(0.8f)
			.effect(() -> nourishment(MEDIUM_DURATION), 1.0F).build();
	public static final FoodValue VEGETABLE_SOUP = (new Builder())
			.nutrition(12).saturationModifier(0.8f)
			.effect(() -> nourishment(MEDIUM_DURATION), 1.0F).build();
	public static final FoodValue FISH_STEW = (new Builder())
			.nutrition(12).saturationModifier(0.8f)
			.effect(() -> nourishment(MEDIUM_DURATION), 1.0F).build();
	public static final FoodValue ONION_SOUP = (new Builder())
			.nutrition(12).saturationModifier(0.8f)
			.effect(() -> nourishment(MEDIUM_DURATION), 1.0F).build();
	public static final FoodValue CHICKEN_SOUP = (new Builder())
			.nutrition(12).saturationModifier(0.8f)
			.effect(() -> nourishment(MEDIUM_DURATION), 1.0F).build();
	public static final FoodValue FRIED_RICE = (new Builder())
			.nutrition(12).saturationModifier(0.8f)
			.effect(() -> nourishment(MEDIUM_DURATION), 1.0F).build();
	public static final FoodValue PUMPKIN_SOUP = (new Builder())
			.nutrition(14).saturationModifier(0.75f)
			.effect(() -> nourishment(LONG_DURATION), 1.0F).build();
	public static final FoodValue BAKED_COD_STEW = (new Builder())
			.nutrition(14).saturationModifier(0.75f)
			.effect(() -> nourishment(LONG_DURATION), 1.0F).build();
	public static final FoodValue NOODLE_SOUP = (new Builder())
			.nutrition(14).saturationModifier(0.75f)
			.effect(() -> nourishment(LONG_DURATION), 1.0F).build();

	// Plated Foods
	public static final FoodValue BACON_AND_EGGS = (new Builder())
			.nutrition(10).saturationModifier(0.6f)
			.effect(() -> nourishment(SHORT_DURATION), 1.0F).build();
	public static final FoodValue RATATOUILLE = (new Builder())
			.nutrition(10).saturationModifier(0.6f)
			.effect(() -> nourishment(SHORT_DURATION), 1.0F).build();
	public static final FoodValue STEAK_AND_POTATOES = (new Builder())
			.nutrition(12).saturationModifier(0.8f)
			.effect(() -> nourishment(MEDIUM_DURATION), 1.0F).build();
	public static final FoodValue PASTA_WITH_MEATBALLS = (new Builder())
			.nutrition(12).saturationModifier(0.8f)
			.effect(() -> nourishment(MEDIUM_DURATION), 1.0F).build();
	public static final FoodValue PASTA_WITH_MUTTON_CHOP = (new Builder())
			.nutrition(12).saturationModifier(0.8f)
			.effect(() -> nourishment(MEDIUM_DURATION), 1.0F).build();
	public static final FoodValue MUSHROOM_RICE = (new Builder())
			.nutrition(12).saturationModifier(0.8f)
			.effect(() -> nourishment(MEDIUM_DURATION), 1.0F).build();
	public static final FoodValue ROASTED_MUTTON_CHOPS = (new Builder())
			.nutrition(14).saturationModifier(0.75f)
			.effect(() -> nourishment(LONG_DURATION), 1.0F).build();
	public static final FoodValue VEGETABLE_NOODLES = (new Builder())
			.nutrition(14).saturationModifier(0.75f)
			.effect(() -> nourishment(LONG_DURATION), 1.0F).build();
	public static final FoodValue SQUID_INK_PASTA = (new Builder())
			.nutrition(14).saturationModifier(0.75f)
			.effect(() -> nourishment(LONG_DURATION), 1.0F).build();
	public static final FoodValue GRILLED_SALMON = (new Builder())
			.nutrition(14).saturationModifier(0.75f)
			.effect(() -> nourishment(MEDIUM_DURATION), 1.0F).build();

	// Feast Portions
	public static final FoodValue ROAST_CHICKEN = (new Builder())
			.nutrition(14).saturationModifier(0.75f)
			.effect(() -> nourishment(LONG_DURATION), 1.0F).build();
	public static final FoodValue STUFFED_PUMPKIN = (new Builder())
			.nutrition(14).saturationModifier(0.75f)
			.effect(() -> nourishment(LONG_DURATION), 1.0F).build();
	public static final FoodValue HONEY_GLAZED_HAM = (new Builder())
			.nutrition(14).saturationModifier(0.75f)
			.effect(() -> nourishment(LONG_DURATION), 1.0F).build();
	public static final FoodValue SHEPHERDS_PIE = (new Builder())
			.nutrition(14).saturationModifier(0.75f)
			.effect(() -> nourishment(LONG_DURATION), 1.0F).build();
	public static final FoodValue GLEAMING_SALAD = (new Builder())
			.nutrition(14).saturationModifier(0.75f)
			.effect(() -> nourishment(LONG_DURATION), 1.0F).build();

	public static final FoodValue DOG_FOOD = (new Builder())
			.nutrition(4).saturationModifier(0.2f).build();

	// Vanilla SoupItems
	public static final Map<Item, List<MobEffectInstance>> VANILLA_SOUP_EFFECTS = (new ImmutableMap.Builder<Item, List<MobEffectInstance>>())
			.put(Items.MUSHROOM_STEW, List.of(nourishment(MEDIUM_DURATION)))
			.put(Items.BEETROOT_SOUP, List.of(nourishment(MEDIUM_DURATION)))
			.put(Items.RABBIT_STEW, List.of(nourishment(LONG_DURATION)))
			.build();

	public static final FoodValue RABBIT_STEW_BUFF = (new Builder())
			.nutrition(14).saturationModifier(0.75f).effect(() -> nourishment(LONG_DURATION), 1.0F).build();

	/** Bowl returned after eating the buffed rabbit stew, applied as a USE_REMAINDER component. */
	public static final Item RABBIT_STEW_BUFF_REMAINDER = Items.BOWL;
}
