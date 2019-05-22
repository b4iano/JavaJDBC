import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Database {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://SEUSERVER.database.windows.net:1433;database=SEUSERVER");
        dataSource.setUsername("user");
        dataSource.setPassword("password");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        System.out.println(
            jdbcTemplate.queryForList("select * from SevenSoft.dbo.CONTINUADA03")
        );

        System.out.println(
                jdbcTemplate.queryForList("select * FROM SevenSoft.dbo.CONTINUADA03 WHERE Age < 25")
        );

        System.out.println(
                jdbcTemplate.update("DELETE FROM SevenSoft.dbo.CONTINUADA03 where ID = 2")
        );

        System.out.println(
                jdbcTemplate.update("insert into CONTINUADA03 (ID, LastName, FirstName, Age) values" +
                        "(9, 'Fenomeno', 'Ronaldo', 39)")
        );


    }

}
