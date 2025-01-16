package com.squoshi.berjs.custom;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;

public record CustomBlockEntityRendererProvider<T extends BlockEntity>(CustomBlockEntityRenderer renderer) implements BlockEntityRendererProvider<T> {
    @Override
    public BlockEntityRenderer<T> create(Context context) {
        return renderer;
    }
}