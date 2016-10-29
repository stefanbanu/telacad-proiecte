/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.config;

import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

/**
 *
 * @author student
 */
@Configuration
@ComponentScan("ro.telacad.*")
@EnableCaching
public class ProjectConfig {

    @Bean
    @Autowired
    public EhCacheCacheManager cacheManager(CacheManager cm) {
        return new EhCacheCacheManager(cm);
    }

    @Bean
    public EhCacheManagerFactoryBean ehcache() {
        EhCacheManagerFactoryBean ehCacheFactoryBean
                = new EhCacheManagerFactoryBean();
        
        ehCacheFactoryBean.setConfigLocation(
                new FileSystemResource("C:\\Users\\student\\Documents\\NetBeansProjects\\java4c5e1\\src\\main\\java\\ro\\telacad\\config\\ehcache.xml"));
        
        return ehCacheFactoryBean;
    }
}
