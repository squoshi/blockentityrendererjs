package com.squoshi.berjs;

import com.squoshi.berjs.event.RegisterBlockEntityRenderersEventJS;
import dev.latvian.mods.rhino.util.HideFromJS;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.HashMap;

@Mod(BERJS.MODID)
@Mod.EventBusSubscriber(modid = BERJS.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BERJS {
    public static final String MODID = "berjs";

    private static final HashMap<BlockEntityType<?>, BlockEntityRendererProvider<?>> blockEntityRenderers = new HashMap<>();

    public BERJS() {}

    @HideFromJS
    public static void addRenderer(BlockEntityType<?> type, BlockEntityRendererProvider<?> provider) {
        blockEntityRenderers.put(type, provider);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RegisterBlockEntityRenderersEventJS e = new RegisterBlockEntityRenderersEventJS();
        if (BERJSPlugin.registerBlockEntityRenderers.hasListeners()) {
            BERJSPlugin.registerBlockEntityRenderers.post(e);
        }
    }

    @Mod.EventBusSubscriber(modid = BERJS.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class BERJSClient {
        @SubscribeEvent
        public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            blockEntityRenderers.forEach((type, provider) -> registerRenderer(event, type, provider));
        }

        private static <T extends BlockEntity> void registerRenderer(EntityRenderersEvent.RegisterRenderers event, BlockEntityType<?> type, BlockEntityRendererProvider<?> provider) {
            event.registerBlockEntityRenderer((BlockEntityType<T>) type, (BlockEntityRendererProvider<? super T>) provider);
        }
    }
}