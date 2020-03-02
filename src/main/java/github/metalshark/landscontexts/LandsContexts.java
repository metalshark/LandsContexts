package github.metalshark.landscontexts;

import github.metalshark.landscontexts.calculators.LandAreaCalculator;
import github.metalshark.landscontexts.calculators.LandCalculator;
import lombok.Getter;
import me.angeschossen.lands.api.integration.LandsIntegration;
import net.luckperms.api.LuckPerms;
import org.bukkit.plugin.java.JavaPlugin;

public class LandsContexts extends JavaPlugin {

    private LuckPerms luckPerms;

    @Getter private LandsIntegration landsAddon;

    public static LandsContexts getPlugin() {
        return getPlugin(LandsContexts.class);
    }

    @Override
    public void onEnable() {
        landsAddon = new LandsIntegration(this, false);

        luckPerms = getServer().getServicesManager().load(LuckPerms.class);
        if (this.luckPerms == null) {
            throw new IllegalStateException("LuckPerms API not loaded.");
        }

        this.luckPerms.getContextManager().registerCalculator(new LandCalculator());
        this.luckPerms.getContextManager().registerCalculator(new LandAreaCalculator());
    }

}
