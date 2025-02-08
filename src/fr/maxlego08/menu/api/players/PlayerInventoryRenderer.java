package fr.maxlego08.menu.api.players;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface PlayerInventoryRenderer {

    void addItem(Player player, int slot, ItemStack itemStack);

}
