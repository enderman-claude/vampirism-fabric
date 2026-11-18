package de.teamlapen.lib.util;

/**
 * A value with an integer weight, for weighted random selection.
 * Standalone replacement for the Forge/Minecraft WeightedRandom.Item base class (unused in the codebase).
 */
public class WeightedRandomItem<T> {
    private final T item;
    private final int itemWeight;

    public WeightedRandomItem(T item, int itemWeightIn) {
        this.item = item;
        this.itemWeight = itemWeightIn;
    }

    public T getItem() {
        return item;
    }

    public int getItemWeight() {
        return itemWeight;
    }
}
