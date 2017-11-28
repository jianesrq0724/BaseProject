> # BaseProject 所有新项目的基础
* 基于MVP，统一标题栏，使用ToolBar,并封装了返回事件
* 支持Lambda表达式
* 集成ButterKnife、EventBus、友盟统计、分享、Retrofit、Rxjava、Glide、greendao、utilcode等第三方库
* RecyclerView、CardView
* multidex 优化超出方法数的限制问题 64k问题
* 实现ViewPage的懒加载
* 集成崩溃日志，在非正式环境下，通过界面展示出来


## 第三方库的使用
* 网络请求：Retrofit+RxJava+RxAndroid+Lambda，自己封装Retrofit，使用单列，另进行token拦截
* 图片加载：greenDao
* 数据库：greenDao（对象关系型数据库）
* 统计、分享：umeng
* 布局：ButterKnife、RecyclerView、CardView、Constraint
* 事件订阅：EventBus
* 浏览器：腾讯的X5WebView


# 优化BaseActivity 2017-8-1
在BaseActivity中优化，防止快速点击，启动多个Activity

# 优化网络环境  2017-8-11
优化常量的定义，使用final修饰常量类，并定义私有构造器，防止被初始化
将网络环境类型抽取为常量，在友盟、日志打印的时候，判断环境的时候不需要使用数字，防止出错

# 优化公共类 2017-11-28
* 在BaseActivity定义intitView、initData
* 在app/build.gradle中提取版本号，编译版本引用使用rootProject.ext.buildToolsVersion

# 待优化
* 网路请求，自动根据编译版本，使用渠道包、增加加载进度条网请求





