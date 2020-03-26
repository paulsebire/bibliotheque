package com.books.dao;


import com.books.entities.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CopiesRepository extends JpaRepository<Copy, Long> {

    public List<Copy> findCopiesByBook_IdAndDispoTrue(Long id);
}
