# Phone Number To Region Springboot Autoconfigure 手机号码转区域SpringBoot自动配置

[![License](https://img.shields.io/github/license/ALI1416/phone2region-spring-boot-autoconfigure?label=License)](https://www.apache.org/licenses/LICENSE-2.0.txt)
[![Java Support](https://img.shields.io/badge/Java-8+-green)](https://openjdk.org/)
[![Maven Central](https://img.shields.io/maven-central/v/cn.404z/phone2region-spring-boot-autoconfigure?label=Maven%20Central)](https://mvnrepository.com/artifact/cn.404z/phone2region-spring-boot-autoconfigure)
[![Tag](https://img.shields.io/github/v/tag/ALI1416/phone2region-spring-boot-autoconfigure?label=Tag)](https://github.com/ALI1416/phone2region-spring-boot-autoconfigure/tags)
[![Repo Size](https://img.shields.io/github/repo-size/ALI1416/phone2region-spring-boot-autoconfigure?label=Repo%20Size&color=success)](https://github.com/ALI1416/phone2region-spring-boot-autoconfigure/archive/refs/heads/master.zip)

[![Java CI](https://github.com/ALI1416/phone2region-spring-boot-autoconfigure/actions/workflows/ci.yml/badge.svg)](https://github.com/ALI1416/phone2region-spring-boot-autoconfigure/actions/workflows/ci.yml)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=ALI1416_phone2region-spring-boot-autoconfigure&metric=coverage)
![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=ALI1416_phone2region-spring-boot-autoconfigure&metric=reliability_rating)
![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=ALI1416_phone2region-spring-boot-autoconfigure&metric=sqale_rating)
![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=ALI1416_phone2region-spring-boot-autoconfigure&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=ALI1416_phone2region-spring-boot-autoconfigure)

## 简介

本项目是[手机号码转区域](https://github.com/ALI1416/phone2region)的SpringBoot自动配置

## 数据文件

- 数据文件目录：[点击查看](https://github.com/ALI1416/phone2region/tree/master/data)

## 依赖导入

```xml
<dependency>
  <groupId>cn.404z</groupId>
  <artifactId>phone2region-spring-boot-autoconfigure</artifactId>
  <version>2.3.0</version>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter</artifactId>
  <version>2.7.18</version>
</dependency>
```

## 使用方法

### 定义常量

```java
final String zdbPath = "E:/phone2region.zdb";
final int phone = 1875471;
```

### 使用资源路径

```java
// phone2region:
//   resource-path: /file/phone2region/phone2region.zdb
log.info(String.valueOf(Phone2Region.parse(phone)));
log.info("是否已经初始化：{}", Phone2Region.initialized());
// INFO c.z.p.a.Phone2RegionAutoConfiguration    : 手机号码转区域配置：资源路径RESOURCE_PATH /file/phone2region/phone2region.zdb
// INFO cn.z.phone2region.Phone2Region           : 数据加载成功：版本号VERSION 20230225 ，校验码CRC32 C8AEEA0A
// INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.86 seconds (JVM running for 2.316)
// INFO .z.p.a.Phone2RegionAutoConfigurationTest : Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
// INFO .z.p.a.Phone2RegionAutoConfigurationTest : 是否已经初始化：true
```

### 使用本地路径

```java
// phone2region:
//   local-path: E:/phone2region.zdb
log.info(String.valueOf(Phone2Region.parse(phone)));
// INFO c.z.p.a.Phone2RegionAutoConfiguration    : 手机号码转区域配置：本地路径LOCAL_PATH E:/phone2region.zdb
// INFO cn.z.phone2region.Phone2Region           : 手机号码转区域初始化：文件路径LOCAL_PATH E:/phone2region.zdb
// INFO cn.z.phone2region.Phone2Region           : 数据加载成功：版本号VERSION 20230225 ，校验码CRC32 C8AEEA0A
// INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.86 seconds (JVM running for 2.316)
// INFO .z.p.a.Phone2RegionAutoConfigurationTest : Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
```

### 使用url路径

```java
// phone2region:
//   url-path: https://www.404z.cn/files/phone2region/v2.0.0/data/phone2region.zdb
log.info(String.valueOf(Phone2Region.parse(phone)));
// INFO c.z.p.a.Phone2RegionAutoConfiguration    : 手机号码转区域配置：URL路径URL_PATH https://www.404z.cn/files/phone2region/v2.0.0/data/phone2region.zdb
// INFO cn.z.phone2region.Phone2Region           : 手机号码转区域初始化：URL路径URL_PATH https://www.404z.cn/files/phone2region/v2.0.0/data/phone2region.zdb
// INFO cn.z.phone2region.Phone2Region           : 数据加载成功：版本号VERSION 20230225 ，校验码CRC32 C8AEEA0A
// INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.86 seconds (JVM running for 2.316)
// INFO .z.p.a.Phone2RegionAutoConfigurationTest : Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
```

### 优先级

```java
// phone2region:
//   resource-path: /file/phone2region/phone2region.zdb
//   local-path: E:/phone2region.zdb
//   url-path: https://www.404z.cn/files/phone2region/v2.0.0/data/phone2region.zdb
log.info(String.valueOf(Phone2Region.parse(phone)));
// INFO c.z.p.a.Phone2RegionAutoConfiguration    : 手机号码转区域配置：资源路径RESOURCE_PATH /file/phone2region/phone2region.zdb
// INFO cn.z.phone2region.Phone2Region           : 数据加载成功：版本号VERSION 20230225 ，校验码CRC32 C8AEEA0A
// INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.86 seconds (JVM running for 2.316)
// INFO .z.p.a.Phone2RegionAutoConfigurationTest : Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
```

### 没有配置

```java
// # 不需要配置
log.info(String.valueOf(Phone2Region.parse(phone)));
// INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.86 seconds (JVM running for 2.316)
// cn.z.phone2region.Phone2RegionException: 未初始化！
```

### 配置错误

```java
// phone2region:
//   resource-path: /file/phone2region/phone2region
log.info(String.valueOf(Phone2Region.parse(phone)));
//  INFO  c.z.p.a.Phone2RegionAutoConfiguration    : 手机号码转区域配置：资源路径RESOURCE_PATH /file/phone2region/phone2region
// ERROR  c.z.p.a.Phone2RegionAutoConfiguration    : 资源文件异常！
// java.io.FileNotFoundException: class path resource [file/phone2region/phone2region] cannot be opened because it does not exist
```

### 配置属性后又手动初始化

```java
// phone2region:
//   resource-path: /file/phone2region/phone2region.zdb
Phone2Region.initByFile(zdbPath);
log.info(String.valueOf(Phone2Region.parse(phone)));
// INFO c.z.p.a.Phone2RegionAutoConfiguration    : 手机号码转区域配置：资源路径RESOURCE_PATH /file/phone2region/phone2region.zdb
// INFO cn.z.phone2region.Phone2Region           : 数据加载成功：版本号VERSION 20230225 ，校验码CRC32 C8AEEA0A
// INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.86 seconds (JVM running for 2.316)
// WARN cn.z.phone2region.Phone2Region           : 已经初始化过了，不可重复初始化！
// INFO .z.p.a.Phone2RegionAutoConfigurationTest : Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
```

更多请见[测试](./src/test)

## 更新日志

[点击查看](./CHANGELOG.md)

## 关于

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="https://www.404z.cn/images/about.dark.svg">
  <img alt="About" src="https://www.404z.cn/images/about.light.svg">
</picture>
