package MySQL.连接池;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.lang.model.SourceVersion;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 *  C3P0 学习
 *
 * 第一步：定义配置文件 (配置文件万岁)
 *      c3p0.properties
 *      c3p0-config.xml
 *    路径默认在classpath下，编码时在src下
 */

public class C3P0Test {
    public static void main(String[] args) throws Exception{
        //创建核心对象
//        DataSource dataSource = new ComboPooledDataSource();
        DataSource dataSource = new ComboPooledDataSource("zrx");
        //补充硬编码 而是xml文件配置
//        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/school?serverTimezone=Asia/Shanghai");
//        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
//        dataSource.setUser("root");
//        dataSource.setPassword("123456");

        //获取连接，getConn
//        final Connection connection = dataSource.getConnection();
        //7月 29, 2019 3:32:56 下午 com.mchange.v2.log.MLog
        //信息: MLog clients using java 1.4+ standard logging.
        //7月 29, 2019 3:32:57 下午 com.mchange.v2.c3p0.C3P0Registry
        //信息: Initializing c3p0-0.9.5.4 [built 23-March-2019 23:00:48 -0700; debug? true; trace: 10]
        //7月 29, 2019 3:32:57 下午 com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource
        //信息: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 3, acquireRetryAttempts -> 30, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> false, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1hgfbb5a4gts5ft18shev3|5c7fa833, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.mysql.cj.jdbc.Driver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hgfbb5a4gts5ft18shev3|5c7fa833, idleConnectionTestPeriod -> 0, initialPoolSize -> 10, jdbcUrl -> jdbc:mysql://localhost:3306/school?serverTimezone=Asia/Shanghai, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 10, maxStatements -> 0, maxStatementsPerConnection -> 0, minPoolSize -> 2, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {password=******, user=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ]
        //connection = com.mchange.v2.c3p0.impl.NewProxyConnection@79b06cab [wrapping: com.mysql.cj.jdbc.ConnectionImpl@3eb7fc54]

//        System.out.println("connection = " + connection);


        for (int i = 0; i < 11; i++) {
            final Connection connection = dataSource.getConnection();
            System.out.println("i  connection = "+i+" " + connection);

            if(i==5)
                connection.close();
        }
        //最大10个
        //i  connection = 0 com.mchange.v2.c3p0.impl.NewProxyConnection@5be6e01c [wrapping: com.mysql.cj.jdbc.ConnectionImpl@1c93084c]
        //i  connection = 1 com.mchange.v2.c3p0.impl.NewProxyConnection@10e92f8f [wrapping: com.mysql.cj.jdbc.ConnectionImpl@7ce3cb8e]
        //i  connection = 2 com.mchange.v2.c3p0.impl.NewProxyConnection@5223e5ee [wrapping: com.mysql.cj.jdbc.ConnectionImpl@bef2d72]
        //i  connection = 3 com.mchange.v2.c3p0.impl.NewProxyConnection@22a637e7 [wrapping: com.mysql.cj.jdbc.ConnectionImpl@6fe7aac8]
        //i  connection = 4 com.mchange.v2.c3p0.impl.NewProxyConnection@659a969b [wrapping: com.mysql.cj.jdbc.ConnectionImpl@76908cc0]
        //i  connection = 5 com.mchange.v2.c3p0.impl.NewProxyConnection@35047d03 [wrapping: com.mysql.cj.jdbc.ConnectionImpl@49b0b76]
        //i  connection = 6 com.mchange.v2.c3p0.impl.NewProxyConnection@4c9f8c13 [wrapping: com.mysql.cj.jdbc.ConnectionImpl@5ae50ce6]
        //i  connection = 7 com.mchange.v2.c3p0.impl.NewProxyConnection@be64738 [wrapping: com.mysql.cj.jdbc.ConnectionImpl@3ba9ad43]
        //i  connection = 8 com.mchange.v2.c3p0.impl.NewProxyConnection@48e4374 [wrapping: com.mysql.cj.jdbc.ConnectionImpl@3d680b5a]
        //i  connection = 9 com.mchange.v2.c3p0.impl.NewProxyConnection@4a22f9e2 [wrapping: com.mysql.cj.jdbc.ConnectionImpl@3c419631]
    }


}
