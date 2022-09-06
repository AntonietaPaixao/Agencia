package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CompraDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Compra compra) {

		String sql = "INSERT INTO Compra (valorCompra,dataCompra,quantPacotes)" + " VALUES(?,?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setDouble(1, compra.getValorCompra());
			pstm.setString(2, compra.getDataCompra());
			pstm.setInt(3, compra.getQuantPacotes());
		
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removeById(int idCompra) {

		String sql = "DELETE FROM Compra WHERE idCompra = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idCompra);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Compra compra) {
		String sql = "UPDATE Compra SET valorCompra = ?, dataCompra = ?, quantPacotes = ?" + "WHERE idCompra = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setDouble(1, compra.getValorCompra());
			pstm.setString(2, compra.getDataCompra());
			pstm.setInt(3, compra.getQuantPacotes());
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Compra> getCompras() {

		String sql = "SELECT * FROM Compra";

		List<Compra> compras = new ArrayList<Compra>();

		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Compra compra = new Compra();
				
				compra.setIdCompra(rset.getInt("idCompra"));
				
				compra.setValorCompra(rset.getDouble("valorCompra"));
			
				compra.setDataCompra(rset.getString("dataCompra"));
				
				compra.setQuantPacotes(rset.getInt("quantPacotes"));
				
			
				compras.add(compra);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return compras;
	}

	public Compra getCompraById(int idCompra) {

		String sql = "SELECT * FROM Compra where idCompra = ?";
		Compra compra = new Compra();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idCompra);
			rset = pstm.executeQuery();

			rset.next();
			
			compra.setValorCompra(rset.getInt("valorCompra"));
			
			compra.setDataCompra(rset.getString("dataCompra"));
		
			compra.setQuantPacotes(rset.getInt("quantPacotes"));
			

					


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return compra;
	}


}