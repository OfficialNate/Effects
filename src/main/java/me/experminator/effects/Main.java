package me.experminator.effects;

import me.experminator.effects.command.EffectCommand;
import me.experminator.effects.effect.EffectManager;
import me.experminator.effects.effect.Helix;
import me.experminator.effects.effect.RadialWave;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright (c) 2016, Experminator.
 */
public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        EffectCommand effectCommand = new EffectCommand();

        getCommand("effect").setExecutor(effectCommand);
        getCommand("effect").setTabCompleter(effectCommand);

        EffectManager.getInstance().addEffect(new Helix());
        EffectManager.getInstance().addEffect(new RadialWave());
    }
}
