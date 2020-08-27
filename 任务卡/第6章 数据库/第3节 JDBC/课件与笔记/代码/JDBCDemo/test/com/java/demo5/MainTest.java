package com.java.demo5;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class MainTest {

    //24.627
    @Test
    public void insert1_1() throws SQLException {
        Main.insert1_1();
    }
    //24.382
    @Test
    public void insert1_2() throws SQLException {
        Main.insert1_2();
    }
    //24.683
    @Test
    public void insert2_1() throws SQLException {
        Main.insert2_1();
    }
    //24.159
    @Test
    public void insert2_2() throws SQLException {
        Main.insert2_2();
    }
}