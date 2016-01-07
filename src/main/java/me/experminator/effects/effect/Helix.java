package me.experminator.effects.effect;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Copyright (c) 2016, Experminator.
 */
public class Helix extends Effect {

    @Override
    public void play(Player player) {
        final Location loc = player.getLocation();

        int radius = 3;
        int maxHeight = 100;

        double empower = 0.5;

        for(double y = 0; y <= maxHeight; y += empower) {
            double x = Math.sin(y * radius);
            double z = Math.cos(y * radius);

            PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
                    EnumParticle.FLAME,
                    false,
                    ((float) (loc.getX() + x)),
                    ((float) (loc.getY() + y)),
                    ((float) (loc.getZ() + z)),
                    0,
                    0,
                    0,
                    1,
                    1,
                    null
            );

            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
        }
    }
}
