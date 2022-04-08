package com.github.mdjoo0810.messageworker;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ReadProduct, Long> {
}
