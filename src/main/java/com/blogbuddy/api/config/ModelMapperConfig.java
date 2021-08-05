package com.blogbuddy.api.config;

import com.blogbuddy.api.mapper.MapperAutoRegister;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ModelMapperConfig {

    @Autowired
    private List<? extends MapperAutoRegister> mappers;

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        mappers.stream().forEach(m -> m.register(modelMapper));

        return modelMapper;

    }

}
