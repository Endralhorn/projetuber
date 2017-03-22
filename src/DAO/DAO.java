package DAO;

import java.util.List;

	
	public interface DAO <T, I>
	{
		public List<T> findAll();
		public T find(I id);
		public T save(T obj);
		public void delete(T obj);
	}


