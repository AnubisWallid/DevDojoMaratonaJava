package ZZJCrud.repository;

import ZZJCrud.conn.ConnectionFactory;
import ZZJCrud.domain.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Log4j2
public class ProducerRepository {
    private final Connection connection;

    {
        try {
            connection = ConnectionFactory.getConnection();
            log.info("Connection Established");
        } catch (SQLException e) {
            log.error("Error when trying to establish connection");
            throw new RuntimeException(e);
        }
    }

    public List<Producer> findByName(String name) {
        List<Producer> producers = new ArrayList<>();
        try (PreparedStatement preparedStatement = createPrepareStatementFindByName(name);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Producer producer = getBuilderProducer(resultSet);
                producers.add(producer);
            }
            producers.sort(Comparator.comparing(Producer::getId));
        } catch (SQLException e) {
            log.error("findByNamePreparedStatement", e);
        }
        return producers;
    }

    public Producer findById(Integer id) {
        try (PreparedStatement preparedStatement = createPrepareStatementFindByID(id);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            return getBuilderProducer(resultSet);
        } catch (SQLException e) {
            log.error("findById PreparedStatement in Producer", e);
        }
        return null;
    }

    public void save(Producer producer) {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ( ? );";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, producer.getName());
            preparedStatement.execute();
            System.out.printf("Inserted producer '%s' in the Database%n",
                    producer.getName());
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", producer.getName(), e);
        }
    }

    public void update(Producer producer) {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, producer.getName());
            preparedStatement.setInt(2, producer.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            log.info("Update producer '{}' in the Database, rows affected '{}'",
                    producer.getName(),
                    rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", producer.getName(), e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.printf("Deleted producer 'id=%d' in the Database, rows affected '%d'%n", id, rowsAffected);
//            log.info("Deleted producer 'id={}' in the Database, rows affected '{}'", id, rowsAffected);
            clearAutoIncrement();
        } catch (SQLException e) {
            log.error("Error while trying to delete producer 'id ={}'", id, e);
        }
    }

    private PreparedStatement createPrepareStatementFindByName(String name) throws SQLException {
        /*SQL injector -- String name = "B or X'='X";*/
        String sql = "SELECT * FROM anime_store.producer where name like ?;";/* ? = wildcard*/
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.format("%%%s%%", name));
        return preparedStatement;
    }

    private PreparedStatement createPrepareStatementFindByID(Integer id) throws SQLException {
        /*SQL injector -- String name = "B or X'='X";*/
        String sql = "SELECT * FROM anime_store.producer where id = ?;";/* ? = wildcard*/
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }

    private void clearAutoIncrement() {
        String sql = "ALTER TABLE `anime_store`.`producer` AUTO_INCREMENT = 0;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
            log.info("Auto_Increment Reinitialized");
        } catch (SQLException e) {
            log.error("Error while trying reinitialize the Auto increment... ", e);
        }
    }

    private Producer getBuilderProducer(ResultSet resultSet) throws SQLException {
        return Producer.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .build();
    }
}
