package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PessoaDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Pessoa pessoa) {

		String sql = "INSERT INTO Pessoa (CPF,nomePessoa,dataNascimento,sexo,email,telefone)" + " VALUES(?,?,?,?,?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pessoa.getCPF());
			pstm.setString(2, pessoa.getNomePessoa());
			pstm.setString(3, pessoa.getDataNascimento());
			pstm.setString(4, pessoa.getSexo());
			pstm.setString(5, pessoa.getEmail());
   			pstm.setString(6, pessoa.getTelefone());


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

	public void removeById(int idPessoa) {

		String sql = "DELETE FROM Pessoa WHERE idPessoa = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idPessoa);
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

	public void update(Pessoa pessoa) {
		String sql = "UPDATE Pessoa SET CPF = ?, nomePessoa= ?, dataNascimento= ?, sexo= ?, email= ?, telefone= ?" + "WHERE idPessoa = ?";
        

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, pessoa.getCPF());
			pstm.setString(2, pessoa.getNomePessoa());
			pstm.setString(3, pessoa.getDataNascimento());
			pstm.setString(4, pessoa.getSexo());
			pstm.setString(5, pessoa.getEmail());
   			pstm.setString(6, pessoa.getTelefone());
			
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

	public List<Pessoa> getPessoas() {

		String sql = "SELECT * FROM Pessoa";

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Pessoa pessoa = new Pessoa();
				
				pessoa.setIdPessoa(rset.getInt("idPessoa"));
				
				pessoa.setCPF(rset.getString("CPF"));
			
				pessoa.setNomePessoa(rset.getString("nomePessoa"));
				
				pessoa.setDataNascimento(rset.getString("dataNascimento"));
				
				pessoa.setSexo(rset.getString("sexo"));
				
				pessoa.setEmail(rset.getString("email"));

                pessoa.setTelefone(rset.getString("telefone"));
                	
				
				
			
				pessoas.add(pessoa);
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
		return pessoas;
	}

	public Pessoa getPessoaById(int idPessoa) {

		String sql = "SELECT * FROM Pessoa where idPessoa = ?";
		Pessoa pessoa = new Pessoa();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idPessoa);
			rset = pstm.executeQuery();

			rset.next();
			
			pessoa.setIdPessoa(rset.getInt("idPessoa"));
				
			pessoa.setCPF(rset.getString("CPF"));
			
			pessoa.setNomePessoa(rset.getString("nomePessoa"));
				
			pessoa.setDataNascimento(rset.getString("dataNascimento"));
				
			pessoa.setSexo(rset.getString("sexo"));
				
			pessoa.setEmail(rset.getString("email"));

            pessoa.setTelefone(rset.getString("telefone"));
                
            //pessoa.setEndereco(rset.getEndereco("endereco"));

			


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
		return pessoa;
	}


}
