# 第一章 —— 初识mirai与Bot登录

### 目录
- 〇、本章前言
- 一、创建Bot
- 二、登录Bot
- 三、登录之后干什么

## 〇、本章前言：

首先：除极少数API外，多数Mirai的API都是**面向对象**的

例如：
- 对Bot的操作（如登录，配置，注册监听器）<br>都形如`bot.xxx()`

- 对好友、群的操作（如主动发消息）<br>都形如`friend.xxx()` `group.xxx()`
<br>（在监听器中回复消息将有更方便的方法）

> Mirai的四大对象分别是：`机器人(Bot)`、`联系人(Contact)`、`事件（Event）`、`消息(Message)`

因此，使用Mirai的第一步就是**创建Bot并登录**

## 一、创建Bot

> 参考： https://docs.mirai.mamoe.net/Bots.html

使用`BotFactory`的方法`newBot`

下面分别通过Kotlin和Java演示

kotlin: 代码结构
```kotlin
val bot = BotFactory.newBot(/*QQ号*/, /*密码*/) {
    // 配置语句
}
```

Java: 代码结构
```java
Bot bot = BotFactory.INSTANCE.newBot(/*QQ号*/, /*密码*/, config -> {
    // 配置语句
});
```

-----

例如：我们创建一个满足如下条件的机器人：
- 它的QQ号是`123456789`，密码为`"password"`
- 它将使用`IPAD`协议登录（默认为`Android`协议）

> 这里使用`IPAD`协议是为了能让Bot跟我的手机同时在线，请大家按照自己的需求设置

kotlin：
```kotlin
val bot = BotFactory.newBot(123456789L, "password") {
    protocol = MiraiProtocol.IPAD // 选择IPAD协议
    fileBasedDeviceInfo() // 从文件获取设备信息
}
```

Java：

```java
Bot bot = BotFactory.INSTANCE.newBot(123456789L, "password", config -> {
    config.fileBasedDeviceInfo(); // 从文件获取设备信息
    config.setProtocol(BotConfiguration.MiraiProtocol.IPAD); // 选择IPAD协议
});
```

`fileBasedDeviceInfo()`的含义是将QQBot的设备信息储存到文件，若没有则生成一个新的，下次启动直接读取<br>
它有一个参数，表示文件名。**若不填则为默认`"device.json"`（默认即可，没必要改）**

**若不加这句话，QQ每次登录都是相当于一台新设备**，不方便给Bot加设备锁。而且Tx会可能会认为你频繁更换设备，有一定风险。所以建议加上

> 上文虽然只演示了两条配置（设备信息和协议）。除此之外还有很多配置项，请大家按照需求来。不过，入门的话，用默认配置即可。

## 二、登录Bot

> 参考: https://docs.mirai.mamoe.net/Bots.html

无论java还是kotlin，都是调用bot的`login`方法。

```kotlin
bot.login();
```

此过程可能遇到“`登陆环境不安全`”（可以尝试打开设备锁）、“`请处理滑动验证`”（请看上文参考）等问题。

之后若Bot掉线，它会自动解决重连的问题，一般不需要再次调用`login`

除此之外，还有很多策略可以更改配置。这对于初学者来说可以不去了解。若想了解请移步上边的参考


## 三、登录之后做什么

登录之后，我们就可以直接调用所有的 Mirai Bot API 了！

我们可以：

- 读取好友信息
- 读取群信息
- 注册事件监听器
- 管理群文件，通过好友申请，入群申请。禁言他人，踢人等等
- 还有很多功能等待探索