# 虚拟环境和包

# 不同的应用程序可以使用不同的虚拟环境，以用来运行不同版本的 python 或模块
# pyvenv 命令可用于创建和管理虚拟环境，详见文档

# pip：python 用来管理应用程序所用到的包，类似 composer

# pip install -r requirements.txt
# Collecting novas==3.1.1.3 (from -r requirements.txt (line 1))
#   ...
# Collecting numpy==1.9.2 (from -r requirements.txt (line 2))
#   ...
# Collecting requests==2.7.0 (from -r requirements.txt (line 3))
#   ...
# Installing collected packages: novas, numpy, requests
#   Running setup.py install for novas
# Successfully installed novas-3.1.1.3 numpy-1.9.2 requests-2.7.0