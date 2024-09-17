package com.demoboletto.repository;

import com.demoboletto.domain.Travel;
import com.demoboletto.domain.User;
import com.demoboletto.domain.UserTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTravelRepository extends JpaRepository<UserTravel, Long> {
    @Query("select ut.user from UserTravel ut where ut.travel.travelId = :id")
    List<User> findUsersByTravelId(Long id);
    @Query("select ut.travel from UserTravel ut where ut.user.id = :id")
    List<Travel> findTravelsByUserId(Long id);

    @Query("select ut from UserTravel ut where ut.user.id = :userId and ut.travel.travelId = :travelId")
    UserTravel findByUserIdAndTravelId(Long userId, Long travelId);

    @Query("select ut from UserTravel ut where ut.travel.travelId = :travelId")
    List<UserTravel> findAllByTravelId(Long travelId);
    @Query("delete from UserTravel ut where ut.travel.travelId = :travelId")
    void deleteAllByTravelId(Long travelId);
}
