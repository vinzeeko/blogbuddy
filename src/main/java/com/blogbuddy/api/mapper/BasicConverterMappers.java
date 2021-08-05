package com.blogbuddy.api.mapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class BasicConverterMappers implements MapperAutoRegister {

    Converter<String, UUID> strToUUID = ctx -> ctx.getSource() == null ? null : UUID.fromString(ctx.getSource());

    Converter<BigDecimal, Double> bigDecimalToDouble = ctx -> ctx.getSource() == null ? null
            : ctx.getSource().doubleValue();

    @Override
    public void register(ModelMapper modelMapper) {

        modelMapper.addConverter(strToUUID, String.class, UUID.class);
        modelMapper.addConverter(bigDecimalToDouble, BigDecimal.class, Double.class);

    }

}
