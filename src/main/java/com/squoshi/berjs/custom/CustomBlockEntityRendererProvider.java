package com.squoshi.berjs.custom;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;

public class CustomBlockEntityRendererProvider<T extends BlockEntity> implements BlockEntityRendererProvider<T> {
    private final CustomBlockEntityRenderer<T> renderer;

    public CustomBlockEntityRendererProvider(CustomBlockEntityRenderer<T> renderer) {
        super();
        this.renderer = renderer;
    }

    @Override
    public BlockEntityRenderer<T> create(BlockEntityRendererProvider.Context context) {
        return renderer;
    }
}