package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 完成Redis的整合的一些配置
 * @author sunxiaozhe
 * @time 2018/8/7 19:42
 */
@Configuration
public class RedisConfig {

    /**
     * 1.创建JedisPoolConfig对象，在改对象中完成一些连接池配置
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis.jedis.pool")
    public JedisPoolConfig jedisPoolConfig(){

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        /*//最大空闲数
        jedisPoolConfig.setMaxIdle(10);
        //最小空闲数
        jedisPoolConfig.setMinIdle(5);
        //最大连接数
        jedisPoolConfig.setMaxTotal(20);*/

        System.out.println("默认值："+jedisPoolConfig.getMaxIdle());
        System.out.println("默认值："+jedisPoolConfig.getMinIdle());
        System.out.println("默认值："+jedisPoolConfig.getMaxTotal());

        return jedisPoolConfig;
    }

    /**
     * 2. 创建JedisConnectionFactory,配置redis连接信息
     * @ConfigurationProperties:会将前缀相同的内容创建一个实体
     *
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config){

        System.out.println("配置完毕："+config.getMaxIdle());
        System.out.println("配置完毕："+config.getMinIdle());
        System.out.println("配置完毕："+config.getMaxTotal());

        JedisConnectionFactory factory = new JedisConnectionFactory();
        //关联链接池的配置对象
        factory.setPoolConfig(config);
        //配置链接redis的信息
        //主机地址
        /*factory.setHostName("127.0.0.1");
        //端口
        factory.setPort(6379);*/

        return factory;
    }

    /**
     * 3.创建RedisTemplate,用于执行redis操作的方法
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory){

        RedisTemplate<String,Object> template = new RedisTemplate<>();

        //关联
        template.setConnectionFactory(jedisConnectionFactory);

        //为Key设置序列化器
        template.setKeySerializer(new StringRedisSerializer());
        //为value设置序列化器
        template.setValueSerializer(new StringRedisSerializer());

        return template;
    }

}
