# Phone Number To Region Springboot Autoconfigure 手机号码转区域SpringBoot自动配置

[![License](https://img.shields.io/github/license/ali1416/phone2region-spring-boot-autoconfigure?label=License)](https://opensource.org/licenses/BSD-3-Clause)
[![Java Support](https://img.shields.io/badge/Java-8+-green)](https://openjdk.org/)
[![Maven Central](https://img.shields.io/maven-central/v/cn.404z/phone2region-spring-boot-autoconfigure?label=Maven%20Central)](https://mvnrepository.com/artifact/cn.404z/phone2region-spring-boot-autoconfigure)
[![Tag](https://img.shields.io/github/v/tag/ali1416/phone2region-spring-boot-autoconfigure?label=Tag)](https://github.com/ALI1416/phone2region-spring-boot-autoconfigure/tags)
[![Repo Size](https://img.shields.io/github/repo-size/ali1416/phone2region-spring-boot-autoconfigure?label=Repo%20Size&color=success)](https://github.com/ALI1416/phone2region-spring-boot-autoconfigure/archive/refs/heads/master.zip)

[![Java CI](https://github.com/ALI1416/phone2region-spring-boot-autoconfigure/actions/workflows/ci.yml/badge.svg)](https://github.com/ALI1416/phone2region-spring-boot-autoconfigure/actions/workflows/ci.yml)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=ALI1416_phone2region-spring-boot-autoconfigure&metric=coverage)
![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=ALI1416_phone2region-spring-boot-autoconfigure&metric=reliability_rating)
![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=ALI1416_phone2region-spring-boot-autoconfigure&metric=sqale_rating)
![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=ALI1416_phone2region-spring-boot-autoconfigure&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=ALI1416_phone2region-spring-boot-autoconfigure)

## 简介

本项目是[手机号码转区域](https://github.com/ALI1416/phone2region)的SpringBoot自动配置

## 依赖导入

```xml
<dependency>
  <groupId>cn.404z</groupId>
  <artifactId>phone2region-spring-boot-autoconfigure</artifactId>
  <version>2.0.0</version>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter</artifactId>
<version>2.7.9</version>
</dependency>
```

## 使用方法

常量

```java
final String zdbPath = "E:/phone2region.zdb";
final int phone = 1875471;
```

### 使用资源路径

配置文件

```yml
phone2region:
  resource-path: /file/phone2region/phone2region.zdb
```

代码

```java
log.info(String.valueOf(Phone2Region.parse(phone)));
log.info("是否已经初始化：{}", Phone2Region.initialized());
```

结果

```txt
[main] INFO c.z.p.a.Phone2RegionAutoConfiguration    : 读取到配置，RESOURCE_PATH为：/file/phone2region/phone2region.zdb
[main] INFO cn.z.phone2region.Phone2Region           : 数据加载成功，版本号为：20230225，校验码为：C8AEEA0A
[main] INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.442 seconds (JVM running for 0.931)
[main] INFO .z.p.a.Phone2RegionAutoConfigurationTest : Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
[main] INFO .z.p.a.Phone2RegionAutoConfigurationTest : 是否已经初始化：true
```

### 使用本地路径

配置文件

```yml
phone2region:
  local-path: E:/phone2region.zdb
```

代码

```java
log.info(String.valueOf(Phone2Region.parse(phone)));
```

结果

```txt
[main] INFO c.z.p.a.Phone2RegionAutoConfiguration    : 读取到配置，LOCAL_PATH为：E:/phone2region.zdb
[main] INFO cn.z.phone2region.Phone2Region           : 初始化，文件路径为：E:/phone2region.zdb
[main] INFO cn.z.phone2region.Phone2Region           : 数据加载成功，版本号为：20230225，校验码为：C8AEEA0A
[main] INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.442 seconds (JVM running for 0.931)
[main] INFO .z.p.a.Phone2RegionAutoConfigurationTest : Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
```

### 使用url路径

配置文件

```yml
phone2region:
  url-path: https://cdn.jsdelivr.net/gh/ali1416/phone2region@2.0.0/data/phone2region.zdb
```

代码

```java
log.info(String.valueOf(Phone2Region.parse(phone)));
```

结果

```txt
[main] INFO c.z.p.a.Phone2RegionAutoConfiguration    : 读取到配置，URL_PATH为：https://cdn.jsdelivr.net/gh/ali1416/phone2region@2.0.0/data/phone2region.zdb
[main] INFO cn.z.phone2region.Phone2Region           : 初始化，URL路径为：https://cdn.jsdelivr.net/gh/ali1416/phone2region@2.0.0/data/phone2region.zdb
[main] INFO cn.z.phone2region.Phone2Region           : 数据加载成功，版本号为：20230225，校验码为：C8AEEA0A
[main] INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.442 seconds (JVM running for 0.931)
[main] INFO .z.p.a.Phone2RegionAutoConfigurationTest : Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
```

### 优先级

配置文件

```yml
phone2region:
  resource-path: /file/phone2region/phone2region.zdb
  local-path: E:/phone2region.zdb
  url-path: https://cdn.jsdelivr.net/gh/ali1416/phone2region@2.0.0/data/phone2region.zdb
```

代码

```java
log.info(String.valueOf(Phone2Region.parse(phone)));
```

结果

```txt
[main] INFO c.z.p.a.Phone2RegionAutoConfiguration    : 读取到配置，RESOURCE_PATH为：/file/phone2region/phone2region.zdb
[main] INFO cn.z.phone2region.Phone2Region           : 数据加载成功，版本号为：20230225，校验码为：C8AEEA0A
[main] INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.442 seconds (JVM running for 0.931)
[main] INFO .z.p.a.Phone2RegionAutoConfigurationTest : Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
```

### 没有配置

配置文件

```yml
# 不需要配置
```

代码

```java
log.info(String.valueOf(Phone2Region.parse(phone)));
```

结果

```txt
[main]  INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.442 seconds (JVM running for 0.931)
[main] ERROR cn.z.phone2region.Phone2Region           : 未初始化！
[main]  INFO .z.p.a.Phone2RegionAutoConfigurationTest : null
```

### 配置错误

配置文件

```yml
phone2region:
  resource-path: /file/phone2region/phone2region
```

代码

```java
log.info(String.valueOf(Phone2Region.parse(phone)));
```

结果

```txt
[main]  INFO c.z.p.a.Phone2RegionAutoConfiguration    : 读取到配置，RESOURCE_PATH为：/file/phone2region/phone2region
[main] ERROR cn.z.phone2region.Phone2Region           : 资源文件异常！
java.io.FileNotFoundException: class path resource [file/phone2region/phone2region] cannot be opened because it does not exist
[main] ERROR o.s.boot.SpringApplication               : Application run failed
```

### 配置属性后又手动初始化

配置文件

```yml
phone2region:
  resource-path: /file/phone2region/phone2region.zdb
```

代码

```java
Phone2Region.initByFile("E:/phone2region.zdb");
log.info(String.valueOf(Phone2Region.parse(phone)));
```

结果

```txt
[main] INFO c.z.p.a.Phone2RegionAutoConfiguration    : 读取到配置，RESOURCE_PATH为：/file/phone2region/phone2region.zdb
[main] INFO cn.z.phone2region.Phone2Region           : 数据加载成功，版本号为：20230225，校验码为：C8AEEA0A
[main] INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.442 seconds (JVM running for 0.931)
[main] WARN cn.z.phone2region.Phone2Region           : 已经初始化过了，不可重复初始化！
[main] INFO .z.p.a.Phone2RegionAutoConfigurationTest : Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
```

## 交流

- [x] QQ：`1416978277`
- [x] 微信：`1416978277`
- [x] 支付宝：`1416978277@qq.com`

![交流](https://cdn.jsdelivr.net/gh/ALI1416/ALI1416/image/contact.png)

## 赞助

![赞助](https://cdn.jsdelivr.net/gh/ALI1416/ALI1416/image/donate.png)
