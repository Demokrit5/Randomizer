package xyz.motz.randomizer.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.motz.randomizer.main.Randomizer;

public class IndividualRandomizerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("true")) {
                Randomizer.getPlugin().getConfig().set("individualRandomizer", true);
                Randomizer.getPlugin().saveConfig();
                sender.sendMessage(ChatColor.AQUA + "[RANDOMIZER] " + ChatColor.GREEN
                        + "Successfully activated individualRandomizer!");
            } else if(args[0].equalsIgnoreCase("false")) {
                Randomizer.getPlugin().getConfig().set("individualRandomizer", false);
                Randomizer.getPlugin().saveConfig();
                sender.sendMessage(ChatColor.AQUA + "[RANDOMIZER] " + ChatColor.GREEN
                        + "Successfully deactivated individualRandomizer!");
            } else {
                return false;
            }
        }
        return true;
    }
}
