package com.example.demo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.nio.file.Paths;

public class CodeGenerator {

    public static void main(String[] args) {


        FastAutoGenerator.create("jdbc:mysql://localhost:3306/test", "root", "123456")
                .globalConfig(builder -> builder
                        .author("Baomidou")
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java")
                        .commentDate("yyyy-MM-dd").enableSwagger()
                )
                .packageConfig(builder -> builder
                        .parent("com.baomidou.mybatisplus")
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .controller("controller")
                        .xml("mapper.xml")
                )
                .strategyConfig(builder -> builder
                        .entityBuilder()
                        .enableLombok().enableFileOverride()
                        .javaTemplate("/my_templates/entity.java.vm")
                        .controllerBuilder().template("/my_templates/controller.java.vm")
                        .serviceBuilder()
                        .serviceTemplate("/my_templates/service.java.vm")
                        .serviceImplTemplate("/my_templates/serviceImpl.java.vm")
                        .mapperBuilder()
                        .mapperTemplate("/my_templates/mapper.java.vm")
                        .mapperXmlTemplate("/my_templates/mapper.xml.vm")
                )
                .templateEngine(new VelocityTemplateEngine())
                .execute();
    }


}
