import net.mamoe.mirai.Bot
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.utils.BotConfiguration.MiraiProtocol

suspend fun main() {

    val qq = 123456789L
    val password = "password"

    // 创建Bot对象
    // newBot的第一个参数为QQ号(类型为Long)
    // 第二个参数为密码(支持明文密码和ByteArray类型的MD5密码)
    val bot = BotFactory.newBot(qq, password) {
        fileBasedDeviceInfo() // 从文件获取设备信息
        protocol = MiraiProtocol.IPAD // 选择IPAD协议
    }
    // 登录Bot
    bot.login()

    // 之后就可以拿这个bot对象去搞事情了
}

// 如果你使用了Springboot，则把这个bot加入IOC容器就行了
/*
@Bean
fun bot(): Bot {
    val bot = BotFactory.newBot(qq, password) {
        fileBasedDeviceInfo()
        protocol = MiraiProtocol.IPAD
    }
    bot.login()
    return bot
}
*/