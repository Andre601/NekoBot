/*
 * Copyright 2018 - 2020 Andre601
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package site.purrbot.bot.constants;

public enum Emotes{

    // Animated emotes,
    LOADING       ("loading",      "700429690166313041", true),
    SENKO_TAIL_WAG("senkoTailWag", "700429690854440990", true),
    SHIRO_TAIL_WAG("shiroTailWag", "700429690598326414", true),
    TYPING        ("typing",       "700429689851740160", true),
    NEKO_TAIL_WAG ("nekoTailWag",  "700429690732675115", true),

    // Static/normal emotes
    ACCEPT           ("accept",           "700459644719464458", false),
    BLOB_HOLO        ("blobHolo",         "700429689960923187", false),
    BLUSH            ("blush",            "700429690007060671", false),
    BOOST_TIER_0     ("boostTier0",       "700429689864585256", false),
    BOOST_TIER_1     ("boostTier1",       "700429690149666976", false),
    BOOST_TIER_2     ("boostTier2",       "700429689864323144", false),
    BOOST_TIER_3     ("boostLevel3",      "700429690107723826", false),
    BOT              ("bot",              "700429689835094066", false),
    BOT_ICON         ("botIcon",          "701210618140557383", false),
    CANCEL           ("cancel",           "700439540875395112", false),
    CATEGORY         ("category",         "701213334657040415", false),
    DISCORD          ("discord",          "700429689503744161", false),
    DOWNLOAD         ("download",         "700429689444892703", false),
    EDIT             ("edit",             "700429689428377672", false),
    FACE             ("face",             "701217337776537652", false),
    JOINED_GUILD     ("joinedGuild",      "592043203629416459", false),
    LEFT_GUILD       ("leftGuild",        "592043203042213925", false),
    MEMBERS          ("members",          "701217337692651541", false),
    NEKOWO           ("nekOwO",           "700429690309050409", false),
    OWNER            ("owner",            "700429689918849105", false),
    PURR             ("purr",             "700429690405519370", false),
    SEX              ("sex",              "700427729673125908", false),
    SEX_ANAL         ("sex_anal",         "700427729476255785", false),
    SEX_YURI         ("sex_yuri",         "700427729040048208", false),
    SNUGGLE          ("snuggle",          "700429690086752338", false),
    STATUS_DISCONNECT("statusDisconnect", "592043203440410624", false),
    STATUS_READY     ("statusReady",      "592043203646193692", false),
    TAIL             ("tail",             "700429690321633363", false),
    TEXT_CHANNEL     ("textChannel",      "701213334409576540", false),
    VOICE_CHANNEL    ("voiceChannel",     "701213334715891742", false);


    private final String name;
    private final String id;
    private final boolean animated;

    Emotes(String name, String id, boolean animated){
        this.name = name;
        this.id = id;
        this.animated = animated;
    }

    public String getEmote() {
        return String.format(
                "<%s:%s:%s>",
                this.animated ? "a" : "",
                this.name,
                this.id
        );
    }

    public String getNameAndId(){
        return String.format(
                "%s:%s",
                this.name,
                this.id
        );
    }

    public String getId(){
        return this.id;
    }
}
