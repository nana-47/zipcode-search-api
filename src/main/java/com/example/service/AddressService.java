package com.example.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Address;
import com.example.repository.AddressRepository;

@Transactional
@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;

	/**
	 * 郵便番号でヒットした結果をJSON用にmapに詰める
	 * 
	 * @return map
	 */
	public Map<String, String> findByZipcode(String zipcode) {

		Address address = repository.findByZipcode(zipcode);

		// タブ混入事件解消のため
		String newZipcode = address.getZipcode().replace("\t", "");
		String newAddress1 = address.getPrefecture().replace("\t", "") + address.getAddress1().replace("\t", "");
		String newAddress2 = address.getAddress2().replace("\t", "") + address.getAddress3().replace("\t", "");

		// DBのデータをJSONに変換する用のmapに詰める
		Map<String, String> map = new HashMap<>();
		map.put("id", String.valueOf(address.getId()));
		map.put("zipcode", newZipcode);
		map.put("address1", newAddress1);
		map.put("address2", newAddress2);

		return map;
	}
}
