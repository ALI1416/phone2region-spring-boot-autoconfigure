package cn.z.phone2region.autoconfigure;

import cn.z.phone2region.Phone2Region;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <h1>手机号码转区域SpringBoot自动配置测试</h1>
 *
 * <p>
 * createDate 2023/03/23 15:43:49
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 **/
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootApplication
@SpringBootTest
@Slf4j
class Phone2RegionAutoConfigurationTest {

    final String zdbPath = "E:/phone2region.zdb";
    final int phone = 1875471;

    /**
     * 使用资源路径
     */
    // @Test
    void test00Resource() {
        // phone2region:
        //   resource-path: /file/phone2region/phone2region.zdb
        log.info(String.valueOf(Phone2Region.parse(phone)));
        log.info("是否已经初始化：{}", Phone2Region.initialized());
        // INFO c.z.p.a.Phone2RegionAutoConfiguration    : 手机号码转区域配置：资源路径RESOURCE_PATH /file/phone2region/phone2region.zdb
        // INFO cn.z.phone2region.Phone2Region           : 数据加载成功：版本号VERSION 20230225 ，校验码CRC32 C8AEEA0A
        // INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.86 seconds (JVM running for 2.316)
        // INFO .z.p.a.Phone2RegionAutoConfigurationTest : Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
        // INFO .z.p.a.Phone2RegionAutoConfigurationTest : 是否已经初始化：true
    }

    /**
     * 使用本地路径
     */
    // @Test
    void test01Local() {
        // phone2region:
        //   local-path: E:/phone2region.zdb
        log.info(String.valueOf(Phone2Region.parse(phone)));
        // INFO c.z.p.a.Phone2RegionAutoConfiguration    : 手机号码转区域配置：本地路径LOCAL_PATH E:/phone2region.zdb
        // INFO cn.z.phone2region.Phone2Region           : 手机号码转区域初始化：文件路径LOCAL_PATH E:/phone2region.zdb
        // INFO cn.z.phone2region.Phone2Region           : 数据加载成功：版本号VERSION 20230225 ，校验码CRC32 C8AEEA0A
        // INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.86 seconds (JVM running for 2.316)
        // INFO .z.p.a.Phone2RegionAutoConfigurationTest : Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
    }

    /**
     * 使用url路径
     */
    @Test
    void test02Url() {
        // phone2region:
        //   url-path: https://www.404z.cn/files/phone2region/v2.0.0/data/phone2region.zdb
        log.info(String.valueOf(Phone2Region.parse(phone)));
        // INFO c.z.p.a.Phone2RegionAutoConfiguration    : 手机号码转区域配置：URL路径URL_PATH https://www.404z.cn/files/phone2region/v2.0.0/data/phone2region.zdb
        // INFO cn.z.phone2region.Phone2Region           : 手机号码转区域初始化：URL路径URL_PATH https://www.404z.cn/files/phone2region/v2.0.0/data/phone2region.zdb
        // INFO cn.z.phone2region.Phone2Region           : 数据加载成功：版本号VERSION 20230225 ，校验码CRC32 C8AEEA0A
        // INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.86 seconds (JVM running for 2.316)
        // INFO .z.p.a.Phone2RegionAutoConfigurationTest : Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
    }

    /**
     * 优先级
     */
    // @Test
    void test03Priority() {
        // phone2region:
        //   resource-path: /file/phone2region/phone2region.zdb
        //   local-path: E:/phone2region.zdb
        //   url-path: https://www.404z.cn/files/phone2region/v2.0.0/data/phone2region.zdb
        log.info(String.valueOf(Phone2Region.parse(phone)));
        // INFO c.z.p.a.Phone2RegionAutoConfiguration    : 手机号码转区域配置：资源路径RESOURCE_PATH /file/phone2region/phone2region.zdb
        // INFO cn.z.phone2region.Phone2Region           : 数据加载成功：版本号VERSION 20230225 ，校验码CRC32 C8AEEA0A
        // INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.86 seconds (JVM running for 2.316)
        // INFO .z.p.a.Phone2RegionAutoConfigurationTest : Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
    }

    /**
     * 没有配置
     */
    // @Test
    void test04None() {
        // # 不需要配置
        log.info(String.valueOf(Phone2Region.parse(phone)));
        // INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.86 seconds (JVM running for 2.316)
        // cn.z.phone2region.Phone2RegionException: 未初始化！
    }

    /**
     * 配置错误
     */
    // @Test
    void test05Error() {
        // phone2region:
        //   resource-path: /file/phone2region/phone2region
        log.info(String.valueOf(Phone2Region.parse(phone)));
        //  INFO  c.z.p.a.Phone2RegionAutoConfiguration    : 手机号码转区域配置：资源路径RESOURCE_PATH /file/phone2region/phone2region
        // ERROR  c.z.p.a.Phone2RegionAutoConfiguration    : 资源文件异常！
        // java.io.FileNotFoundException: class path resource [file/phone2region/phone2region] cannot be opened because it does not exist
    }

    /**
     * 配置属性后又手动初始化
     */
    // @Test
    void test06Init() {
        // phone2region:
        //   resource-path: /file/phone2region/phone2region.zdb
        Phone2Region.initByFile(zdbPath);
        log.info(String.valueOf(Phone2Region.parse(phone)));
        // INFO c.z.p.a.Phone2RegionAutoConfiguration    : 手机号码转区域配置：资源路径RESOURCE_PATH /file/phone2region/phone2region.zdb
        // INFO cn.z.phone2region.Phone2Region           : 数据加载成功：版本号VERSION 20230225 ，校验码CRC32 C8AEEA0A
        // INFO .z.p.a.Phone2RegionAutoConfigurationTest : Started Phone2RegionAutoConfigurationTest in 0.86 seconds (JVM running for 2.316)
        // WARN cn.z.phone2region.Phone2Region           : 已经初始化过了，不可重复初始化！
        // INFO .z.p.a.Phone2RegionAutoConfigurationTest : Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
    }

}
