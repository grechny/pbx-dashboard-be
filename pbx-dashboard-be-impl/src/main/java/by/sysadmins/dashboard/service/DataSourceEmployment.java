package by.sysadmins.dashboard.service;

import by.sysadmins.dashboard.entities.CompanyCredentials;
import by.sysadmins.dashboard.entities.repositories.CompaniesRepository;
import by.sysadmins.dashboard.entities.repositories.CompanyCredentialsRepository;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DataSourceEmployment {

    @Autowired
    private CompaniesRepository companiesRepository;
    @Autowired
    private CompanyCredentialsRepository companyCredentialsRepository;

    private static Map<String, DataSource> dataSourceMap = new HashMap<>();

    public DataSource getDateSourceByUsername(String username, String dbName){

        String companyName = companiesRepository.getCompanyNameByUsername(username);
        DataSource dataSource = dataSourceMap.get(companyName + dbName);
        if (dataSource == null) {
            dataSource = addDataSource(companyName, dbName);
        }
        return dataSource;
    }

    private synchronized DataSource addDataSource(String companyName, String dbName) {

        DataSource dataSource = dataSourceMap.get(companyName + dbName);
        if (dataSource == null) {
            CompanyCredentials companyCredentials;
            companyCredentials = companyCredentialsRepository.getByCompanies_companyNameAndDbName(companyName, dbName);
            String driverClassName = null, url = null;
            switch (companyCredentials.getDbms().getDbms()){
                case "MySQL":
                    driverClassName = "com.mysql.jdbc.Driver";
                    url = "jdbc:mysql://";
                    break;
                case "MariaDB":
                    driverClassName = "org.mariadb.jdbc.Driver";
                    url = "jdbc:mariadb://";
                    break;
                case "PostgreSQL":
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
            poolProperties.setMaxActive(100);
            poolProperties.setInitialSize(10);
            poolProperties.setMaxWait(10000);
            poolProperties.setRemoveAbandonedTimeout(60);
            poolProperties.setMinEvictableIdleTimeMillis(30000);
            poolProperties.setMinIdle(10);
            poolProperties.setLogAbandoned(true);
            poolProperties.setRemoveAbandoned(true);
            poolProperties.setJdbcInterceptors(
                    "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
                            "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
            DataSource newDataSource = new DataSource();
            newDataSource.setPoolProperties(poolProperties);

            dataSourceMap.put(companyName + dbName, newDataSource);
            return newDataSource;
        }

        return dataSource;
    }

}
