package com.bao.lock;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class LocksApplication extends WebMvcConfigurerAdapter {
	
	@Bean
	public LocksController locksController(LockService lockService) {
		return new LocksController(lockService);
	}
	
	@ConditionalOnClass(RedisConnectionFactory.class)
	@ConditionalOnBean(RedisConnectionFactory.class)
	@Configuration
	protected static class RedisLockServiceConfiguration {
		@Bean
		@ConditionalOnMissingBean(LockService.class)
		public RedisLockService lockService(RedisConnectionFactory connectionFactory) {
			return new RedisLockService(connectionFactory);
		}
	}

	@ConditionalOnClass(RedisConnectionFactory.class)
	@ConditionalOnMissingBean(RedisConnectionFactory.class)
	@Configuration
	protected static class FallbackSimpleLockServiceConfiguration {
		@Bean
		@ConditionalOnMissingBean(LockService.class)
		public SimpleLockService lockService() {
			return new SimpleLockService();
		}
	}

	@ConditionalOnMissingClass(name="org.springframework.data.redis.connection.RedisConnectionFactory")
	@Configuration
	protected static class SimpleLockServiceConfiguration {
		@Bean
		@ConditionalOnMissingBean(LockService.class)
		public SimpleLockService lockService() {
			return new SimpleLockService();
		}
	}

}
