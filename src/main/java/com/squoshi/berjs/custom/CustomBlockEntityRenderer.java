package com.squoshi.berjs.custom;

import com.mojang.blaze3d.vertex.PoseStack;
import com.squoshi.berjs.BERJS;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.function.Consumer;

public class CustomBlockEntityRenderer<T extends BlockEntity> implements BlockEntityRenderer<T> {
    private final Consumer<BERJS.BlockEntityRendererContext> renderCallback;

    public CustomBlockEntityRenderer(Consumer<BERJS.BlockEntityRendererContext> renderCallback) {
        this.renderCallback = renderCallback;
    }

    @Override
    public void render(T t, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        renderCallback.accept(new BERJS.BlockEntityRendererContext(t, v, poseStack, multiBufferSource, i, i1));
    }
}
