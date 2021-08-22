package com.bigboss;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.IFill;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Property;

public class CodeGenerator {


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg =
                new AutoGenerator(new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/ex-wife?useUnicode=true" +
                        "&characterEncoding=UTF-8", "dev", "dev").build());

        // 全局配置
        mpg.global(new GlobalConfig.Builder().outputDir(System.getProperty("user.dir") + "/src/main/java").author(
                "bigboss").openDir(false).dateType(DateType.ONLY_DATE).fileOverride().build());

        // 包配置
        mpg.packageInfo(new PackageConfig.Builder("com", "bigboss")
                .entity("entity").mapper("mapper").service("service").controller("controller").build());

        mpg.strategy(new StrategyConfig.Builder()
                .enableCapitalMode().addTablePrefix("t_").addInclude("t_run_steps")
                .entityBuilder()
                .naming(NamingStrategy.underline_to_camel)
                .enableLombok()
                .idType(IdType.AUTO)
                .addTableFills(new Property("createAt", FieldFill.INSERT))
                .addTableFills(new Property("updateAt", FieldFill.INSERT_UPDATE))
                .columnNaming(NamingStrategy.underline_to_camel)
                .controllerBuilder()
                .enableRestStyle()
                .build());

        mpg.execute();
    }

}
