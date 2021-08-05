package com.blogbuddy.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public abstract class AbstractUnitTest {

    protected final ModelMapper modelMapper;
    protected final ObjectMapper objectMapper;

    public AbstractUnitTest() {

        this.modelMapper = Mockito.spy(ModelMapper.class);
        this.objectMapper = Mockito.spy(ObjectMapper.class);
    }
}
