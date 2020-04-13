package me.reconcubed.homeupdate.container;

import me.reconcubed.homeupdate.init.ModBlocks;
import me.reconcubed.homeupdate.init.ModContainerTypes;
import me.reconcubed.homeupdate.tileentity.CarpentersBenchTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import javax.annotation.Nullable;
import java.util.Objects;

public class CarpentersBenchContainer extends Container {

    public final CarpentersBenchTileEntity tileEntity;
    private final IWorldPosCallable canInteractWithCallable;

    public CarpentersBenchContainer(final int windowID, final PlayerInventory playerInventory, final CarpentersBenchTileEntity tileEntity) {
        super(ModContainerTypes.CARPENTERS_BENCH.get(), windowID);
        this.tileEntity = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

        // Container Inventory
        int startX = 8;
        int startY = 18;
        int slotSizePlus2 = 18;

        for (int row = 0; row < 6; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(tileEntity,
                        (row * 9) + column,
                        startX + (column * slotSizePlus2),
                        startY + (row * slotSizePlus2)
                ));
            }
        }

        // Player Inventory
        int playerStartY = 140;

        for (int row = 0; row < 3; ++row){
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory,
                        9 + (row * 9),
                        startX + (column * slotSizePlus2),
                        playerStartY + (row * slotSizePlus2)
                ));
            }
        }

        // Hotbar Inv.

        int hotbarStartY = 198;

        for (int column = 0; column < 9; ++column) {
            this.addSlot(new Slot(playerInventory,
                    column,
                    startX + (column * slotSizePlus2),
                    hotbarStartY
                    ));
        }
    }

    private static CarpentersBenchTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
        Objects.requireNonNull(playerInventory, "playerInventory can not be null.");
        Objects.requireNonNull(data, "data can not be null.");

        final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());

        if (tileAtPos instanceof CarpentersBenchTileEntity) {
            return (CarpentersBenchTileEntity)tileAtPos;
        }

        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }

    public CarpentersBenchContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId, playerInventory, getTileEntity(playerInventory, data));
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, ModBlocks.CARPENTERS_BENCH.get());
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < 54) {
                if (!this.mergeItemStack(itemstack1, 54, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, 54, false)){
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

        }
        return itemstack;
    }
}
