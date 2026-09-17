package vectorwing.farmersdelight.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.Vec3;
import vectorwing.farmersdelight.common.registry.ModAtlases;

import javax.annotation.Nullable;
import java.util.EnumMap;
import java.util.Map;

public class HangingCanvasSignRenderer extends CanvasSignRenderer
{
	private static final Vec3 TEXT_OFFSET = new Vec3(0.0D, -0.32F, 0.073F);

	private final Map<HangingSignRenderer.AttachmentType, Model> models = new EnumMap<>(HangingSignRenderer.AttachmentType.class);

	public HangingCanvasSignRenderer(BlockEntityRendererProvider.Context context) {
		super(context);
		for (HangingSignRenderer.AttachmentType attachmentType : HangingSignRenderer.AttachmentType.values()) {
			this.models.put(attachmentType, HangingSignRenderer.createSignModel(context.getModelSet(), WoodType.SPRUCE, attachmentType));
		}
	}

	@Override
	protected Model getSignModel(BlockState state, WoodType woodType) {
		// Also captures the background colour for getSignMaterial.
		super.getSignModel(state, woodType);
		return this.models.get(HangingSignRenderer.AttachmentType.byBlockState(state));
	}

	@Override
	public Material getCanvasSignMaterial(@Nullable DyeColor dyeColor) {
		return ModAtlases.getHangingCanvasSignMaterial(dyeColor);
	}

	@Override
	protected float getSignModelRenderScale() {
		return HangingSignRenderer.MODEL_RENDER_SCALE;
	}

	@Override
	protected float getSignTextRenderScale() {
		return 0.9F;
	}

	@Override
	protected Vec3 getTextOffset() {
		return TEXT_OFFSET;
	}

	@Override
	protected void translateSign(PoseStack poseStack, float yRot, BlockState state) {
		HangingSignRenderer.translateBase(poseStack, yRot);
	}
}
