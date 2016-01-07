package me.experminator.effects.command;

import me.experminator.effects.effect.Effect;
import me.experminator.effects.effect.EffectManager;
import me.experminator.effects.event.EffectPlayEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Copyright (c) 2016, Experminator.
 */
public class EffectCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Sorry, only players can use Effects.");
            return true;
        }

        if(args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Sorry, you need to specify an effect.");
            return true;
        }

        Effect effect = EffectManager.getInstance().getEffect(args[0]);

        if(effect == null) {
            sender.sendMessage(ChatColor.RED + "Sorry, the effect '" + args[0] + "' does not exists.");
            return true;
        }

        if(!(sender.hasPermission(effect.getPermission()) || sender.isOp())) {
            sender.sendMessage(ChatColor.RED + "Sorry, you are not authorized to use this effect.");
            return true;
        }

        effect.play(((Player) sender));
        Bukkit.getServer().getPluginManager().callEvent(new EffectPlayEvent(((Player) sender), effect));
        sender.sendMessage(ChatColor.GREEN + "Effect '" + args[0] + "' is played!");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        return EffectManager.getInstance().getEffectNames();
    }
}
