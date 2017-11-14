package khisera.bot.katariyna;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by kyled on 9/29/2017.
 */
public interface Command {

    public boolean called(String[] args, MessageReceivedEvent event);
    public void action(String[] args, MessageReceivedEvent event);
    public String help();
    public void executed(boolean success, MessageReceivedEvent event);

}
