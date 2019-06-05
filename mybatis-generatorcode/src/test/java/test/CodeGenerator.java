package test;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.IOException;
import java.util.Scanner;

/**
 * mybatis代码生成器
 */
public class CodeGenerator {
    /**
     * 读取控制台内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    private static String parentPackage = "com.my.test2";
    private static String url = "jdbc:oracle:thin:@//192.168.43.239:1521/orcl11g.us.oracle.com";

    //private static String url = "jdbc:oracle:thin:@//192.168.3.14:1521/orcl11g.us.oracle.com";
    private static String driverName = "oracle.jdbc.driver.OracleDriver";
    private static String userName = "test";
    private static String pwd = "123456";
    private static String author = "lantian";
    private static String[] tableNames = {"STUDENT"};

    private static String projectPath = "D:/test2";


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        if (org.apache.commons.lang3.StringUtils.isBlank(projectPath)) {
            projectPath = System.getProperty("user.dir");
        }
        gc.setOutputDir(projectPath + "/mybatis-generatorcode/src/main/java");//生成文件的输出目录
        gc.setAuthor(author);//开发人员
        gc.setOpen(false);//是否打开输出目录
        gc.setServiceName("%sService");//service 命名方式
        gc.setServiceImplName("%sServiceImpl");//service impl 命名方式
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setSwagger2(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        //gc.setIdType(IdType.ID_WORKER);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&useSSL=false&characterEncoding=utf8");
//        // dsc.setSchemaName("public"); 数据库 schema name
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("123456");
        dsc.setUrl(url);
        dsc.setDriverName(driverName);
        dsc.setUsername(userName);
        dsc.setPassword(pwd);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));//父包模块名
        pc.setParent(parentPackage);//父包名。// 自定义包路径  如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setEntity("entity");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");//设置控制器包名
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 自定义配置
/*        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });*/
 /*       cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);*/
        //mpg.setTemplate(new TemplateConfig().setXml(null));

        TemplateConfig tc = new TemplateConfig();
//        tc.setController("/templates/controller.java.vm");
//        tc.setService("/templates/service.java.vm");
//        tc.setServiceImpl("/templates/serviceImpl.java.vm");
        tc.setEntity("/templatesMybatis/entity.java.vm");
//        tc.setMapper("/templates/mapper.java.vm");
        // tc.setXml("/templatesMybatis/mapper.xml.vm");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        mpg.setTemplate(tc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy
                .setCapitalMode(true)
                .setEntityLombokModel(true)
                // .setDbColumnUnderline(true) 改为如下 2 个配置
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setFieldPrefix(null)//test_id -> id, test_type -> type
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
//        //数据库表映射到实体的命名策略
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        //自定义继承的Entity类全称，带包名
        strategy.setSuperEntityClass("com.my.common.entity.BaseEntity");
//        //【实体】是否为lombok模型（默认 false）
//        strategy.setEntityLombokModel(true);
//        //生成 @RestController 控制器
//        strategy.setRestControllerStyle(true);
//        //自定义继承的Controller类全称，带包名
//        strategy.setSuperControllerClass("com.my.common.controller.BaseController");
//        //需要包含的表名，允许正则表达式
//        strategy.setInclude("STUDENT");
//        //自定义基础的Entity类，公共字段
//        strategy.setSuperEntityColumns("id");
//        //驼峰转连字符
//        strategy.setControllerMappingHyphenStyle(false);

        //strategy.setTablePrefix("tb_");//表前缀
        mpg.setStrategy(strategy);
        //mpg.setTemplateEngine(new FreemarkerTemplateEngine());


        mpg.execute();

        try {
            Runtime.getRuntime().exec("start " + projectPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}