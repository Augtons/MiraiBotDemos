# 第二章 —— Contact (联系人) 与Bot交互的纽带

### 目录
- 一、什么是联系人(Contact)

## 一、什么是联系人(Contact)

> 参考：https://docs.mirai.mamoe.net/Contacts.html

注：读者入门之后，可以前往上述参考文章中查看关于Contact的完整内容

简单来说，联系人Contact就是所有Bot能联系的对象

例如`群`、`群成员（含匿名成员）`、`好友`、`陌生人（包括群临时会话等）`、`Bot自身`、`其他设备（Bot账号同时在线的其他设备）`等都属于Contact

不同的Contact有不同的功能。例如： “群”这个Contact（对应`Group`类）除了能发消息以外，还能访问群名、群文件、群设置等。
而“好友”这个Contact（对应`Friend`类）则不可能有群文件的概念，但是可以获取用户昵称、用户的Profile等。

而操作这些Contact的Mirai的API，就是它们不同的属性、成员方法（和Kotlin拓展方法[^1]）





[^1]: 此处的“kotlin拓展方法”并非指为kotlin拓展的API，而是一种Kotlin语法名为“拓展方法”

