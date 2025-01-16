package com.squoshi.berjs.custom;

import com.mojang.blaze3d.vertex.PoseStack;
import com.squoshi.berjs.BERJS;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.function.Consumer;

public record CustomBlockEntityRenderer<T extends BlockEntity>(Consumer<BERJS.BlockEntityRendererContext> context) implements BlockEntityRenderer<T> {
    @Override
    public void render(T be, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        context.accept(new BERJS.BlockEntityRendererContext(be, v, poseStack, multiBufferSource, i, i1));
    }
}
