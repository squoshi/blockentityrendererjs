package com.squoshi.berjs.util;

import dev.latvian.mods.kubejs.block.entity.BlockEntityJS;
import dev.latvian.mods.rhino.util.RemapForJS;

public interface BlockEntityBERJS {
    @RemapForJS("getAsJS")
    BlockEntityJS berJS$getAsJS();
}
