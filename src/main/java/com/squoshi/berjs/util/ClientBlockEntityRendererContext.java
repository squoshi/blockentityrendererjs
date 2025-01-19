package com.squoshi.berjs.util;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public record ClientBlockEntityRendererContext(BlockEntity entity, float partialTicks, PoseStack poseStack,
                                               MultiBufferSource bufferSource, int light,
                                               int overlay) implements BlockEntityRendererContext {
}