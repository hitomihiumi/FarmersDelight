package vectorwing.farmersdelight.common.item;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public class MilkBottleItem extends DrinkableItem
{
	public MilkBottleItem(Properties properties) {
		super(properties, false, true);
	}

	@Override
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
		// NeoForge's EffectCures registry is gone as of 1.21.8, so every active effect is
		// treated as curable, matching what milk cured by default before.
		List<Holder<MobEffect>> curableEffects = new ArrayList<>();
		for (MobEffectInstance effect : consumer.getActiveEffects()) {
			curableEffects.add(effect.getEffect());
		}

		if (!curableEffects.isEmpty()) {
			consumer.removeEffect(curableEffects.get(level.random.nextInt(curableEffects.size())));
		}
	}
}
