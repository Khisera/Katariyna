package khisera.bot.katariyna;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by kyled on 9/29/2017.
 */
public class BotListener extends ListenerAdapter{

    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContent().startsWith(".") && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
            Driver.handleCommand(
                    Driver.parser.parse(
                        event.getMessage().getContent().toLowerCase(),
                        event
            ));
        }
    }

    public void onReady(ReadyEvent event){

    }

}
