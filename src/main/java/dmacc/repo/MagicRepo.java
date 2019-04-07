package dmacc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.SpringMagic;

@Repository
public interface MagicRepo extends JpaRepository<SpringMagic, Long> {
	
}
