package io.github.jimregan.jcanuint;

import org.junit.Test;

import static org.junit.Assert.*;

public class ModelDataTest {
    Model test = ModelData.getModel();

    @Test
    public void getModel() {
        assertNotNull(test);
    }
}