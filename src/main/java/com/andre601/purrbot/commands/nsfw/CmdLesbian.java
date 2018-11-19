package com.andre601.purrbot.commands.nsfw;

import com.andre601.purrbot.util.HttpUtil;
import com.andre601.purrbot.util.PermUtil;
import com.andre601.purrbot.util.constants.Emotes;
import com.andre601.purrbot.util.messagehandling.EmbedUtil;
import com.github.rainestormee.jdacommand.Command;
import com.github.rainestormee.jdacommand.CommandAttribute;
import com.github.rainestormee.jdacommand.CommandDescription;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

import java.text.MessageFormat;

@CommandDescription(
        name = "Lesbian",
        description = "Gives you a gif of lesbians",
        triggers = {"lesbian", "les"},
        attributes = {@CommandAttribute(key = "nsfw")}
)
public class CmdLesbian implements Command {

    @Override
    public void execute(Message msg, String s){
        TextChannel tc = msg.getTextChannel();
        String link = HttpUtil.getLesbian();

        if(PermUtil.canDeleteMsg(tc))
            msg.delete().queue();

        if(link == null){
            EmbedUtil.error(msg, "Couldn't reach the API! Try again later.");
            return;
        }

        EmbedBuilder les = EmbedUtil.getEmbed(msg.getAuthor())
                .setTitle(MessageFormat.format(
                        "{0}",
                        link.replace("https://cdn.nekos.life/les/", "")
                ), link)
                .setImage(link);

        tc.sendMessage(MessageFormat.format(
                "{0} Getting lewd lesbians...",
                Emotes.LOADING
        )).queue(message -> message.editMessage("\u200B").embed(les.build()).queue());
    }
}