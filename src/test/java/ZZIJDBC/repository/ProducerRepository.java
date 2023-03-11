package ZZIJDBC.repository;

import ZZIJDBC.conn.ConnectionFactory;
import ZZIJDBC.domain.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
public class ProducerRepository {
    public static void save(Producer producer) {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try (Connection connection = ConnectionFactory.getConnection()) {
            assert connection != null;
            try (Statement stmt = connection.createStatement()) {
                int rowsAffected = stmt.executeUpdate(sql);
                log.info("Inserted producer in the Database, rows affected '{}'",rowsAffected);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
