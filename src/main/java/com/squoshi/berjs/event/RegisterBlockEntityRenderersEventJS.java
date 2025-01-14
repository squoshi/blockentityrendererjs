package com.squoshi.berjs.event;

import com.squoshi.berjs.BERJS;
import com.squoshi.berjs.custom.CustomBlockEntityRenderer;
import com.squoshi.berjs.custom.CustomBlockEntityRendererProvider;
import dev.latvian.mods.kubejs.event.EventJS;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Consumer;

public class RegisterBlockEntityRenderersEventJS extends EventJS {
    public void registerBlockEntityRenderer(BlockEntityType<?> type, Consumer<BERJS.BlockEntityRendererContext> renderer) {
        CustomBlockEntityRenderer<?> ber = new CustomBlockEntityRenderer<>(renderer);
        BlockEntityRendererProvider<?> provider = new CustomBlockEntityRendererProvider<>(ber);
        BERJS.blockEntityRenderers.put(type, provider);
    }
}
