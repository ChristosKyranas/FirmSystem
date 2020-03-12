package models;

public class Database {

    private String username;
    private String password;
    private String databaseUrl;

    public Database(String database_user, String database_password, String database_url) {
        this.username = database_user;
        this.password = database_password;
        this.databaseUrl = database_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    @Override
    public String toString() {
        return "Database{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", databaseUrl='" + databaseUrl + '\'' +
                '}';
    }
}
