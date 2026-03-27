package org.lolicode.luckperms_storage_redirect.mixin;

import org.spongepowered.asm.mixin.Mixin;
import me.lucko.luckperms.fabric.LPFabricBootstrap;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.nio.file.Path;

@Mixin(value = LPFabricBootstrap.class)
public abstract class LPFabricBootstrapMixin {
    @Shadow
    public abstract Path getConfigDirectory();

    @Inject(method = "getDataDirectory()Ljava/nio/file/Path;", at = @At("HEAD"), cancellable = true)
    private void getDataDirectory(CallbackInfoReturnable<Path> cir) {
        cir.setReturnValue(getConfigDirectory().resolve("data"));
    }
}
