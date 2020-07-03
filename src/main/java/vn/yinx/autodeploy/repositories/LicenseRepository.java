package vn.yinx.autodeploy.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import vn.yinx.autodeploy.entities.License;

public interface LicenseRepository extends MongoRepository<License, String>{

}
