package com.squoshi.berjs.mixin;

import com.squoshi.berjs.BERJS;
import com.squoshi.berjs.util.BlockEntityInfoBERJS;
import dev.latvian.mods.kubejs.block.entity.BlockEntityInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.function.Consumer;

@Mixin(BlockEntityInfo.class)
public class BlockEntityInfoMixin implements BlockEntityInfoBERJS {
    @Unique
    private Consumer<BERJS.BlockEntityRendererContext> blockEntityRendererJS$renderContext;

    @Override
    public Consumer<BERJS.BlockEntityRendererContext> renderContext() {
        return blockEntityRendererJS$renderContext;
    }

    @Override
    public void blockEntityRendererJS$addRenderer(Consumer<BERJS.BlockEntityRendererContext> context) {
        blockEntityRendererJS$renderContext = context;
    }
}
