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

        // 获取某群(群号: 12345)内的某人(QQ号: 67890)的头像的URL
        String avatarUrl = null;
        Group group = bot.getGroup(12345L);
        if (group != null) {
            Member member = group.get(67890L);
            if (member != null) {
                avatarUrl = member.getAvatarUrl();
            }
        }

    }
}