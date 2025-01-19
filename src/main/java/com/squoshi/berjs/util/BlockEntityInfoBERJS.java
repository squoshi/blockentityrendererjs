package com.squoshi.berjs.util;

import dev.latvian.mods.rhino.util.HideFromJS;
import dev.latvian.mods.rhino.util.RemapForJS;
import net.minecraft.nbt.CompoundTag;

import java.util.function.Consumer;

@SuppressWarnings("unused")
public interface BlockEntityInfoBERJS {
    @HideFromJS
    Consumer<BlockEntityRendererContext> berJS$renderContext();

    @HideFromJS
    CompoundTag berJS$getInitialLocalData();

    @RemapForJS("initialLocalData")
    void berJS$initialLocalData(CompoundTag tag);

    @RemapForJS("addRenderer")
    void berJS$addRenderer(Consumer<BlockEntityRendererContext> context);
}
