package com.pqtca.repos;

import com.pqtca.models.Application;
import com.pqtca.models.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicationRepo extends CrudRepository<Application, Long> {
    List<Application> findAll();

    Application findBy(User user);

    @Override
    Application findOne(Long aLong);

    Long countByAEthnicity(String aEthnicity);

    Long countByBCity(String bCity);

    Long countByDMaritalStatus(String cMarital);

    Long countByDfamilyStatus(String dFamily);

    Long countByEDrugTest(Boolean eDrugTest);

    Long countByESnap(Boolean eSnap);
    Long countByESsi(Boolean eSsi);
    Long countByESsh(Boolean eSsh);
    Long countByESsdi(Boolean eSsdi);
    Long countByETanf(Boolean eTanf);
    Long countByEUnemp(Boolean eUnemp);
    Long countByEWic(Boolean eWic);

    Long countByEMilitarySrv(String eMilitarySrv);

    Long countByEMilSpouse(Boolean eMilSpouse);

    Long countByEReferralSrc(String eReferralSrc);



//    TODO will work whenever education is added into the application table.
}
