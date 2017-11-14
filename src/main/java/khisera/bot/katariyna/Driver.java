package khisera.bot.katariyna;

import khisera.bot.katariyna.commands.Ping;
import khisera.bot.katariyna.commands.Roll;
import khisera.bot.katariyna.utils.BotInfo;
import khisera.bot.katariyna.utils.CommandParser;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.HashMap;

/**
 * Created by kyled on 9/29/2017.
 */
public class Driver {

    private static JDA jda;
    public static final CommandParser parser = new CommandParser();

    public static HashMap<String, Command> commands = new HashMap<String, Command>();

    public static void main(String[] args) {
        try {
            jda = new JDABuilder(AccountType.BOT)
                    .addEventListener(new BotListener())
                    .setToken(BotInfo.TOKEN)
                    .buildBlocking();
            jda.setAutoReconnect(true);
        }catch(Exception e){
            e.printStackTrace();
        }

        commands.put("ping", new Ping());
        commands.put("r", new Roll());
    }

    public static void handleCommand(CommandParser.CommandContainer cmd){

        if(commands.containsKey(cmd.invoke)){

            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if(safe){
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
            }
            commands.get(cmd.invoke).executed(safe, cmd.event);
        }
    }
}
