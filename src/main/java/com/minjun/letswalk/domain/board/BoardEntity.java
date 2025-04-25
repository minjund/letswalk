package com.minjun.letswalk.domain.board;

import ch.qos.logback.core.util.StringUtil;
import com.minjun.letswalk.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "board")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "content", columnDefinition = "MEDIUMTEXT")
    private String content;

    @Column(name = "recruit_gender_type")
    @Comment("모집 성별")
    private BoardRecruitGenderType recruitGenderType;

    @Column(name = "recruit_age_type")
    @Comment("모집 나이")
    private BoardRecruitAgeType recruitAgeType;

    @Column(name = "recruit_address")
    @Comment("모집 지역")
    private String recruitAddress;

    @Column(name = "recruit_date_time")
    @Comment("모집 시간")
    private LocalDateTime recruitDateTime;

    @Column(name = "recruit_personnel")
    @Comment("모집 인원")
    private Integer recruitPersonnel;

    @Builder
    private BoardEntity(
            String title,
            String content,
            BoardRecruitGenderType recruitGenderType,
            Integer recruitPersonnel,
            BoardRecruitAgeType boardRecruitAgeType,
            String recruitAddress,
            LocalDateTime recruitDateTime
    ) {
        this.title = title;
        this.content = content;
        this.recruitGenderType = recruitGenderType;
        this.recruitPersonnel = recruitPersonnel;
        this.recruitAgeType = boardRecruitAgeType;
        this.recruitDateTime = recruitDateTime;
        this.recruitAddress = recruitAddress;
    }

    public static BoardEntity of(
            BoardTitle boardTitle,
            BoardContent boardContent,
            BoardRecruitGenderType boardRecruitGenderType,
            Integer boardRecruitPersonnel,
            BoardRecruitAgeType boardRecruitAgeType,
            String recruitAddress,
            LocalDateTime recruitDateTime
    ) {
        return BoardEntity.builder()
                .title(boardTitle.value())
                .content(boardContent.value())
                .recruitGenderType(boardRecruitGenderType)
                .recruitPersonnel(boardRecruitPersonnel)
                .boardRecruitAgeType(boardRecruitAgeType)
                .recruitAddress(recruitAddress)
                .recruitDateTime(recruitDateTime)
                .build();
    }

    @PostPersist
    public void generateId() {
        id = String.valueOf(seq);
    }

}
