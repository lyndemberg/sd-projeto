package sd.oficina.person3.infra.config;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class PropertiesApplication {

    public static final String PROPERTIES_FILENAME = "application.properties";

    public static PropertiesConfiguration getConfig() throws ConfigurationException {
        FileBasedConfigurationBuilder<PropertiesConfiguration> builder =
                new FileBasedConfigurationBuilder<>(PropertiesConfiguration.class)
                        .configure(new Parameters().properties()
                                .setFileName(PROPERTIES_FILENAME)
                                .setThrowExceptionOnMissing(true)
                                .setListDelimiterHandler(new DefaultListDelimiterHandler(';'))
                                .setIncludesAllowed(false));
        return builder.getConfiguration();
    }

}
