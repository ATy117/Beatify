package DAO;

import object.Searchable;

import java.util.List;

public interface SearchDAO {

	public List<Searchable> getResults(String keyword);
}
