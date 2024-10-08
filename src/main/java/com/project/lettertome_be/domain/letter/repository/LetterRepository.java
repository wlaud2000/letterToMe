package com.project.lettertome_be.domain.letter.repository;

import com.project.lettertome_be.domain.letter.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface LetterRepository extends JpaRepository<Letter, Long> {

    // 현재 시간과 1분 이내에 발송해야 할 편지들을 조회하는 메서드
    @Query("SELECT l FROM Letter l JOIN FETCH l.user WHERE l.sendAt BETWEEN :startTime AND :endTime")
    List<Letter> findBySendAtBetween(LocalDateTime startTime, LocalDateTime endTime);
}
