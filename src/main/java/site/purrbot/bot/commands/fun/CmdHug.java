package site.purrbot.bot.commands.fun;

import com.github.rainestormee.jdacommand.CommandAttribute;
import com.github.rainestormee.jdacommand.CommandDescription;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import site.purrbot.bot.PurrBot;
import site.purrbot.bot.commands.Command;
import site.purrbot.bot.constants.API;
import site.purrbot.bot.constants.Emotes;

import java.util.List;
import java.util.stream.Collectors;

@CommandDescription(
        name = "Hug",
        description = "Lets you hug someone.",
        triggers = {"hug", "hugging"},
        attributes = {
                @CommandAttribute(key = "category", value = "fun"),
                @CommandAttribute(key = "usage", value = "{p}hug @user [@user ...]")
        }
)
public class CmdHug implements Command {

    private PurrBot bot;

    public CmdHug(PurrBot bot){
        this.bot = bot;
    }

    @Override
    public void execute(Message msg, String s) {
        TextChannel tc = msg.getTextChannel();

        if(msg.getMentionedMembers().isEmpty()){
            bot.getEmbedUtil().sendError(tc, msg.getAuthor(), "Please mention at least one user to hug.");
            return;
        }

        Member member = msg.getMember();
        if(member == null)
            return;

        Guild guild = msg.getGuild();
        List<Member> members = msg.getMentionedMembers();

        if(members.contains(guild.getSelfMember())){
            if(bot.isBeta()){
                tc.sendMessage(String.format(
                        "\\*loves the hug from %s*",
                        member.getAsMention()
                )).queue();
                msg.addReaction("❤").queue();
            }else {
                tc.sendMessage(String.format(
                        "\\*enjoys the hug from %s*",
                        member.getAsMention()
                )).queue();
                msg.addReaction("❤").queue();
            }
        }

        if(members.contains(msg.getMember())){
            tc.sendMessage(String.format(
                    "Why are you hugging yourself %s?\n" +
                    "You can hug me if you want... %s",
                    member.getAsMention(),
                    Emotes.VANILLABLUSH.getEmote()
            )).queue();
        }

        String link = bot.getHttpUtil().getImage(API.GIF_HUG);

        String huggedMembers = members.stream().filter(
                mem -> !mem.equals(guild.getSelfMember())
        ).filter(
                mem -> !mem.equals(msg.getMember())
        ).map(Member::getEffectiveName).collect(Collectors.joining(", "));

        if(huggedMembers.isEmpty())
            return;

        tc.sendMessage(String.format(
                "%s Getting a hug-gif...",
                Emotes.ANIM_LOADING.getEmote()
        )).queue(message -> {
            if(link == null){
                message.editMessage(String.format(
                        "%s hugs you %s",
                        member.getEffectiveName(),
                        huggedMembers
                )).queue();
            }else{
                message.editMessage(
                        EmbedBuilder.ZERO_WIDTH_SPACE
                ).embed(bot.getEmbedUtil().getEmbed().setDescription(String.format(
                        "%s hugs you %s",
                        member.getEffectiveName(),
                        huggedMembers
                )).setImage(link).build()).queue();
            }
        });
    }
}
