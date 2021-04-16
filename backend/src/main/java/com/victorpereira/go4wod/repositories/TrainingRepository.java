package com.victorpereira.go4wod.repositories;

import com.victorpereira.go4wod.domains.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    Optional<Training> findByDate(LocalDate date);

    @Query(value = "SELECT trn.id, trn.wod, trn.date FROM tb_training trn INNER JOIN tb_user_training utr " +
            "ON trn.id = utr.training_id WHERE utr.user_id = :id", nativeQuery = true)
    List<Training> findAllByUserId(Long id);

    @Query(value = "SELECT trn.id, trn.wod, trn.date FROM tb_training trn INNER JOIN tb_user_training utr " +
            "ON trn.id = utr.training_id WHERE utr.user_id = :userId AND trn.id = :trainingId", nativeQuery = true)
    Optional<Training> findOneByUserId(Long userId, Long trainingId);

    @Modifying
    @Query(value = "DELETE FROM tb_user_training utr WHERE utr.user_id = :userId " +
            "AND utr.training_id = :trainingId", nativeQuery = true)
    void deleteOneTrainingByUserId(Long userId, Long trainingId);
}
