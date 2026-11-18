package de.teamlapen.lib.lib.util;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;


public class ItemStackUtil {

    /**
     * Can be used in {@link Inventory#decrStackSize(int, int)}
     */
    public static ItemStack decrIInventoryStackSize(Inventory inv, int slot, int amt) {
        ItemStack stack = inv.getStack(slot);
        if (!stack.isEmpty()) {
            if (stack.getCount() <= amt) {
                inv.setStack(slot, ItemStack.EMPTY);
            } else {
                stack = stack.split(amt);
                if (stack.isEmpty()) {
                    inv.setStack(slot, ItemStack.EMPTY);
                }
            }
            return stack;
        }
        return ItemStack.EMPTY;
    }

    /**
     * Checks if stackA contains stackB
     * True if A !=null and B == null
     */
    public static boolean doesStackContain(ItemStack stackA, ItemStack stackB) {
        return (stackB.isEmpty() || !stackA.isEmpty() && (areStacksEqualIgnoreAmount(stackA, stackB) && stackA.getCount() >= stackB.getCount()));
    }

    /**
     * compares ItemStack argument to the instance ItemStack; returns true if both ItemStacks are equal. ignores stack size
     */
    public static boolean areStacksEqualIgnoreAmount(ItemStack stackA, ItemStack stackB) {
        if (stackA.isEmpty() && stackB.isEmpty()) return true;
        if (stackA.isEmpty() || stackB.isEmpty()) return false;
        if (stackA.getItem() != stackB.getItem()) return false;
        if (stackA.getDamage() != stackB.getDamage()) return false;
        return ItemStack.areTagsEqual(stackA, stackB);
    }

    public static boolean stackEqualExact(ItemStack stack1, ItemStack stack2) {
        return stack1.getItem() == stack2.getItem() && ItemStack.areTagsEqual(stack1, stack2);
    }
}
