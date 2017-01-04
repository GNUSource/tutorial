# 标准库（python 常用模块）

# 输出格式
#     reprlib 模块为大型的或深度嵌套的容器缩写显示提供了 :repr() 函数的一个定制版本
#     pprint 模块，用于当输出超过一行的时候，pretty printer 添加断行和标识符，使得数据结构显示的更清晰
#     textwrap 模块格式化文本段落以适应设定的屏宽

import pprint

t = [[[['black', 'cyan'], 'white', ['green', 'red']], [['magenta','yellow'], 'blue']]]
pprint.pprint(t, width=30)

import textwrap
doc = """The wrap() method is just like fill() except that it returns
 a list of strings instead of one big string with newlines to separate
 the wrapped lines."""
print(textwrap.fill(doc, width=40))

# 模版（string 提供的一个灵活多变的模板类 Template）
#     格式使用 $ 为开头的 python 合法标识作为占位符，占位符外面的大括号使它可以和其它的字符不加空格混在一起
#     模块中的 safe_substitute() 方法在数据不完整时，不会改变占位符

from string import Template
t = Template('Return the $item to ${owner}')
d = dict(item = 'unladen swallow')
print(t.safe_substitute(d))

# 多线程（详见 python 的 Queue 模块）

# 日志
#     默认情况下捕获信息和调试信息并将输出发送到标准错误流
import logging
logging.debug('Debugging information')
logging.info('Info information')
logging.warning('Warning information')
logging.error('Error information')
logging.critical('Critical error，shutting down')

# 列表工具
#     list 相当于堆栈
#     deque 相当于队列
#     bisect 用以存储链表
#     heapq 保持链表的最小值总是在 index 为 0 的位置


from heapq import heapify, heappop, heappush
data = [1, 3, 5, 7, 9, 2, 4, 6, 8, 0]
heapify(data)
heappush(data, -5)
[heappop(data) for i in range(3)]

# 十进制浮点数算法
#     decimal 是一个适用于高精度浮点数运算的模块
#     fractions 模块是一个基于有理数的运算

from decimal import *
print(Decimal('1.00') % Decimal('.10'))  # 0.00
print(1.00 % 0.10)  # 0.09999999999999995

getcontext().prec = 36
print(Decimal(1) / Decimal(7))  # 0.142857142857142857142857142857142857

from fractions import Fraction
print(Fraction.from_float(0.1))  # 3602879701896397/36028797018963968
print((0.1).as_integer_ratio())  # (3602879701896397, 36028797018963968)


