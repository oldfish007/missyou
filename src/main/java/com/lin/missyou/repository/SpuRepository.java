package com.lin.missyou.repository;

import com.lin.missyou.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpuRepository extends JpaRepository<Spu,Long> {

    Spu  findOneById(Long id);
    Page<Spu>  findByCategoryIdOrderByCreateTimeDesc(Long cid, Pageable pageable);
    Page<Spu>  findByRootCategoryIdOrderByCreateTimeDesc(Long cid,Pageable pageable);

}
