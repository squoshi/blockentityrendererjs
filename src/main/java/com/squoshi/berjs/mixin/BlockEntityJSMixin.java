package com.squoshi.berjs.mixin;

import com.squoshi.berjs.util.BlockEntityInfoBERJS;
import com.squoshi.berjs.util.BlockEntityJSBERJS;
import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;
import dev.latvian.mods.kubejs.block.entity.BlockEntityInfo;
import dev.latvian.mods.kubejs.block.entity.BlockEntityJS;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = BlockEntityJS.class, remap = false)
public abstract class BlockEntityJSMixin implements BlockEntityJSBERJS {
    @Shadow @Final public BlockEntityInfo info;
    @Unique
    public CompoundTag berJS$localData;
    @Unique
    public CompoundTag berJS$serverData;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void init(BlockPos blockPos, BlockState blockState, BlockEntityInfo entityInfo, CallbackInfo ci) {
        berJS$localData = ((BlockEntityInfoBERJS) info).berJS$getInitialLocalData().copy();
        berJS$serverData = ((BlockEntityInfoBERJS) info).berJS$getInitialLocalData().copy();
    }

    @Override
    public CompoundTag berJS$getLocalData() {
        if (Platform.getEnvironment() == Env.CLIENT) {
            return berJS$localData;
        } else {
            return berJS$serverData;
        }
    }
}
