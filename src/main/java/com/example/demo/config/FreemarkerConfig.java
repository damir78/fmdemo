package com.example.demo.config;

import freemarker.template.DefaultObjectWrapper;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.TemplateHashModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

@Configuration
public class FreemarkerConfig {

    @Autowired
    void configureFreeMarkerConfigurer(FreeMarkerConfig configurer) {
        final freemarker.template.Configuration configuration = configurer.getConfiguration();

        final DefaultObjectWrapper wrapper = new DefaultObjectWrapperBuilder(freemarker.template.Configuration.VERSION_2_3_29).build();
        configuration.setObjectWrapper(wrapper);

        final TemplateHashModel staticModels = wrapper.getStaticModels();
        configuration.setSharedVariable("staticModels", staticModels);
    }
}