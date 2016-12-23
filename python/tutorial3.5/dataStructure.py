# data Structure

# list.append(x) <==> a[len(x):] = [x]：将元素添加到列表的末尾
# list.extend(l) <==> a[len(x):] = l：将一个给定列表中的所有元素都添加到另一个列表中
# list.insert(i, x)：指定位置插入元素
# list.remove(x)：删除列表中值为 x 的第一个元素
# list.pop(i)：从列表的指定位置删除元素，并将其返回。如果没有指定索引，a.pop() 返回最后一个元素。
# list.clear()：从列表中删除所有元素。
# list.index(x)：返回列表中第一个值为 x 的元素的索引。
# list.count(x)：返回 x 在列表中出现的次数。
# list.reverse()：就地倒排列列表中的元素。
# list.copy()：返回列表中的一个浅拷贝。

# list 作为堆栈使用（后进先出）

stack = list(['a', 'b', 3])

stack.append('d')
stack.append(5)

print(stack)  # ['a', 'b', 3, 'd', 5]

stack.pop()  # 5

print(stack)  # ['a', 'b', 3, 'd']

# list 作为队列使用（先进先出）：使用 collections.deque，它为首位两端快速插入和删除而设计

from collections import deque
queue = deque(['a', 'b', 3])
queue.append('d')
queue.append(5)

print(queue)  # deque(['a', 'b', 3, 'd', 5])

queue.popleft()  # 'a'

print(queue)  # deque(['b', 3, 'd', 5])

# list 列表推导式：为从序列中创建列表提供了一个简单的方法。使用的是笛卡尔积
# 列表推导式创建列表避免了使用 for 循环创建后迭代元素依旧存在的问题

# function map(function, iterable, ...)
# 详见 https://my.oschina.net/zyzzy/blog/115096

squares = list(map((lambda x: x**2), range(10)))

print(squares)  # [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]

squares = list([x**2 for x in range(10)])

print(squares)  # [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]

squares = list([(x, y) for x in [1, 2, 3] for y in (3, 1, 4) if x != y])

print(squares)  # [(1, 3), (1, 4), (2, 3), (2, 1), (2, 4), (3, 1), (3, 4)]

squares = list()

for x in range(1, 4):
    for y in (3, 1, 4):
        if x != y:
            squares.append((x, y))

print(squares)  # [(1, 3), (1, 4), (2, 3), (2, 1), (2, 4), (3, 1), (3, 4)]


# del：从列表中按给定的索引来删除一个子项，可用来删除切片或清空整个列表。

a = list([-1, 2, 3, 4, 5])
del a[0]

print(a)  # [2, 3, 4, 5]

del a[1:3]

print(a)  # [2, 5]

del a  # 清空整个列表


# 元组：序列类型（Sequence Types）

t = (12345, 'hello', 3, 'world')

print(t[0])  # 12345

print(t)  # (12345, 'hello', 3, 'world')

u = (t, ('a', 'b', 'c', 'd', 'e'))

print(u)  # ((12345, 'hello', 3, 'world'), ('a', 'b', 'c', 'd', 'e'))

print(u[0][1:3])  # ('hello', 3)

# 创建一个空元组，或者单元素的元组

empty = ()

singleton = ('hello', )

print('len is ', len(empty), '，and value is ', empty)  # len is  0 ，and value is  ()

print('len is ', len(singleton), '，and value is ', singleton)  # len is  1 ，and value is  ('hello',)

# 元组封装 & 序列拆封

t = (12345, 36985, 14725)  # 元组封装

x, y, z = t  # 序列拆封

print('x is ', x, '，y is ', y, '，z is ', z)  # x is  12345 ，y is  36985 ，z is  14725


# 集合：无序不重复元素的集。基本功能包括关系测试和消除重复元素；集合的创建必须使用 set()；
# 可用的运算有：union(联合)，intersection(交)，difference(差)，sysmmetric difference(对称差集)

basket = {'apple', 'orange', 'apple', 'pear', 'orange', 'banana'}

print(basket)  # 消除重复元素，{'banana', 'orange', 'pear', 'apple'}

print('orange' in basket)  # 关系测试：True

a = set('127')
a.add('s')

print(a)  # {'2', 's', '1', '7'}


# 字典：字典即为无序的键：值对 (key:value) 集合，键必须是互不相同的，一对大括号创建一个空的字典：{}。
# del 删除键值对；list(d.keys())，返回字典中所有关键字组成的无序列表（排序可使用 sorted(d.keys)）

tel = {'jack':4098, 'tom':552}

tel['liLei'] = 489

print(tel)  # {'jack': 4098, 'liLei': 489, 'tom': 552}

del tel['liLei']

print(tel)  # {'tom': 552, 'jack': 4098}

print(list(tel.keys()), sorted(tel.keys()))  # ['tom', 'jack'] ['jack', 'tom']

# dict()构造函数可以直接从 key-value 对中创建字典

print(dict([('tom', 'men'), ('hanMeiMei', 'women')]))  # {'liLei': 'man', 'hanMeiMei': 'women'}
print(dict(tom='men', hanMeiMei='women', jack='undefined'))  # {'jack': 'undefined', 'hanMeiMei': 'women', 'tom': 'men'}





