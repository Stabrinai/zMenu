package fr.maxlego08.menu.api.requirement;

import fr.maxlego08.menu.api.button.Button;
import fr.maxlego08.menu.api.engine.InventoryEngine;
import fr.maxlego08.menu.api.utils.Placeholders;
import org.bukkit.entity.Player;

import java.util.List;

public class ConditionalName {

    private final String name;
    private final List<Permissible> permissibles;
    private final int priority;

    public ConditionalName(String name, List<Permissible> permissibles, int priority) {
        this.name = name;
        this.permissibles = permissibles;
        this.priority = priority;
    }

    /**
     * Retrieves the name of the conditional name.
     *
     * <p>This name is used to display the name of the conditional name in the menu.</p>
     *
     * @return the name of the conditional name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves a list of all permissibles associated with this conditional name.
     *
     * <p>This list is used to check if a player has permission to access a menu.
     * If the list is empty, the player will not be able to access the menu.</p>
     *
     * @return a list of all permissibles associated with this conditional name.
     */
    public List<Permissible> getPermissibles() {
        return this.permissibles;
    }

    /**
     * Retrieves the priority of this conditional name.
     *
     * <p>This priority is used to determine the order in which the conditional
     * name is evaluated or displayed in the menu.</p>
     *
     * @return the priority of this conditional name.
     */
    public int getPriority() {
        return this.priority;
    }

    /**
     * Checks if the given player has permission to access the given menu.
     *
     * <p>This method is called whenever a player tries to access a menu that
     * has a conditional name. The method should return true if the player has
     * permission to access the menu, and false otherwise.</p>
     *
     * @param player          the player who is trying to access the menu.
     * @param button          the button that the player clicked to access the menu.
     * @param inventoryEngine the inventory that the button is located in.
     * @param placeholders    the placeholders to use when evaluating the conditional
     *                        name.
     * @return true if the player has permission to access the menu, and false
     * otherwise.
     */
    public boolean hasPermission(Player player, Button button, InventoryEngine inventoryEngine, Placeholders placeholders){
        return this.permissibles.stream().allMatch(permissible -> permissible.hasPermission(player, button, inventoryEngine, placeholders));
    }
}
