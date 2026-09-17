package vectorwing.farmersdelight.common;

import net.minecraft.client.model.HumanoidModel;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import vectorwing.farmersdelight.client.renderer.SkilletItemRenderer;

public class EnumParameters
{
	/**
	 * Recipe book categories became registry entries in 1.21.5, so only the skillet's arm pose
	 * still needs an extended enum.
	 */
	public static final EnumProxy<HumanoidModel.ArmPose> PROXY_SKILLET_FLIP = new EnumProxy<>(
			HumanoidModel.ArmPose.class, false, new SkilletItemRenderer.ArmPoseTransformer()
	);
}
