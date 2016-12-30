# python 模块介绍

# 模块：为代码的复用提供了可能。python 中模块名就是文件名（去除后缀）
# 采用 import 引入模块时，该语法知识引入了模块名，不会直接把模块中的函数导入当前的语义表

import test

print(test.f(1))

# 出于性能的考虑，每个模块在每个解释器会话中只导入一遍。
# 因此，如果你修改了你的模块，需要重启解释器或采用 imp.reload(modulename)
# import 语句有一个变体，不会从局部语义表中导入模块名

# from test import f  # test 就没有定义

# f(1)

# 作为脚本来执行模块

# 以如下方式运行 python 模块时，模块中的代码便会被执行
# python test.py <arguments>

# 模块的搜索路径：
# （1）例如导入一个 spam.py 的模块时，解释器会先在当前目录中搜索名为 spam.py 的文件。
# （2）如果没有找到，接着会到 sys.path 变量中给出的目录列表中查找。

# sys.path 变脸的初始值来自如下：
# (1) 当前目录
# (2) 环境变量 PYTHONPATH 表示的目录列表中搜索
# (3) Python 默认安装路径中搜索


# package（collections of modules）

# import sound.effects.echo 这样就导入了 sound.effects.echo 子模块，但是它必须通过完整的名称来引用
# sound.effects.echo.echofilter(input, output, delay=0.7, atten=4)

# from sound.effects import echo 这样就加载了子模块，并且使得它在没有包前缀的情况下也可使用
# echo.echofilter(input, output, delay=0.7, atten=4)

# from sound.effects.echo import echofilter 这种变体就可以直接调用函数数
# echofilter(input, output, delay=0.7, atten=4)

# summary：
# from package import item，此方式的子项（item）既可以是包中的子模块（子包），也可以是定义的其他命名，如函数、变量、类等
# import item.subitem.subsubitem，此方式的子项必须是包，最后的子项可以是包或模块


