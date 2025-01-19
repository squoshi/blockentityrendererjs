package com.squoshi.berjs;

import com.mojang.blaze3d.vertex.PoseStack;
import com.squoshi.berjs.util.BlockEntityInfoBERJS;
import com.squoshi.berjs.util.BlockEntityRendererContext;
import dev.latvian.mods.kubejs.block.entity.BlockEntityBuilder;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import dev.latvian.mods.kubejs.util.ConsoleJS;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Consumer;

@Mod(BERJS.MODID)
public class BERJS {
    public static final String MODID = "berjs";

    public BERJS() {}

    @Mod.EventBusSubscriber(modid = BERJS.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    @OnlyIn(Dist.CLIENT)
    public static class BERJSClient {
        @SubscribeEvent
        public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            RegistryInfo.ALL_BUILDERS.stream().filter(builder -> builder instanceof BlockEntityBuilder).forEach(builder -> {
                BlockEntityBuilder blockEntityBuilder = (BlockEntityBuilder) builder;
                BlockEntityType<? extends BlockEntity> type = blockEntityBuilder.get();
                var renderContext = ((BlockEntityInfoBERJS) blockEntityBuilder.info).berJS$renderContext();
                if (renderContext != null) {
                    CustomBlockEntityRenderer<BlockEntity> ber = new CustomBlockEntityRenderer<>(renderContext);
                    BlockEntityRendererProvider<BlockEntity> provider = new CustomBlockEntityRendererProvider<>(ber);
                    event.registerBlockEntityRenderer(type, provider);
                }
            });
        }

        public record CustomBlockEntityRenderer<T extends BlockEntity>(Consumer<BlockEntityRendererContext> context) implements BlockEntityRenderer<T> {
            @Override
            public void render(T be, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
                try {
                    context.accept(new com.squoshi.berjs.util.ClientBlockEntityRendererContext(be, v, poseStack, multiBufferSource, i, i1));
                } catch (Exception e) {
                    ConsoleJS.STARTUP.error("Error rendering block entity at " + be.getBlockPos().toShortString(), e);
                }
            }
        }

        public record CustomBlockEntityRendererProvider<T extends BlockEntity>(CustomBlockEntityRenderer renderer) implements BlockEntityRendererProvider<T> {
            @Override
            public BlockEntityRenderer<T> create(Context context) {
                return renderer;
            }
        }
    }
}