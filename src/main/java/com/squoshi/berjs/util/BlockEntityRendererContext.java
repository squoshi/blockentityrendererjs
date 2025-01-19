package com.squoshi.berjs.util;

import net.minecraft.world.level.block.entity.BlockEntity;

@SuppressWarnings("unused")
public interface BlockEntityRendererContext {
    BlockEntity entity();
    float partialTicks();
    int light();
    int overlay();
}