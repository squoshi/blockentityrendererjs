package com.squoshi.berjs;

import com.mojang.blaze3d.vertex.PoseStack;
import com.squoshi.berjs.event.RegisterBlockEntityRenderersEventJS;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

@Mod(BERJS.MODID)
public class BERJS {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "berjs";

    public static HashMap<BlockEntityType<?>, BlockEntityRendererProvider<?>> blockEntityRenderers = new HashMap<>();

    public BERJS() {}

    @Mod.EventBusSubscriber(modid = BERJS.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class BERJSClient {
        @SubscribeEvent
        public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            blockEntityRenderers.forEach((type, provider) -> registerRenderer(event, type, provider));
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            RegisterBlockEntityRenderersEventJS e = new RegisterBlockEntityRenderersEventJS();
            BERJSPlugin.registerBlockEntityRenderers.post(e);
        }

        private static <T extends BlockEntity> void registerRenderer(EntityRenderersEvent.RegisterRenderers event, BlockEntityType<?> type, BlockEntityRendererProvider<?> provider) {
            LOGGER.info("Registering block entity renderer (in event) for " + type);
            event.registerBlockEntityRenderer((BlockEntityType<T>) type, (BlockEntityRendererProvider<? super T>) provider);
        }
    }

    public record BlockEntityRendererContext(BlockEntity entity, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int light, int overlay) { }
}