package vectorwing.farmersdelight.client.renderer;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.blockentity.AbstractSignRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.Vec3;
import vectorwing.farmersdelight.common.block.state.CanvasSign;
import vectorwing.farmersdelight.common.registry.ModAtlases;

import javax.annotation.Nullable;

/**
 * Sign rendering was rewritten in 1.21.5: AbstractSignRenderer handles the text and the model,
 * and subclasses only supply the model, material, scales and placement.
 * <p>
 * Canvas signs pick their material from the block's dye colour, which getSignMaterial is not
 * given. getSignModel is called with the block state immediately before it within the same render
 * call, so the colour is captured there.
 */
public class CanvasSignRenderer extends AbstractSignRenderer
{
	public static final Vec3 TEXT_OFFSET = new Vec3(0.0D, 0.33333334F, 0.046666667F);

	private final Model standingModel;
	private final Model wallModel;

	@Nullable
	private DyeColor backgroundColor;

	public CanvasSignRenderer(BlockEntityRendererProvider.Context context) {
		super(context);
		this.standingModel = SignRenderer.createSignModel(context.getModelSet(), WoodType.SPRUCE, true);
		this.wallModel = SignRenderer.createSignModel(context.getModelSet(), WoodType.SPRUCE, false);
	}

	@Override
	protected Model getSignModel(BlockState state, WoodType woodType) {
		this.backgroundColor = state.getBlock() instanceof CanvasSign canvasSign ? canvasSign.getBackgroundColor() : null;
		return state.getBlock() instanceof StandingSignBlock ? this.standingModel : this.wallModel;
	}

	@Override
	protected Material getSignMaterial(WoodType woodType) {
		return this.getCanvasSignMaterial(this.backgroundColor);
	}

	public Material getCanvasSignMaterial(@Nullable DyeColor dyeColor) {
		return ModAtlases.getCanvasSignMaterial(dyeColor);
	}

	@Override
	protected float getSignModelRenderScale() {
		return SignRenderer.RENDER_SCALE;
	}

	@Override
	protected float getSignTextRenderScale() {
		return 1.0F;
	}

	@Override
	protected Vec3 getTextOffset() {
		return TEXT_OFFSET;
	}

	@Override
	protected void translateSign(PoseStack poseStack, float yRot, BlockState state) {
		poseStack.translate(0.5F, 0.75F * this.getSignModelRenderScale(), 0.5F);
		poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
		if (!(state.getBlock() instanceof StandingSignBlock)) {
			poseStack.translate(0.0F, -0.3125F, -0.4375F);
		}
	}
}
