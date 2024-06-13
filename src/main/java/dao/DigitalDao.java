package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Digital;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class DigitalDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	ResultSet rs = null;
	EntityManager em = null;

	public DigitalDao() {
		em = Persistence.createEntityManagerFactory("Digital_online ssql").createEntityManager();
	}

//	public Digital getTop1() {
//		try {
////			String sql = "SELECT TOP 1 * FROM Digital ORDER BY timePost DESC";
//			String sql = "select * from digital where timePost = (select max(timePost) from digital)";
//			
//			
//			ps = connectDB.getInstance().getConnection().prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				Digital digital = new Digital(
//						rs.getInt(1), 
//						rs.getString(2), 
//						rs.getString(3), 
//						rs.getString(4),
//						rs.getString(5), 
//						rs.getDate(6), 
//						rs.getString(7));
//				return digital;
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	public Digital getTop1() {
		try {
//			String sql = "SELECT TOP 1 * FROM Digital ORDER BY timePost DESC";
			String sql = "select e from Digital e where e.timePost = (select max(e.timePost) from Digital e)";
			Digital digital = (Digital) em.createQuery(sql).getSingleResult();
			return digital;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Digital> getTop5() {
		List<Digital> list = new ArrayList<Digital>();
		try {
			String sql = "select e from Digital e where e.timePost not in  (select max(e.timePost) from Digital e) order by e.timePost desc";
			TypedQuery<Digital> query = em.createQuery(sql, Digital.class);
			query.setMaxResults(5); // Giới hạn số lượng kết quả trả về là 5
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Digital getOne(int id) {
		String sql = "select e from Digital e where e.id = :id";
		TypedQuery<Digital> query = em.createQuery(sql, Digital.class);
		try {
			query.setParameter("id", id);
			Digital di = query.getSingleResult();
			if (di != null) {
				return di;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
