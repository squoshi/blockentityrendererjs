package com.squoshi.berjs.util;

import com.squoshi.berjs.BERJS;
import dev.latvian.mods.rhino.util.HideFromJS;
import dev.latvian.mods.rhino.util.RemapForJS;
import net.minecraft.nbt.CompoundTag;

import java.util.function.Consumer;

public interface BlockEntityInfoBERJS {
    @HideFromJS
    Consumer<BERJS.BlockEntityRendererContext> berJS$renderContext();

    @HideFromJS
    CompoundTag berJS$getInitialLocalData();

    @RemapForJS("initialLocalData")
    void berJS$initialLocalData(CompoundTag tag);

    @RemapForJS("addRenderer")
    void berJS$addRenderer(Consumer<BERJS.BlockEntityRendererContext> context);
}
