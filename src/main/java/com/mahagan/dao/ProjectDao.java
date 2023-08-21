package com.mahagan.dao;

import com.mahagan.domain.Project;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {
   private JdbcTemplate jdbcTemplate;
   private final String SQL_NO_OF_RECORDS="SELECT * FROM PROJECT";

   public ProjectDao(JdbcTemplate jdbcTemplate){
      this.jdbcTemplate=jdbcTemplate;

   }

   public void getAllProject(){

      List<Project> projects=jdbcTemplate.queryForObject(SQL_NO_OF_RECORDS,new ProjectRowMapper());
    for(Project project:projects){
       System.out.println(project);
    }
   }
   private final class ProjectRowMapper implements RowMapper<List<Project>>{

      @Override
      public List<Project> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<Project> projects=new ArrayList<Project>();
        while (resultSet.next()){
           Project project=new Project();
           project.setProjectNo(resultSet.getInt(1));
           project.setTitle(resultSet.getString(2));
           project.setDescription(resultSet.getString(3));
           project.setDuration(resultSet.getInt(4));
           project.setStatus(resultSet.getString(5));
           projects.add(project);




        }


         return projects;
      }
   }

}
