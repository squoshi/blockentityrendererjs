package com.squoshi.berjs.event;

import com.mojang.blaze3d.vertex.PoseStack;
import com.squoshi.berjs.BERJS;
import dev.latvian.mods.kubejs.event.EventJS;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Consumer;

@SuppressWarnings("unused")
public class RegisterBlockEntityRenderersEventJS extends EventJS {
    public static void registerBlockEntityRenderer(BlockEntityType<?> type, Consumer<BlockEntityRendererContext> renderer) {
        BlockEntityRendererProvider<BlockEntity> provider = context -> (entity, partialTicks, poseStack, bufferSource, light, overlay) -> renderer.accept(new BlockEntityRendererContext(entity, partialTicks, poseStack, bufferSource, light, overlay));
        BERJS.addRenderer(type, provider);
    }

    public record BlockEntityRendererContext(BlockEntity entity, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int light, int overlay) { }
}