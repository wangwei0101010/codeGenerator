// 该文件是样本文件，用作参考。不要直接进行修改提交。
// 可将该文件复制为，同目录下的MyCodeGenerator.java.

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @Author: xulihui
 * @CreateTime: 2020/8/29 15:24
 * @Description: 该文件是样本文件，用作参考。不要直接进行修改提交。 可将该文件复制为，同目录下的MyCodeGenerator.java.
 */
public class CodeGenerator {

  public static void main(String[] args) throws Exception {
    //1、包的配置
    String packageName = "iotdevicemgt";
    String parentPackagename = "simplecode.bizcom";
    String tables = "T_CONTRACT";

    PackageConfig packageInfo = new PackageConfig();
    packageInfo.setModuleName(packageName)
        .setParent(parentPackagename)
        .setEntity("entity")
        .setMapper("dao")
        .setService("service")
        .setController("controller")
        .setXml("dao");

    //2、设置数据源 mysql配置
    DataSourceConfig dataSource = new DataSourceConfig();
    dataSource.setDbType(DbType.MYSQL) // 设置数据源类型
        .setDriverName("com.mysql.jdbc.Driver")
        .setUrl(
            "jdbc:mysql://47.92.155.150:12306/sunboxiot?characterEncoding=UTF-8&serverTimezone=GMT%2B8")
        .setUsername("root")
        .setPassword("PFxcd123$%^");

/*    //2、设置数据源 oracle配置
    DataSourceConfig dataSource = new DataSourceConfig();
    dataSource.setDbType(DbType.ORACLE) // 设置数据源类型
        .setDriverName("oracle.jdbc.driver.OracleDriver")
        .setUrl("jdbc:oracle:thin:@11.10.143.36:1521:orcl")
        .setUsername("db_contract")
        .setPassword("cnpc-contract@#.2022");*/

    // 3、全局配置
    String projectPath = System.getProperty("user.dir");
    GlobalConfig gc = new GlobalConfig();
    gc.setActiveRecord(false)// 是否支持ActiveRecord模式
        .setOutputDir(projectPath + "/generatedcodes")
        .setAuthor("WangWei")
        .setOpen(false)
        .setFileOverride(true)// 文件是否覆盖
        .setServiceName("%sService")// 去Service接口名称的I前缀
        .setIdType(IdType.AUTO)// 主键生成策略
        .setDateType(DateType.TIME_PACK)
        .setSwagger2(true)
        .setBaseResultMap(true)//基本的resultMap对象
        .setBaseColumnList(true)//基本的 sql对象
    // 自定义文件命名，注意 %s 会自动填充表实体属性！
    // .setMapperName("%sDao")
    // .setXmlName("%sMapper")
    // .setServiceName("MP%sService")
    // .setServiceImplName("%sServiceDiy")
    // .setControllerName("%sAction")
    ;

    //4、策略配置
    StrategyConfig strategy = new StrategyConfig();
    strategy.setCapitalMode(true)// 全局大小写 命名
        .setNaming(NamingStrategy.underline_to_camel)// 数据表转驼峰的命名策略
        .setColumnNaming(NamingStrategy.underline_to_camel)
        //.setTablePrefix("t_")//表名前缀,一般项目不要!!!!!!!!!!!!!!!!!!!!
        .setEntityLombokModel(true) // 自动lombok；
        .setLogicDeleteFieldName("deleted")
//                .setTablePrefix("t_mhpt")// 表前缀
        .setInclude(tables.replace("，", ",").split(",")) // 逆向工程生成的表
//                .setExclude("flyway_schema_history")
        .setVersionFieldName("version") // 乐观锁
        .setRestControllerStyle(true)
        .setControllerMappingHyphenStyle(true)
        // .setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        // .setSuperEntityClass("com.baomidou.demo.TestEntity")
        // 自定义实体，公共字段
        // .setSuperEntityColumns(new String[] { "test_id", "age" })
        // 自定义 mapper 父类
        // .setSuperMapperClass("com.baomidou.demo.TestMapper")
        // 自定义 service 父类
        // .setSuperServiceClass("com.baomidou.demo.TestService")
        // 自定义 service 实现类父类
        // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
        // 自定义 controller 父类
        // .setSuperControllerClass("com.baomidou.demo.TestController")
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        .setEntityColumnConstant(true);
    // 【实体】是否为构建者模型（默认 false）
    // public User setName(String name) {this.name = name; return this;}
    strategy.setChainModel(true)
    ;

//        TemplateConfig tc = new TemplateConfig();
//        tc.setXml(null);

    // .需要构建一个 代码自动生成器 对象
    AutoGenerator autoGenerator = new AutoGenerator();
    autoGenerator.setGlobalConfig(gc)
        .setDataSource(dataSource)
        .setPackageInfo(packageInfo)
        .setStrategy(strategy)
//                .setTemplate(tc)
        .execute(); //执行

    System.out.println("Done!");
    System.out.println(projectPath + "/generatedcodes");
    System.out.println();
  }

//
//    public static void main(String[] args) {
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        //String projectPath = scanner("生成路径"); //生成路径改为从控制台输入
//        String runningFolder = System.getProperty("user.dir");
//        gc.setOutputDir( runningFolder + "/codegenerator/codes");
//        gc.setFileOverride(true);
//        //ActiveRecord特性
//        gc.setActiveRecord(false);
//        // XML ResultMap
//        gc.setBaseResultMap(true);
//        // XML columList
//        gc.setBaseColumnList(true);
//        gc.setEnableCache(false);
//        // 自动打开输出目录
//        gc.setOpen(false);
//        gc.setAuthor("pangu");
//        gc.setSwagger2(true);
//        //主键策略
//        gc.setIdType(IdType.AUTO);
//        // 自定义文件命名，注意 %s 会自动填充表实体属性！
//        gc.setServiceName("I%sService");
//        gc.setServiceImplName("%sServiceImpl");
//        gc.setMapperName("%sMapper");
//        gc.setXmlName("%sMapper");
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://172.16.2.139:3306/test2?characterEncoding=UTF-8&serverTimezone=GMT%2B8")
//                .setUsername("root")
//                .setPassword("123");
//        // dsc.setSchemaName("public");
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        // pc.setModuleName(scanner("模块名"));
//        // 此处设置包名，需要自定义
//        pc.setParent("sssss");
//        mpg.setPackageInfo(pc);
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//
//        // 如果模板引擎是 freemarker
//        // String templatePath = "/templates/mapper.xml.ftl";
//        // 如果模板引擎是 velocity
//        String templatePath = "/templates/mapper.xml.vm";
//
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return gc.getOutputDir() + StringPool.SLASH + pc.getParent().replace(".", StringPool.SLASH) + "/mapper/"
//                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        /*
//        cfg.setFileCreate(new IFileCreate() {
//            @Override
//            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
//                // 判断自定义文件夹是否需要创建
//                checkDir("调用默认方法创建的目录");
//                return false;
//            }
//        });
//        */
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//
//        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//
//        // 配置自定义输出模板
//        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//        // templateConfig.setEntity("templates/entity2.java");
//        // templateConfig.setService();
//        // templateConfig.setController();
//
//        templateConfig.setXml(null);
//        mpg.setTemplate(templateConfig);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("vip.mate.core.database.entity.BaseEntity");
//        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
//        // 公共父类
//        strategy.setSuperControllerClass("vip.mate.core.web.controller.BaseController");
//        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
//        strategy.setInclude("user");
//        strategy.setControllerMappingHyphenStyle(true);
////        strategy.setTablePrefix("t_");
//        // strategy.setTablePrefix(pc.getModuleName() + "_");
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new VelocityTemplateEngine());
//        mpg.execute();
//
//        System.out.println("Done.");
//    }

}
