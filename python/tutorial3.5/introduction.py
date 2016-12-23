# Base syntax introduction

# 运算符 +，-，*，/ 与其他语言意义一样。() 用于分组，/ 永远返回一个浮点数，// 返回整数部分，% 计算余数
# ** 计算幂乘方
print(3 ** 4)  # 81

# 字符串可以用 '' 或 "" 来标识。
# 如果字符串前面带有 \ 的字符被当作特殊字符，你可以使用原始字符串，方法是在第一个引号前面加上一个 r
print('c:\test\name')  # c:	est ame
print(r'c:\test\name')  # c:\test\name
# 多行字符串
print("""\
Usage: thingy [OPTIONS]
    -h  Display this usage message
    -H hostname Hostname to connect to
""")
# 字符串可以使用 + 连接在一起，可以由 * 表示重复；相邻的两个字符串文本会自动连接在一起，当这种语法只能用于两个字符串文本，不能用于字符串表达式
print(3 * 'um' + 'an')  # display:umumuman
print('Pyth' 'on')
# 字符串可以被用来截取或切割，采用类似数组的方式，字符串切割也支持负数；len(s) 返回字符串的长度
word = 'python'
print(word[0], word[-3:-1])  # p ho
# Python 字符串不可以被更改，它们是不可变的，因此，赋值给字符串的位置会导致错误
# word[0] = 'a'  # display TypeError: 'str' object does not support item assignment
# tips：可以使用逗号结尾来禁止输出换行
print('Python', end=',')
print('Hello World')

# Python 列表语法结构与 php 类似，元素可以是不同的类型，适用于切割，+ 支持连接操作；列表是可变的，允许修改元素。append() 方法可以用来在列表的末尾添加新的元素。
cubes = [1, 8, 27, 65, 125]
x = [cubes, ['a', 'b']]
cubes.append(3 ** 2)
print(cubes)
print(x)



