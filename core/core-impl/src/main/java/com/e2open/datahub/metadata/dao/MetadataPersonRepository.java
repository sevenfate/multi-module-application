package com.e2open.datahub.metadata.dao;

import com.e2open.datahub.metadata.entity.order.MetadataPerson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional("metadataTransactionManager")
public interface MetadataPersonRepository extends CrudRepository<MetadataPerson, Long> {

    List<MetadataPerson> findByLastName(String lastName);
}
