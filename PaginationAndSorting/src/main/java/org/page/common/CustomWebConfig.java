package org.page.common;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CustomWebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		PageableHandlerMethodArgumentResolver pageResolver = new PageableHandlerMethodArgumentResolver();
		pageResolver.setPageParameterName("page-number");
		pageResolver.setSizeParameterName("page-size");
		pageResolver.setOneIndexedParameters(true);
		PageRequest request = PageRequest.of(0, 20);
		pageResolver.setFallbackPageable(request);
//		Pageable defaultPage = new Pageable(0,  10);
//		pageResolver.setFallbackPageable(defaultPage);
		
		argumentResolvers.add(pageResolver);
	}

}
