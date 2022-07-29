import net.mamoe.mirai.Bot
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.utils.BotConfiguration.MiraiProtocol

suspend fun main() {
    val qq = 123456789L
    val password = "password"

    val bot = BotFactory.newBot(qq, password) {
        fileBasedDeviceInfo() // 从文件获取设备信息
        protocol = MiraiProtocol.IPAD // 选择IPAD协议
    }

    bot.login() // 登录Bot

    // 上边看不懂的请去看第一章

    // 向QQ号为123456789的好友发消息
    bot.getFriend(123456789L)?.sendMessage("我上线了")

    // 向群号为987654321的好友发消息
    bot.getGroup(987654321L)?.sendMessage("大家晚上好")
}