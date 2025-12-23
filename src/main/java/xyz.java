
//public class xyz {
//
//	public xyz() {
//		// TODO Auto-generated constructor stub
//	}
//
//}

import java.util.List;

 interface ReadableRepository<T> {
    T findById(Long id);
    List<T> findAll();
}

 interface WritableRepository<T> {
    T save(T entity);
    void delete(Long id);
}

public class xyz implements ReadableRepository<Object>, WritableRepository<Object> {

	@Override
	public Object save(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
    // Implement only relevant methods
}