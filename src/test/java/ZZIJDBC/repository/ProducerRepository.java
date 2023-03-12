package ZZIJDBC.repository;

import ZZIJDBC.conn.ConnectionFactory;
import ZZIJDBC.domain.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {
    public static final Connection connection;

    static {
        try {
            connection = ConnectionFactory.getConnection();
            log.info("Connection Established");
        } catch (SQLException e) {
            log.error("Error when trying to establish connection");
            throw new RuntimeException(e);
        }
    }

    public static final Statement statement;

    static {
        try {
            statement = connection.createStatement();
            log.info("Statement Created");
        } catch (SQLException e) {
            log.error("Error when trying to create the Statement");
            throw new RuntimeException(e);
        }
    }

    public static int length() {
        String sql = "SELECT * FROM anime_store.producer;";
        try {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            log.error("Unable to get the size", e);
            return 0;
        }
    }

    public static void save(Producer producer) {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try {
            int rowsAffected = statement.executeUpdate(sql);
            log.info("Inserted producer '{}' in the Database, rows affected '{}'",
                    producer.getName(),
                    rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", producer.getName(), e);
        }
    }

    public static void update(Producer producer) {
        log.info("Finding all Producers");
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s' WHERE (`id` = '%d');"
                .formatted(producer.getName(), producer.getId());
        try {
            int rowsAffected = statement.executeUpdate(sql);
            log.info("Update producer '{}' in the Database, rows affected '{}'",
                    producer.getName(),
                    rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", producer.getName(), e);
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id);
        try {
            int rowsAffected = statement.executeUpdate(sql);
            log.info("Deleted producer 'id={}' in the Database, rows affected '{}'",
                    id,
                    rowsAffected);

        } catch (SQLException e) {
            log.error("Error while trying to delete producer 'id ={}'", id, e);
        }
    }

    public static void deleteAll() {
        String sql = "DELETE FROM `anime_store`.`producer` WHERE id;";
        try {
            int rowsAffected = statement.executeUpdate(sql);
            log.info("Deleted producer all in the Database, rows affected '{}'",
                    rowsAffected);
        } catch (SQLException e) {
            log.error("Error when trying to delete all", e);
        }
    }

    public static void clearAutoIncrement() {
        String sql = "ALTER TABLE `anime_store`.`producer` AUTO_INCREMENT = 0;";
        try {
            statement.executeUpdate(sql);
            log.info("Auto_Increment Reinitialized");
        } catch (SQLException e) {
            log.error("Error while trying reinitialize... ", e);
        }
    }

    private static List<Producer> find(String name) {
        String sql = "SELECT * FROM anime_store.producer where name like '%%%s%%';".formatted(name);
        List<Producer> producers = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                 /*int id = rs.getInt("id");
                 String name = rs.getString("name");
                 producers.add(Producer.builder().id(id).name(name).build());*/
                producers.add(Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build());
            }
        } catch (SQLException e) {
            log.error("Error in finding generically");
        }
        return producers;
    }

    public static List<Producer> findByName(String name) {
        log.info("Finding Producer witch name: '{}'", name);
        return find(name);
    }

    public static void showProducerMetaData() {
        log.info("Showing Produce MetaData");
        String sql = "SELECT * FROM anime_store.producer";
        try {
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("----------MetaDadosProducer----------");
                System.out.printf("%s: '%s',%n%s: '%s',%n%s: '%s',%n" +
                                  "%s: '%s',%n%s: '%s',%n%s: '%s',%n" +
                                  "%s: '%s',%n%s: '%s',%n",
                        "CatalogName", resultSetMetaData.getCatalogName(i),
                        "TableName", resultSetMetaData.getTableName(i),
                        "ColumnLabel", resultSetMetaData.getColumnLabel(i),
                        "ColumnClassName", resultSetMetaData.getColumnClassName(i),
                        "ColumnDisplaySize", resultSetMetaData.getColumnDisplaySize(i),
                        "ColumnTypeName", resultSetMetaData.getColumnTypeName(i),
                        "ColumnType", resultSetMetaData.getColumnType(i),
                        "SchemaName", resultSetMetaData.getSchemaName(i)
                );
            }
            log.info("Information retrieved successfully");
        } catch (SQLException e) {
            log.error("Error when trying to get information");
        }
    }
    public static void showDriverMetaData(){
        log.info("Start - - - Showing Driver MetaData");
        String sql = "SELECT * FROM anime_store.producer";
        try {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            /*TYPE_FORWARD_ONLY -> leitura de cima para baixo*/
            extractSupportType(databaseMetaData, "TYPE_FORWARD_ONLY");
            /*TYPE_SCROLL_INSENSITIVE -> leitura up-down e down-up, MAS NÃO altera em tempo real*/
            extractSupportType(databaseMetaData, "TYPE_SCROLL_INSENSITIVE");
            /*TYPE_SCROLL_SENSITIVE -> leitura up-down e down-up, E altera em tempo real*/
            extractSupportType(databaseMetaData, "TYPE_SCROLL_SENSITIVE");
            log.info("End - - - Information Driver MetaData retrieved successfully");
        } catch (SQLException e) {
            log.error("Error when trying to get information");
        }
    }
    private static void extractSupportType(DatabaseMetaData databaseMetaData, String type) throws SQLException {
        int resultSetType;
        if ("TYPE_FORWARD_ONLY".equals(type)) {
            resultSetType = ResultSet.TYPE_FORWARD_ONLY;
        } else if ("TYPE_SCROLL_INSENSITIVE".equals(type)) {
            resultSetType = ResultSet.TYPE_SCROLL_INSENSITIVE;
        } else if ("TYPE_SCROLL_SENSITIVE".equals(type)) {
            resultSetType = ResultSet.TYPE_SCROLL_SENSITIVE;
        }else {
            log.error("Error when getiting ResultSetType by String");
            return;
        }
        if (databaseMetaData.supportsResultSetType(resultSetType)){
            if (databaseMetaData.supportsResultSetConcurrency(resultSetType,ResultSet.CONCUR_UPDATABLE)){
                log.info("Supports '{}', and supports CONCUR_UPDATABLE",type);
            } else if (databaseMetaData.supportsResultSetConcurrency(resultSetType,ResultSet.CONCUR_READ_ONLY)) {
                log.info("Supports '{}', and supports CONCUR_READ_ONLY",type);

            }
        }else log.warn("No Supports '{}'",type);
    }


    public static List<Producer> findAll() {
        log.info("Finding all Producers");
        return find("");
    }
}

