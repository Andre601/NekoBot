package site.purrbot.bot.commands.info;

import com.github.rainestormee.jdacommand.CommandAttribute;
import com.github.rainestormee.jdacommand.CommandDescription;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import site.purrbot.bot.PurrBot;
import site.purrbot.bot.commands.Command;
import site.purrbot.bot.constants.Emotes;
import site.purrbot.bot.constants.IDs;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@CommandDescription(
        name = "User",
        description = "Gives you information about yourself or a mentioned user",
        triggers = {"user", "member", "userinfo", "memberinfo"},
        attributes = {
                @CommandAttribute(key = "category", value = "info"),
                @CommandAttribute(key = "usage", value =
                        "{p}user\n" +
                        "{p}user @user"
                )
        }
)
public class CmdUser implements Command{

    private PurrBot bot;

    public CmdUser(PurrBot bot){
        this.bot = bot;
    }

    private String getRoles(Member member){
        List<Role> roles = member.getRoles();

        if(roles.size() <= 1)
            return "`No other roles`";

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < roles.size(); i++){
            Role role = roles.get(i);
            String name = String.format("%s", role.getName().replace("`", "'"));

            if(sb.length() + name.length() + 20 > MessageEmbed.VALUE_MAX_LENGTH){
                int rolesLeft = roles.size() - i;

                sb.append("**__+").append(rolesLeft).append(" more__**");
                break;
            }

            sb.append(name).append("\n");
        }

        return sb.toString();
    }

    private String getNickname(Member member){
        if(member.getNickname() == null)
            return "";

        String nick = member.getNickname();

        return nick.length() > 25 ? nick.substring(0, 24) + "...\n" : nick + "\n";
    }

    private String getName(Member member){
        StringBuilder sb = new StringBuilder();

        if(member.isOwner())
            sb.append(Emotes.OWNER.getEmote()).append(" ");

        if(member.getUser().isBot())
            sb.append(Emotes.BOT.getEmote()).append(" ");

        sb.append(member.getUser().getName());

        return sb.toString();
    }

    private String getGame(Activity game){
        String type;

        switch(game.getType()){
            default:
            case DEFAULT:
                type = "Playing";
                break;

            case WATCHING:
                type = "Watching";
                break;

            case LISTENING:
                type = "Listening to";
                break;

            case STREAMING:
                type = "Streaming";
                break;
        }

        return String.format(
                "%s %s",
                type,
                game.getName().length() > 25 ? game.getName().substring(0, 24) + "..." : game.getName()
        );
    }

    private String getTimes(Member member){
        StringBuilder sb = new StringBuilder();

        sb.append("Account created: ")
                .append(bot.getMessageUtil().formatTime(LocalDateTime.from(member.getTimeCreated())))
                .append("\n")
                .append("Guild joined:    ")
                .append(bot.getMessageUtil().formatTime(LocalDateTime.from(member.getTimeJoined())))
                .append("\n");

        if(member.getTimeBoosted() != null)
            sb.append("Boost since:     ")
                    .append(bot.getMessageUtil().formatTime(LocalDateTime.from(member.getTimeBoosted())))
                    .append("\n");

        return sb.toString();
    }

    @Override
    public void execute(Message msg, String args) {
        Member member;
        TextChannel tc = msg.getTextChannel();

        if(msg.getMentionedMembers().isEmpty()){
            member = msg.getMember();
        }else{
            member = msg.getMentionedMembers().get(0);
        }

        if(member == null){
            bot.getEmbedUtil().sendError(tc, msg.getAuthor(), "The requested Member doesn't seem to be in this Discord!");
            return;
        }

        String imgName = String.format("userinfo_%s.png", member.getId());

        EmbedBuilder embed = bot.getEmbedUtil().getEmbed(msg.getAuthor())
                .addField(getName(member), String.format(
                        "```yaml\n" +
                        "%s" +
                        "ID:   %s\n" +
                        "%s\n" +
                        "```",
                        getNickname(member),
                        member.getId(),
                        member.getActivities().isEmpty() ? "" : "Game: " + getGame(member.getActivities().get(0))
                        ),
                        false
                )
                .addField(
                        "Avatar",
                        String.format(
                                "[`Avatar URL`](%s)",
                                member.getUser().getEffectiveAvatarUrl()
                        ),
                        true
                )
                .addField(
                        "Highest Role",
                        member.getRoles().isEmpty() ? "`No roles assigned`" : member.getRoles().get(0).getAsMention(),
                        true
                )
                .addField(
                        "Other Roles",
                        getRoles(member),
                        false
                )
                .addField(
                        "Dates",
                        String.format(
                                "```yaml\n" +
                                "%s\n" +
                                "```",
                                getTimes(member)
                        ),
                        false
                );

        if(msg.getGuild().getId().equals(IDs.GUILD.getId()) && !member.getUser().isBot() && !bot.isBeta())
            embed.addField(
                    "XP",
                    String.format(
                            "`%d/%d`",
                            bot.getDbUtil().getXp(member.getUser().getId()),
                            (long)bot.getLevelManager().reqXp(bot.getDbUtil().getLevel(member.getUser().getId()))
                    ),
                    true
            )
            .addField(
                    "Level",
                    String.format(
                            "`%d`",
                            bot.getDbUtil().getLevel(member.getUser().getId())
                    ),
                    true
            );

        byte[] bytes;
        try {
            bytes = bot.getImageUtil().getStatusAvatar(
                    member.getUser().getEffectiveAvatarUrl(),
                    member.getOnlineStatus().toString()
            );
        }catch(IOException ex){
            bytes = null;
        }

        if(bytes == null){
            tc.sendMessage(embed.setThumbnail(member.getUser().getEffectiveAvatarUrl()).build()).queue();
            return;
        }

        tc.sendFile(bytes, String.format("%s", imgName)).embed(embed.setThumbnail(String.format(
                "attachment://%s",
                imgName
                )
        ).build()).queue();
    }
}
