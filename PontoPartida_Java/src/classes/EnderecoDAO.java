package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EnderecoDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Endereco endereco) {

		String sql = "INSERT INTO Endereco (cidade,estadoUf,logradouro,bairro,numero)" + " VALUES(?,?,?,?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, endereco.getCidade());
			pstm.setString(2, endereco.getEstadoUf());	
			pstm.setString(3, endereco.getLogradouro());
			pstm.setString(4, endereco.getBairro());
			pstm.setString(5, endereco.getNumero());
		
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

	public void removeById(int idEndereco) {

		String sql = "DELETE FROM Endereco WHERE idEndereco = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idEndereco);
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

	public void update(Endereco endereco) {
		String sql = "UPDATE Endereco SET cidade = ?, estadoUf = ?, logradouro = ?, bairro = ?, numero= ? " + "WHERE idEndereco = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, endereco.getCidade());
			pstm.setString(2, endereco.getEstadoUf());	
			pstm.setString(3, endereco.getLogradouro());
			pstm.setString(4, endereco.getBairro());
			pstm.setString(5, endereco.getNumero());
			
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

	public List<Endereco> getEnderecos() {

		String sql = "SELECT * FROM Endereco";

		List<Endereco> enderecos = new ArrayList<Endereco>();

		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Endereco endereco = new Endereco();
				
				endereco.setIdEndereco(rset.getInt("idEndereco"));

				endereco.setCidade(rset.getString("cidade"));

				endereco.setEstadoUf(rset.getString("estadoUf"));
				
				endereco.setLogradouro(rset.getString("logradouro"));
			
				endereco.setBairro(rset.getString("bairro"));
								
				endereco.setNumero(rset.getString("numero"));
						
			
				enderecos.add(endereco);
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
		return enderecos;
	}

	public Endereco getEnderecoById(int idEndereco) {

		String sql = "SELECT * FROM Endereco where idEndereco = ?";
		Endereco endereco = new Endereco();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idEndereco);
			rset = pstm.executeQuery();

			rset.next();
			
			endereco.setIdEndereco(rset.getInt("idEndereco"));

			endereco.setCidade(rset.getString("cidade"));

			endereco.setEstadoUf(rset.getString("estadoUf"));
			
			endereco.setLogradouro(rset.getString("logradouro"));
		
			endereco.setBairro(rset.getString("bairro"));
			
			endereco.setNumero(rset.getString("numero"));
			
			


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
		return endereco;
	}


}