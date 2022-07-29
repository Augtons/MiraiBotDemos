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

    // 获取某群(群号: 12345)内的某人(QQ号: 67890)的头像的URL
    val avatarUrl = bot.getGroup(12345L)?.get(67890L)?.avatarUrl
}