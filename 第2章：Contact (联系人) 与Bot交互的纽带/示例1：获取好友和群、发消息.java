import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.utils.BotConfiguration;

class Test {

    public static void main(String[] args) {
        long qq = 123456789L;
        String password = "password";

        Bot bot = BotFactory.INSTANCE.newBot(qq, password, config -> {
            config.fileBasedDeviceInfo();
            config.setProtocol(BotConfiguration.MiraiProtocol.IPAD);
        });

        bot.login(); // 登录Bot

        // 上边看不懂的请去看第一章

        // 向QQ号为123456789的好友发消息
        Friend friend = bot.getFriend(123456789L);
        if (friend != null) {
            friend.sendMessage("我上线了");
        }

        // 向群号为987654321的好友发消息
        Group group = bot.getGroup(987654321L);
        if (group != null) {
            group.sendMessage("大家晚上好");
        }
    }
}