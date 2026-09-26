package com.aquaskripto.aquaplugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class AquaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Command diament = new Command("diament") {
            @Override
            public boolean execute(CommandSender sender, String label, String[] args) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage("Ta komenda jest dostępna tylko dla graczy.");
                    return true;
                }

                Player player = (Player) sender;
                ItemStack diamond = new ItemStack(Material.DIAMOND, 1);

                for (ItemStack leftover : player.getInventory().addItem(diamond).values()) {
                    player.getWorld().dropItemNaturally(player.getLocation(), leftover);
                }

                player.sendMessage("Otrzymujesz jeden diament!");
                return true;
            }
        };

        diament.setDescription("Daje graczowi jeden diament.");
        diament.setUsage("/diament");
        getServer().getCommandMap().register("aquaplugin", diament);
    }

    @Override
    public void onDisable() {
        // Plugin nie wymaga dodatkowego sprzątania.
    }
}