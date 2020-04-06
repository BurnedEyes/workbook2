package logic;

import exception.FileProcessingException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class HTMLRenderer {

    public static void renderToFile(String templateName, String outputFilePath, Map<String, Object> input) {
        try (FileWriter fileWriter = new FileWriter(new File(outputFilePath))) {
            Template template = templateConfig().getTemplate(templateName);
            template.process(input, fileWriter);
        } catch (IOException | TemplateException e) {
            throw new FileProcessingException(e);
        }
    }

    private static Configuration templateConfig() {
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setClassForTemplateLoading(HTMLRenderer.class, "/");
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return configuration;
    }

}
