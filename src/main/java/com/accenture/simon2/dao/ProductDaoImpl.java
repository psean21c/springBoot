package com.accenture.simon2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.accenture.simon2.dao.ProductDao;
import com.accenture.simon2.model.Product;


@Repository
public class ProductDaoImpl extends JdbcDaoSupport implements ProductDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	
	@Override
	public void insert(Product product) {
		String sql = "INSERT INTO product " +
				"(PRODUCT_ID, NAME, AGE) VALUES (?, ?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				product.getProductId(), product.getName(), product.getAge()
		});
	}

	
	@Override
	public void inserBatch(List<Product> products) {
		String sql = "INSERT INTO product " + "(PRODUCT_ID, NAME, AGE) VALUES (?, ?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Product product = products.get(i);
				ps.setLong(1, product.getProductId());
				ps.setString(2, product.getName());
				ps.setInt(3, product.getAge());
			}
			
			public int getBatchSize() {
				return products.size();
			}
		});
	}
	

	public List<Product> loadAllProduct(){
		String sql = "SELECT * FROM product";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Product> result = new ArrayList<Product>();
		for(Map<String, Object> row:rows){
			Product cus = new Product();
			cus.setProductId((Integer)row.get("product_id"));
			cus.setName((String)row.get("name"));
			cus.setAge((Integer) row.get("age"));
			result.add(cus);
		}
		
		return result;
	}


	@Override
	public Product findProductById(long productId) {
		String sql = "SELECT * FROM product WHERE PRODUCT_ID = ?";
		return (Product)getJdbcTemplate().queryForObject(sql, new Object[]{productId}, new RowMapper<Product>(){
			@Override
			public Product mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Product cust = new Product();
				cust.setProductId(rs.getInt("product_id"));
				cust.setName(rs.getString("name"));
				cust.setAge(rs.getInt("age"));
				return cust;
			}
		});
	}

	
	@Override
	public String findNameById(long productId) {
		String sql = "SELECT name FROM product WHERE product_id = ?";
		return getJdbcTemplate().queryForObject(sql, new Object[]{productId}, String.class);
	}

	@Override
	public int getTotalNumberProduct() {
		String sql = "SELECT Count(*) FROM product";
		int total = getJdbcTemplate().queryForObject(sql, Integer.class);
		return total;
	}
}

