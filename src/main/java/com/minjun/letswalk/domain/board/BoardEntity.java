package com.minjun.letswalk.domain.board;

import com.minjun.letswalk.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@Table(name = "board")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long boardSeq;

    @Column(name = "title")
    private String boardTitle;

    @Column(name = "contents", columnDefinition = "MEDIUMTEXT")
    private String boardContents;

    @Column(name = "recruit_gender_type")
    private BoardRecruitGenderType boardRecruitGenderType;

    @Column(name = "recruit_personnel")
    private Integer boardRecruitPersonnel;

}
