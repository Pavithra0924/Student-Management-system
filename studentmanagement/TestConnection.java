package studentmanagement;

import java.sql.Connection;

import studentmanagement.dao.DBconnection;

public class TestConnection {

    public static void main(String[] args) {

        Connection con = DBconnection.getConnection();

        if (con != null) {
            System.out.println("Connection Successful!");
        } else {
            System.out.println("Connection Failed!");
        }
    }
}