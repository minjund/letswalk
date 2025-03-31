package com.minjun.letswalk.domain.board;

import com.minjun.letswalk.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;

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

    @Column(name = "recruit_personnel")
    @Comment("모집 인원")
    private Integer recruitPersonnel;

    public static BoardEntity of(BoardTitle boardTitle,
                                 BoardContent boardContent,
                                 BoardRecruitGenderType boardRecruitGenderType,
                                 Integer boardRecruitPersonnel
    ) {
        BoardEntity boardEntity = new BoardEntity();

        boardEntity.title = boardTitle.value();
        boardEntity.content = boardContent.value();
        boardEntity.recruitGenderType = boardRecruitGenderType;
        boardEntity.recruitPersonnel = boardRecruitPersonnel;

        return boardEntity;
    }
}
