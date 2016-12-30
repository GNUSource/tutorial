# errors and exceptions

# except：关键字后必须是异常类或异常类的对象，当省略异常名称时，会作为通配符使用表示捕获所有异常
# else 子句：用于在没有发生异常时，执行的代码
# finally 子句：在任何情况下都会执行，一般进行一些资源的释放

import sys

try:
    f = open('myfile.txt')
    s = f.readline()
    i = int(s.strip())
except OSError as err:
    print("OS error: {0}".format(err))
except ValueError:
    print("Could not convert data to an integer.")
except:
    print("Unexpected error:", sys.exc_info()[0])
    raise
else:
    print('There is no exception')
finally:
    f.close()