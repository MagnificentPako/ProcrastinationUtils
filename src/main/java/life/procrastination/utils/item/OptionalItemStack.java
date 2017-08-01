package life.procrastination.utils.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OptionalItemStack {

    private OptionalItemMeta meta;
    private ItemStack stack;

    private OptionalItemStack() {
        meta = new OptionalItemMeta();
    }

    public OptionalItemStack(Material material) {
        super();
        this.stack = new ItemStack(material);
    }

    public OptionalItemStack(Material material, int amount) {
        super();
        this.stack = new ItemStack(material, amount);
    }

    public static OptionalItemStack from(ItemStack itemStack) {
        OptionalItemStack stack = new OptionalItemStack(itemStack.getType(), itemStack.getAmount());
        OptionalItemMeta meta = new OptionalItemMeta();
        ItemMeta met = itemStack.getItemMeta();
        meta.setDisplayName(met.getDisplayName());
        meta.setLocalizedName(met.getLocalizedName());
        meta.setLore(met.getLore());
        meta.setUnbreakable(met.isUnbreakable());
        stack.setItemMeta(meta);
        return stack;
    }

    public OptionalItemMeta getItemMeta() {
        return meta;
    }

    public void setItemMeta(OptionalItemMeta meta) {
        this.meta = meta;
    }

    public ItemStack getStack() {
        ItemStack itemStack = stack.clone();
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(meta.getDisplayName().orElse(null));
        itemMeta.setLocalizedName(meta.getLocalizedName().orElse(null));
        itemMeta.setUnbreakable(meta.isUnbreakable());
        itemMeta.setLore(meta.getLore().raw());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
