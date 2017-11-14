package khisera.bot.katariyna.commands;

import khisera.bot.katariyna.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by kyled on 9/29/2017.
 */
public class Ping implements Command{

    private final String HELP = "Usage: !ping";

    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("Pong").complete();
    }

    public String help() {
        return HELP;
    }

    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
