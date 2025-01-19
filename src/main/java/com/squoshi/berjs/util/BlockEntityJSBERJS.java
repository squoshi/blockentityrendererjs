package com.squoshi.berjs.util;

import dev.latvian.mods.rhino.util.RemapForJS;
import net.minecraft.nbt.CompoundTag;

@SuppressWarnings("unused")
public interface BlockEntityJSBERJS {
    @RemapForJS("getLocalData")
    CompoundTag berJS$getLocalData();
}
