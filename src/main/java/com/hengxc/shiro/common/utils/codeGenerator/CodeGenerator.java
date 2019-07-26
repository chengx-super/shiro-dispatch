package com.hengxc.shiro.common.utils.codeGenerator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * @author Chengx
 * @date 2019-02-27 15:39:14
 * 代码生成器
 * https://mp.baomidou.com/guide/generator.html
 *
 * <p>
 * 读取控制台内容
 * </p>
 *
 * <p>
 * 读取控制台内容
 * </p>
 */

public class CodeGenerator {

    /*
     * <p>
     * 读取控制台内容
     * </p>
     */


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        //author
        gc.setAuthor("chenguangxu");
        gc.setDateType(DateType.TIME_PACK);
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();        //配置数据源
        dsc.setUrl("jdbc:mysql://localhost:3306/hengxc_base?serverTimezone=UTC");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));//模块名称自定义 可以不用每次输入
        pc.setModuleName("job");//模块名称自定义 可以不用每次输入
        pc.setParent("com.hengxc.shiro");//包路径
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                //自己生产代码需要修改的地方
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        //配置 common 包为自己的路径
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(/*pc.getModuleName() + */"t_");//去除表的前缀
//        strategy.setInclude(scanner("表名"));//表名自定义 可以用每次输入
        //生成表
//        strategy.setInclude("t_job_task_log");// 需要生成的表
        strategy.setInclude(new String[]{"t_login_log", "t_base_log"});// 需要生成的表可多个 "t_login_log","t_base_log"
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表

//        strategy.setSuperEntityColumns("id");//继承父类id

        //---------------------- 通用 父包路径
//        strategy.setSuperEntityClass("com.hengxc.shiro.common.tk.mybatis.base.BaseModel");
//        strategy.setSuperMapperClass("com.hengxc.shiro.common.tk.mybatis.base.BaseMapper");
//        strategy.setSuperServiceClass(null);
//        strategy.setSuperServiceImplClass("com.hengxc.shiro.common.tk.mybatis.base.BaseService");
        //-------------------------


        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

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

}
