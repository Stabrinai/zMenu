package fr.maxlego08.menu.scheduler;

import fr.maxlego08.menu.api.scheduler.ZScheduler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class BukkitScheduler implements ZScheduler {

    BukkitTask bukkitTask;
    JavaPlugin plugin;

    public BukkitScheduler(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public ZScheduler runTask(Runnable task) {
        bukkitTask = Bukkit.getScheduler().runTask(plugin, task);
        return this;
    }

    @Override
    public ZScheduler runTask(Location location, Runnable task) {
        bukkitTask = Bukkit.getScheduler().runTask(plugin, task);
        return this;
    }

    @Override
    public ZScheduler runTask(Entity entity, Runnable task) {
        bukkitTask = Bukkit.getScheduler().runTask(plugin, task);
        return this;
    }

    @Override
    public ZScheduler runTaskAsynchronously(Runnable task) {
        bukkitTask = Bukkit.getScheduler().runTaskAsynchronously(plugin, task);
        return this;
    }

    @Override
    public ZScheduler runTaskLater(long delay, Runnable task) {
        bukkitTask = Bukkit.getScheduler().runTaskLater(plugin, task, delay);
        return this;
    }

    @Override
    public ZScheduler runTaskLater(Location location, long delay, Runnable task) {
        bukkitTask = Bukkit.getScheduler().runTaskLater(plugin, task, delay);
        return this;
    }

    @Override
    public ZScheduler runTaskLater(Entity entity, long delay, Runnable task) {
        bukkitTask = Bukkit.getScheduler().runTaskLater(plugin, task, delay);
        return this;
    }

    @Override
    public ZScheduler runTaskLaterAsynchronously(long delay, Runnable task) {
        bukkitTask = Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, task, delay);
        return this;
    }

    @Override
    public ZScheduler runTaskTimer(long delay, long period, Runnable task) {
        bukkitTask = Bukkit.getScheduler().runTaskTimer(plugin, task, delay, period);
        return this;
    }

    @Override
    public ZScheduler runTaskTimer(Location location, long delay, long period, Runnable task) {
        bukkitTask = Bukkit.getScheduler().runTaskTimer(plugin, task, delay, period);
        return this;
    }

    @Override
    public ZScheduler runTaskTimer(Entity entity, long delay, long period, Runnable task) {
        bukkitTask = Bukkit.getScheduler().runTaskTimer(plugin, task, delay, period);
        return this;
    }

    @Override
    public ZScheduler runTaskTimerAsynchronously(long delay, long period, Runnable task) {
        bukkitTask = Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, task, delay, period);
        return this;
    }

    @Override
    public void cancel() {
        if (!bukkitTask.isCancelled()) {
            bukkitTask.cancel();
        }
    }

    @Override
    public boolean isFolia() {
        return false;
    }
}
