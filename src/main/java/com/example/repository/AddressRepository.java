package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Address;

@Repository
public class AddressRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final org.springframework.jdbc.core.RowMapper<Address> ADDRESS_ROW_MAPPER = (rs, i) -> {
		Address address = new Address();
		address.setId(rs.getInt("id"));
		address.setZipcode(rs.getString("zipcode"));
		address.setPrefecture(rs.getString("prefecture"));
		address.setAddress1(rs.getString("address1"));
		address.setAddress2(rs.getString("address2"));
		address.setAddress3(rs.getString("address3"));
		return address;
	};

	/**
	 * 郵便番号で絞り込む検索。
	 * 
	 * @return Address
	 */
	public Address findByZipcode(String zipcode) {

		String sql = "SELECT id,zipcode,prefecture,address1,address2,address3 FROM address WHERE zipcode LIKE :zipcode";
		SqlParameterSource param = new MapSqlParameterSource().addValue("zipcode", "%" + zipcode + "%");
		List<Address> addressList = template.query(sql, param, ADDRESS_ROW_MAPPER);

		Address address = new Address();

		for (int i = 0; i < addressList.size(); i++) {
			address = addressList.get(0);
		}

		return address;
	}
	
}
