package resources;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;

import static net.serenitybdd.core.environment.ConfiguredEnvironment.getEnvironmentVariables;

public class GlobalConfig {

    public static final String MAIN_URL = EnvironmentSpecificConfiguration.from(getEnvironmentVariables()).getProperty("base.url");
    public static final String REGISTRATION_URL = MAIN_URL + EnvironmentSpecificConfiguration.from(getEnvironmentVariables()).getProperty("registration.url");
    public static final String FORGOT_PASS_URL = MAIN_URL + EnvironmentSpecificConfiguration.from(getEnvironmentVariables()).getProperty("forgotPass.url");

}
