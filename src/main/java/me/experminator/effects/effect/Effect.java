package me.experminator.effects.effect;

import org.bukkit.entity.Player;

/**
 * Copyright (c) 2016, Experminator.
 */
public abstract class Effect {

    public abstract void play(Player player);

    public final String getName() {
        return getClass().getSimpleName();
    }

    public final String getPermission() {
        return "effects.effect." + getClass().getSimpleName().toLowerCase();
    }
}
