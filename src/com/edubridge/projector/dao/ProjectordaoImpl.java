
	package com.edubridge.projector.dao;

	import java.sql.Connection;

	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import com.edubridge.projector.model.Projector;
	import com.edubridge.projector.util.DBUtils;


	public class ProjectordaoImpl implements Projectordao{
		
		static Connection con=DBUtils.getConnection();	

		@Override
		public int addProjector(Projector p) {
			String INSERT_QUERY="insert into projector(brand,colour,connection,imagescreen,price)values(?,?,?,?,?)";
			int status=0;
			try {
				PreparedStatement ps=con.prepareStatement(INSERT_QUERY);
				ps.setString(1,p.getBrand());
				ps.setString(2,p.getColour());
				ps.setString(3,p.getConnection());
				ps.setString(4,p.getImagescreen());
				ps.setFloat(5,p.getPrice());
				
				status=ps.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return status;
		}

		@Override
		public List<Projector> findProjector() {
			String SELECT_QUERY="select * from projector";
			List<Projector>projectorList=new ArrayList<>();
			try {
				PreparedStatement ps=con.prepareStatement(SELECT_QUERY);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					Projector p=new Projector();
					p.setId(rs.getInt("id"));
					p.setBrand(rs.getString("Brand"));
					p.setColour(rs.getString("Colour"));
					p.setConnection(rs.getString("Connection"));
					p.setImagescreen(rs.getString("ImageScreen"));
					p.setPrice(rs.getFloat("Price"));
					projectorList.add(p);				
				}			
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return projectorList;
		}
		@Override
		public int updateProjector(Projector p) {
			String UPDATE_QUERY="update projector set colour=?,connection=?,imagescreen=?,price=?,brand=? where id=?";
			int status=0;
			try {
				PreparedStatement ps=con.prepareStatement(UPDATE_QUERY);
				
				ps.setString(1,p.getColour());
				ps.setString(2,p.getConnection());
				ps.setString(3,p.getImagescreen());
				ps.setFloat(4,p.getPrice());
				ps.setString(5,p.getBrand());
				ps.setInt(6,p.getId());
				
				status=ps.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return status;
		}

		@Override
		public int deleteProjectorByBrand(String Brand) {
			String DELETE_QUERY="delete from projector where brand=?";
			int status=0;
			try {
				PreparedStatement ps=con.prepareStatement(DELETE_QUERY);
				ps.setString(1, Brand);
				status=ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			
			}
			return status;
		}

		@Override
		public void deleteAllProjectors() {
			String DELETE_QUERY="delete from Projector";
			try{
				PreparedStatement ps=con.prepareStatement(DELETE_QUERY);
				ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		@Override
		public Projector findProjectorByBrand(String Brand) {
			Projector p=null;
			String SELECT_QUERY="select * from projector where brand=?";
			try {
				PreparedStatement ps=con.prepareStatement(SELECT_QUERY);
				ps.setString(1,Brand);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					p=new Projector();
					p.setId(rs.getInt("Id"));
					p.setBrand(rs.getString("brand"));
					p.setColour(rs.getString("colour"));
					p.setConnection(rs.getString("Connection"));				
					p.setImagescreen(rs.getString("imagescreen"));
					p.setPrice(rs.getFloat("price"));
				
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
				
			return p;
		}

	}

