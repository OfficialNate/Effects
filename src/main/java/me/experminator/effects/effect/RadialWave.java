package me.experminator.effects.effect;

import me.experminator.effects.Main;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Copyright (c) 2016, Experminator.
 */
public class RadialWave extends Effect {

    @Override
    public void play(Player player) {
        final Location loc = player.getLocation();

        BukkitRunnable run = new BukkitRunnable() {

            double timer = Math.PI / 4;

            @Override
            public void run() {
                timer += Math.PI * 0.2;

                for(double theta = 0; theta <= Math.PI * 2; theta += Math.PI / 32 + theta) {
                    double x = Math.cos(theta) * timer;
                    double y = Math.tan(theta) * timer;
                    double z = Math.sin(theta) * timer;

                    loc.add(x, y, z);

                    PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
                            EnumParticle.DRIP_WATER,
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

                    loc.multiply(5.5);

                    PacketPlayOutWorldParticles packet2 = new PacketPlayOutWorldParticles(
                            EnumParticle.DRIP_LAVA,
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
                    ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet2);

                    loc.subtract(x, y, z);
                }
            }
        };

        run.runTaskTimer(Main.getPlugin(Main.class), 1, 1);


    }
}
