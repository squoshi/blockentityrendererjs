package com.squoshi.berjs;

import com.mojang.math.Axis;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemDisplayContext;

public class BERJSPlugin extends KubeJSPlugin {
    @Override
    public void registerBindings(BindingsEvent event) {
        if (!event.getType().isServer()) {
            event.add("RotationAxis", Axis.class);
            event.add("ItemDisplayContext", ItemDisplayContext.class);
            event.add("RenderType", RenderType.class);
        }
    }
}
