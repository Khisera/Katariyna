package khisera.bot.katariyna.commands;

import khisera.bot.katariyna.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by kyled on 9/29/2017.
 */
public class Roll implements Command {

    private final String HELP = "Usage: .r or .roll, followed by XdY+Z";

    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    public void action(String[] args, MessageReceivedEvent event) {

        Random random = new Random();
        String message = "";
        int dice;
        int tenAgain = 0;
        int successes = 0;
        int failures = 0;

        event.getMessage().delete().complete();

        if(args.length == 0){
            event.getChannel().sendMessage("Hey, fucker!  You can't roll without any dice!").complete();
            return;
        }

        try {
            dice = Integer.parseInt(args[0]);
        } catch(NumberFormatException e){
            event.getChannel().sendMessage("Hey, fucker! "+args[0]+" isn't a number!").complete();
            return;
        }

        message += ":game_die: "+event.getAuthor().getAsMention()+" :game_die:\nYou rolled.. ";

        while(dice-- > 0){
            int roll = random.nextInt(10)+1;

            if(roll == 10){
                message += "***10***";
                tenAgain++;
                successes++;
            }else if(roll >= 8){
                message += "**"+roll+"**";
                successes++;
            }else if(roll == 1){
                message += "**1**";
                failures++;
            }else
                message += roll;

            if(dice > 0){
                message += ", ";
            }else if(dice == 0 && tenAgain > 0){
                dice = tenAgain;
                tenAgain = 0;
                message += "!\nTen again.. ";
            }else{
                message += "!\n";
            }
        }

        message += "\nYou succeeded "+successes+" times! :relieved:";
       // if(failures > 0)
         //   message += "\nYou failed "+failures+" times. :confused:";
        event.getChannel().sendMessage(message).complete();

    }

    public String help() {
        return HELP;
    }

    public void executed(boolean success, MessageReceivedEvent event) {

    }

}
