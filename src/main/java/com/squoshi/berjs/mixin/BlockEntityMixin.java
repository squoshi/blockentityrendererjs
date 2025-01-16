package com.squoshi.berjs.mixin;

import com.squoshi.berjs.util.BlockEntityBERJS;
import dev.latvian.mods.kubejs.block.entity.BlockEntityJS;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockEntity.class)
public class BlockEntityMixin implements BlockEntityBERJS {
    @Override
    public BlockEntityJS berJS$getAsJS() {
        var thiz = (BlockEntity) (Object) this;
        if (thiz instanceof BlockEntityJS) {
            return (BlockEntityJS) thiz;
        } else {
            return null;
        }
    }
}
