package me.reconcubed.homeupdate.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import me.reconcubed.homeupdate.Homeupdate;
import me.reconcubed.homeupdate.container.CarpentersBenchContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CarpentersBenchScreen extends ContainerScreen<CarpentersBenchContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(Homeupdate.MODID, "textures/gui/carpenters_bench_inventory.png");

    public CarpentersBenchScreen(CarpentersBenchContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);

        this.guiLeft = 0;
        this.guiTop = 0;
        this.xSize = 175;
        this.ySize = 221;
    }

    @Override
    public void render(final int mouseX, final int mouseY,final float partialTicks) {
        this.renderBackground();
        this.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        this.font.drawString(this.title.getFormattedText(), 8.0f, 6.0f, 4210752);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0f, 126.0f, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        int x = (this.width - this.xSize)/2;
        int y = (this.width - this.ySize)/2;
        this.blit(x, y, 0, 0, this.xSize, this.ySize);
    }
}
