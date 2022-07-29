import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;

class Test {

    public static void main(String[] args) {
        long qq = 123456789L;
        String password = "password";

        // 创建Bot对象
        // newBot的第一个参数为QQ号(类型为long)
        // 第二个参数为密码(支持明文密码和byte[]类型的MD5密码)
        Bot bot = BotFactory.INSTANCE.newBot(qq, password, config -> {
            config.fileBasedDeviceInfo();
            config.setProtocol(BotConfiguration.MiraiProtocol.IPAD);
        });

        bot.login();

        // 之后就可以拿这个bot对象去搞事情了
    }

}

// 如果你使用了Springboot，则把这个bot加入IOC容器就行了