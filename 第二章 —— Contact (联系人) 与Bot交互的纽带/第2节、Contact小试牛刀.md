# 二、Contact小试牛刀

### 目录

## 一、主动发消息

本节演示主动向指定群、好友发消息的示例

完整示例文件：
- `示例一：获取好友和群、发消息.kt`
- `示例一：获取好友和群、发消息.java`

### 1、获取好友，向好友发消息

场景：Bot登录成功后，为QQ号为`123456789`的人发一条消息

Kotlin:
```kotlin
bot.getFriend(123456789L)?.sendMessage("我上线了")
```

Java:
```java
Friend friend = bot.getFriend(123456789L);
if (friend != null) {
    friend.sendMessage("我上线了");
}
```

> 注：getFriend()若没找到此好友，则返回null
> 
> 除此之外，还可以用getFriendOrFail()，若没找到则抛出`NoSuchElementException`

### 2. 获取群，向群发消息

场景：Bot登录成功后，为QQ群号为`123456789`的群发一条消息

Kotlin:
```kotlin
bot.getGroup(987654321L)?.sendMessage("大家晚上好")
```

Java:
```java
Group group = bot.getGroup(987654321L);
if (group != null) {
    group.sendMessage("大家晚上好");
}
```

> 注：getGroup()若没找到此群，则返回null
>
> 除此之外，还可以用getGroupOrFail()，若没找到则抛出`NoSuchElementException`


## 二、获取好友、群信息

### 1. 获取用户信息

我们拿到`Friend`对象之后，除了能发消息，还可以获取好友信息。

例如：昵称、备注、头像、部分资料卡信息（如QQ等级，性别，年龄，个性签名等）。
这些都可以通过Friend类的**成员属性**直接获取的。除此之外还可以操作好友，例如删除等等。

对于群，还能获取群成员的群名片，专属头衔，入群时间，是否被禁言。还可以查群头像，群公告等等。
除此之外还可以踢人，禁言别人，撤回群消息，加入精华消息，发布群公告等等（这种需要Bot管理员权限）

如果你在用IDEA，还可以直接点个"."呼出IDEA的智能提示。

mirai为大家写了很多通俗易懂的javadoc，可以配合IDEA直接显示出来其作用。

这里只演示一下获取群成员的头像下载链接，**其他的属性请类比使用**。

-----

场景：获取某群(群号: 12345)内的某人(QQ号: 67890)的头像的URL

Kotlin:
```kotlin
// 多行版
val group = bot.getGroup(12345L)
val member = group?.get(67890L)
val avatarUrl = member?.avatarUrl
```
```kotlin
// 单行版
val avatarUrl = bot.getGroup(12345L)?.get(67890L)?.avatarUrl
```

Java:
```java
String avatarUrl = null;
Group group = bot.getGroup(12345L);
if (group != null) {
    Member member = group.get(67890L);
    if (member != null) {
        avatarUrl = member.getAvatarUrl();
    }
}
```