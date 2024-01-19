package DB;

import MODELS.Client;

import java.sql.*;
import java.util.ArrayList;

public class Repository {
    Connection conn;
    Statement stmt;
    public Repository() throws Exception{
        this.conn = Connection_DB.getConnection();
        this.stmt = this.conn.createStatement();
    }
}
