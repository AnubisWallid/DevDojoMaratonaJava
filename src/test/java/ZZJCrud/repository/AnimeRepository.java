package ZZJCrud.repository;

import ZZJCrud.conn.ConnectionFactory;
import ZZJCrud.domain.Anime;
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
public class AnimeRepository {
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

    public List<Anime> findByName(String name) {
        List<Anime> animes = new ArrayList<>();
        try (PreparedStatement preparedStatement = createPrepareStatementFindByName(name);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Anime anime = getBuilderAnime(resultSet);
                animes.add(anime);
            }
            animes.sort(Comparator.comparing(Anime::getId));
        } catch (SQLException e) {
            log.error("findByName PreparedStatement in AnimeRepository", e);
        }
        return animes;
    }
    public Anime findById(Integer id) {
        try (PreparedStatement preparedStatement = createPrepareStatementFindByID(id);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            return getBuilderAnime(resultSet);
        } catch (SQLException e) {
            log.error("findById in PrepareStatement", e);
        }
        return null;
    }

    public void save(Anime anime) {
        String sql = "INSERT INTO `anime_store`.`anime` (`name`, `episodes`, `producer_id`) VALUES ( ?, ? , ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, anime.getName());
            preparedStatement.setInt(2, anime.getEpisodes());
            preparedStatement.setInt(3, anime.getProducer().getId());
            preparedStatement.execute();
            System.out.printf("Inserted anime '%s' in the Database%n",
                    anime.getName());
        } catch (SQLException e) {
            log.error("Error while trying to insert anime '{}'", anime.getName(), e);
        }
    }

    public void update(Anime anime) {
        String sql = "UPDATE `anime_store`.`anime` SET `name` = ?, `episodes` = ? WHERE (`id` = ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, anime.getName());
            preparedStatement.setInt(2, anime.getEpisodes());
            preparedStatement.setInt(2, anime.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            log.info("Update anime '{}' in the Database, rows affected '{}'",
                    anime.getName(),
                    rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to insert anime '{}'", anime.getName(), e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM `anime_store`.`anime` WHERE (`id` = ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.printf("Deleted anime 'id=%d' in the Database, rows affected '%d'%n", id, rowsAffected);
//            log.info("Deleted anime 'id={}' in the Database, rows affected '{}'", id, rowsAffected);
            clearAutoIncrement();
        } catch (SQLException e) {
            log.error("Error while trying to delete anime 'id ={}'", id, e);
        }
    }

    private PreparedStatement createPrepareStatementFindByName(String name) throws SQLException {
        String sql = "SELECT a.id, a.name, a.episodes, a.producer_id, p.name AS 'producer_name' " +
                     "FROM anime_store.anime a " +
                     "INNER JOIN anime_store.producer p " +
                     "ON a.producer_id = p.id " +
                     "WHERE a.name LIKE ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.format("%%%s%%", name));
        return preparedStatement;
    }
    private PreparedStatement createPrepareStatementFindByID(Integer id) throws SQLException {
        /*SQL injector -- String name = "B or X'='X";*/
        String sql = "SELECT a.id, a.name, a.episodes, a.producer_id, p.name AS 'producer_name' " +
                     "FROM anime_store.anime a " +
                     "INNER JOIN anime_store.producer p " +
                     "ON a.producer_id = p.id " +
                     "WHERE a.id = ?;";/* ? = wildcard*/
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }
    private void clearAutoIncrement() {
        String sql = "ALTER TABLE `anime_store`.`anime` AUTO_INCREMENT = 0;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
            log.info("Auto_Increment Reinitialized");
        } catch (SQLException e) {
            log.error("Error while trying reinitialize the Auto increment... ", e);
        }
    }
    private Anime getBuilderAnime(ResultSet resultSet) throws SQLException {
        Producer producer = Producer.builder()
                .name(resultSet.getString("producer_name"))
                .id(resultSet.getInt("producer_id"))
                .build();
        return Anime.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .episodes(resultSet.getInt("episodes"))
                .producer(producer)
                .build();
    }
}
