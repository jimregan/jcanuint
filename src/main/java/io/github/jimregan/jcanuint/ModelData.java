package io.github.jimregan.jcanuint;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

final class ModelData {
    private static Model loadModel(String path) throws Exception {
        Model mdl = new Model();
        Set<String> lines = new HashSet<String>();
        InputStream is =ModelData.class.getResourceAsStream(path);
        Scanner scanner = new Scanner(is, "utf-8");
        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line == null || line.equals("") || line.charAt(0) == '#') {
                    continue;
                }
                String[] parts = line.split("\\t");
                if(parts.length != 4) {
                    throw new IOException("Incorrect number of fields: " + line);
                }
                mdl.add(parts);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        return mdl;
    }
}
