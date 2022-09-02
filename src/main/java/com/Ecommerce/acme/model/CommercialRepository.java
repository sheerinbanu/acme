package com.Ecommerce.acme.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommercialRepository extends CrudRepository<Commercial, Integer>{

}
