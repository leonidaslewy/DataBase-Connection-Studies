package persistent;

import java.util.List;

public interface  DAO<T> {

	void inserir(T e);

	void excluir(T e);

	List<T> listar(int limit, int offset);

	T buscar (int id);

	void alterar(T e);
}