package github.metalshark.landscontexts.calculators;

import github.metalshark.landscontexts.LandsContexts;
import me.angeschossen.lands.api.land.LandArea;
import net.luckperms.api.context.ContextCalculator;
import net.luckperms.api.context.ContextConsumer;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LandAreaCalculator implements ContextCalculator<Player> {
    private static final String KEY = "landarea";

    @Override
    public void calculate(Player player, ContextConsumer consumer) {
        final Location location = player.getLocation();
        final LandArea landarea = LandsContexts.getPlugin().getLandsAddon().getArea(location);
        if (landarea != null) {
            final String name = landarea.getName().toLowerCase();
            consumer.accept(KEY, name);
        }
    }
}
