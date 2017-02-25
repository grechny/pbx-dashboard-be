package by.sysadmins.dashboard.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import by.sysadmins.dashboard.dto.CompanyCredentialsDto;
import by.sysadmins.dashboard.services.CompanyProfileService;
import by.sysadmins.dashboard.services.UserProfileService;

@Service
public class DataSourceManager {

    private static Map<String, DataSource> dataSourceMap = new ConcurrentHashMap<>();

    private final UserProfileService userProfileService;
    private final CompanyProfileService companyProfileService;

    @Autowired
    public DataSourceManager(UserProfileService userProfileService,
                             CompanyProfileService companyProfileService) {
        this.userProfileService = userProfileService;
        this.companyProfileService = companyProfileService;
    }

    public synchronized DataSource getDateSourceByUsername(String username, String dbName) {

        String companyName = userProfileService.getUserProfile(username).getCompanyName();
        DataSource dataSource = dataSourceMap.get(companyName + dbName);
        if (dataSource == null) {
            dataSource = addDataSource(companyName, dbName);
        }
        return dataSource;
    }

    private DataSource addDataSource(String companyName, String dbName) {
        CompanyCredentialsDto companyCredentials = companyProfileService.getCompanyCredentials(companyName, dbName);
        String driverClassName = null, url = null;
        switch (companyCredentials.getDbms()) {
            case MYSQL:
                driverClassName = "com.mysql.jdbc.Driver";
                url = "jdbc:mysql://";
                break;
            case MARIADB:
                driverClassName = "org.mariadb.jdbc.Driver";
                url = "jdbc:mariadb://";
                break;
            case POSTGRESQL:
                driverClassName = "org.postgresql.Driver";
                url = "jdbc:postgresql://";
                break;
            default:
        }

        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setUrl(url + companyCredentials.getDbAddress()
                + ":" + companyCredentials.getDbPort()
                + "/" + companyCredentials.getDbName());
        poolProperties.setDriverClassName(driverClassName);
        poolProperties.setUsername(companyCredentials.getDbUsername());
        poolProperties.setPassword(companyCredentials.getDbPassword());
        poolProperties.setJmxEnabled(true);
        poolProperties.setTestWhileIdle(false);
        poolProperties.setTestOnBorrow(true);
        poolProperties.setValidationQuery("SELECT 1");
        poolProperties.setTestOnReturn(false);
        poolProperties.setValidationInterval(30000);
        poolProperties.setTimeBetweenEvictionRunsMillis(30000);
        poolProperties.setMaxActive(30);
        poolProperties.setInitialSize(10);
        poolProperties.setMaxWait(10000);
        poolProperties.setRemoveAbandonedTimeout(60);
        poolProperties.setMinEvictableIdleTimeMillis(30000);
        poolProperties.setMinIdle(10);
        poolProperties.setLogAbandoned(true);
        poolProperties.setRemoveAbandoned(true);
        poolProperties.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
                        "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");

        DataSource dataSource = new DataSource();
        dataSource.setPoolProperties(poolProperties);

        dataSourceMap.put(companyName + dbName, dataSource);
        return dataSource;
    }

}
