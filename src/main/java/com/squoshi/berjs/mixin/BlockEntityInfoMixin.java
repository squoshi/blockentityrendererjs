package com.squoshi.berjs.mixin;

import com.squoshi.berjs.util.BlockEntityRendererContext;
import com.squoshi.berjs.util.BlockEntityInfoBERJS;
import dev.latvian.mods.kubejs.block.entity.BlockEntityInfo;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.function.Consumer;

@Mixin(value = BlockEntityInfo.class, remap = false)
public class BlockEntityInfoMixin implements BlockEntityInfoBERJS {
    @Unique
    private Consumer<BlockEntityRendererContext> berJS$renderContext;
    @Unique
    public CompoundTag berJS$initialLocalData;

    @Override
    public Consumer<BlockEntityRendererContext> berJS$renderContext() {
        return berJS$renderContext;
    }

    @Override
    public CompoundTag berJS$getInitialLocalData() {
        return berJS$initialLocalData;
    }

    @Override
    public void berJS$initialLocalData(CompoundTag tag) {
        berJS$initialLocalData = tag;
    }

    @Override
    public void berJS$addRenderer(Consumer<BlockEntityRendererContext> context) {
        berJS$renderContext = context;
    }
}