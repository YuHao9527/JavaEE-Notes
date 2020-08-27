package com.java.demo;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class Demo1Test {

    @Test
    public void createTable() throws SQLException, ClassNotFoundException {
        Demo1.createTable();
    }

    @Test
    public void insertData() throws Exception {
        Demo1.insertData();
    }

    @Test
    public void insertPerson() throws Exception {
        Demo1.insertPerson();
    }

    @Test
    public void deletePerson() throws Exception {
        Demo1.deletePerson();
    }

    @Test
    public void updatePerson() throws Exception {
        Demo1.updatePerson();
    }

    @Test
    public void selectPerson() throws Exception {
        Demo1.selectPerson();
    }
}