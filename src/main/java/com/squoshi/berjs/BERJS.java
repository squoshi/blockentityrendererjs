package com.squoshi.berjs;

import com.mojang.blaze3d.vertex.PoseStack;
import com.squoshi.berjs.custom.CustomBlockEntityRenderer;
import com.squoshi.berjs.custom.CustomBlockEntityRendererProvider;
import com.squoshi.berjs.util.BlockEntityInfoBERJS;
import dev.latvian.mods.kubejs.block.entity.BlockEntityBuilder;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BERJS.MODID)
public class BERJS {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "berjs";

    public BERJS() {}

    @Mod.EventBusSubscriber(modid = BERJS.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    @OnlyIn(Dist.CLIENT)
    public static class BERJSClient {
        @SubscribeEvent
        public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            RegistryInfo.ALL_BUILDERS.stream().filter(builder -> builder instanceof BlockEntityBuilder).forEach(builder -> {
                BlockEntityBuilder blockEntityBuilder = (BlockEntityBuilder) builder;
                BlockEntityType<?> type = blockEntityBuilder.get();
                var renderContext = ((BlockEntityInfoBERJS) blockEntityBuilder).renderContext();
                if (renderContext != null) {
                    CustomBlockEntityRenderer<?> ber = new CustomBlockEntityRenderer<>(renderContext);
                    BlockEntityRendererProvider<?> provider = new CustomBlockEntityRendererProvider<>(ber);
                    event.registerBlockEntityRenderer(type, provider);
                }
            });
        }
    }

    public record BlockEntityRendererContext(BlockEntity entity, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int light, int overlay) { }
}