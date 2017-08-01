package life.procrastination.utils.item;

import life.procrastination.utils.optional.OptionalList;
import life.procrastination.utils.optional.OptionalMap;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

public class OptionalItemMeta {

    private Optional<String> displayName;
    private Optional<String> localizedName;
    private OptionalList<String> lore;
    private OptionalMap<Enchantment, Integer> enchantments;
    private Set<ItemFlag> itemFlags ;
    private boolean unbreakable = false;

    public OptionalItemMeta() {
        this.displayName = Optional.empty();
        this.localizedName = Optional.empty();
        this.lore = new OptionalList();
        this.enchantments = new OptionalMap();
        this.itemFlags = new HashSet();
    }

    public Optional<String> getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String s) {
        this.displayName = Optional.of(s);
    }

    public Optional<String> getLocalizedName() {
        return this.localizedName;
    }

    public void setLocalizedName(String s) {
        this.localizedName = Optional.of(s);
    }

    public OptionalList<String> getLore() {
        return this.lore;
    }

    public void setLore(List<String> list) {
        this.lore = OptionalList.of(list);
    }

    public OptionalInt getEnchantLevel(Enchantment enchantment) {
        return OptionalInt.of(enchantments.get(enchantment).get());
    }

    public OptionalMap<Enchantment, Integer> getEnchants() {
        return enchantments;
    }

    public void addEnchant(Enchantment enchantment, int i, boolean b) {
        this.enchantments.put(enchantment, i);
    }

    public boolean removeEnchant(Enchantment enchantment) {
        return false;
    }

    public void addItemFlags(ItemFlag... itemFlags) {
        for(ItemFlag flag : itemFlags) {
            this.itemFlags.add(flag);
        }
    }

    public void removeItemFlags(ItemFlag... itemFlags) {
        for(ItemFlag flag : itemFlags) {
            this.itemFlags.remove(flag);
        }
    }

    public Set<ItemFlag> getItemFlags() {
        return this.itemFlags;
    }

    public boolean isUnbreakable() {
        return this.unbreakable;
    }

    public void setUnbreakable(boolean b) {
        this.unbreakable = b;
    }

}
