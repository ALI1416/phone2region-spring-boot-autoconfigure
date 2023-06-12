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
        log.info(String.valueOf(Phone2Region.parse(phone)));
        log.info("是否已经初始化：{}", Phone2Region.initialized());
        // [main] INFO c.z.p.a.Phone2RegionAutoConfiguration    :
        // 读取到配置，RESOURCE_PATH为：/file/phone2region/phone2region.zdb
        // [main] INFO cn.z.phone2region.Phone2Region           :
        // 数据加载成功，版本号为：20230225，校验码为：C8AEEA0A
        // [main] INFO .z.p.a.Phone2RegionAutoConfigurationTest :
        // Started Phone2RegionAutoConfigurationTest in 0.442 seconds (JVM running for 0.931)
        // [main] INFO .z.p.a.Phone2RegionAutoConfigurationTest :
        // Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
        // [main] INFO .z.p.a.Phone2RegionAutoConfigurationTest :
        // 是否已经初始化：true
    }

    /**
     * 使用本地路径
     */
    // @Test
    void test01Local() {
        log.info(String.valueOf(Phone2Region.parse(phone)));
        // [main] INFO c.z.p.a.Phone2RegionAutoConfiguration    :
        // 读取到配置，LOCAL_PATH为：E:/phone2region.zdb
        // [main] INFO cn.z.phone2region.Phone2Region           :
        // 初始化，文件路径为：E:/phone2region.zdb
        // [main] INFO cn.z.phone2region.Phone2Region           :
        // 数据加载成功，版本号为：20230225，校验码为：C8AEEA0A
        // [main] INFO .z.p.a.Phone2RegionAutoConfigurationTest :
        // Started Phone2RegionAutoConfigurationTest in 0.442 seconds (JVM running for 0.931)
        // [main] INFO .z.p.a.Phone2RegionAutoConfigurationTest :
        // Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
    }

    /**
     * 使用url路径
     */
    @Test
    void test02Url() {
        log.info(String.valueOf(Phone2Region.parse(phone)));
        // [main] INFO c.z.p.a.Phone2RegionAutoConfiguration    :
        // 读取到配置，URL_PATH为：https://www.404z.cn/files/phone2region/v2.0.0/data/phone2region.zdb
        // [main] INFO cn.z.phone2region.Phone2Region           :
        // 初始化，URL路径为：https://www.404z.cn/files/phone2region/v2.0.0/data/phone2region.zdb
        // [main] INFO cn.z.phone2region.Phone2Region           :
        // 数据加载成功，版本号为：20230225，校验码为：C8AEEA0A
        // [main] INFO .z.p.a.Phone2RegionAutoConfigurationTest :
        // Started Phone2RegionAutoConfigurationTest in 0.442 seconds (JVM running for 0.931)
        // [main] INFO .z.p.a.Phone2RegionAutoConfigurationTest :
        // Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
    }

    /**
     * 优先级
     */
    // @Test
    void test03Priority() {
        log.info(String.valueOf(Phone2Region.parse(phone)));
        // [main] INFO c.z.p.a.Phone2RegionAutoConfiguration    :
        // 读取到配置，RESOURCE_PATH为：/file/phone2region/phone2region.zdb
        // [main] INFO cn.z.phone2region.Phone2Region           :
        // 数据加载成功，版本号为：20230225，校验码为：C8AEEA0A
        // [main] INFO .z.p.a.Phone2RegionAutoConfigurationTest :
        // Started Phone2RegionAutoConfigurationTest in 0.442 seconds (JVM running for 0.931)
        // [main] INFO .z.p.a.Phone2RegionAutoConfigurationTest :
        // Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
    }

    /**
     * 没有配置
     */
    // @Test
    void test04None() {
        log.info(String.valueOf(Phone2Region.parse(phone)));
        // [main]  INFO .z.p.a.Phone2RegionAutoConfigurationTest :
        // Started Phone2RegionAutoConfigurationTest in 0.442 seconds (JVM running for 0.931)
        // [main] ERROR cn.z.phone2region.Phone2Region           :
        // 未初始化！
        // [main]  INFO .z.p.a.Phone2RegionAutoConfigurationTest :
        // null
    }

    /**
     * 配置错误
     */
    // @Test
    void test05Error() {
        log.info(String.valueOf(Phone2Region.parse(phone)));
        // [main]  INFO c.z.p.a.Phone2RegionAutoConfiguration    :
        // 读取到配置，RESOURCE_PATH为：/file/phone2region/phone2region
        // [main] ERROR cn.z.phone2region.Phone2Region           :
        // 资源文件异常！
        // java.io.FileNotFoundException: class path resource [file/phone2region/phone2region]
        // cannot be opened because it does not exist
        // [main] ERROR o.s.boot.SpringApplication               :
        // Application run failed
    }

    /**
     * 配置属性后又手动初始化
     */
    // @Test
    void test06Init() {
        Phone2Region.initByFile(zdbPath);
        log.info(String.valueOf(Phone2Region.parse(phone)));
        // [main] INFO c.z.p.a.Phone2RegionAutoConfiguration    :
        // 读取到配置，RESOURCE_PATH为：/file/phone2region/phone2region.zdb
        // [main] INFO cn.z.phone2region.Phone2Region           :
        // 数据加载成功，版本号为：20230225，校验码为：C8AEEA0A
        // [main] INFO .z.p.a.Phone2RegionAutoConfigurationTest :
        // Started Phone2RegionAutoConfigurationTest in 0.442 seconds (JVM running for 0.931)
        // [main] WARN cn.z.phone2region.Phone2Region           :
        // 已经初始化过了，不可重复初始化！
        // [main] INFO .z.p.a.Phone2RegionAutoConfigurationTest :
        // Region{province='山东', city='济宁', zipCode='272000', areaCode='0537', isp='移动'}
    }

}
