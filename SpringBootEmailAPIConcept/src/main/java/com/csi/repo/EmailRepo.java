package com.csi.repo;

import com.csi.model.EmailRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepo extends JpaRepository<EmailRequest,Integer> {
}
