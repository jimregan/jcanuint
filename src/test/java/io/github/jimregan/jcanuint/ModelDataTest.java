package io.github.jimregan.jcanuint;

import org.junit.Test;

import static org.junit.Assert.*;

public class ModelDataTest {

    Model test = ModelData.getModel();

    @Test
    public void getModel() {
        assertNotNull(test);
    }

    @Test
    public void checkModel() {
        String inp = "goidé mar atá na préataí ag an bhomaite seo";
        test.stat();
        Score out = test.checkString(inp);

        assertEquals("U", out.toString());
    }
}