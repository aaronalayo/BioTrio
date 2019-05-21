package dk.kea.dat18i.team8.biotrio.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.core.JdbcTemplate;
import java.awt.event.ActionEvent;

import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public Employee findEmployee(int employee_id) {

        SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM employee WHERE employee_id = " + employee_id );
        Employee employee = new Employee();
        while (rs.next()) {

            employee.setEmployee_id(rs.getInt( "employee_id" ) );
            employee.setName( rs.getString( "name" ) );
            employee.setLastName( rs.getString( "lastname" ) );
            employee.setUsername( rs.getString( "username" ) );
            employee.setPassword( rs.getString( "password" ) );

        }
        return employee;
    }

    public List<Employee> findAllEmployees() {

        SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM employee" );

        List<Employee> employeeList = new ArrayList<>();

        while (rs.next()) {
            Employee employee = new Employee();


            employee.setEmployee_id( rs.getInt( "employee_id" ) );
            employee.setName( rs.getString( "name" ) );
            employee.setLastName( rs.getString( "lastname" ) );
            employee.setUsername( rs.getString( "username" ) );
            employee.setPassword(rs.getString("password"));


            employeeList.add( employee );


        }
        return employeeList;

    }

    public Employee addEmployee(Employee employee) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement( "INSERT INTO biotrio.employee (name, lastname,username, password)VALUES (?,?,?,?)");

                ps.setString( 1,(employee.getName()) );
                ps.setString( 2,(employee.getLastName()) );
                ps.setString( 3,(employee.getUsername()));
                ps.setString( 4,(employee.getPassword()));

                return ps;
            }
        };

        jdbc.update( psc );

        return employee;
    }


    public void deleteEmployee(int employee_id) {

        jdbc.execute( "DELETE FROM employee WHERE employee_id = " + employee_id );
    }

    public Employee update(Employee employee) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {


                PreparedStatement ps = connection.prepareStatement("UPDATE biotrio.employee SET name = ?, lastname = ?, username = ?, password = ? WHERE employee_id=  " + employee.getEmployee_id(), new String[]{"employee_id"});

                ps.setString( 1,(employee.getName()) );
                ps.setString( 2,(employee.getLastName()) );
                ps.setString( 3, (employee.getUsername() ) );
                ps.setString( 4,(employee.getPassword()) );


                return ps;
            }

        };

        jdbc.update(psc);


        return employee;
    }

//
//    private Employee JButtonActionPerformed(ActionEvent event, Employee employee) {
//
//        PreparedStatementCreator psc = new PreparedStatementCreator() {
//
//            @Override
//            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//
//                PreparedStatement ps = connection.prepareStatement( "SELECT * FROM employee WHERE username = ? AND password = ?" );
//
//                ps.setString( 1,(employee.getUsername()) );
//                ps.setString( 2,(employee.getPassword()) );
//
//                ResultSet rs = ps.executeQuery();
//
//                if(rs.next() ) {
//
//                    JOptionPane.showMessageDialog(null,"Valid Username and Password");
//                }
//                    else {
//
//                        JOptionPane.showMessageDialog( null,"Invalid Username and/or Password, try again !" );
//
//                        employee.setUsername( " " );
//                        employee.setPassword( " " );
//                }
//
//                return ps;
//
//
//
//
//
//            }
//        };
//
//
//
//
//
//        return employee;
//        }



}
