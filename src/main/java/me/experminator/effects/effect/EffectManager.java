package me.experminator.effects.effect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (c) 2016, Experminator.
 */
public final class EffectManager {

    private static final EffectManager instance = new EffectManager();
    private List<Effect> effects = new ArrayList<>();

    public static EffectManager getInstance() {
        return instance;
    }

    public List<Effect> getEffects() {
        return effects;
    }

    public List<String> getEffectNames() {
        return effects.stream().map(Effect::getName).collect(Collectors.toList());
    }

    public Effect getEffect(String name) {
        for(Effect effect : effects) {
            if(effect.getName().equalsIgnoreCase(name)) {
                return effect;
            }
        }

        return null;
    }

    public Effect addEffect(Effect effect) {
        effects.add(effect);
        return effect;
    }
}
