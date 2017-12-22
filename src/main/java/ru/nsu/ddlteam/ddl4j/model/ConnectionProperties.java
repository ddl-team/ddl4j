package ru.nsu.ddlteam.ddl4j.model;

public class ConnectionProperties {
    private String hostname;
    private String port;
    private String sid;
    private String username;
    private String password;

    public ConnectionProperties() {
    }

    public ConnectionProperties(String hostname, String port, String sid, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        this.sid = sid;
        this.username = username;
        this.password = password;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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
}
