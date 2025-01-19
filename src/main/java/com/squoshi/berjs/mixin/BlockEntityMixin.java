package com.squoshi.berjs.mixin;

import com.squoshi.berjs.util.BlockEntityBERJS;
import dev.latvian.mods.kubejs.block.entity.BlockEntityJS;
import dev.latvian.mods.kubejs.script.ScriptManager;
import dev.latvian.mods.kubejs.util.ConsoleJS;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockEntity.class)
public class BlockEntityMixin implements BlockEntityBERJS {
    @Override
    public BlockEntityJS berJS$getCustom() {
        try {
            var thiz = (BlockEntity) (Object) this;
            if (thiz instanceof BlockEntityJS) {
                return (BlockEntityJS) thiz;
            } else {
                throw new ClassCastException();
            }
        } catch (ClassCastException e) {
            ConsoleJS.getCurrent(ScriptManager.getCurrentContext()).error("[KubeJS Advanced Rendering] Tried to get BlockEntityJS on a non-KubeJS block entity", e);
            e.printStackTrace();
            return null;
        }
    }
}