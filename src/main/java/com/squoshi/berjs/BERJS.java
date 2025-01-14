package com.squoshi.berjs;

import dev.latvian.mods.rhino.util.HideFromJS;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;

@Mod(BERJS.MODID)
public class BERJS {
    public static final String MODID = "berjs";

    private static final HashMap<BlockEntityType<?>, BlockEntityRenderer<?>> blockEntityRenderers = new HashMap<>();

    public BERJS() {}

    @HideFromJS
    public static void addRenderer(BlockEntityType<?> type, BlockEntityRenderer<?> renderer) {
        blockEntityRenderers.put(type, renderer);
    }
}
