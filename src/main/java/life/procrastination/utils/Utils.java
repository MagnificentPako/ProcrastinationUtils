package life.procrastination.utils;

import life.procrastination.utils.item.OptionalItemMeta;
import life.procrastination.utils.item.OptionalItemStack;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Utils extends JavaPlugin {

    @Override
    public void onEnable() {
        ItemStack stack = new ItemStack(Material.STONE);
        String displayname = OptionalItemStack.from(stack).getItemMeta().getDisplayName().orElse("Default");
        OptionalItemStack.from(stack)
                .getItemMeta().getDisplayName()
                .filter(name -> name.equals("Special name"))
                .ifPresent(name -> Bukkit.broadcastMessage(name + " is a really special item."));
    }

    @Override
    public void onDisable() {

    }

}
