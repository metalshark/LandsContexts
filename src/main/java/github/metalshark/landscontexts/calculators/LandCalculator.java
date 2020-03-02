package github.metalshark.landscontexts.calculators;

import github.metalshark.landscontexts.LandsContexts;
import me.angeschossen.lands.api.land.Land;
import net.luckperms.api.context.ContextCalculator;
import net.luckperms.api.context.ContextConsumer;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class LandCalculator implements ContextCalculator<Player> {
    private static final String KEY = "land";

    @Override
    public void calculate(Player player, ContextConsumer consumer) {
        final World world = player.getWorld();
        final Location location = player.getLocation();
        final Chunk chunk = location.getChunk();
        final int x = chunk.getX();
        final int z = chunk.getZ();
        final Land land = LandsContexts.getPlugin().getLandsAddon().getLand(world, x, z);
        if (land != null) {
            final String name = land.getName().toLowerCase();
            consumer.accept(KEY, name);
        }
    }
}
