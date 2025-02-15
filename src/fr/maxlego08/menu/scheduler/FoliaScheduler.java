package fr.maxlego08.menu.scheduler;

import com.tcoded.folialib.FoliaLib;
import com.tcoded.folialib.impl.FoliaImplementation;
import com.tcoded.folialib.impl.PlatformScheduler;
import com.tcoded.folialib.wrapper.task.WrappedTask;
import fr.maxlego08.menu.api.scheduler.ZScheduler;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public class FoliaScheduler implements ZScheduler {

    private final PlatformScheduler platformScheduler;
    private WrappedTask task;

    public FoliaScheduler(JavaPlugin plugin) {
        FoliaLib foliaLib = new FoliaLib(plugin);
        this.platformScheduler = foliaLib.getScheduler();
    }

    @Override
    public ZScheduler runTask(Runnable task) {
        this.platformScheduler.runNextTick(w -> task.run());
        return this;
    }

    @Override
    public ZScheduler runTask(Location location, Runnable task) {
        if (location != null)
            this.platformScheduler.runAtLocation(location, w -> task.run());
        return this;
    }

    @Override
    public ZScheduler runTask(Entity entity, Runnable task) {
        if (entity != null)
            this.platformScheduler.runAtEntity(entity, w -> task.run());
        return this;
    }

    @Override
    public ZScheduler runTaskAsynchronously(Runnable task) {
        this.platformScheduler.runAsync(w -> task.run());
        return this;
    }

    @Override
    public ZScheduler runTaskLater(long delay, Runnable task) {
        this.task = this.platformScheduler.runLater(task, delay);
        return this;
    }

    @Override
    public ZScheduler runTaskLater(Location location, long delay, Runnable task) {
        if (location != null)
            this.task = this.platformScheduler.runAtLocationLater(location, task, delay);
        return this;
    }

    @Override
    public ZScheduler runTaskLater(Entity entity, long delay, Runnable task) {
        if (entity != null)
            this.task = this.platformScheduler.runAtEntityLater(entity, task, delay);
        return this;
    }

    @Override
    public ZScheduler runTaskLaterAsynchronously(long delay, Runnable task) {
        this.task = this.platformScheduler.runLater(task, delay);
        return this;
    }

    @Override
    public ZScheduler runTaskTimer(long delay, long period, Runnable task) {
        this.task = this.platformScheduler.runTimer(task, delay, period);
        return this;
    }

    @Override
    public ZScheduler runTaskTimer(Location location, long delay, long period, Runnable task) {
        if (location != null)
            this.task = this.platformScheduler.runAtLocationTimer(location, task, delay, period);
        return this;
    }

    @Override
    public ZScheduler runTaskTimer(Entity entity, long delay, long period, Runnable task) {
        if (entity != null)
            this.task = this.platformScheduler.runAtEntityTimer(entity, task, delay, period);
        return this;
    }

    @Override
    public ZScheduler runTaskTimerAsynchronously(long delay, long period, Runnable task) {
        this.task = this.platformScheduler.runTimerAsync(task, delay, period);
        return this;
    }

    @Override
    public void cancel() {
        if (this.task != null && !this.task.isCancelled()) {
            this.task.cancel();
        }
    }

    @Override
    public boolean isFolia() {
        return this.platformScheduler instanceof FoliaImplementation;
    }
}
