package me.experminator.effects.event;

import me.experminator.effects.effect.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Copyright (c) 2016, Experminator.
 */
public class EffectPlayEvent extends Event implements Cancellable {

    private final HandlerList handlers = new HandlerList();
    private Player player;
    private Effect effect;
    private boolean cancelled;

    public EffectPlayEvent(Player player, Effect effect) {
        this.player = player;
        this.effect = effect;
    }

    public Player getPlayer() {
        return player;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public Effect getEffect() {
        return effect;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
