package com.squoshi.berjs.util;

import com.squoshi.berjs.BERJS;
import dev.latvian.mods.rhino.util.RemapForJS;

import java.util.function.Consumer;

public interface BlockEntityInfoBERJS {
    Consumer<BERJS.BlockEntityRendererContext> renderContext();

    @RemapForJS("addRenderer")
    void blockEntityRendererJS$addRenderer(Consumer<BERJS.BlockEntityRendererContext> context);
}
