package me.gkdudans.springbootdeveloper.repository;

import me.gkdudans.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
