package learn;

/**
 * 884 Maven
 * /meven/
 *
 * 定义：项目管理工具
 * 包含：项目对象模型POM 项目生命周期 依赖管理系统
 * 能做什么：
 *      jsr包管理 --jar包冲突？
 *      遍历java文件
 *      一次性大范围的单元测试
 *      项目打包
 *
 * maven开发的web项目
 * jar包不在项目中!! jar包仓库 jar包坐标
 *
 * 项目一键构建
 *      编译 测试 运行 打包 安装
 *      mvn tomcat:run
 *
 * maven 内容：
 *      bin/——mvn命令构建项目
 *      boot/——maven自己提供的一个类加载器(Java)
 *      conf/——settings.xml 配置文件
 *      lib/——自己依赖包
 *      LICENCE
 *      NOTICE
 *      README.txt
 *
 * 环境变量配置
 *      解压地——D:\Program Files\apache-maven-3.6.2
 *      MAVEN_HOME
 *
 *      C:\Users\madokast>mvn --version
 *      Apache Maven 3.6.2 (40f52333136460af0dc0d7232c0dc0bcf0d9e117; 2019-08-27T23:06:16+08:00)
 *      Maven home: D:\Program Files\apache-maven-3.6.2\bin\..
 *      Java version: 12.0.1, vendor: Oracle Corporation, runtime: D:\Program Files\jdk-12.0.1
 *      Default locale: zh_CN, platform encoding: GBK
 *      OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
 *
 * maven——仓库总类，关系——三类
 * maven工程——不放置jar包，只放置其坐标，因此启动maven后，就回去坐标点找jar包
 *
 * 默认本地仓库 Default: ${user.home}/.m2/repository 即系统盘找本地仓库 这里找jar包            local
 * 中央仓库：如果电脑联网，可以访问中央仓库，自动下载jar包。中央仓库，几乎放置了开源的jar包      center
 * 远程仓库：为了不联网开发：创建“远程仓库【私服】”——maven也可以访问，                       b2b
 *
 * 修改本地仓库路径
 * D:\Documents\GitHub\JavaLearning\maven_repository
 * <localRepository>D:\Documents\GitHub\JavaLearning\maven_repository</localRepository>
 *
 *
 * maven标准目录结构
 *      核心代码部分——达成jar包，供用户使用——需要不断维护升级
 *      配置文件部分——不打到jar中，jar包之外
 *      测试代码部分——单元测试
 *      测试配置文件——与上面配套
 *
 * 传统项目
 *      src/——只有一个src目录以上四个部分都在这里面——不合理
 *
 * maven项目标准目录结构
 *      src/main/java——核心代码
 *      src/main/resource——配置文件
 *      src/test/java——测试代码
 *      src/test/resource——测试配置文件
 *      src/main/webapp —— 页面资源 js css 图片...
 *
 *      target——mvn帮我们编译的out文件
 *      target/classes —— 编译输出的class文件存放地
 *
 * maven常用命令
 *      首先进入项目所在路径
 *      mvn clean —— 删除编译好的 class 文件等
 *      mvn compile —— 编译项目，生成 target 文件夹
 *      mvn test —— 生成了test代码，并运行了测试，生成测试报告。同时执行了 mvn compile
 *      mvn package —— 打包 war 包。正式和测试代码都编译了
 *      mvn install —— 打包，并把 war包 复制到了本地仓库
 *      mvn deploy —— 发部，需要配置
 *
 * maven生命周期
 *      清除编译信息 clean    —— 清理生命周期
 *
 *      编译 compile          ——以下为 默认生命周期
 *      测试 test
 *      打包 package
 *      安装 install
 *      发部 deploy
 *      ？？？                 —— 站点生命周期
 *
 * maven概念模型图
 *      pom.xml --> 项目对象模型POM  <-----> 依赖管理模型  --->三个仓库
 *              ---------  构建 build lifecycle 生命周期     -------
 *      plug-in plug-in plug-in plug-in plug-in plug-in plug-in —— 每一个mvn命令 对应一个底层插件
 *      源文件 中间产出文件 资源文件 二进制文件 打包产出物 ——
 *
 *
 *      项目对象模型POM 即 pom.xml 文件 ——
 *          项目自身信息 、 依赖坐标 、 插件(运行环境信息)(maven自己插件 、 tomcat插件)
 *
 *      依赖管理模型 —— 即 pom.xml  中防止的 依赖坐标
 *          1. 公司组织名称 groupId
 *          2. 项目名  artifactId
 *          3. 版本号  version
 *
 *
 * 893
 * ideaJ 如何集成 maven 插件
 *      maven 设置 指定目录 setting.xml文件 即可
 *      -DarchetypeCatalog=internal 不用每次都联网下载jar包了 runner设定
 *
 *
 *
 *
 */


public class D0909Maven {
}
