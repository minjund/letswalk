package com.minjun.letswalk.domain.board;

import com.minjun.letswalk.global.entity.BaseEntity;
import com.minjun.letswalk.service.board.BoardSaveCommend;
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
    private Long boardSeq;

    @Column(name = "title")
    private String title;

    @Column(name = "content", columnDefinition = "MEDIUMTEXT")
    private String content;

    @Column(name = "recruit_gender_type")
    @Comment("모집 성별")
    private BoardRecruitGenderType boardRecruitGenderType;

    @Column(name = "recruit_personnel")
    @Comment("모집 인원")
    private Integer boardRecruitPersonnel;


    public static BoardEntity save(BoardSaveCommend boardSaveCommend) {
        BoardEntity boardEntity = new BoardEntity();

        boardEntity.title = boardSaveCommend.title().valueOf();
        boardEntity.content = boardSaveCommend.content().valueOf();
        boardEntity.boardRecruitGenderType = boardSaveCommend.boardRecruitGenderType();
        boardEntity.boardRecruitPersonnel = boardSaveCommend.boardRecruitPersonnel().valueOf();

        return boardEntity;
    }
}
