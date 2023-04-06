package cn.z.phone2region.autoconfigure;

import cn.z.phone2region.Phone2Region;
import cn.z.phone2region.Phone2RegionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;

/**
 * <h1>手机号码转区域自动配置</h1>
 *
 * <p>
 * createDate 2023/03/23 15:43:49
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 **/
@Configuration
@EnableConfigurationProperties(Phone2RegionProperties.class)
public class Phone2RegionAutoConfiguration {

    /**
     * 日志实例
     */
    private static final Logger log = LoggerFactory.getLogger(Phone2RegionAutoConfiguration.class);
    /**
     * Phone2RegionProperties
     */
    private final Phone2RegionProperties phone2RegionProperties;

    /**
     * 构造函数(自动注入)
     *
     * @param phone2RegionProperties Phone2RegionProperties
     */
    public Phone2RegionAutoConfiguration(Phone2RegionProperties phone2RegionProperties) {
        this.phone2RegionProperties = phone2RegionProperties;
    }

    /**
     * 初始化
     */
    @PostConstruct
    public void init() {
        if (phone2RegionProperties.getResourcePath() != null) {
            log.info("读取到配置，RESOURCE_PATH为：{}", phone2RegionProperties.getResourcePath());
            try {
                Phone2Region.init(new ClassPathResource(phone2RegionProperties.getResourcePath()).getInputStream());
            } catch (Exception e) {
                log.error("资源文件异常！", e);
                throw new Phone2RegionException("资源文件异常！");
            }
        } else if (phone2RegionProperties.getLocalPath() != null) {
            log.info("读取到配置，LOCAL_PATH为：{}", phone2RegionProperties.getLocalPath());
            Phone2Region.initByFile(phone2RegionProperties.getLocalPath());
        } else if (phone2RegionProperties.getUrlPath() != null) {
            log.info("读取到配置，URL_PATH为：{}", phone2RegionProperties.getUrlPath());
            Phone2Region.initByUrl(phone2RegionProperties.getUrlPath());
        }
    }

}
