package com.middleservice;

import com.middleservice.domain.RealUserApi;
import com.middleservice.domain.RuntimeMockUserApi;
import com.middleservice.domain.UserApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class UserApiConfig {
    @Bean
    @Profile("mock")
    public UserApi mockUserApi() {
        return new RuntimeMockUserApi();
    }

    @Bean
    @Profile("real")
    public UserApi realUserApi() {
        return new RealUserApi(); // Реальная реализация UserApi
    }
}
