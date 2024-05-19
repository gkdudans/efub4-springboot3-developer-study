package me.gkdudans.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity // 엔티티로 지정
@Getter // 게터 메서드 대체
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 추가
public class Article {
    @Id // id 필드 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
    @Column(name="id", updatable=false)
    private Long id;

    @Column(name="title", nullable=false) // 'title'이라는 not null 컬럼과 매핑
    private String title;

    @Column(name="content", nullable=false)
    private String content;

    // 10장: OAuth, 글쓴이 추가
    @Column(name = "author", nullable = false)
    private String author;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @Builder // 빌더 패턴으로 객체 생성
    public Article(String author, String title, String content){
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

