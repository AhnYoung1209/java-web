package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Build {
	public Boolean add(String id,String pass){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Boolean judge=null;
		String sql="insert into user values(?,?)";
		
		
		Con_mysql con_mysql=new Con_mysql();
		con=con_mysql.getConnection();
		
		
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);
			//ps.executeUpdate();���ظı����ݵ�����
			ps.executeUpdate();
			judge=true;
		} catch (SQLException e) {
			judge=false;
			System.out.println("����û�ʧ��");
			e.printStackTrace();
		}
		con_mysql.closes(con, ps, rs);
		return judge;
	}
	
	//��ѯ�Ѵ����û��˺�
	public Map<String,String> querys(){
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String sql="select * from user";
		Map<String,String>map=new HashMap<String,String>();
		
		
		
		Con_mysql con_mysql=new Con_mysql();
		con=con_mysql.getConnection();

		
		try {
			st = con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				map.put(rs.getString(1),rs.getString(2));
			}
		} catch (SQLException e) {
			System.out.println("��ѯ�û�ʧ��");
			e.printStackTrace();
		}
		con_mysql.close(con, st, rs);
		return map;
	}
}
