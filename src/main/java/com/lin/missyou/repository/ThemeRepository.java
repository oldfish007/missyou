package com.lin.missyou.repository;

import com.lin.missyou.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ThemeRepository extends JpaRepository<Theme,Long> {
    @Query("select t from Theme t where t.name in (:names)")
    List<Theme> findByNames(List<String> names);
}
