package com.minjun.letswalk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // 개발 환경의 Vue 서버 주소를 명시적으로 허용
        config.addAllowedOrigin("http://localhost:5173");

        // 필요한 경우 추가 오리진 등록
        // config.addAllowedOrigin("http://localhost:3000");

        // 또는 모든 패턴 허용 (개발 환경에서만 사용할 것)
        // config.addAllowedOriginPattern("*");

        // 모든 헤더 허용
        config.addAllowedHeader("*");

        // 모든 HTTP 메소드 허용
        config.addAllowedMethod("*");

        // 인증 정보 (쿠키, 인증 헤더 등) 포함 허용
        config.setAllowCredentials(true);

        // preflight 요청 캐시 시간 설정 (선택사항)
        config.setMaxAge(3600L);

        // 모든 경로에 이 CORS 설정 적용
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}