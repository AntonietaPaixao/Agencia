package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PartidaDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Partida partida) {

		String sql = "INSERT INTO Partida (data,nomeCampeonato,timeCasa,timeConvidado)" + " VALUES(?,?,?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, partida.getData());
			pstm.setString(2, partida.getNomeCampeonato());
			pstm.setString(3, partida.getTimeCasa());
			pstm.setString(4, partida.getTimeConvidado());
		
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

	public void removeById(int idPartida) {

		String sql = "DELETE FROM Partida WHERE idPartida = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idPartida);
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

	public void update(Partida partida) {
		String sql = "UPDATE Partida SET data = ?,nomeCampeonato=?,timeCasaidade=?,timeConvidado=?" + "WHERE idPartida = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, partida.getData());
			pstm.setString(2, partida.getNomeCampeonato());
			pstm.setString(3, partida.getTimeCasa());
			pstm.setString(4, partida.getTimeConvidado());
			
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

	public List<Partida> getPartidas() {

		String sql = "SELECT * FROM Partida";

		List<Partida> partidas = new ArrayList<Partida>();

		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Partida partida = new Partida();
				
				partida.setIdPartida(rset.getInt("idPartida"));
				
				partida.setData(rset.getString("data"));
			
				partida.setNomeCampeonato(rset.getString("nomeCampeonato"));
				
				partida.setTimeCasa(rset.getString("timeCasa"));
				
				partida.setTimeConvidado(rset.getString("timeConvidado"));
				
	
				
				
			
				partidas.add(partida);
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
		return partidas;
	}

	public Partida getPartidaById(int idPartida) {

		String sql = "SELECT * FROM Partida where idPartida = ?";
		Partida partida = new Partida();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idPartida);
			rset = pstm.executeQuery();

			rset.next();
			
			partida.setIdPartida(rset.getInt("idPartida"));
			
			partida.setData(rset.getString("data"));
			
			partida.setNomeCampeonato(rset.getString("nomeCampeonato"));
				
			partida.setTimeCasa(rset.getString("timeCasa"));
				
			partida.setTimeConvidado(rset.getString("timeConvidado"));
			


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
		return partida;
	}


}
