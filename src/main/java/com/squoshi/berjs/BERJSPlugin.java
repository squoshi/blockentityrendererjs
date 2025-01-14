package com.squoshi.berjs;

import com.squoshi.berjs.event.RegisterBlockEntityRenderersEventJS;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.bindings.event.StartupEvents;
import dev.latvian.mods.kubejs.event.EventHandler;
import dev.latvian.mods.kubejs.script.ScriptType;
import dev.latvian.mods.rhino.util.wrap.TypeWrappers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ForgeRegistries;

public class BERJSPlugin extends KubeJSPlugin {
    public static final EventHandler registerBlockEntityRenderers = StartupEvents.GROUP.startup("registerBlockEntityRenderers", () -> RegisterBlockEntityRenderersEventJS.class);

    @Override
    public void registerTypeWrappers(ScriptType type, TypeWrappers wrappers) {
        wrappers.registerSimple(BlockEntityType.class, o -> {
            if (o instanceof BlockEntity) {
                return ((BlockEntity) o).getType();
            }
            if (o instanceof String string) {
                return ForgeRegistries.BLOCK_ENTITY_TYPES.getValue(new ResourceLocation(string));
            }
            if (o instanceof ResourceLocation rl) {
                return ForgeRegistries.BLOCK_ENTITY_TYPES.getValue(rl);
            }
            if (o instanceof BlockEntityType<?> t) {
                return t;
            }
            return null;
        });
    }
}
