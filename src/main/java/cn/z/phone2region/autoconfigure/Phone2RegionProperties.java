package cn.z.phone2region.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <h1>手机号码转区域配置属性</h1>
 *
 * <p>
 * createDate 2023/03/23 15:43:49
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "phone2region")
public class Phone2RegionProperties {

    /**
     * 资源路径(优先级0)<br>
     * 读取项目文件夹resources下的路径
     */
    private String resourcePath;
    /**
     * 本地路径(优先级1)<br>
     * 读取本地物理路径
     */
    private String localPath;
    /**
     * URL路径(优先级2)<br>
     * 读取URL路径<br>
     * 例如：<code>https://www.404z.cn/files/phone2region/v2.0.0/data/phone2region.zdb</code>
     */
    private String urlPath;

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
}
