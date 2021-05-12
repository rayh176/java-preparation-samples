package org.example.orderbook.config;

import org.apache.avro.specific.SpecificRecordBase;
import org.example.orderbook.schema.AvroJsonHttpMessageConverter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class ConverterConfig extends WebMvcConfigurationSupport /*WebMvcConfigurerAdapter*/ {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(new AvroJsonHttpMessageConverter<SpecificRecordBase>());
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        restTemplate.getMessageConverters().add(0, new AvroJsonHttpMessageConverter<SpecificRecordBase>());
        return restTemplate;
    }

}
