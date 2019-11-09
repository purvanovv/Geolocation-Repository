package com.tusofia.geoloc.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableWs
@Configuration
public class Config {

	@Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) 
    {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/service/*");
    }
 
    @Bean(name = "geolocationWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema geolocationsSchema) 
    {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("GeolocationsPort");
        wsdl11Definition.setLocationUri("/service/getRoute");
        wsdl11Definition.setTargetNamespace("https://www.geolocation.com/route/directions");
        wsdl11Definition.setSchema(geolocationsSchema);
        return wsdl11Definition;
    }
 
    @Bean
    public XsdSchema geolocationsSchema() 
    {
        return new SimpleXsdSchema(new ClassPathResource("xsd/geolocations.xsd"));
    }
    
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return mapper;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper());
        return converter;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, mappingJacksonHttpMessageConverter());
        return restTemplate;
    }
}
