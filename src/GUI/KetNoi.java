/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Loi
 */
public class KetNoi {
    //private Connection con;

    public Connection ConnectDB() throws ClassNotFoundException, SQLException {
        //load driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //ket not database
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=QLTV", "sa", "1234");
        return con;

    }

}
