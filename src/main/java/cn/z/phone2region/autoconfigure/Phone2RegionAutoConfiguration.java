package cn.z.phone2region.autoconfigure;

import cn.z.phone2region.Phone2Region;
import cn.z.phone2region.Phone2RegionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.ClassPathResource;

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
@EnableConfigurationProperties(Phone2RegionProperties.class)
public class Phone2RegionAutoConfiguration {

    /**
     * 日志实例
     */
    private static final Logger log = LoggerFactory.getLogger(Phone2RegionAutoConfiguration.class);

    /**
     * 构造函数(自动注入)
     *
     * @param phone2RegionProperties Phone2RegionProperties
     */
    public Phone2RegionAutoConfiguration(Phone2RegionProperties phone2RegionProperties) {
        if (phone2RegionProperties.getResourcePath() != null) {
            log.info("手机号码转区域配置：资源路径RESOURCE_PATH {}", phone2RegionProperties.getResourcePath());
            try {
                Phone2Region.init(new ClassPathResource(phone2RegionProperties.getResourcePath()).getInputStream());
            } catch (Exception e) {
                throw new Phone2RegionException("资源文件异常！", e);
            }
        } else if (phone2RegionProperties.getLocalPath() != null) {
            log.info("手机号码转区域配置：本地路径LOCAL_PATH {}", phone2RegionProperties.getLocalPath());
            Phone2Region.initByFile(phone2RegionProperties.getLocalPath());
        } else if (phone2RegionProperties.getUrlPath() != null) {
            log.info("手机号码转区域配置：URL路径URL_PATH {}", phone2RegionProperties.getUrlPath());
            Phone2Region.initByUrl(phone2RegionProperties.getUrlPath());
        }
    }

}
