1、此rpc项目目前供B端和C端使用，接口也对应到不同目录下。
   在包com.sunlands.rpc.web下供B端使用；
   在包com.sunlands.rpc.api下供C端使用；
   同样的thrift文件也区分开；
   并且在B端和C端下接口的service也按照接口功能定义到不同的thrift文件和java包目录下。
   修改接口切记更新thrift文件。
   