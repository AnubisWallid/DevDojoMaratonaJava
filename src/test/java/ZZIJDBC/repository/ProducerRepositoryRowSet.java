package ZZIJDBC.repository;

import ZZIJDBC.conn.ConnectionFactory;
import ZZIJDBC.domain.Producer;
import ZZIJDBC.listener.CustomRowSetListener;
import lombok.extern.log4j.Log4j2;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Log4j2
public class ProducerRepositoryRowSet {
    public List<Producer> findByNameJdbcRowSet(String name) {
        String sql = "SELECT * FROM anime_store.producer where name like ?;";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jdbcRowSet = ConnectionFactory.getJdbcRowSet()) {
            jdbcRowSet.addRowSetListener(new CustomRowSetListener());
            jdbcRowSet.setCommand(sql);
            jdbcRowSet.setString(1, String.format("%%%s%%", name));
            jdbcRowSet.execute();/*Apenas busca dados*/
            while (jdbcRowSet.next()) {
                Producer producer = Producer.builder()
                        .id(jdbcRowSet.getInt("id"))
                        .name(jdbcRowSet.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Erro in findByNameJdbcRowSet", e);
        }
        producers.sort(Comparator.comparing(Producer::getId));
        log.info(producers);
        return producers;
    }

    /*public void updateJdbcRowSet(Producer producer) {
        String sql = "UPADTE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
        try (JdbcRowSet jdbcRowSet = ConnectionFactory.getJdbcRowSet()) {
            jdbcRowSet.setCommand(sql);
            jdbcRowSet.setString(1, producer.getName());
            jdbcRowSet.setInt(2, producer.getId());
            jdbcRowSet.execute();
            log.info("Row '{}', id = '{}', name = '{}'",
                    jdbcRowSet.getRow()
                    ,jdbcRowSet.getRowId("id"),
                    jdbcRowSet.getString("name"));

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Erro in findByNameJdbcRowSet", e);
        }
    }*/
    public void updateJdbcRowSet(Producer producer) {
        String sql = "SELECT * FROM anime_store.producer WHERE (`id` = ?);";
        try (JdbcRowSet jdbcRowSet = ConnectionFactory.getJdbcRowSet()) {
            jdbcRowSet.addRowSetListener(new CustomRowSetListener());
            jdbcRowSet.setCommand(sql);
            jdbcRowSet.setInt(1, producer.getId());
            jdbcRowSet.execute();/*Apenas busca dados*/
            if (!jdbcRowSet.next())return;
            jdbcRowSet.updateString("name", producer.getName());
            jdbcRowSet.updateRow();
            log.info("On updateJdbcRowSet => Row '{}', id = '{}', name = '{}'",
                    jdbcRowSet.getRow()
                    , producer.getId(),
                    producer.getName());

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Erro in updateJdbcRowSet", e);
        }
    }
    public void updateCachedRowSet(Producer producer) {
        String sql = "SELECT * FROM producer WHERE (`id` = ?);";
        try (CachedRowSet cachedRowSet = ConnectionFactory.getCachedRowSet();
             Connection connection = ConnectionFactory.getConnection()) {
            connection.setAutoCommit(false);
            cachedRowSet.setCommand(sql);
            cachedRowSet.setInt(1, producer.getId());
            cachedRowSet.execute(connection);/*Apenas busca dados*/
            if (!cachedRowSet.next())return;
            cachedRowSet.updateString("name", producer.getName());
            cachedRowSet.updateRow();
            cachedRowSet.acceptChanges();
            log.info("On updateCachedRowSet => Row '{}', id = '{}', name = '{}'",
                    cachedRowSet.getRow()
                    , producer.getId(),
                    producer.getName());

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Erro in updateCachedRowSet", e);
        }
    }

}
