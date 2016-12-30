# input and output

# 格式化输出

# str() 和 repr() 函数，用来将值转化为字符串
# str.rjust() 把字符串输出到一列，并通过向左侧填充空格来使其右对齐；str.ljust()、str.center() 等方法类似
# str.zfill() 用于向数值的字符串表达左侧填充0

# str.format()：用于格式化输出字符串。可采取位置参数和关键字参数随意组合的形式

print('The story of {1}, {0}, and {other}.' .
      format('Manfred', 'Bill', other='Georg'))  # The story of Bill, Manfred, and Georg.

# 字段名后允许可选的 ':' 和格式指令，以用来对格式化进行更加深入的控制。
# 字段后的 ':' 后面加一个整数会限定该字段的最小宽度
import math
print('The value of pi is {0:.2f}' . format(math.pi))  # The value of PI is approximately 3.14

table = {'Tom': 23, 'HanMeiMei': 22, 'LiLei': 23}
for name, age in table.items():
    print('{0:10} ==> {1:8d}' . format(name, age))

# '**' 标志将这个字典以关键字参数的方式传入
table = {'Sjoerd': 4127, 'Jack': 4098, 'Dcab': 8637678}
print('Jack: {Jack:5d}; Sjoerd: {Sjoerd:d}; Dcab: {Dcab:d}'.format(**table))

# 文件读写
# open(filename, mode)：返回文件对象。
#     mode 的可选值为：'r'、'w'、'a'，'r+'
#     通常以文本方式打开，模式后面若有的 'b'，则表示以二进制的方式文件：数据会以字节对象的形式读写
# read([size])：读取文件，size指定字符串长度（可选值）
#     默认一次性读取，过大则会溢出
# readline()：读取一行，字符串结尾会自动添加换行符，返回值为空表示达到了文件的末尾
# close()：销毁文件对象释放资源
# 使用关键字 with 处理文件对象是个好习惯，它的先进之处在于文件操作结束之后会自动关闭。
#    它是 try-finally 快的缩写

# with open('workfile', 'r') as f:
#     data = f.read()

# json 序列化
# dumps()：将 python 的数据类型转换为 json 字符串
# dump(x, f)：将对象序列化到文件
# load(f)：从文件中解码对象

import json

x = json.dumps([1, 'tom', 'jack'])
print(x)



