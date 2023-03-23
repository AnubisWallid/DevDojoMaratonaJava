package ZZIJDBC.repository;

import ZZIJDBC.conn.ConnectionFactory;
import ZZIJDBC.domain.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Log4j2
public class ProducerRepositoryTransaction {
    public final Connection connection;

    {
        try {
            connection = ConnectionFactory.getConnection();
            log.info("Connection Established");
        } catch (SQLException e) {
            log.error("Error when trying to establish connection");
            throw new RuntimeException(e);
        }
    }

    public void saveTransaction(List<Producer> producers) {
        try {
            connection.setAutoCommit(false);
            preparedStatementsaveTransaction(producers);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            log.error("Error while trying to save producers from saveTransaction(), '{}'", producers, e);
        }
    }

    private void preparedStatementsaveTransaction(List<Producer> producers) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ( ? );";
        boolean shouldRollBack = false;
        for (Producer producer : producers) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                log.info("Saving producer '{}'", producer.getName());
                preparedStatement.setString(1, producer.getName());
                preparedStatement.execute();
            } catch (SQLException e) {
                log.error("Error at reparedStatementsaveTransaction", e);//erro no metodo X
                e.printStackTrace();
                shouldRollBack = true;
            }
        }
        if (shouldRollBack) {
            log.warn("Transaction is going be rollback" +
                     "");
            connection.rollback();
        }
    }
}
