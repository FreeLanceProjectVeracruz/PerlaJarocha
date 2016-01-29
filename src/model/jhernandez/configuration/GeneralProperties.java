package model.jhernandez.configuration;

import java.net.URL;

/**
 *
 * @author WIN 8
 */
public class GeneralProperties {

    private final String dbMysql = "/model/jhernandez/configuration/config.properties";

    /**
     *
     * @return
     */
    public URL getFileDbMysql() {
        return getClass().getResource(dbMysql);
    }
}
