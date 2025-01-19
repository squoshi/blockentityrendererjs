package com.squoshi.berjs.util;

import dev.latvian.mods.kubejs.block.entity.BlockEntityJS;
import dev.latvian.mods.rhino.util.RemapForJS;

@SuppressWarnings("unused")
public interface BlockEntityBERJS {
    @RemapForJS("getCustom")
    BlockEntityJS berJS$getCustom();
}
